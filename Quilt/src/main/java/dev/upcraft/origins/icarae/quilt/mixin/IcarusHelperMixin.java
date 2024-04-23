package dev.upcraft.origins.icarae.quilt.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.cammiescorner.icarus.api.IcarusPlayerValues;
import dev.cammiescorner.icarus.util.IcarusHelper;
import dev.upcraft.origins.icarae.quilt.power.WingsPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.function.Function;
import java.util.function.Predicate;

@Mixin(value = IcarusHelper.class, remap = false)
public class IcarusHelperMixin {

    @ModifyReturnValue(method = "getConfigValues", at = @At("RETURN"))
    private static IcarusPlayerValues injectPowerConfigValues(IcarusPlayerValues original, LivingEntity entity) {
        var list = PowerHolderComponent.getPowers(entity, WingsPower.class);
        if (!list.isEmpty()) {
            var power = list.get(0);
            power.updateFallback(original);
            return power;
        }

        return original;
    }

    @WrapOperation(method = "hasWings", at = @At(value = "INVOKE", target = "Ljava/util/function/Predicate;test(Ljava/lang/Object;)Z"))
    private static boolean originHasWings(Predicate<LivingEntity> instance, Object entity, Operation<Boolean> original) {
        if (PowerHolderComponent.hasPower((LivingEntity) entity, WingsPower.class)) {
            return true;
        }

        return original.call(instance, entity);
    }

    @WrapOperation(method = "getEquippedWings", at = @At(value = "INVOKE", target = "Ljava/util/function/Function;apply(Ljava/lang/Object;)Ljava/lang/Object;"))
    private static Object originGetWings(Function<LivingEntity, ItemStack> instance, Object entity, Operation<ItemStack> original) {
        if (PowerHolderComponent.hasPower((LivingEntity) entity, WingsPower.class)) {
            // null is special case
            return null;
        }

        return original.call(instance, entity);
    }
}

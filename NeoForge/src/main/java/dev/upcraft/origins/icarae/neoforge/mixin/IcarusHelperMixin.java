package dev.upcraft.origins.icarae.neoforge.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import dev.cammiescorner.icarus.api.IcarusPlayerValues;
import dev.cammiescorner.icarus.util.IcarusHelper;
import dev.upcraft.origins.icarae.neoforge.init.IcaraePowers;
import io.github.edwinmindcraft.apoli.api.ApoliAPI;
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
        var pc = ApoliAPI.getPowerContainer(entity);
        if (pc != null) {
            var powers = pc.getPowers(IcaraePowers.WINGS_POWER.get());
            if (!powers.isEmpty()) {
                var powerValue = powers.get(0).value().getConfiguration();
                powerValue.updateFallback(original);
                return powerValue;
            }
        }

        return original;
    }

    @WrapOperation(method = "hasWings", at = @At(value = "INVOKE", target = "Ljava/util/function/Predicate;test(Ljava/lang/Object;)Z"))
    private static boolean originHasWings(Predicate<LivingEntity> instance, Object entity, Operation<Boolean> original) {
        var pc = ApoliAPI.getPowerContainer((LivingEntity) entity);
        if (pc != null && pc.hasPower(IcaraePowers.WINGS_POWER.get())) {
            return true;
        }

        return original.call(instance, entity);
    }

    @WrapOperation(method = "getEquippedWings", at = @At(value = "INVOKE", target = "Ljava/util/function/Function;apply(Ljava/lang/Object;)Ljava/lang/Object;"))
    private static Object originGetWings(Function<LivingEntity, ItemStack> instance, Object entity, Operation<ItemStack> original) {
        var pc = ApoliAPI.getPowerContainer((LivingEntity) entity);
        if (pc != null && pc.hasPower(IcaraePowers.WINGS_POWER.get())) {
            // null is special case
            return null;
        }

        return original.call(instance, entity);
    }
}

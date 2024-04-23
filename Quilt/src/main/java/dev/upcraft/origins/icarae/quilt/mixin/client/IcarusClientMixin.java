package dev.upcraft.origins.icarae.quilt.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.cammiescorner.icarus.client.IcarusClient;
import dev.upcraft.origins.icarae.quilt.power.WingsPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = IcarusClient.class, remap = false)
public class IcarusClientMixin {

    @ModifyReturnValue(method = "getWingsForRendering", at = @At(value = "RETURN"))
    private static ItemStack injectOriginWings(ItemStack original, LivingEntity entity) {
        if (original.isEmpty()) {
            var list = PowerHolderComponent.getPowers(entity, WingsPower.class);
            if (!list.isEmpty()) {
                return list.get(0).getWingsType();
            }
        }

        return original;
    }
}

package dev.upcraft.origins.icarae.forge.mixin.client.compat.origins_fabric;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.cammiescorner.icarus.client.IcarusClient;
import dev.upcraft.origins.icarae.forge.compat.origins_fabric.util.IcaraeCompatMixinHooksClient;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = IcarusClient.class, remap = false)
public class IcarusClientMixin {

    @ModifyReturnValue(method = "getWingsForRendering", at = @At(value = "RETURN"))
    private static ItemStack injectOriginWings(ItemStack original, LivingEntity entity) {
        if(original.isEmpty()) {
            var override = IcaraeCompatMixinHooksClient.getRenderWingsOverride(entity);
            if(override != null) {
                return override;
            }
        }

        return original;
    }
}

package dev.upcraft.origins.icarae.neoforge.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import dev.cammiescorner.icarus.client.IcarusClient;
import dev.upcraft.origins.icarae.neoforge.init.IcaraePowers;
import io.github.edwinmindcraft.apoli.api.ApoliAPI;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = IcarusClient.class, remap = false)
public class IcarusClientMixin {

    @ModifyReturnValue(method = "getWingsForRendering", at = @At(value = "RETURN"))
    private static ItemStack injectOriginWings(ItemStack original, LivingEntity entity) {
        if(original.isEmpty()) {
            var pc = ApoliAPI.getPowerContainer(entity);
            if (pc != null) {
                var powers = pc.getPowers(IcaraePowers.WINGS_POWER.get());
                if (!powers.isEmpty()) {
                    return powers.get(0).value().getConfiguration().cosmeticWingsType();
                }
            }
        }

        return original;
    }
}

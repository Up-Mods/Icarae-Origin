package dev.upcraft.origins.icarae.forge.compat.origins_fabric.util;

import dev.cammiescorner.icarus.api.IcarusPlayerValues;
import dev.upcraft.origins.icarae.forge.compat.origins_fabric.power.WingsPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.world.entity.LivingEntity;

public class IcaraeCompatMixinHooks {

    public static boolean hasWingsOverride(LivingEntity entity) {
        return PowerHolderComponent.hasPower(entity, WingsPower.class);
    }

    public static IcarusPlayerValues getConfigOverride(IcarusPlayerValues original, LivingEntity entity) {
        var list = PowerHolderComponent.getPowers(entity, WingsPower.class);
        if(!list.isEmpty()) {
            var power = list.get(0);
            power.updateFallback(original);
            return power;
        }

        return original;
    }
}

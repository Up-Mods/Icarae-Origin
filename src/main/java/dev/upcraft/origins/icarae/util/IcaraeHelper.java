package dev.upcraft.origins.icarae.util;

import net.minecraft.world.entity.Entity;

public class IcaraeHelper {

    public static boolean isWet(Entity entity) {
        return entity.isInWaterRainOrBubble();
    }
}

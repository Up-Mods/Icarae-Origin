package dev.upcraft.origins.icarae;

import net.minecraft.resources.ResourceLocation;

public class IcaraeOrigin {

    public static final String MODID = "icarae_origin";

    public static ResourceLocation id(String path) {
        return new ResourceLocation(MODID, path);
    }
}

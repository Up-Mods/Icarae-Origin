package dev.upcraft.origins.icarae.quilt.entrypoints;

import dev.upcraft.origins.icarae.quilt.init.IcaraeEntityConditions;
import dev.upcraft.origins.icarae.quilt.init.IcaraePowers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        IcaraePowers.register();
        IcaraeEntityConditions.register();
    }
}

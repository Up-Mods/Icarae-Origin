package dev.upcraft.origins.icarae.fabric.entrypoints;

import dev.upcraft.origins.icarae.fabric.init.IcaraeEntityConditions;
import dev.upcraft.origins.icarae.fabric.init.IcaraePowers;
import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        IcaraePowers.register();
        IcaraeEntityConditions.register();
    }
}

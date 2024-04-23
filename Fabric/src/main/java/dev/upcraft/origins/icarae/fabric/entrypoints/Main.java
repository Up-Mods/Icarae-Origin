package dev.upcraft.origins.icarae.fabric.entrypoints;

import dev.upcraft.origins.icarae.fabric.init.IcaraePowers;
import dev.upcraft.origins.icarae.fabric.power.WingsPower;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.Registry;

public class Main implements ModInitializer {

    @Override
    public void onInitialize() {
        Registry.register(ApoliRegistries.POWER_FACTORY, WingsPower.POWER_TYPE_ID, IcaraePowers.WINGS_POWER);
    }
}

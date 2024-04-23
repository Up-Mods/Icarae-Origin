package dev.upcraft.origins.icarae.quilt.entrypoints;

import dev.upcraft.origins.icarae.quilt.init.IcaraePowers;
import dev.upcraft.origins.icarae.quilt.power.WingsPower;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.core.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class Main implements ModInitializer {

    @Override
    public void onInitialize(ModContainer mod) {
        Registry.register(ApoliRegistries.POWER_FACTORY, WingsPower.POWER_TYPE_ID, IcaraePowers.WINGS_POWER);
    }
}

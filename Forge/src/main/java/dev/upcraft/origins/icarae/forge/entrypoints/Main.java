package dev.upcraft.origins.icarae.forge.entrypoints;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.forge.compat.OriginsCompatMode;
import dev.upcraft.origins.icarae.forge.compat.origins_fabric.init.IcaraeFabricEntityConditions;
import dev.upcraft.origins.icarae.forge.compat.origins_fabric.init.IcaraeFabricPowers;
import dev.upcraft.origins.icarae.forge.init.IcaraeConditionTypes;
import dev.upcraft.origins.icarae.forge.init.IcaraePowers;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(IcaraeOrigin.MODID)
public class Main {

    public Main() {
        var bus = FMLJavaModLoadingContext.get().getModEventBus();

        switch (OriginsCompatMode.CURRENT) {
            case FORGE -> {
                IcaraePowers.POWER_FACTORIES.register(bus);
                IcaraeConditionTypes.ENTITY_CONDITION_TYPES.register(bus);
            }
            case FABRIC -> {
                IcaraeFabricPowers.POWER_FACTORIES.register(bus);
                IcaraeFabricEntityConditions.ENTITY_CONDITIONS.register(bus);
            }
        }
    }
}

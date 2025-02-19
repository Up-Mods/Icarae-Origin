package dev.upcraft.origins.icarae.fabric.entrypoints;

import dev.upcraft.origins.icarae.fabric.init.IcaraeEntityConditions;
import dev.upcraft.origins.icarae.fabric.init.IcaraePowers;
import dev.upcraft.sparkweave.api.entrypoint.MainEntryPoint;
import dev.upcraft.sparkweave.api.platform.ModContainer;
import dev.upcraft.sparkweave.api.platform.services.RegistryService;

public class Main implements MainEntryPoint {

    @Override
    public void onInitialize(ModContainer mod) {
        var registryService = RegistryService.get();
        IcaraeEntityConditions.ENTITY_CONDITION_TYPES.accept(registryService);
        IcaraePowers.POWER_TYPES.accept(registryService);
    }
}

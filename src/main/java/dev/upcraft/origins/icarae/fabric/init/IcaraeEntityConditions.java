package dev.upcraft.origins.icarae.fabric.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.fabric.condition.type.entity.EntityIsWetConditionType;
import dev.upcraft.sparkweave.api.registry.RegistryHandler;
import dev.upcraft.sparkweave.api.registry.RegistrySupplier;
import io.github.apace100.apoli.condition.ConditionConfiguration;
import io.github.apace100.apoli.condition.type.EntityConditionType;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.registry.ApoliRegistryKeys;

public class IcaraeEntityConditions {

    static {
        // TODO remove once fixed in sparkweave
        // this exists so apoli definitely registers its registries before we try to retrieve them.
        ApoliRegistries.ENTITY_CONDITION_TYPE.size();
    }

    public static final RegistryHandler<ConditionConfiguration<EntityConditionType>> ENTITY_CONDITION_TYPES = RegistryHandler.create(ApoliRegistryKeys.ENTITY_CONDITION_TYPE, IcaraeOrigin.MODID);

    public static final RegistrySupplier<ConditionConfiguration<EntityConditionType>> WET = ENTITY_CONDITION_TYPES.register("wet", () -> ConditionConfiguration.simple(IcaraeOrigin.id("wet"), EntityIsWetConditionType::new));

}

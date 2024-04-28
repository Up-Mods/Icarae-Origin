package dev.upcraft.origins.icarae.neoforge.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.neoforge.power.condition.EntityIsWetCondition;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import io.github.edwinmindcraft.apoli.api.registry.ApoliRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcaraeConditionTypes {

    public static final DeferredRegister<EntityCondition<?>> ENTITY_CONDITION_TYPES = DeferredRegister.create(ApoliRegistries.ENTITY_CONDITION_KEY, IcaraeOrigin.MODID);

    public static final RegistryObject<EntityIsWetCondition> WET = ENTITY_CONDITION_TYPES.register("wet", EntityIsWetCondition::new);
}

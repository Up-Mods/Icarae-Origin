package dev.upcraft.origins.icarae.quilt.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import dev.upcraft.origins.icarae.util.IcaraeHelper;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;

public class IcaraeEntityConditions {

    public static final ConditionFactory<Entity> WET = new ConditionFactory<>(IcaraeOrigin.id("wet"), new SerializableData(), (cfg, entity) -> IcaraeHelper.isWet(entity));

    public static void register() {
        Registry.register(ApoliRegistries.ENTITY_CONDITION, IcaraeOrigin.id("wet"), WET);
    }
}

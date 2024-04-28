package dev.upcraft.origins.icarae.fabric.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.Entity;

public class IcaraeEntityConditions {

    public static final ConditionFactory<Entity> WET = new ConditionFactory<>(IcaraeOrigin.id("wet"), new SerializableData(), (instance, entity) -> entity.isInWaterRainOrBubble());

    public static void register() {
        Registry.register(ApoliRegistries.ENTITY_CONDITION, IcaraeOrigin.id("wet"), WET);
    }
}

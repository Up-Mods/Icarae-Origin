package dev.upcraft.origins.icarae.forge.compat.origins_fabric.init;

import dev.upcraft.origins.icarae.IcaraeOrigin;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class IcaraeFabricEntityConditions {

    public static final DeferredRegister<ConditionFactory<Entity>> ENTITY_CONDITIONS = DeferredRegister.create(ApoliRegistries.ENTITY_CONDITION.key(), IcaraeOrigin.MODID);

    public static final RegistryObject<ConditionFactory<Entity>> WET = ENTITY_CONDITIONS.register("wet", () -> new ConditionFactory<>(IcaraeOrigin.id("wet"), new SerializableData(), (instance, entity) -> entity.isInWaterRainOrBubble()));
}

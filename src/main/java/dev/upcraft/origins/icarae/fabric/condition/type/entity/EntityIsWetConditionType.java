package dev.upcraft.origins.icarae.fabric.condition.type.entity;

import dev.upcraft.origins.icarae.fabric.init.IcaraeEntityConditions;
import dev.upcraft.origins.icarae.util.IcaraeHelper;
import io.github.apace100.apoli.condition.ConditionConfiguration;
import io.github.apace100.apoli.condition.context.EntityConditionContext;
import io.github.apace100.apoli.condition.type.EntityConditionType;
import org.jetbrains.annotations.NotNull;

public class EntityIsWetConditionType extends EntityConditionType {

    @Override
    public boolean test(EntityConditionContext context) {
        return IcaraeHelper.isWet(context.entity());
    }

    @Override
    public @NotNull ConditionConfiguration<?> getConfig() {
        return IcaraeEntityConditions.WET.get();
    }
}

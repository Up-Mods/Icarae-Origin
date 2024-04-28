package dev.upcraft.origins.icarae.neoforge.power.condition;

import com.mojang.serialization.Codec;
import dev.upcraft.origins.icarae.util.IcaraeHelper;
import io.github.edwinmindcraft.apoli.api.IDynamicFeatureConfiguration;
import io.github.edwinmindcraft.apoli.api.power.factory.EntityCondition;
import net.minecraft.world.entity.Entity;

public class EntityIsWetCondition extends EntityCondition<EntityIsWetCondition.Configuration> {

    public EntityIsWetCondition() {
        super(Configuration.CODEC);
    }

    @Override
    protected boolean check(Configuration configuration, Entity entity) {
        return IcaraeHelper.isWet(entity);
    }

    public record Configuration() implements IDynamicFeatureConfiguration {

        public static final Codec<Configuration> CODEC = Codec.unit(Configuration::new);

    }
}

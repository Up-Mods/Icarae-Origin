package dev.upcraft.origins.icarae.forge.compat.origins_fabric.util;

import dev.upcraft.origins.icarae.forge.compat.origins_fabric.power.WingsPower;
import io.github.apace100.apoli.component.PowerHolderComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class IcaraeCompatMixinHooksClient {

    @Nullable
    public static ItemStack getRenderWingsOverride(LivingEntity entity) {
        var list = PowerHolderComponent.getPowers(entity, WingsPower.class);
        if (!list.isEmpty()) {
            return list.get(0).getWingsType();
        }

        return null;
    }
}

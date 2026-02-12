package dev.upcraft.origins.icarae.forge;

import dev.upcraft.origins.icarae.forge.compat.OriginsCompatMode;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public class IcaraeOriginForgeMixinConfig implements IMixinConfigPlugin {
    @Override
    public void onLoad(String mixinPackage) {
        // NO-OP
    }

    @Override
    public String getRefMapperConfig() {
        // NO-OP
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        var isOriginsFabricCompat = mixinClassName.contains(".compat.origins_fabric.");

        return (OriginsCompatMode.CURRENT == OriginsCompatMode.FABRIC)
                == isOriginsFabricCompat;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {
        // NO-OP
    }

    @Override
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // NO-OP
    }

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {
        // NO-OP
    }
}

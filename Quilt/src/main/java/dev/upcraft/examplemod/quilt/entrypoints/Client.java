package dev.upcraft.examplemod.quilt.entrypoints;

import dev.upcraft.sparkweave.api.annotation.CalledByReflection;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;

@CalledByReflection
public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient(ModContainer mod) {

    }
}

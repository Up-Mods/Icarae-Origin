package dev.upcraft.origins.icarae.forge.compat;

import org.sinytra.connector.loader.ConnectorEarlyLoader;

public class ConnectorHelper {

    public static boolean isLoadedThroughConnector(String modid) {
        return ConnectorEarlyLoader.isConnectorMod(modid);
    }
}

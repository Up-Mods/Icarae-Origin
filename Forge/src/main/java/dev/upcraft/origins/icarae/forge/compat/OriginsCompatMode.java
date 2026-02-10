package dev.upcraft.origins.icarae.forge.compat;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.LoadingModList;
import org.slf4j.Logger;

public enum OriginsCompatMode {
    FORGE,
    FABRIC;

    private static final String CONNECTOR_MOD_ID = "connectormod";
    private static final String ORIGINS_MOD_ID = "origins";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final OriginsCompatMode CURRENT = selectCompatMode();

    private static OriginsCompatMode selectCompatMode() {
        var connectorLoaded = false;

        var modList = ModList.get();
        if(modList == null) {
            connectorLoaded = LoadingModList.get().getMods().stream().anyMatch(it -> it.getModId().equals(CONNECTOR_MOD_ID));
        }
        else {
            connectorLoaded = modList.isLoaded(CONNECTOR_MOD_ID);
        }

        if(connectorLoaded && ConnectorHelper.isLoadedThroughConnector(ORIGINS_MOD_ID)) {
            LOGGER.info("Enabling Origins Fabric compatibility mode.");
            return OriginsCompatMode.FABRIC;
        }

        return OriginsCompatMode.FORGE;
    }
}

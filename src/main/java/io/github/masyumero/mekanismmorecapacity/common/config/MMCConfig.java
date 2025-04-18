package io.github.masyumero.mekanismmorecapacity.common.config;

import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModLoadingContext;

public class MMCConfig {

    private MMCConfig() {
    }

    public static final MMCCommonConfig MMCcommon = new MMCCommonConfig();

    public static void registerConfigs(ModLoadingContext modLoadingContext) {
        ModContainer modContainer = modLoadingContext.getActiveContainer();
        MMCConfigHelper.registerConfig(modContainer, MMCcommon);
    }
}

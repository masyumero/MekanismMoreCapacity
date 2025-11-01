package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.IMekanismConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.config.IConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class MMCConfig {

    private MMCConfig() {
    }

    private static final Map<IConfigSpec, IMekanismConfig> KNOWN_CONFIGS = new HashMap<>();
    public static final MMCMekMachineConfig MEK_MACHINE_CONFIG = new MMCMekMachineConfig();
    public static final MMCMekExtrasMachineConfig MEK_EXTRAS_MACHINE_CONFIG = new MMCMekExtrasMachineConfig();
    public static final MMCMekScienceMachineConfig MEK_SCIENCE_MACHINE_CONFIG = new MMCMekScienceMachineConfig();
    public static final MMCMekMMMachineConfig MEK_MM_MACHINE_CONFIG = new MMCMekMMMachineConfig();

    public static void registerConfigs(ModContainer modContainer) {
        MMCConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, MEK_MACHINE_CONFIG);
        if(ModList.get().isLoaded("mekanism_extras")) {
            MMCConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, MEK_EXTRAS_MACHINE_CONFIG);
        }
        if(ModList.get().isLoaded("mekanismscience")) {
            MMCConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, MEK_SCIENCE_MACHINE_CONFIG);
        }
        if(ModList.get().isLoaded("mekmm")) {
            MMCConfigHelper.registerConfig(KNOWN_CONFIGS, modContainer, MEK_MM_MACHINE_CONFIG);
        }
    }
}

package io.github.masyumero.mekanismmorecapacity.common.config;

import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoadingContext;

public class MMCConfig {

    private MMCConfig() {
    }

    public static final MMCMekMachineConfig MEK_MACHINE_CONFIG = new MMCMekMachineConfig();
    public static final MMCMekExtrasMachineConfig MEK_EXTRAS_MACHINE_CONFIG = new MMCMekExtrasMachineConfig();
    public static final MMCMekScienceMachineConfig MEK_ELEMENTS_MACHINE_CONFIG = new MMCMekScienceMachineConfig();
    public static final MMCEvoMekMachineConfig EVO_MEK_MACHINE_CONFIG = new MMCEvoMekMachineConfig();

    public static void registerConfigs(ModLoadingContext modLoadingContext) {
        ModContainer modContainer = modLoadingContext.getActiveContainer();
        MMCConfigHelper.registerConfig(modContainer, MEK_MACHINE_CONFIG);
        if(ModList.get().isLoaded("mekanism_extras")) {
            MMCConfigHelper.registerConfig(modContainer, MEK_EXTRAS_MACHINE_CONFIG);
        }
        if(ModList.get().isLoaded("mekanismelements")) {
            MMCConfigHelper.registerConfig(modContainer, MEK_ELEMENTS_MACHINE_CONFIG);
        }
        if(ModList.get().isLoaded("evolvedmekanism")) {
            MMCConfigHelper.registerConfig(modContainer, EVO_MEK_MACHINE_CONFIG);
        }
    }
}

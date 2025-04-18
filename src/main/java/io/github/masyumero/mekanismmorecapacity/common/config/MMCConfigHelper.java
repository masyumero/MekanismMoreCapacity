package io.github.masyumero.mekanismmorecapacity.common.config;

import io.github.masyumero.mekanismmorecapacity.MekanismMoreCapacity;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MMCConfigHelper {
    private MMCConfigHelper() {
    }

    public static final Path CONFIG_DIR = FMLPaths.getOrCreateGameRelativePath(FMLPaths.CONFIGDIR.get().resolve(MekanismMoreCapacity.MODNAME));

    public static void registerConfig(ModContainer modContainer, IMekanismConfig config) {
        MMCModConfig modConfig = new MMCModConfig(modContainer, config);
        if (config.addToContainer()) {
            modContainer.addConfig(modConfig);
        }
    }
}

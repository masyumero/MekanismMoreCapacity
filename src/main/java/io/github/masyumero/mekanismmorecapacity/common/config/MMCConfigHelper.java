package io.github.masyumero.mekanismmorecapacity.common.config;

import io.github.masyumero.mekanismmorecapacity.MekanismMoreCapacity;
import mekanism.common.config.IMekanismConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.config.IConfigSpec;
import net.neoforged.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.Map;

public class MMCConfigHelper {
    private MMCConfigHelper() {
    }

    public static final Path CONFIG_DIR = FMLPaths.getOrCreateGameRelativePath(FMLPaths.CONFIGDIR.get().resolve(MekanismMoreCapacity.MODNAME));

    public static void registerConfig(Map<IConfigSpec, IMekanismConfig> knownConfigs, ModContainer modContainer, IMekanismConfig config) {
        modContainer.registerConfig(config.getConfigType(), config.getConfigSpec(),MekanismMoreCapacity.MODNAME + "/" + config.getFileName() + ".toml");
        knownConfigs.put(config.getConfigSpec(), config);
    }

}

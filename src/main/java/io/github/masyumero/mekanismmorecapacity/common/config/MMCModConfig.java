package io.github.masyumero.mekanismmorecapacity.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import io.github.masyumero.mekanismmorecapacity.MekanismMoreCapacity;
import mekanism.common.config.IMekanismConfig;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.config.ConfigFileTypeHandler;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.util.function.Function;

public class MMCModConfig extends ModConfig {

    private static final MMCConfigFileTypeHandler MMC_TOML = new MMCConfigFileTypeHandler();

    private final IMekanismConfig MMCConfig;

    public MMCModConfig(ModContainer container, IMekanismConfig config) {
        super(config.getConfigType(), config.getConfigSpec(), container, MekanismMoreCapacity.MODNAME + "/" + config.getFileName() + ".toml");
        this.MMCConfig = config;
    }

    @Override
    public ConfigFileTypeHandler getHandler() {
        return MMC_TOML;
    }

    public  void clearCache(ModConfigEvent event) {
        MMCConfig.clearCache(event instanceof ModConfigEvent.Unloading);
    }

    private static class MMCConfigFileTypeHandler extends ConfigFileTypeHandler {
        private static Path getPath(Path configBasePath) {
            if (configBasePath.endsWith("serverconfig")) {
                return FMLPaths.CONFIGDIR.get();
            }
            return configBasePath;
        }

        @Override
        public Function<ModConfig, CommentedFileConfig> reader(Path configBasePath) {
            return super.reader(getPath(configBasePath));
        }

        @Override
        public void unload(Path configBasePath, ModConfig config) {
            super.unload(getPath(configBasePath), config);
        }
    }

}

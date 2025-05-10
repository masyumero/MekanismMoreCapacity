package io.github.masyumero.mekanismmorecapacity;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MekanismMoreCapacity.MODID)
public class MekanismMoreCapacity {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "mekanismmorecapacity";
    public static final String MODNAME = "MekanismMoreCapacity";

    public MekanismMoreCapacity(ModContainer modContainer) {
        MMCConfig.registerConfigs(modContainer);
    }

}

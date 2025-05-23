package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityChemicalCrystallizer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityChemicalCrystallizer.class, remap = false)
public class MixinTileEntityChemicalCrystallizer {
    @ModifyConstant(method = "presetVariables",constant = @Constant(longValue = 10000L))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalCrystallizer.get();
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityChemicalDissolutionChamber.class,remap = false)
public class MixinTileEntityChemicalDissolutionChamber {
    @ModifyConstant(method = "presetVariables",constant = @Constant(longValue = 10000L))
    private long modifyChemicalOutputTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalDissolutionChamberOutput.get();
    }
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000L))
    private long modifyChemicalInputTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalDissolutionChamberInput.get();
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.common.tile.machine.TileEntityChemicalDemolitionMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityChemicalDemolitionMachine.class,remap = false)
public class MixinTileEntityChemicalDemolitionMachine {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.ChemicalDemolition.get();
    }
}

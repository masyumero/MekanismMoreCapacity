package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityElectrolyticSeparator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityElectrolyticSeparator.class,remap = false)
public class MixinTileEntityElectrolyticSeparator {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 2400L))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ElectrolyticSeparatorChemical.get();
    }
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 24000))
    private int modifyFluidTankCapacity(int c){
        return MMCConfig.MEK_MACHINE_CONFIG.ElectrolyticSeparatorFluid.get();
    }
}

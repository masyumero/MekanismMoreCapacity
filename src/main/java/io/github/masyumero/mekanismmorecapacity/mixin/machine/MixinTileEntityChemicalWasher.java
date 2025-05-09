package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityChemicalWasher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityChemicalWasher.class, remap = false)
public class MixinTileEntityChemicalWasher {
    @ModifyConstant(method = "getInitialSlurryTanks",constant = @Constant(longValue = 10000L))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalWasherSlurry.get();
    }
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10000))
    private int modifyFluidTankCapacity(int c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalWasherFluid.get();
    }
}

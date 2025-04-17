package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import mekanism.common.tile.machine.TileEntityRotaryCondensentrator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityRotaryCondensentrator.class,remap = false)
public class MixinTileEntityRotaryCondensentrator {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000L))
    private long modifyChemicalTankCapacity(long c){
        return Long.MAX_VALUE;
    }
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10000))
    private int modifyFluidTankCapacity(int c){
        return Integer.MAX_VALUE;
    }
}

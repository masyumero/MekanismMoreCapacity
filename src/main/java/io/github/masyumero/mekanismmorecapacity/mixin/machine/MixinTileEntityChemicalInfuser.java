package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityChemicalInfuser.class,remap = false)
public class MixinTileEntityChemicalInfuser {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000L))
    private long modifyChemicalTankCapacity(long c){
        return Long.MAX_VALUE;
    }
}

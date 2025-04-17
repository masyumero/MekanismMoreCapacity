package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import mekanism.common.tile.machine.TileEntityMetallurgicInfuser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityMetallurgicInfuser.class,remap = false)
public class MixinTileEntityMetallurgicInfuser {
    @ModifyConstant(method = "getInitialInfusionTanks",constant = @Constant(longValue = 1000L))
    private long modifyChemicalTankCapacity(long c){
        return Long.MAX_VALUE;
    }
}

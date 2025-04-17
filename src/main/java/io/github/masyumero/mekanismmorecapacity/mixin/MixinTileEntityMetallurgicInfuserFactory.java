package io.github.masyumero.mekanismmorecapacity.mixin;

import mekanism.common.tile.factory.TileEntityMetallurgicInfuserFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityMetallurgicInfuserFactory.class,remap = false)
public class MixinTileEntityMetallurgicInfuserFactory {
    @ModifyConstant(method = "getInitialInfusionTanks",constant = @Constant(longValue = 1000L))
    private long modifyInputTankCapacity(long c){
        return Long.MAX_VALUE;
    }
}

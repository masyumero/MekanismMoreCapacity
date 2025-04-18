package io.github.masyumero.mekanismmorecapacity.mixin;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.factory.TileEntityMetallurgicInfuserFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityMetallurgicInfuserFactory.class,remap = false)
public class MixinTileEntityMetallurgicInfuserFactory {
    @ModifyConstant(method = "getInitialInfusionTanks",constant = @Constant(longValue = 1000L))
    private long modifyInputTankCapacity(long c){
        return MMCConfig.MMCcommon.MetallurgicInfuser.get();
    }
}

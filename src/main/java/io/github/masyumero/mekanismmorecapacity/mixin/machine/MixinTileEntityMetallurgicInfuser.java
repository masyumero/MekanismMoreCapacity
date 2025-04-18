package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityMetallurgicInfuser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityMetallurgicInfuser.class,remap = false)
public class MixinTileEntityMetallurgicInfuser {
    @ModifyConstant(method = "getInitialInfusionTanks",constant = @Constant(longValue = 1000L))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MMCcommon.MetallurgicInfuser.get();
    }
}

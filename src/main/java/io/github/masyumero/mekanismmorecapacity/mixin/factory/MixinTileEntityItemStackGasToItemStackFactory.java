package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.factory.TileEntityItemStackGasToItemStackFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityItemStackGasToItemStackFactory.class,remap = false)
public class MixinTileEntityItemStackGasToItemStackFactory {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 210L))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MMCcommon.Factorys.get();
    }
}

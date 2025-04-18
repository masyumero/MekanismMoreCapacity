package io.github.masyumero.mekanismmorecapacity.mixin;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.content.sps.SPSMultiblockData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;


@Mixin(value = SPSMultiblockData.class, remap = false)
public class MixinSPSMultiblockData {
    @ModifyConstant(method = "getMaxInputGas", constant = @Constant(longValue = 2L))
    private long modifyInputTankCapacity(long c) {
        return MMCConfig.MMCcommon.sps.getAsLong();
    }
}
package io.github.masyumero.mekanismmorecapacity.mixin;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.content.sps.SPSMultiblockData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(value = SPSMultiblockData.class, remap = false)
public class MixinSPSMultiblockData {
    @Inject(method = "getMaxInputGas", at = @At(value = "RETURN"), cancellable = true)
    private void modifyInputTankCapacity(CallbackInfoReturnable<Long> cir) {
        cir.setReturnValue(MMCConfig.MEK_MACHINE_CONFIG.sps.get());
    }
}
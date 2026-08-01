package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityAdsorptionSeparator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAdsorptionSeparator.class,remap = false)
public class MixinTileEntityAdsorptionSeparator {
    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;create(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int inputModifyArg(int c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.AdsorptionSeparatorInput.get();
    }

    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.AdsorptionSeparatorOutput.get();
    }
}

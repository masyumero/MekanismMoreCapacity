package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.large;

import com.jerry.meklm.common.tile.machine.TileEntityLargeElectrolyticSeparator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityLargeElectrolyticSeparator.class, remap = false)
public class MixinTileEntityLargeElectrolyticSeparator {

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"), index = 0)
    private int inputModifyArg(int capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.inputLargeElectrolyticSeparator.get();
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 0), index = 0)
    private long leftOutputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.leftOutputLargeElectrolyticSeparator.get();
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 0), index = 0)
    private long rightOutputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.rightOutputLargeElectrolyticSeparator.get();
    }
}

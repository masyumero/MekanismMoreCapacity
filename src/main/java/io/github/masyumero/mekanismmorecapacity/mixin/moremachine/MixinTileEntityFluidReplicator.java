package io.github.masyumero.mekanismmorecapacity.mixin.moremachine;

import com.jerry.mekmm.common.tile.machine.TileEntityFluidReplicator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityFluidReplicator.class, remap = false)
public class MixinTileEntityFluidReplicator {
    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long gasInputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.FluidReplicatorGasInput.get();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int fluidOutputModifyArg(int capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.FluidReplicatorFluidInput.get();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int fluidInputModifyArg(int capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.FluidReplicatorFluidOutput.get();
    }
}

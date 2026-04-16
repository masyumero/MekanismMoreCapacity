package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.large;

import com.jerry.meklm.common.tile.machine.TileEntityLargeRotaryCondensentrator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityLargeRotaryCondensentrator.class, remap = false)
public abstract class MixinTileEntityLargeRotaryCondensentrator {

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"), index = 0)
    private long gasModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.gasLargeRotaryCondensentrator.get();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;create(ILjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"), index = 0)
    private int fluidModifyArg(int capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.fluidLargeRotaryCondensentrator.get();
    }
}

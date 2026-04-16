package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.large;

import com.jerry.meklm.common.tile.machine.TileEntityLargeAntiprotonicNucleosynthesizer;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityLargeAntiprotonicNucleosynthesizer.class, remap = false)
public class MixinTileEntityLargeAntiprotonicNucleosynthesizer {

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.largeAntiprotonicNucleosynthesizer.get();
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityRadiationIrradiator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityRadiationIrradiator.class,remap = false)
public class MixinTileEntityRadiationIrradiator {
    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.RadiationIrradiatorInput.get();
    }

    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.RadiationIrradiatorOutput.get();
    }
}

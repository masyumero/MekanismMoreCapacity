package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.large;

import com.jerry.meklm.common.tile.machine.TileEntityLargeSolarNeutronActivator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityLargeSolarNeutronActivator.class, remap = false)
public class MixinTileEntityLargeSolarNeutronActivator {

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"), index = 0)
    private long inputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.inputLargeSolarNeutronActivator.get();
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"), index = 0)
    private long outputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.outputLargeSolarNeutronActivator.get();
    }
}

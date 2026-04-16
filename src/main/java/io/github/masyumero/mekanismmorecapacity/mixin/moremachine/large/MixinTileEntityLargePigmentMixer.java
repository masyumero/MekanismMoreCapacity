package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.large;

import com.jerry.meklm.common.tile.machine.TileEntityLargePigmentMixer;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityLargePigmentMixer.class, remap = false)
public class MixinTileEntityLargePigmentMixer {

    @ModifyArg(method = "getInitialPigmentTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 0), index = 0)
    private long leftInputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.leftInputLargePigmentMixer.get();
    }

    @ModifyArg(method = "getInitialPigmentTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 1), index = 0)
    private long rightInputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.rightInputLargePigmentMixer.get();
    }

    @ModifyArg(method = "getInitialPigmentTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"), index = 0)
    private long outputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.outputLargePigmentMixer.get();
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.prefab;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.prefab.TileEntityAdvancedElectricMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAdvancedElectricMachine.class,remap = false)
public class MixinTileEntityAdvancedElectricMachine {
    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_MACHINE_CONFIG.CompressingInjectingPurifying.get();
    }
}

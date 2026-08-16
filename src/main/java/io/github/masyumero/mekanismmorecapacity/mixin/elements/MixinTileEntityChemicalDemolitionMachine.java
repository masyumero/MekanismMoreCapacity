package io.github.masyumero.mekanismmorecapacity.mixin.elements;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityChemicalDemolitionMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityChemicalDemolitionMachine.class,remap = false)
public class MixinTileEntityChemicalDemolitionMachine {
    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.ChemicalDemolition.get();
    }
}

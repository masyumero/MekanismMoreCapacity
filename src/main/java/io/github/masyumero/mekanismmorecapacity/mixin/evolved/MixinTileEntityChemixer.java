package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.tiles.machine.TileEntityChemixer;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityChemixer.class,remap = false)
public class MixinTileEntityChemixer {
    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.Chemixer.get();
    }
}

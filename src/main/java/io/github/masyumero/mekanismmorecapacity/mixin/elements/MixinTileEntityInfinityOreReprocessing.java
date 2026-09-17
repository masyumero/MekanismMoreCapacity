package io.github.masyumero.mekanismmorecapacity.mixin.elements;

import fixdol.mekanismelements.common.tile.machine.TileEntityInfinityOreReprocessing;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityInfinityOreReprocessing.class, remap = false)
public class MixinTileEntityInfinityOreReprocessing {
    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.infinityOreReprocessing.get();
    }
}

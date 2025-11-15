package io.github.masyumero.mekanismmorecapacity.mixin.moremachine;

import com.jerry.mekmm.common.tile.machine.TileEntityAmbientGasCollector;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAmbientGasCollector.class, remap = false)
public class MixinTileEntityAmbientGasCollector {
    @ModifyArg(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONFIG.AmbientGasCollector.get();
    }
}

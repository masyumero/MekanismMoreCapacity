package io.github.masyumero.mekanismmorecapacity.mixin.elements;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityAirCompressor;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAirCompressor.class,remap = false)
public class MixinTileEntityAirCompressor {
    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private static long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AirCompressor.get();
    }
}

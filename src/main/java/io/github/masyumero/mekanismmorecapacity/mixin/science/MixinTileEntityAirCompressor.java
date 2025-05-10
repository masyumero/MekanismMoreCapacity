package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.common.tile.machine.TileEntityAirCompressor;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityAirCompressor.class,remap = false)
public class MixinTileEntityAirCompressor {
    @ModifyConstant(method = "<clinit>",constant = @Constant(longValue = 100L))
    private static long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AirCompressor.get();
    }
}

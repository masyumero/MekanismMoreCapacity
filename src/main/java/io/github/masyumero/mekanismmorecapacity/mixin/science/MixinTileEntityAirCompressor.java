package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityAirCompressor;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityAirCompressor.class,remap = false)
public class MixinTileEntityAirCompressor {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.AirCompressor.get();
    }
}

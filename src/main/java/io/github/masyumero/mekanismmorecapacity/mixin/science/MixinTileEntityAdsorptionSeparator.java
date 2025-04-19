package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionSeparator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityAdsorptionSeparator.class,remap = false)
public class MixinTileEntityAdsorptionSeparator {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000))
    private long modifyChemicalInputTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorInput.get();
    }
    @ModifyConstant(method = "presetVariables",constant = @Constant(longValue = 10000))
    private long modifyChemicalOutputTankCapacity(long c) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorOutput.get();
    }
}

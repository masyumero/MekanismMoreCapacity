package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismelements.common.tile.machine.TileEntityRadiationIrradiator;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityRadiationIrradiator.class,remap = false)
public class MixinTileEntityRadiationIrradiator {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 10000))
    private long modifyChemicalInputTankCapacity(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.RadiationIrradiatorInput.get();
    }
    @ModifyConstant(method = "presetVariables",constant = @Constant(longValue = 10000))
    private long modifyChemicalOutputTankCapacity(long c) {
        return MMCConfig.MEK_ELEMENTS_MACHINE_CONFIG.RadiationIrradiatorOutput.get();
    }
}

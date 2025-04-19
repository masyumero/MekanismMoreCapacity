package io.github.masyumero.mekanismmorecapacity.mixin.prefab;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.prefab.TileEntityAdvancedElectricMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityAdvancedElectricMachine.class,remap = false)
public class MixinTileEntityAdvancedElectricMachine {
    @ModifyConstant(method = "getInitialGasTanks",constant = @Constant(longValue = 210L))
    private long modifyChemicalTankCapacity(long c) {
        return MMCConfig.MMCcommon.CompressingInjectingPurifying.get();
    }
}

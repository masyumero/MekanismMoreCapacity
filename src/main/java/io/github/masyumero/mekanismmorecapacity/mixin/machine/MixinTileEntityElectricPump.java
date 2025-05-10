package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityElectricPump;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityElectricPump.class,remap = false)
public class MixinTileEntityElectricPump {
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10000))
    private int modifyFluidTankCapacity(int c){
        return MMCConfig.MEK_MACHINE_CONFIG.ElectricPump.get();
    }
}

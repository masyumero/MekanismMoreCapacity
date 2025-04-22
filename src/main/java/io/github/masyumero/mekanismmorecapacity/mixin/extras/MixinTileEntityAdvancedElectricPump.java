package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekanism_extras.common.tile.machine.TileEntityAdvancedElectricPump;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityAdvancedElectricPump.class,remap = false)
public class MixinTileEntityAdvancedElectricPump {
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10000000))
    private int modifyFluidTankCapacity(int i) {
        return MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AdvancedElectricPump.get();
    }
}

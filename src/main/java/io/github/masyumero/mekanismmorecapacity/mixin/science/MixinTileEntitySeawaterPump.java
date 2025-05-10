package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.common.tile.machine.TileEntitySeawaterPump;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntitySeawaterPump.class,remap = false)
public class MixinTileEntitySeawaterPump {
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10000))
    private int modifyFluidTankCapacity(int i) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.SeawaterPump.get();
    }
}

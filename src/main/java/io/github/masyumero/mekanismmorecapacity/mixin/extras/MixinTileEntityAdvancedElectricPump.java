package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekextras.common.tile.machine.TileEntityAdvancedElectricPump;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAdvancedElectricPump.class,remap = false)
public class MixinTileEntityAdvancedElectricPump {
    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int modifyFluidTankCapacity(int i) {
        return MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AdvancedElectricPump.get();
    }
}

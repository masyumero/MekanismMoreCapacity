package io.github.masyumero.mekanismmorecapacity.mixin.elements;

import com.fxd927.mekanismelements.common.tile.machine.TileEntitySeawaterPump;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntitySeawaterPump.class,remap = false)
public class MixinTileEntitySeawaterPump {
    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int modifyFluidTankCapacity(int i) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.SeawaterPump.get();
    }
}

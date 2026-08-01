package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.tiles.machine.TileEntityMelter;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityMelter.class, remap = false)
public abstract class MixinTileEntityMelter {

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int outputModifyArg(int c) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.Thermalizer.get();
    }
}

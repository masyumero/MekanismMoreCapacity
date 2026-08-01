package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.tiles.machine.TileEntitySolidifier;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntitySolidifier.class, remap = false)
public abstract class MixinTileEntitySolidifier {

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;", ordinal = 0))
    private int inputModifyArg(int c) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SolidifierMoltenMaterial.get();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;", ordinal = 1))
    private int inputExtraModifyArg(int c) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SolidifierCoolantTank.get();
    }
}

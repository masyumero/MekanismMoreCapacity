package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityChemicalWasher;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityChemicalWasher.class, remap = false)
public class MixinTileEntityChemicalWasher {
    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalWasherSlurry.get();
    }
    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int modifyFluidTankCapacity(int c){
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalWasherFluid.get();
    }
}

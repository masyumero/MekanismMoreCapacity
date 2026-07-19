package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import com.bawnorton.mixinsquared.TargetHandler;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityChemicalInfuser.class,remap = false, priority = 1500)
public class MixinTileEntityChemicalInfuserSquared {

    @TargetHandler(mixin = "com.fxd927.mekanismelements.mixin.MixinTileEntityChemicalInfuser", name = "getInitialGasTanksRedirect")
    @ModifyArg(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 0))
    private long leftTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserLeft.get();
    }

    @TargetHandler(mixin = "com.fxd927.mekanismelements.mixin.MixinTileEntityChemicalInfuser", name = "getInitialGasTanksRedirect")
    @ModifyArg(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 1))
    private long rightTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserRight.get();
    }

    @TargetHandler(mixin = "com.fxd927.mekanismelements.mixin.MixinTileEntityChemicalInfuser", name = "getInitialGasTanksRedirect")
    @ModifyArg(method = "@MixinSquared:Handler", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserCenter.get();
    }
}

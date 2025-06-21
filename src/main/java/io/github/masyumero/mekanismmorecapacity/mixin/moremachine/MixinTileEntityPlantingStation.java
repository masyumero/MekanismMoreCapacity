package io.github.masyumero.mekanismmorecapacity.mixin.moremachine;

import com.jerry.mekmm.common.tile.machine.TileEntityPlantingStation;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityPlantingStation.class,remap = false)
public abstract class MixinTileEntityPlantingStation {
    @ModifyArg(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return MMCConfig.MEK_MM_MACHINE_CONDIG.PlantingStation.get();
    }
}

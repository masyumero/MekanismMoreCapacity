package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityPressurizedReactionChamber;
import net.neoforged.neoforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityPressurizedReactionChamber.class,remap = false)
public class MixinTileEntityPressurizedReactionChamber {
    @ModifyConstant(method = "getInitialChemicalTanks",constant = @Constant(longValue = 10 * FluidType.BUCKET_VOLUME))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.PressurizedReactionChamberChemical.get();
    }
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10 * FluidType.BUCKET_VOLUME))
    private int modifyFluidTankCapacity(int i){
        return MMCConfig.MEK_MACHINE_CONFIG.PressurizedReactionChamberFluid.get();
    }
}

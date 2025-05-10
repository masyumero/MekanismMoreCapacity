package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityNutritionalLiquifier;
import net.neoforged.neoforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityNutritionalLiquifier.class,remap = false)
public class MixinTileEntityNutritionalLiquifier {
    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 10 * FluidType.BUCKET_VOLUME))
    private int modifyFluidTankCapacity(int i){
        return MMCConfig.MEK_MACHINE_CONFIG.NutritionalLiquifier.get();
    }
}

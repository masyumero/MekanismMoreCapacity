package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.common.tile.machine.TileEntityMetallurgicInfuser;
import net.neoforged.neoforge.fluids.FluidType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(value = TileEntityMetallurgicInfuser.class,remap = false)
public class MixinTileEntityMetallurgicInfuser {
    @ModifyConstant(method = "getInitialChemicalTanks",constant = @Constant(longValue = FluidType.BUCKET_VOLUME))
    private long modifyChemicalTankCapacity(long c){
        return MMCConfig.MEK_MACHINE_CONFIG.MetallurgicInfuser.get();
    }
}

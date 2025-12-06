package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSDoubleRecipeLookupHandler;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSRecipeLookupHandler;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionSeparator;
import com.fxd927.mekanismscience.common.tile.prefab.MSTileEntityProgressMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntityAdsorptionSeparator.class,remap = false)
public abstract class MixinTileEntityAdsorptionSeparator extends MSTileEntityProgressMachine<RadiationIrradiatingRecipe> implements IMSRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IMSDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<RadiationIrradiatingRecipe> {

    protected MixinTileEntityAdsorptionSeparator(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyArg(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;input(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    public long inputModifyArg(long capacity) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorInput.get();
    }

    @ModifyArg(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    public long outputModifyArg(long capacity) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorOutput.get();
    }
}

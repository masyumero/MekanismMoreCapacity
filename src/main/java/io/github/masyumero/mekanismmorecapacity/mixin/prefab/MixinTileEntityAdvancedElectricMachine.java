package io.github.masyumero.mekanismmorecapacity.mixin.prefab;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackGasToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.MekanismRecipeType;
import mekanism.common.tile.prefab.TileEntityAdvancedElectricMachine;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntityAdvancedElectricMachine.class,remap = false)
public abstract class MixinTileEntityAdvancedElectricMachine extends TileEntityProgressMachine<ItemStackGasToItemStackRecipe> {

    protected MixinTileEntityAdvancedElectricMachine(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        if (getRecipeType() == MekanismRecipeType.COMPRESSING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Compressing.get();
        } else if (getRecipeType() == MekanismRecipeType.PURIFYING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Purifying.get();
        } else if (getRecipeType() == MekanismRecipeType.INJECTING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Injecting.get();
        } else {
            return 210L;
        }
    }
}

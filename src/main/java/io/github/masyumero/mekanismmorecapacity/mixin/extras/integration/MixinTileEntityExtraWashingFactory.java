package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.TileEntityExtraWashingFactory;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraChemicalToChemicalFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.FluidChemicalToChemicalRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraWashingFactory.class, remap = false)
public abstract class MixinTileEntityExtraWashingFactory extends TileEntityExtraChemicalToChemicalFactory<FluidChemicalToChemicalRecipe> {

    protected MixinTileEntityExtraWashingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int inputModifyArg(int capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @Unique
    private int mekanismMoreCapacity$getInputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteWashingFluidInput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeWashingFluidInput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicWashingFluidInput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteWashingFluidInput.get();
        };
    }
}

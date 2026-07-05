package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraItemToChemicalFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.MekanismRecipe;
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

@Mixin(value = TileEntityExtraItemToChemicalFactory.class, remap = false)
public abstract class MixinTileEntityExtraItemToChemicalFactory<RECIPE extends MekanismRecipe<?>> extends TileEntityExtraAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityExtraItemToChemicalFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return capacity;
    }

    @Unique
    private long mekanismMoreCapacity$getOutputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteDissolvingOutput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeDissolvingOutput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicDissolvingOutput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteDissolvingOutput.get();
        };
    }
}

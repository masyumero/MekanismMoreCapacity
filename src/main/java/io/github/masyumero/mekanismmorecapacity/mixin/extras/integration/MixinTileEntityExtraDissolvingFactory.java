package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.TileEntityExtraDissolvingFactory;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraItemToChemicalFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ChemicalDissolutionRecipe;
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

@Mixin(value = TileEntityExtraDissolvingFactory.class, remap = false)
public abstract class MixinTileEntityExtraDissolvingFactory extends TileEntityExtraItemToChemicalFactory<ChemicalDissolutionRecipe> {

    protected MixinTileEntityExtraDissolvingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteDissolvingInput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeDissolvingInput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicDissolvingInput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteDissolvingInput.get();
        };
    }
}

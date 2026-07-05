package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.TileEntityExtraPaintingFactory;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraItemToItemAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
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

@Mixin(value = TileEntityExtraPaintingFactory.class, remap = false)
public abstract class MixinTileEntityExtraPaintingFactory extends TileEntityExtraItemToItemAdvancedFactory<ItemStackChemicalToItemStackRecipe> {

    protected MixinTileEntityExtraPaintingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePainting.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePainting.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPainting.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePainting.get();
        };
    }
}

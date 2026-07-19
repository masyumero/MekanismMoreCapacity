package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.TileEntityExtraCrystallizingFactory;
import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.base.TileEntityExtraMergedToItemFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ChemicalCrystallizerRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraCrystallizingFactory.class, remap = false)
public abstract class MixinTileEntityExtraCrystallizingFactory extends TileEntityExtraMergedToItemFactory<ChemicalCrystallizerRecipe> {

    protected MixinTileEntityExtraCrystallizingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCrystallizing.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCrystallizing.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCrystallizing.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCrystallizing.get();
        };
    }
}

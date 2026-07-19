package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.base.TileEntityExtraMergedToItemFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraMergedToItemFactory.class, remap = false)
public abstract class MixinTileEntityExtraMergedToItemFactory<RECIPE extends MekanismRecipe> extends TileEntityExtraAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityExtraMergedToItemFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyVariable(method = {
            "distributeGas",
            "distributeInfusion",
            "distributePigment",
            "distributeSlurry",
    },
            at = @At("STORE"),
            name = "maxAmount"
    )
    private long inputModifyVariable(long maxAmount) {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCrystallizing.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCrystallizing.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCrystallizing.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCrystallizing.get();
        };
    }
}

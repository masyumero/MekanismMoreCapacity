package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import com.jerry.mekanism_extras.common.integration.mekaf.tile.factory.base.TileEntityExtraItemToGasFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraItemToGasFactory.class, remap = false)
public abstract class MixinTileEntityExtraItemToGasFactory<RECIPE extends MekanismRecipe> extends TileEntityExtraAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityExtraItemToGasFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return mekanismMoreCapacity$getOutputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getOutputCapacity() {
        return switch (type) {
            case OXIDIZING -> switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteOxidizing.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeOxidizing.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicOxidizing.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteOxidizing.get();
            };
            case PIGMENT_EXTRACTING -> switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePigmentExtracting.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePigmentExtracting.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPigmentExtracting.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePigmentExtracting.get();
            };
            default -> throw new IllegalStateException("Unhandled factory type");
        };
    }
}

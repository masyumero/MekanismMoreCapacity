package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekaf.common.content.blocktype.AdvancedFactoryType;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraChemicalToChemicalFactory;
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

//Centrifuging Washing
@Mixin(value = TileEntityExtraChemicalToChemicalFactory.class, remap = false)
public abstract class MixinTileEntityExtraChemicalToChemicalFactory<RECIPE extends MekanismRecipe<?>> extends TileEntityExtraAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityExtraChemicalToChemicalFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return mekanismMoreCapacity$getOutputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        if (type == AdvancedFactoryType.CENTRIFUGING) {
            return switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCentrifugingInput.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCentrifugingInput.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCentrifugingInput.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCentrifugingInput.get();
            };
        } else {
            return switch (tier) { //WASHING
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteWashingInput.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeWashingInput.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicWashingInput.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteWashingInput.get();
            };
        }
    }

    @Unique
    private long mekanismMoreCapacity$getOutputCapacity() {
        if (type == AdvancedFactoryType.CENTRIFUGING) {
            return switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCentrifugingOutput.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCentrifugingOutput.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCentrifugingOutput.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCentrifugingOutput.get();
            };
        } else {
            return switch (tier) { //WASHING
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteWashingOutput.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeWashingOutput.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicWashingOutput.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteWashingOutput.get();
            };
        }
    }
}

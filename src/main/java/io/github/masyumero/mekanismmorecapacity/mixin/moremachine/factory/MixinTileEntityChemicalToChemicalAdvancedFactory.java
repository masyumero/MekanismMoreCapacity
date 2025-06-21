package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.factory.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.factory.TileEntityChemicalToChemicalAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.tier.FactoryTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityChemicalToChemicalAdvancedFactory.class,remap = false)
public abstract class MixinTileEntityChemicalToChemicalAdvancedFactory<RECIPE extends MekanismRecipe<?>> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityChemicalToChemicalAdvancedFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue(this.tier).get();
    }

    private CachedLongValue getInputConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC -> MMCConfig.MEK_MM_MACHINE_CONDIG.BasicChemicalToChemicalFactoryinputL;
            case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONDIG.AdvancedChemicalToChemicalFactoryinputL;
            case ELITE -> MMCConfig.MEK_MM_MACHINE_CONDIG.EliteChemicalToChemicalFactoryinputL;
            case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONDIG.UltimateChemicalToChemicalFactoryinputL;
        };
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getOutputConfigValue(this.tier).get();
    }

    private CachedLongValue getOutputConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC -> MMCConfig.MEK_MM_MACHINE_CONDIG.BasicChemicalToChemicalFactoryoutput;
            case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONDIG.AdvancedChemicalToChemicalFactoryoutput;
            case ELITE -> MMCConfig.MEK_MM_MACHINE_CONDIG.EliteChemicalToChemicalFactoryoutput;
            case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONDIG.UltimateChemicalToChemicalFactoryoutput;
        };
    }
}

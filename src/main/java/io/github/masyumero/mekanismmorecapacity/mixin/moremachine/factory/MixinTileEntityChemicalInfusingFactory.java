package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.factory.TileEntityChemicalInfusingFactory;
import com.jerry.mekaf.common.tile.factory.TileEntityChemicalToChemicalAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ChemicalChemicalToChemicalRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.recipe.lookup.IEitherSideRecipeLookupHandler;
import mekanism.common.tier.FactoryTier;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityChemicalInfusingFactory.class,remap = false)
public abstract class MixinTileEntityChemicalInfusingFactory extends TileEntityChemicalToChemicalAdvancedFactory<ChemicalChemicalToChemicalRecipe> implements IHasDumpButton, IEitherSideRecipeLookupHandler.EitherSideChemicalRecipeLookupHandler<ChemicalChemicalToChemicalRecipe> {

    protected MixinTileEntityChemicalInfusingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getConfigValue(this.tier).get();
    }

    private CachedLongValue getConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC -> MMCConfig.MEK_MM_MACHINE_CONDIG.BasicChemicalToChemicalFactoryinputR;
            case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONDIG.AdvancedChemicalToChemicalFactoryinputR;
            case ELITE -> MMCConfig.MEK_MM_MACHINE_CONDIG.EliteChemicalToChemicalFactoryinputR;
            case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONDIG.UltimateChemicalToChemicalFactoryinputR;
        };
    }
}

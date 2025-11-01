package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.factory.TileEntityDissolvingFactory;
import com.jerry.mekaf.common.tile.factory.TileEntityItemToChemicalAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ChemicalDissolutionRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
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

@Mixin(value = TileEntityDissolvingFactory.class,remap = false)
public abstract class MixinTileEntityDissolvingFactory extends TileEntityItemToChemicalAdvancedFactory<ChemicalDissolutionRecipe> implements IHasDumpButton, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<ChemicalDissolutionRecipe> {

    protected MixinTileEntityDissolvingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getConfigValue(this.tier).get();
    }

    private CachedLongValue getConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactory;
            case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactory;
            case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactory;
            case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactory;
        };
    }
}

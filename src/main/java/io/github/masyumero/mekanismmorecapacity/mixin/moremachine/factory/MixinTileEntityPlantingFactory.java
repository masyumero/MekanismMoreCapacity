package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekmm.api.recipes.PlantingRecipe;
import com.jerry.mekmm.common.tile.factory.MMTileEntityFactory;
import com.jerry.mekmm.common.tile.factory.TileEntityPlantingFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
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

@Mixin(value = TileEntityPlantingFactory.class,remap = false)
public abstract class MixinTileEntityPlantingFactory extends MMTileEntityFactory<PlantingRecipe> implements IHasDumpButton, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<PlantingRecipe> {

    protected MixinTileEntityPlantingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue(tier).get();
    }

    private CachedLongValue getInputConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC ->       MMCConfig.MEK_MM_MACHINE_CONDIG.BasicPlantingStationFactory;
            case ADVANCED ->    MMCConfig.MEK_MM_MACHINE_CONDIG.AdvancedPlantingStationFactory;
            case ELITE ->       MMCConfig.MEK_MM_MACHINE_CONDIG.ElitePlantingStationFactory;
            case ULTIMATE ->    MMCConfig.MEK_MM_MACHINE_CONDIG.UltimatePlantingStationFactory;
        };
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekanism_extras.common.tile.factory.TileEntityExtraItemStackGasToItemStackFactory;
import com.jerry.mekanism_extras.common.tile.factory.TileEntityExtraItemToItemFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackGasToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraItemStackGasToItemStackFactory.class,remap = false)
public abstract class MixinTileEntityExtraItemStackGasToItemStackFactory extends TileEntityExtraItemToItemFactory<ItemStackGasToItemStackRecipe> implements IHasDumpButton,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ItemStackGasToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {

    protected MixinTileEntityExtraItemStackGasToItemStackFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long createModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        return switch (type) {
            case COMPRESSING -> switch (this.tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCompressing.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCompressing.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCompressing.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCompressing.get();
            };
            case INJECTING -> switch (this.tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteInjecting.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeInjecting.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicInjecting.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteInjecting.get();
            };
            default -> switch (this.tier) { //PURIFYING
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePurifying.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePurifying.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPurifying.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePurifying.get();
            };
        };
    }
}

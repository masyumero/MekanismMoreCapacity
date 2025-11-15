package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekanism_extras.common.tile.factory.TileEntityItemStackGasToItemStackExtraFactory;
import com.jerry.mekanism_extras.common.tile.factory.TileEntityItemToItemExtraFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.ChemicalTankBuilder;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasTank;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackGasToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeFactoryType;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemStackGasToItemStackExtraFactory.class,remap = false)
public abstract class MixinTileEntityItemStackGasToItemStackExtraFactory extends TileEntityItemToItemExtraFactory<ItemStackGasToItemStackRecipe> implements IHasDumpButton,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ItemStackGasToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {

    protected MixinTileEntityItemStackGasToItemStackExtraFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @Shadow
    public IGasTank gasTank;

    @Redirect(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder<Gas, GasStack, IGasTank> getInitialGasTanks(ChemicalTankHelper instance, IContentsListener listener) {
        ChemicalTankHelper<Gas, GasStack, IGasTank> builder = ChemicalTankHelper.forSideGasWithConfig(this::getDirection, this::getConfig);
        if (allowExtractingChemical()) {
            gasTank = ChemicalTankBuilder.GAS.create(mekanismMoreCapacity$getConfigValue(), this::containsRecipeB,
                    markAllMonitorsChanged(listener));
        } else {
            gasTank = ChemicalTankBuilder.GAS.input(mekanismMoreCapacity$getConfigValue(), this::containsRecipeB,
                    markAllMonitorsChanged(listener));
        }
        builder.addTank(gasTank);
        return builder.build();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        return switch (this.tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteFactories.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeFactories.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicFactories.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteFactories.get();
        };
    }

    @Shadow
    private boolean allowExtractingChemical() {
        return Attribute.get(blockProvider, AttributeFactoryType.class).getFactoryType() == FactoryType.COMPRESSING;
    }
}

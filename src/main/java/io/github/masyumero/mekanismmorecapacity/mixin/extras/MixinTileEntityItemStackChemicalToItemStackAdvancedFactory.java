package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekextras.common.tile.factory.TileEntityItemStackChemicalToItemStackAdvancedFactory;
import com.jerry.mekextras.common.tile.factory.TileEntityItemToItemAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
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
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemStackChemicalToItemStackAdvancedFactory.class,remap = false)
public abstract class MixinTileEntityItemStackChemicalToItemStackAdvancedFactory extends TileEntityItemToItemAdvancedFactory<ItemStackChemicalToItemStackRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<ItemStackChemicalToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {

    @Shadow
    public IChemicalTank chemicalTank;

    protected MixinTileEntityItemStackChemicalToItemStackAdvancedFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @Redirect(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanksRedirect(ChemicalTankHelper instance, IContentsListener listener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        //If the tank's contents change make sure to call our extended content listener that also marks sorting as being needed
        // as maybe the valid recipes have changed, and we need to sort again and have all recipes know they may need to be rechecked
        // if they are not still valid
        long capacity = Attribute.getOrThrow(getBlockHolder(), AttributeFactoryType.class).getFactoryType() == FactoryType.INFUSING ? mekanismMoreCapacity$getInfusingConfigValue() : mekanismMoreCapacity$getFactoryConfigValue();
        if (allowExtractingChemical()) {
            chemicalTank = BasicChemicalTank.createModern(capacity, this::containsRecipeB, markAllMonitorsChanged(listener));
        } else {
            chemicalTank = BasicChemicalTank.inputModern(capacity, this::containsRecipeB, markAllMonitorsChanged(listener));
        }
        builder.addTank(chemicalTank);
        return builder.build();
    }

    @Unique
    private long mekanismMoreCapacity$getInfusingConfigValue() {
        return switch (this.tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteMetallurgicInfuserFactoryExtras.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeMetallurgicInfuserFactoryExtras.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicMetallurgicInfuserFactoryExtras.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteMetallurgicInfuserFactoryExtras.get();
        };
    }

    @Unique
    private long mekanismMoreCapacity$getFactoryConfigValue() {
        return switch (this.tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteFactories.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeFactories.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicFactories.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteFactories.get();
        };
    }

    @Unique
    private boolean allowExtractingChemical() {
        FactoryType factoryType = Attribute.getOrThrow(getBlockHolder(), AttributeFactoryType.class).getFactoryType();
        return factoryType == FactoryType.COMPRESSING || factoryType == FactoryType.INFUSING;
    }
}

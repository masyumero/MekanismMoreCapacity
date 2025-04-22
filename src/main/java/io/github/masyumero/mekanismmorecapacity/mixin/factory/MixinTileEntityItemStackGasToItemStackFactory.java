package io.github.masyumero.mekanismmorecapacity.mixin.factory;

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
import mekanism.common.tile.factory.TileEntityItemStackGasToItemStackFactory;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemStackGasToItemStackFactory.class,remap = false)
public abstract class MixinTileEntityItemStackGasToItemStackFactory extends TileEntityItemToItemFactory<ItemStackGasToItemStackRecipe> implements IHasDumpButton,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ItemStackGasToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {
    
    protected MixinTileEntityItemStackGasToItemStackFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }
    
    @Shadow
    public IGasTank gasTank;
    
    @Redirect(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder<Gas, GasStack, IGasTank> getInitialGasTanks(ChemicalTankHelper instance, IContentsListener listener) {
        ChemicalTankHelper<Gas, GasStack, IGasTank> builder = ChemicalTankHelper.forSideGasWithConfig(this::getDirection, this::getConfig);
        if (mekanismMoreCapacity$allowExtractingChemical()) {
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
    private String mekanismMoreCapacity$getTier() {
        return tier.getBaseTier().getSimpleName();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (mekanismMoreCapacity$getTier()) {
                case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
                case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OVERCLOCKEDFactories.get();
                case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QUANTUMFactories.get();
                case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DENSEFactories.get();
                case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MULTIVERSALFactories.get();
                case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CREATIVEFactories.get();
                default -> throw new IllegalStateException("Unexpected value: " + mekanismMoreCapacity$getTier());
            };
        } else {
            return switch (mekanismMoreCapacity$getTier()) {
                case  "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case  "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case  "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case  "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
                default -> throw new IllegalStateException("Unexpected value: " + mekanismMoreCapacity$getTier());
            };
        }
    }

    @Unique
    private boolean mekanismMoreCapacity$allowExtractingChemical() {
        return Attribute.get(blockProvider, AttributeFactoryType.class).getFactoryType() == FactoryType.COMPRESSING;
    }
}

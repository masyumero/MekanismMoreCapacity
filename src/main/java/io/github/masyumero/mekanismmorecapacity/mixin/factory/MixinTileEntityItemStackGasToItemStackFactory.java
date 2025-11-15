package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackGasToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.factory.TileEntityItemStackGasToItemStackFactory;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemStackGasToItemStackFactory.class,remap = false)
public abstract class MixinTileEntityItemStackGasToItemStackFactory extends TileEntityItemToItemFactory<ItemStackGasToItemStackRecipe> implements IHasDumpButton,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ItemStackGasToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {
    
    protected MixinTileEntityItemStackGasToItemStackFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }
    
    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg_0(long capacity) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @ModifyArg(method = "getInitialGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg_1(long capacity) {
        return mekanismMoreCapacity$getConfigValue();
    }



    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
                case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OVERCLOCKEDFactories.get();
                case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QUANTUMFactories.get();
                case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DENSEFactories.get();
                case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MULTIVERSALFactories.get();
                case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CREATIVEFactories.get();
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (TierUtil.getTierName(tier)) {
                case  "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case  "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case  "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case  "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        }
    }

}

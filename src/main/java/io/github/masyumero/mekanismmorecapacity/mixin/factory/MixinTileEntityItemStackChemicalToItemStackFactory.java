package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.factory.TileEntityItemStackChemicalToItemStackFactory;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemStackChemicalToItemStackFactory.class,remap = false)
public abstract class MixinTileEntityItemStackChemicalToItemStackFactory extends TileEntityItemToItemFactory<ItemStackChemicalToItemStackRecipe> implements IHasDumpButton,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<ItemStackChemicalToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {

    protected MixinTileEntityItemStackChemicalToItemStackFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    public long inputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    @Unique
    private CachedLongValue getConfigValue() {
        if (getFactoryType() == FactoryType.COMPRESSING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicCompressing;
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedCompressing;
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteCompressing;
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateCompressing;
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OverclockedCompressing;
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QuantumCompressing;
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DenseCompressing;
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MultiversalCompressing;
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CreativeCompressing;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicCompressing;
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedCompressing;
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteCompressing;
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateCompressing;
                };
            }
        } else if(getFactoryType() == FactoryType.INJECTING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicInjecting;
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedInjecting;
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteInjecting;
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting;
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Overclockedinjecting;
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Quantuminjecting;
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Denseinjecting;
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Multiversalinjecting;
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Creativeinjecting;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicInjecting;
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedInjecting;
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteInjecting;
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting;
                };
            }
        } else if(getFactoryType() == FactoryType.INFUSING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicMetallurgicInfuserFactory;
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedMetallurgicInfuserFactory;
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteMetallurgicInfuserFactory;
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateMetallurgicInfuserFactory;
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OverclockedMetallurgicInfuserFactoryEvolved;
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QuantumMetallurgicInfuserFactoryEvolved;
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DenseMetallurgicInfuserFactoryEvolved;
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MultiversalMetallurgicInfuserFactoryEvolved;
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CreativeMetallurgicInfuserFactoryEvolved;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicMetallurgicInfuserFactory;
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedMetallurgicInfuserFactory;
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteMetallurgicInfuserFactory;
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateMetallurgicInfuserFactory;
                };
            }
        } else {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicPurifying;
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedPurifying;
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.ElitePurifying;
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting;
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Overclockedpurifying;
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Quantumpurifying;
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Densepurifying;
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Multiversalpurifying;
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Creativepurifying;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicPurifying;
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedPurifying;
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.ElitePurifying;
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimatePurifying;
                };
            }
        }
    }
}


package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeFactoryType;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.tile.factory.TileEntityItemStackChemicalToItemStackFactory;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
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

@Mixin(value = TileEntityItemStackChemicalToItemStackFactory.class, remap = false)
public abstract class MixinTileEntityItemStackChemicalToItemStackFactory extends TileEntityItemToItemFactory<ItemStackChemicalToItemStackRecipe> {

    protected MixinTileEntityItemStackChemicalToItemStackFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long createModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        FactoryType type = Attribute.getOrThrow(getBlockHolder(), AttributeFactoryType.class).getFactoryType();
        if (type == FactoryType.COMPRESSING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicCompressing.get();
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedCompressing.get();
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteCompressing.get();
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateCompressing.get();
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OverclockedCompressing.get();
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QuantumCompressing.get();
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DenseCompressing.get();
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MultiversalCompressing.get();
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CreativeCompressing.get();
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicCompressing.get();
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedCompressing.get();
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteCompressing.get();
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateCompressing.get();
                };
            }
        } else if(type == FactoryType.INJECTING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicInjecting.get();
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedInjecting.get();
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteInjecting.get();
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting.get();
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Overclockedinjecting.get();
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Quantuminjecting.get();
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Denseinjecting.get();
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Multiversalinjecting.get();
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Creativeinjecting.get();
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicInjecting.get();
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedInjecting.get();
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteInjecting.get();
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting.get();
                };
            }
        } else if(type == FactoryType.INFUSING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicMetallurgicInfuserFactory.get();
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedMetallurgicInfuserFactory.get();
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.EliteMetallurgicInfuserFactory.get();
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateMetallurgicInfuserFactory.get();
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.OverclockedMetallurgicInfuserFactoryEvolved.get();
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.QuantumMetallurgicInfuserFactoryEvolved.get();
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.DenseMetallurgicInfuserFactoryEvolved.get();
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.MultiversalMetallurgicInfuserFactoryEvolved.get();
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.CreativeMetallurgicInfuserFactoryEvolved.get();
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicMetallurgicInfuserFactory.get();
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedMetallurgicInfuserFactory.get();
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.EliteMetallurgicInfuserFactory.get();
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimateMetallurgicInfuserFactory.get();
                };
            }
        } else {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MACHINE_CONFIG.BasicPurifying.get();
                    case "Advanced" -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedPurifying.get();
                    case "Elite" -> MMCConfig.MEK_MACHINE_CONFIG.ElitePurifying.get();
                    case "Ultimate" -> MMCConfig.MEK_MACHINE_CONFIG.UltimateInjecting.get();
                    case "Overclocked" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Overclockedpurifying.get();
                    case "Quantum" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Quantumpurifying.get();
                    case "Dense" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Densepurifying.get();
                    case "Multiversal" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Multiversalpurifying.get();
                    case "Creative" -> MMCConfig.EVO_MEK_MACHINE_CONFIG.Creativepurifying.get();
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MACHINE_CONFIG.BasicPurifying.get();
                    case ADVANCED -> MMCConfig.MEK_MACHINE_CONFIG.AdvancedPurifying.get();
                    case ELITE -> MMCConfig.MEK_MACHINE_CONFIG.ElitePurifying.get();
                    case ULTIMATE -> MMCConfig.MEK_MACHINE_CONFIG.UltimatePurifying.get();
                };
            }
        }
    }
}


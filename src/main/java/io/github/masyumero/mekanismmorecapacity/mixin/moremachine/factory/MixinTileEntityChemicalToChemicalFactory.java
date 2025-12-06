package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.content.blocktype.AdvancedFactoryType;
import com.jerry.mekaf.common.tile.factory.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.factory.TileEntityChemicalToChemicalFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityChemicalToChemicalFactory.class,remap = false)
public abstract class MixinTileEntityChemicalToChemicalFactory<RECIPE extends MekanismRecipe<?>> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityChemicalToChemicalFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
        if (getAdvancedFactoryType() == AdvancedFactoryType.CENTRIFUGING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryinput;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryinput;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryinput;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryinput;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedCentrifugingFactoryinput;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumCentrifugingFactoryinput;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseCentrifugingFactoryinput;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalCentrifugingFactoryinput;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeCentrifugingFactoryinput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryinput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryinput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryinput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryinput;
                };
            }
        } else if (getAdvancedFactoryType() == AdvancedFactoryType.WASHING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryInput;
                    case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryInput;
                    case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryInput;
                    case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryInput;
                    case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedWashingFactoryInput;
                    case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumWashingFactoryInput;
                    case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseWashingFactoryInput;
                    case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalWashingFactoryInput;
                    case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeWashingFactoryInput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryInput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryInput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryInput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryInput;
                };
            }
        } else {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryinputL;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryinputL;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryinputL;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryinputL;
                    case "Overclocked" ->
                            MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedChemicalToChemicalFactoryinputL;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumChemicalToChemicalFactoryinputL;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseChemicalToChemicalFactoryinputL;
                    case "Multiversal" ->
                            MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalChemicalToChemicalFactoryinputL;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeChemicalToChemicalFactoryinputL;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryinputL;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryinputL;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryinputL;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryinputL;
                };
            }
        }
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getOutputConfigValue().get();
    }

    private CachedLongValue getOutputConfigValue() {
        if (getAdvancedFactoryType() == AdvancedFactoryType.CENTRIFUGING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryoutput;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryoutput;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryoutput;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryoutput;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedCentrifugingFactoryoutput;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumCentrifugingFactoryoutput;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseCentrifugingFactoryoutput;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalCentrifugingFactoryoutput;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeCentrifugingFactoryoutput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryoutput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryoutput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryoutput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryoutput;
                };
            }
        } else if (getAdvancedFactoryType() == AdvancedFactoryType.WASHING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryOutput;
                    case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryOutput;
                    case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryOutput;
                    case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryOutput;
                    case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedWashingFactoryOutput;
                    case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumWashingFactoryOutput;
                    case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseWashingFactoryOutput;
                    case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalWashingFactoryOutput;
                    case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeWashingFactoryOutput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryOutput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryOutput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryOutput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryOutput;
                };
            }
        } else {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryoutput;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryoutput;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryoutput;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryoutput;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedChemicalToChemicalFactoryoutput;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumChemicalToChemicalFactoryoutput;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseChemicalToChemicalFactoryoutput;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalChemicalToChemicalFactoryoutput;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeChemicalToChemicalFactoryoutput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryoutput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryoutput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryoutput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryoutput;
                };
            }
        }
    }
}

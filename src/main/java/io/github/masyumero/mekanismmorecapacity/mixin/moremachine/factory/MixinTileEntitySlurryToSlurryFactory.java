package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.base.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.base.TileEntitySlurryToSlurryFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntitySlurryToSlurryFactory.class, remap = false)
public abstract class MixinTileEntitySlurryToSlurryFactory<RECIPE extends MekanismRecipe> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntitySlurryToSlurryFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addSlurryTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
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
    }

    @ModifyArg(method = "addSlurryTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getOutputConfigValue().get();
    }

    private CachedLongValue getOutputConfigValue() {
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
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.base.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.base.TileEntityGasToGasFactory;
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

@Mixin(value = TileEntityGasToGasFactory.class,remap = false)
public abstract class MixinTileEntityGasToGasFactory<RECIPE extends MekanismRecipe> extends TileEntityAdvancedFactoryBase<RECIPE>  {

    protected MixinTileEntityGasToGasFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
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
    }

    @ModifyArg(method = "addGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getOutputConfigValue().get();
    }

    private CachedLongValue getOutputConfigValue() {
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
    }
}

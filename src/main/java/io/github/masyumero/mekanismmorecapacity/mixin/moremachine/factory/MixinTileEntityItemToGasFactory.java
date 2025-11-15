package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.base.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.base.TileEntityItemToGasFactory;
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

@Mixin(value = TileEntityItemToGasFactory.class,remap = false)
public abstract class MixinTileEntityItemToGasFactory<RECIPE extends MekanismRecipe> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityItemToGasFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    private CachedLongValue getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicOxidizingFactory;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedOxidizingFactory;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteOxidizingFactory;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateOxidizingFactory;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedOxidizingFactory;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumOxidizingFactory;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseOxidizingFactory;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalOxidizingFactory;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeOxidizingFactory;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicOxidizingFactory;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedOxidizingFactory;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteOxidizingFactory;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateOxidizingFactory;
            };
        }
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.base.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.base.TileEntityItemToMergedFactory;
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

@Mixin(value = TileEntityItemToMergedFactory.class, remap = false)
public abstract class MixinTileEntityItemToMergedFactory<RECIPE extends MekanismRecipe> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityItemToMergedFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "presetVariables", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    private CachedLongValue getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryOutput;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryOutput;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryOutput;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryOutput;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedDissolvingFactoOutput;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumDissolvingFactoryOutput;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseDissolvingFactoryOutput;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalDissolvingFactoOutput;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeDissolvingFactoryOutput;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryOutput;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryOutput;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryOutput;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryOutput;
            };
        }
    }
}

package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.TileEntityCrystallizingFactory;
import com.jerry.mekaf.common.tile.base.TileEntityMergedToItemFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ChemicalCrystallizerRecipe;
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

@Mixin(value = TileEntityCrystallizingFactory.class,remap = false)
public abstract class MixinTileEntityCrystallizingFactory extends TileEntityMergedToItemFactory<ChemicalCrystallizerRecipe> {

    protected MixinTileEntityCrystallizingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "presetVariables",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    private CachedLongValue getConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCrystallizingFactory;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCrystallizingFactory;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCrystallizingFactory;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCrystallizingFactory;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedCrystallizingFactory;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumCrystallizingFactory;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseCrystallizingFactory;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalCrystallizingFactory;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeCrystallizingFactory;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCrystallizingFactory;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCrystallizingFactory;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCrystallizingFactory;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCrystallizingFactory;
            };
        }
    }
}

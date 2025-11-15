package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.TileEntityWashingFactory;
import com.jerry.mekaf.common.tile.base.TileEntitySlurryToSlurryFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.slurry.Slurry;
import mekanism.api.chemical.slurry.SlurryStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.FluidSlurryToSlurryRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityWashingFactory.class, remap = false)
public abstract class MixinTileEntityWashingFactory extends TileEntitySlurryToSlurryFactory<FluidSlurryToSlurryRecipe> implements IDoubleRecipeLookupHandler.FluidChemicalRecipeLookupHandler<Slurry, SlurryStack, FluidSlurryToSlurryRecipe>, IHasDumpButton {

    protected MixinTileEntityWashingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int inputFluidTunkModify(int capacity) {
        return getInputConfigValue().get();
    }

    private CachedIntValue getInputConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactory;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactory;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactory;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactory;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedWashingFactory;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumWashingFactory;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseWashingFactory;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalWashingFactory;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeWashingFactory;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactory;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactory;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactory;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactory;
            };
        }
    }
}

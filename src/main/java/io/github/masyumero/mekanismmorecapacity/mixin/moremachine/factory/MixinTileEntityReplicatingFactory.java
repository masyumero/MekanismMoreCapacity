package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekmm.common.tile.factory.TileEntityItemToItemMoreMachineFactory;
import com.jerry.mekmm.common.tile.factory.TileEntityReplicatingFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackGasToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
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

@Mixin(value = TileEntityReplicatingFactory.class,remap = false)
public abstract class MixinTileEntityReplicatingFactory extends TileEntityItemToItemMoreMachineFactory<ItemStackGasToItemStackRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ItemStackGasToItemStackRecipe> {

    protected MixinTileEntityReplicatingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicReplicatorFactory;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedReplicatorFactory;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteReplicatorFactory;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateReplicatorFactory;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedReplicatorFactory;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumReplicatorFactory;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseReplicatorFactory;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalReplicatorFactory;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeReplicatorFactory;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicReplicatorFactory;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedReplicatorFactory;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteReplicatorFactory;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateReplicatorFactory;
            };
        }
    }
}

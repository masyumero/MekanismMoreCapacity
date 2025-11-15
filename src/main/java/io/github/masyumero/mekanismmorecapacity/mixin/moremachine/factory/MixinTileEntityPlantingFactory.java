package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekmm.api.recipes.PlantingRecipe;
import com.jerry.mekmm.common.tile.factory.TileEntityMoreMachineFactory;
import com.jerry.mekmm.common.tile.factory.TileEntityPlantingFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityPlantingFactory.class,remap = false)
public abstract class MixinTileEntityPlantingFactory extends TileEntityMoreMachineFactory<PlantingRecipe> implements IHasDumpButton, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, PlantingRecipe> {

    protected MixinTileEntityPlantingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPlantingStationFactory;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPlantingStationFactory;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePlantingStationFactory;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePlantingStationFactory;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedPlantingStationFactory;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumPlantingStationFactory;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DensePlantingStationFactory;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalPlantingStationFactory;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativePlantingStationFactory;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPlantingStationFactory;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPlantingStationFactory;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePlantingStationFactory;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePlantingStationFactory;
            };
        }
    }
}

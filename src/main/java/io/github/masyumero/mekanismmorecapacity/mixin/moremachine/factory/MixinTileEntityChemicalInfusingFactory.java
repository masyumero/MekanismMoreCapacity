package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.TileEntityChemicalInfusingFactory;
import com.jerry.mekaf.common.tile.base.TileEntityGasToGasFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ChemicalInfuserRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.recipe.lookup.IEitherSideRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityChemicalInfusingFactory.class,remap = false)
public abstract class MixinTileEntityChemicalInfusingFactory extends TileEntityGasToGasFactory<ChemicalInfuserRecipe> implements IEitherSideRecipeLookupHandler.EitherSideChemicalRecipeLookupHandler<Gas, GasStack, ChemicalInfuserRecipe>, IHasDumpButton {


    protected MixinTileEntityChemicalInfusingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    private CachedLongValue getConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryinputR;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryinputR;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryinputR;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryinputR;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedChemicalToChemicalFactoryinputR;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumChemicalToChemicalFactoryinputR;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseChemicalToChemicalFactoryinputR;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalChemicalToChemicalFactoryinputR;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeChemicalToChemicalFactoryinputR;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicChemicalToChemicalFactoryinputR;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedChemicalToChemicalFactoryinputR;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteChemicalToChemicalFactoryinputR;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateChemicalToChemicalFactoryinputR;
            };
        }
    }
}

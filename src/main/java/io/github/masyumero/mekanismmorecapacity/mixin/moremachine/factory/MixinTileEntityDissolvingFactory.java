package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.TileEntityDissolvingFactory;
import com.jerry.mekaf.common.tile.base.TileEntityItemToMergedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ChemicalDissolutionRecipe;
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

@Mixin(value = TileEntityDissolvingFactory.class,remap = false)
public abstract class MixinTileEntityDissolvingFactory extends TileEntityItemToMergedFactory<ChemicalDissolutionRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<Gas, GasStack, ChemicalDissolutionRecipe> {

    protected MixinTileEntityDissolvingFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addGasTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;input(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getConfigValue().get();
    }

    private CachedLongValue getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryInput;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryInput;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryInput;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryInput;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedDissolvingFactoryInput;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumDissolvingFactoryInput;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseDissolvingFactoryInput;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalDissolvingFactoryInput;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeDissolvingFactoryInput;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryInput;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryInput;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryInput;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryInput;
            };
        }
    }
}

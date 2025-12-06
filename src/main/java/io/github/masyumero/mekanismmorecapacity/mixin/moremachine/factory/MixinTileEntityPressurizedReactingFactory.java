package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.factory.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.factory.TileEntityPressurizedReactingFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.recipes.PressurizedReactionRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.recipe.lookup.ITripleRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityPressurizedReactingFactory.class, remap = false)
public abstract class MixinTileEntityPressurizedReactingFactory extends TileEntityAdvancedFactoryBase<PressurizedReactionRecipe> implements IHasDumpButton, ITripleRecipeLookupHandler.ItemFluidChemicalRecipeLookupHandler<PressurizedReactionRecipe> {

    protected MixinTileEntityPressurizedReactingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getInputConfigValue().get();
    }

    private CachedLongValue getInputConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPressurizedReactingFactoryinput;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPressurizedReactingFactoryinput;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePressurizedReactingFactoryinput;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePressurizedReactingFactoryinput;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedPressurizedReactingFactoryinput;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumPressurizedReactingFactoryinput;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DensePressurizedReactingFactoryinput;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalPressurizedReactingFactoryinput;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativePressurizedReactingFactoryinput;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPressurizedReactingFactoryinput;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPressurizedReactingFactoryinput;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePressurizedReactingFactoryinput;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePressurizedReactingFactoryinput;
            };
        }
    }

    @ModifyArg(method = "addTanks",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return getOutputConfigValue().get();
    }

    private CachedLongValue getOutputConfigValue() {
        if (ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPressurizedReactingFactoryoutput;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPressurizedReactingFactoryoutput;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePressurizedReactingFactoryoutput;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePressurizedReactingFactoryoutput;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedPressurizedReactingFactoryoutput;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumPressurizedReactingFactoryoutput;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DensePressurizedReactingFactoryoutput;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalPressurizedReactingFactoryoutput;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativePressurizedReactingFactoryoutput;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicPressurizedReactingFactoryoutput;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedPressurizedReactingFactoryoutput;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.ElitePressurizedReactingFactoryoutput;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimatePressurizedReactingFactoryoutput;
            };
        }
    }
}

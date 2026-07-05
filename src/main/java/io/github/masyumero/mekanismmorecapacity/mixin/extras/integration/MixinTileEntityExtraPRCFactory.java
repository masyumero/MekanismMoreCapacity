package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.TileEntityExtraPRCFactory;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.PressurizedReactionRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraPRCFactory.class, remap = false)
public abstract class MixinTileEntityExtraPRCFactory extends TileEntityExtraAdvancedFactoryBase<PressurizedReactionRecipe> {

    protected MixinTileEntityExtraPRCFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return mekanismMoreCapacity$getOutputCapacity();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int inputFluidModifyArg(int capacity) {
        return mekanismMoreCapacity$getInputFluidCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePRCInput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePRCInput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPRCInput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePRCInput.get();
        };
    }

    @Unique
    private long mekanismMoreCapacity$getOutputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePRCOutput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePRCOutput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPRCOutput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePRCOutput.get();
        };
    }

    @Unique
    private int mekanismMoreCapacity$getInputFluidCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePRCFluidInput.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePRCFluidInput.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPRCFluidInput.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePRCFluidInput.get();
        };
    }
}

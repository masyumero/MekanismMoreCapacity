package io.github.masyumero.mekanismmorecapacity.mixin.extras.integration;

import com.jerry.mekextras.common.integration.mekaf.tile.factory.TileEntityExtraLiquifyingFactory;
import com.jerry.mekextras.common.integration.mekaf.tile.factory.base.TileEntityExtraAdvancedFactoryBase;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.basic.BasicItemStackToFluidOptionalItemRecipe;
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

@Mixin(value = TileEntityExtraLiquifyingFactory.class, remap = false)
public abstract class MixinTileEntityExtraLiquifyingFactory extends TileEntityExtraAdvancedFactoryBase<BasicItemStackToFluidOptionalItemRecipe> {

    protected MixinTileEntityExtraLiquifyingFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int outputModifyArg(int capacity) {
        return mekanismMoreCapacity$getOutputCapacity();
    }

    @Unique
    private int mekanismMoreCapacity$getOutputCapacity() {
        return switch (tier) {
            case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteLiquifying.get();
            case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeLiquifying.get();
            case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicLiquifying.get();
            case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteLiquifying.get();
        };
    }
}

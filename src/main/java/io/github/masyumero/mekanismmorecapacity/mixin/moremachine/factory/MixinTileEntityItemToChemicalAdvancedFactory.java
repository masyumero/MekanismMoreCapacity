package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.tile.factory.TileEntityAdvancedFactoryBase;
import com.jerry.mekaf.common.tile.factory.TileEntityItemToChemicalAdvancedFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.tier.FactoryTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityItemToChemicalAdvancedFactory.class,remap = false)
public abstract class MixinTileEntityItemToChemicalAdvancedFactory<RECIPE extends MekanismRecipe<?>> extends TileEntityAdvancedFactoryBase<RECIPE> {

    protected MixinTileEntityItemToChemicalAdvancedFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return getConfigValue(this.tier).get();
    }

    private CachedLongValue getConfigValue(FactoryTier tier) {
        return switch (tier) {
            case BASIC -> MMCConfig.MEK_MM_MACHINE_CONDIG.BasicOxidizingFactory;
            case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONDIG.AdvancedOxidizingFactory;
            case ELITE -> MMCConfig.MEK_MM_MACHINE_CONDIG.EliteOxidizingFactory;
            case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONDIG.UltimateOxidizingFactory;
        };
    }
}

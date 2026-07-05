package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ChemicalChemicalToChemicalRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.IEitherSideRecipeLookupHandler;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import mekanism.common.tile.prefab.TileEntityRecipeMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntityChemicalInfuser.class,remap = false)
public abstract class MixinTileEntityChemicalInfuser extends TileEntityRecipeMachine<ChemicalChemicalToChemicalRecipe> implements
        IEitherSideRecipeLookupHandler.EitherSideChemicalRecipeLookupHandler<ChemicalChemicalToChemicalRecipe> {

    protected MixinTileEntityChemicalInfuser(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes) {
        super(blockProvider, pos, state, errorTypes);
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 0))
    private long leftTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserLeft.get();
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;", ordinal = 1))
    private long rightTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserRight.get();
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputTankModifyArg(long capacity) {
        return MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserCenter.get();
    }
}

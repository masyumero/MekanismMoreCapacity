package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.tiles.machine.TileEntityMelter;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ItemStackToFluidRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.ISingleRecipeLookupHandler;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntityMelter.class, remap = false)
public abstract class MixinTileEntityMelter extends TileEntityProgressMachine<ItemStackToFluidRecipe> implements ISingleRecipeLookupHandler.ItemRecipeLookupHandler<ItemStackToFluidRecipe> {

    protected MixinTileEntityMelter(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;output(ILmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;"))
    private int getInitialFluidTanksModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.Thermalizer.get();
    }
}

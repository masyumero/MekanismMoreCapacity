package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.tiles.machine.TileEntityMelter;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ItemStackToFluidRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.ISingleRecipeLookupHandler;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.List;

@Mixin(value = TileEntityMelter.class, remap = false)
public abstract class MixinTileEntityMelter extends TileEntityProgressMachine<ItemStackToFluidRecipe> implements ISingleRecipeLookupHandler.ItemRecipeLookupHandler<ItemStackToFluidRecipe> {

    protected MixinTileEntityMelter(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyConstant(method = "getInitialFluidTanks", constant = @Constant(intValue = 16000))
    private int getInitialFluidTanksModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.THERMALIZER.get();
    }
}

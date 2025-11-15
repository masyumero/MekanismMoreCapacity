package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.interfaces.EMInputRecipeCache;
import fr.iglee42.evolvedmekanism.recipes.SolidificationRecipe;
import fr.iglee42.evolvedmekanism.tiles.machine.TileEntitySolidifier;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.List;

@Mixin(value = TileEntitySolidifier.class, remap = false)
public abstract class MixinTileEntitySolidifier extends TileEntityProgressMachine<SolidificationRecipe> implements
        EMInputRecipeCache.ItemFluidFluidRecipeLookupHandler<SolidificationRecipe> {

    protected MixinTileEntitySolidifier(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyConstant(method = "getInitialFluidTanks", constant = @Constant(intValue = 10000, ordinal = 0))
    private int inputFluidTankModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SOLIDIFIERMOLTENMATERIAL.get();
    }

    @ModifyConstant(method = "getInitialFluidTanks", constant = @Constant(intValue = 10000, ordinal = 1))
    private int inputFluidExtraTankModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SOLIDIFIERCOOLANTTANK.get();
    }
}

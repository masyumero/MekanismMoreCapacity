package io.github.masyumero.mekanismmorecapacity.mixin.evolved;

import fr.iglee42.evolvedmekanism.interfaces.EMInputRecipeCache;
import fr.iglee42.evolvedmekanism.recipes.SolidificationRecipe;
import fr.iglee42.evolvedmekanism.tiles.machine.TileEntitySolidifier;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntitySolidifier.class, remap = false)
public abstract class MixinTileEntitySolidifier extends TileEntityProgressMachine<SolidificationRecipe> implements
        EMInputRecipeCache.ItemFluidFluidRecipeLookupHandler<SolidificationRecipe> {

    protected MixinTileEntitySolidifier(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;", ordinal = 0))
    private int inputFluidTankModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SolidifierMoltenMaterial.get();
    }

    @ModifyArg(method = "getInitialFluidTanks", at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/fluid/BasicFluidTank;input(ILjava/util/function/Predicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/common/capabilities/fluid/BasicFluidTank;", ordinal = 1))
    private int inputFluidExtraTankModify(int constant) {
        return MMCConfig.EVO_MEK_MACHINE_CONFIG.SolidifierCoolantTank.get();
    }
}

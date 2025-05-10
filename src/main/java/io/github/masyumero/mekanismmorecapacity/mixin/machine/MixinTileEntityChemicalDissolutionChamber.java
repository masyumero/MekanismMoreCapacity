package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.recipes.ChemicalDissolutionRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.inventory.slot.InputInventorySlot;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.machine.TileEntityChemicalDissolutionChamber;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityChemicalDissolutionChamber.class,remap = false)
public abstract class MixinTileEntityChemicalDissolutionChamber extends TileEntityProgressMachine<ChemicalDissolutionRecipe> implements IRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<ChemicalDissolutionRecipe> {

    @Shadow
    public IChemicalTank injectTank;
    @Shadow
    public IChemicalTank outputTank;
    @Shadow
    InputInventorySlot inputSlot;

    protected MixinTileEntityChemicalDissolutionChamber(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanks(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(injectTank = BasicChemicalTank.inputModern(MMCConfig.MEK_MACHINE_CONFIG.ChemicalDissolutionChamberInput.get(), gas -> containsRecipeBA(this.inputSlot.getStack(), gas), this::containsRecipeB, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MMCConfig.MEK_MACHINE_CONFIG.ChemicalDissolutionChamberOutput.get(), recipeCacheUnpauseListener));
        return builder.build();
    }
}

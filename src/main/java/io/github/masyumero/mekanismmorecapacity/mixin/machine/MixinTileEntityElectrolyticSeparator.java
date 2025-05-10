package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.recipes.ElectrolysisRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.recipe.lookup.ISingleRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasGasMode;
import mekanism.common.tile.machine.TileEntityElectrolyticSeparator;
import mekanism.common.tile.prefab.TileEntityRecipeMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityElectrolyticSeparator.class,remap = false)
public abstract class MixinTileEntityElectrolyticSeparator extends TileEntityRecipeMachine<ElectrolysisRecipe> implements IHasGasMode, ISingleRecipeLookupHandler.FluidRecipeLookupHandler<ElectrolysisRecipe> {

    @Shadow
    public IChemicalTank leftTank;
    @Shadow
    public IChemicalTank rightTank;

    protected MixinTileEntityElectrolyticSeparator(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes) {
        super(blockProvider, pos, state, errorTypes);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanks(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(leftTank = BasicChemicalTank.output(MMCConfig.MEK_MACHINE_CONFIG.ElectrolyticSeparatorChemicalLeft.get(), recipeCacheUnpauseListener));
        builder.addTank(rightTank = BasicChemicalTank.output(MMCConfig.MEK_MACHINE_CONFIG.ElectrolyticSeparatorChemicalRight.get(), recipeCacheUnpauseListener));
        return builder.build();
    }

    @ModifyConstant(method = "getInitialFluidTanks",constant = @Constant(intValue = 24000))
    private int modifyFluidTankCapacity(int c){
        return MMCConfig.MEK_MACHINE_CONFIG.ElectrolyticSeparatorFluid.get();
    }
}

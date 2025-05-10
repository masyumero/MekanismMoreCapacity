package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.recipes.ChemicalChemicalToChemicalRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.recipe.lookup.IEitherSideRecipeLookupHandler;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import mekanism.common.tile.prefab.TileEntityRecipeMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityChemicalInfuser.class,remap = false)
public abstract class MixinTileEntityChemicalInfuser extends TileEntityRecipeMachine<ChemicalChemicalToChemicalRecipe> implements
        IEitherSideRecipeLookupHandler.EitherSideChemicalRecipeLookupHandler<ChemicalChemicalToChemicalRecipe> {

    @Shadow
    public IChemicalTank leftTank;
    @Shadow
    public IChemicalTank rightTank;
    @Shadow
    public IChemicalTank centerTank;

    protected MixinTileEntityChemicalInfuser(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes) {
        super(blockProvider, pos, state, errorTypes);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanksRedirect(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(leftTank = BasicChemicalTank.inputModern(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserLeft.get(), gas -> containsRecipe(gas, rightTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(rightTank = BasicChemicalTank.inputModern(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserRight.get(), gas -> containsRecipe(gas, leftTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(centerTank = BasicChemicalTank.output(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserCenter.get(), recipeCacheUnpauseListener));
        return builder.build();
    }
}

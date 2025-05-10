package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.ChemicalTankBuilder;
import mekanism.api.chemical.gas.Gas;
import mekanism.api.chemical.gas.GasStack;
import mekanism.api.chemical.gas.IGasTank;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.ChemicalInfuserRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.recipe.lookup.IEitherSideRecipeLookupHandler;
import mekanism.common.tile.machine.TileEntityChemicalInfuser;
import mekanism.common.tile.prefab.TileEntityRecipeMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityChemicalInfuser.class,remap = false,priority = 5000)
public abstract class MixinTileEntityChemicalInfuser extends TileEntityRecipeMachine<ChemicalInfuserRecipe> implements IEitherSideRecipeLookupHandler.EitherSideChemicalRecipeLookupHandler<Gas, GasStack, ChemicalInfuserRecipe> {

    @Shadow
    public IGasTank leftTank;
    @Shadow
    public IGasTank rightTank;
    @Shadow
    public IGasTank centerTank;

    protected MixinTileEntityChemicalInfuser(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes) {
        super(blockProvider, pos, state, errorTypes);
    }

    @Redirect(method = "getInitialGasTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder<Gas, GasStack, IGasTank> getInitialGasTanks(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener) {
        ChemicalTankHelper<Gas, GasStack, IGasTank> builder = ChemicalTankHelper.forSideGasWithConfig(this::getDirection, this::getConfig);
        builder.addTank(leftTank = ChemicalTankBuilder.GAS.input(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserleft.get(), gas -> containsRecipe(gas, rightTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(rightTank = ChemicalTankBuilder.GAS.input(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfuserright.get(), gas -> containsRecipe(gas, leftTank.getStack()), this::containsRecipe, recipeCacheListener));
        builder.addTank(centerTank = ChemicalTankBuilder.GAS.output(MMCConfig.MEK_MACHINE_CONFIG.ChemicalInfusercenter.get(), listener));
        return builder.build();
    }
}
package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSDoubleRecipeLookupHandler;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSRecipeLookupHandler;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityAdsorptionSeparator;
import com.fxd927.mekanismscience.common.tile.prefab.MSTileEntityProgressMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.integration.computer.SpecialComputerMethodWrapper;
import mekanism.common.integration.computer.annotation.WrappingComputerMethod;
import mekanism.common.inventory.slot.InputInventorySlot;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityAdsorptionSeparator.class,remap = false)
public abstract class MixinTileEntityAdsorptionSeparator extends MSTileEntityProgressMachine<RadiationIrradiatingRecipe> implements IMSRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IMSDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<RadiationIrradiatingRecipe> {

    @Shadow
    public IChemicalTank injectTank;
    @Shadow
    public IChemicalTank outputTank;
    @Shadow
    @WrappingComputerMethod(wrapper = SpecialComputerMethodWrapper.ComputerIInventorySlotWrapper.class, methodNames = "getInputItem", docPlaceholder = "input slot")
    InputInventorySlot inputSlot;

    protected MixinTileEntityAdsorptionSeparator(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanksRedirect(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(injectTank = BasicChemicalTank.inputModern(MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorInput.get(), gas -> containsRecipeBA(inputSlot.getStack(), gas), this::containsRecipeB, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.AdsorptionSeparatorOutput.get(), recipeCacheUnpauseListener));
        return builder.build();
    }
}

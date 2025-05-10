package io.github.masyumero.mekanismmorecapacity.mixin.science;

import com.fxd927.mekanismscience.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSDoubleRecipeLookupHandler;
import com.fxd927.mekanismscience.common.recipe.lookup.IMSRecipeLookupHandler;
import com.fxd927.mekanismscience.common.tile.machine.TileEntityRadiationIrradiator;
import com.fxd927.mekanismscience.common.tile.prefab.MSTileEntityProgressMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.chemical.attribute.ChemicalAttributeValidator;
import mekanism.api.functions.ConstantPredicates;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(value = TileEntityRadiationIrradiator.class,remap = false)
public abstract class MixinTileEntityRadiationIrradiator extends MSTileEntityProgressMachine<RadiationIrradiatingRecipe> implements IMSRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IMSDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<RadiationIrradiatingRecipe> {


    @Shadow
    public IChemicalTank injectTank;
    @Shadow
    public IChemicalTank outputTank;

    protected MixinTileEntityRadiationIrradiator(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanksRedirect(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        builder.addTank(injectTank = BasicChemicalTank.createModern(MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.RadiationIrradiatorInput.get(), ChemicalTankHelper.radioactiveInputTankPredicate(() -> outputTank),
                ConstantPredicates.alwaysTrueBi(), this::containsRecipeB, ChemicalAttributeValidator.ALWAYS_ALLOW, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.RadiationIrradiatorOutput.get(), recipeCacheUnpauseListener));
        return builder.build();
    }
}

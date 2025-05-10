package io.github.masyumero.mekanismmorecapacity.mixin.machine;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.BasicChemicalTank;
import mekanism.api.chemical.IChemicalTank;
import mekanism.api.chemical.attribute.ChemicalAttributeValidator;
import mekanism.api.functions.ConstantPredicates;
import mekanism.api.recipes.ChemicalToChemicalRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.recipe.lookup.ISingleRecipeLookupHandler;
import mekanism.common.tile.interfaces.IBoundingBlock;
import mekanism.common.tile.machine.TileEntityIsotopicCentrifuge;
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

@Mixin(value = TileEntityIsotopicCentrifuge.class,remap = false)
public abstract class MixinTileEntityIsotopicCentrifuge extends TileEntityRecipeMachine<ChemicalToChemicalRecipe> implements IBoundingBlock, ISingleRecipeLookupHandler.ChemicalRecipeLookupHandler<ChemicalToChemicalRecipe> {

    @Shadow
    public IChemicalTank inputTank;
    @Shadow
    public IChemicalTank outputTank;

    protected MixinTileEntityIsotopicCentrifuge(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes) {
        super(blockProvider, pos, state, errorTypes);
    }

    @Redirect(method = "getInitialChemicalTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder getInitialChemicalTanksRedirect(ChemicalTankHelper instance, IContentsListener listener, IContentsListener recipeCacheListener, IContentsListener recipeCacheUnpauseListener) {
        ChemicalTankHelper builder = ChemicalTankHelper.forSideWithConfig(this);
        //Allow extracting out of the input gas tank if it isn't external OR the output tank is empty AND the input is radioactive
        builder.addTank(inputTank = BasicChemicalTank.createModern(MMCConfig.MEK_MACHINE_CONFIG.IsotopicCentrifugeInput.get(), ChemicalTankHelper.radioactiveInputTankPredicate(() -> outputTank),
                ConstantPredicates.alwaysTrueBi(), this::containsRecipe, ChemicalAttributeValidator.ALWAYS_ALLOW, recipeCacheListener));
        builder.addTank(outputTank = BasicChemicalTank.output(MMCConfig.MEK_MACHINE_CONFIG.IsotopicCentrifugeOutput.get(), recipeCacheUnpauseListener));
        return builder.build();
    }
}

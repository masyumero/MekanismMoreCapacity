package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.IContentsListener;
import mekanism.api.chemical.ChemicalTankBuilder;
import mekanism.api.chemical.infuse.IInfusionTank;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfusionStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.MetallurgicInfuserRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.capabilities.holder.chemical.ChemicalTankHelper;
import mekanism.common.capabilities.holder.chemical.IChemicalTankHolder;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import mekanism.common.tile.factory.TileEntityMetallurgicInfuserFactory;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityMetallurgicInfuserFactory.class,remap = false)
public abstract class MixinTileEntityMetallurgicInfuserFactory extends TileEntityItemToItemFactory<MetallurgicInfuserRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<InfuseType, InfusionStack, MetallurgicInfuserRecipe> {

    @Shadow
    public IInfusionTank infusionTank;

    protected MixinTileEntityMetallurgicInfuserFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @Redirect(method = "getInitialInfusionTanks",at = @At(value = "INVOKE", target = "Lmekanism/common/capabilities/holder/chemical/ChemicalTankHelper;build()Lmekanism/common/capabilities/holder/chemical/IChemicalTankHolder;"))
    public IChemicalTankHolder<InfuseType, InfusionStack, IInfusionTank> getInitialInfusionTanksRedirect(ChemicalTankHelper instance, IContentsListener listener) {
        ChemicalTankHelper<InfuseType, InfusionStack, IInfusionTank> builder = ChemicalTankHelper.forSideInfusionWithConfig(this::getDirection, this::getConfig);
        builder.addTank(infusionTank = ChemicalTankBuilder.INFUSION.create(MMCConfig.MMCcommon.MetallurgicInfuserFactory.get() * tier.processes, this::containsRecipeB,
                markAllMonitorsChanged(listener)));
        return builder.build();
    }
    //@ModifyConstant(method = "getInitialInfusionTanks",constant = @Constant(longValue = 1000L))
    //private long modifyInputTankCapacity(long c){
    //    return MMCConfig.MMCcommon.MetallurgicInfuser.get();
    //}
}

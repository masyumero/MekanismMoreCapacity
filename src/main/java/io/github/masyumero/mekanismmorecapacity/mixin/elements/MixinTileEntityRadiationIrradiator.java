package io.github.masyumero.mekanismmorecapacity.mixin.elements;

import com.fxd927.mekanismelements.api.recipes.RadiationIrradiatingRecipe;
import com.fxd927.mekanismelements.common.recipe.lookup.IMSDoubleRecipeLookupHandler;
import com.fxd927.mekanismelements.common.recipe.lookup.IMSRecipeLookupHandler;
import com.fxd927.mekanismelements.common.tile.machine.TileEntityRadiationIrradiator;
import com.fxd927.mekanismelements.common.tile.prefab.MSTileEntityProgressMachine;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.cache.CachedRecipe;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;

@Mixin(value = TileEntityRadiationIrradiator.class,remap = false)
public abstract class MixinTileEntityRadiationIrradiator extends MSTileEntityProgressMachine<RadiationIrradiatingRecipe> implements IMSRecipeLookupHandler.ConstantUsageRecipeLookupHandler,
        IMSDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<RadiationIrradiatingRecipe> {

    protected MixinTileEntityRadiationIrradiator(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @ModifyArg(method = "presetVariables",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    public long inputModifyArg(long capacity) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.RadiationIrradiatorInput.get();
    }

    @ModifyArg(method = "presetVariables",at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    public long outputModifyArg(long capacity) {
        return MMCConfig.MEK_SCIENCE_MACHINE_CONFIG.RadiationIrradiatorOutput.get();
    }
}

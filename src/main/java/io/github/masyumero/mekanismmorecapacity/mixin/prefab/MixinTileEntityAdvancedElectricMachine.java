package io.github.masyumero.mekanismmorecapacity.mixin.prefab;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
import mekanism.common.recipe.MekanismRecipeType;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.prefab.TileEntityAdvancedElectricMachine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityAdvancedElectricMachine.class,remap = false)
public abstract class MixinTileEntityAdvancedElectricMachine implements IRecipeLookupHandler<ItemStackChemicalToItemStackRecipe> {

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long modifyChemicalTankCapacity(long c) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        if (getRecipeType() == MekanismRecipeType.COMPRESSING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Compressing.get();
        } else if (getRecipeType() == MekanismRecipeType.PURIFYING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Purifying.get();
        } else if (getRecipeType() == MekanismRecipeType.INJECTING) {
            return MMCConfig.MEK_MACHINE_CONFIG.Injecting.get();
        } else {
            return 210L;
        }
    }
}

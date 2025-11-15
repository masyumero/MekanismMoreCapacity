package io.github.masyumero.mekanismmorecapacity.mixin.factory;

import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.api.chemical.infuse.InfuseType;
import mekanism.api.chemical.infuse.InfusionStack;
import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.MetallurgicInfuserRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.tile.factory.TileEntityItemToItemFactory;
import mekanism.common.tile.factory.TileEntityMetallurgicInfuserFactory;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityMetallurgicInfuserFactory.class,remap = false)
public abstract class MixinTileEntityMetallurgicInfuserFactory extends TileEntityItemToItemFactory<MetallurgicInfuserRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<InfuseType, InfusionStack, MetallurgicInfuserRecipe> {

    protected MixinTileEntityMetallurgicInfuserFactory(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialInfusionTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/ChemicalTankBuilder;create(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getConfigValue();
    }

    @Unique
    private long mekanismMoreCapacity$getConfigValue() {
        if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case "Advanced" ->      MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case "Elite" ->         MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case "Ultimate" ->      MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
                case "Overclocked" ->   MMCConfig.EVO_MEK_MACHINE_CONFIG.OVERCLOCKEDMetallurgicInfuserFactoryEvolved.get();
                case "Quantum" ->       MMCConfig.EVO_MEK_MACHINE_CONFIG.QUANTUMFMetallurgicInfuserFactoryEvolved.get();
                case "Dense" ->         MMCConfig.EVO_MEK_MACHINE_CONFIG.DENSEMetallurgicInfuserFactoryEvolved.get();
                case "Multiversal" ->   MMCConfig.EVO_MEK_MACHINE_CONFIG.MULTIVERSALMetallurgicInfuserFactoryEvolved.get();
                case "Creative" ->      MMCConfig.EVO_MEK_MACHINE_CONFIG.CREATIVEMetallurgicInfuserFactoryEvolved.get();
                default ->
                        throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (this.tier) {
                case BASIC ->       MMCConfig.MEK_MACHINE_CONFIG.BasicFactories.get();
                case ADVANCED ->    MMCConfig.MEK_MACHINE_CONFIG.AdvancedFactories.get();
                case ELITE ->       MMCConfig.MEK_MACHINE_CONFIG.EliteFactories.get();
                case ULTIMATE ->    MMCConfig.MEK_MACHINE_CONFIG.UltimateFactories.get();
            };
        }
    }

}

package io.github.masyumero.mekanismmorecapacity.mixin.extras;

import com.jerry.mekextras.common.block.attribute.ExtraAttribute;
import com.jerry.mekextras.common.tier.ExtraFactoryTier;
import com.jerry.mekextras.common.tile.factory.TileEntityExtraItemStackChemicalToItemStackFactory;
import com.jerry.mekextras.common.tile.factory.TileEntityExtraItemToItemFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import mekanism.api.recipes.ItemStackChemicalToItemStackRecipe;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.block.attribute.AttributeFactoryType;
import mekanism.common.content.blocktype.FactoryType;
import mekanism.common.recipe.lookup.IDoubleRecipeLookupHandler;
import mekanism.common.recipe.lookup.IRecipeLookupHandler;
import mekanism.common.tile.interfaces.IHasDumpButton;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import java.util.List;
import java.util.Set;

@Mixin(value = TileEntityExtraItemStackChemicalToItemStackFactory.class,remap = false)
public abstract class MixinTileEntityItemStackChemicalToItemStackAdvancedFactory extends TileEntityExtraItemToItemFactory<ItemStackChemicalToItemStackRecipe> implements IHasDumpButton, IDoubleRecipeLookupHandler.ItemChemicalRecipeLookupHandler<ItemStackChemicalToItemStackRecipe>, IRecipeLookupHandler.ConstantUsageRecipeLookupHandler {

    protected MixinTileEntityItemStackChemicalToItemStackAdvancedFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, Set<CachedRecipe.OperationTracker.RecipeError> globalErrorTypes) {
        super(blockProvider, pos, state, errorTypes, globalErrorTypes);
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;inputModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @ModifyArg(method = "getInitialChemicalTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/Predicate;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long createModernModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputCapacity();
    }

    @Unique
    private long mekanismMoreCapacity$getInputCapacity() {
        FactoryType type = Attribute.getOrThrow(getBlockHolder(), AttributeFactoryType.class).getFactoryType();
        ExtraFactoryTier tier = ExtraAttribute.getAdvancedTier(getBlockHolder(), ExtraFactoryTier.class);
        return switch (type) {
            case INFUSING -> switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteMetallurgicInfuserFactory.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeMetallurgicInfuserFactory.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicMetallurgicInfuserFactory.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteMetallurgicInfuserFactory.get();
            };
            case COMPRESSING -> switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteCompressing.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeCompressing.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicCompressing.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteCompressing.get();
            };
            case INJECTING -> switch (tier) {
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsoluteInjecting.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremeInjecting.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicInjecting.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfiniteInjecting.get();
            };
            default -> switch (tier) { //PURIFYING
                case ABSOLUTE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.AbsolutePurifying.get();
                case SUPREME -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.SupremePurifying.get();
                case COSMIC -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.CosmicPurifying.get();
                case INFINITE -> MMCConfig.MEK_EXTRAS_MACHINE_CONFIG.InfinitePurifying.get();
            };
        };
    }
}

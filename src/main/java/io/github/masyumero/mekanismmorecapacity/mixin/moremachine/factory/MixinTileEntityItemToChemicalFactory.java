package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.block.attribute.AttributeAdvancedFactoryType;
import com.jerry.mekaf.common.content.blocktype.AdvancedFactoryType;
import com.jerry.mekaf.common.tile.factory.base.TileEntityItemToChemicalFactory;
import io.github.masyumero.mekanismmorecapacity.common.config.MMCConfig;
import io.github.masyumero.mekanismmorecapacity.common.util.TierUtil;
import mekanism.common.block.attribute.Attribute;
import mekanism.common.config.value.CachedLongValue;
import mekanism.common.tier.FactoryTier;
import mekanism.common.tile.base.TileEntityMekanism;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = TileEntityItemToChemicalFactory.class,remap = false)
public abstract class MixinTileEntityItemToChemicalFactory extends TileEntityMekanism {

    public MixinTileEntityItemToChemicalFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return mekanismMoreCapacity$getConfigValue().get();
    }

    @Unique
    private CachedLongValue mekanismMoreCapacity$getConfigValue() {
        FactoryTier tier = Attribute.getTier(getBlockHolder(), FactoryTier.class);
        AdvancedFactoryType type = Attribute.getOrThrow(getBlockHolder(), AttributeAdvancedFactoryType.class).getAdvancedFactoryType();
        if (type == AdvancedFactoryType.OXIDIZING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicOxidizingFactory;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedOxidizingFactory;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteOxidizingFactory;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateOxidizingFactory;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedOxidizingFactory;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumOxidizingFactory;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseOxidizingFactory;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalOxidizingFactory;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeOxidizingFactory;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicOxidizingFactory;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedOxidizingFactory;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteOxidizingFactory;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateOxidizingFactory;
                };
            }
        } else if(ModList.get().isLoaded("evolvedmekanism")) {
            return switch (TierUtil.getTierName(tier)) {
                case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryOutput;
                case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryOutput;
                case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryOutput;
                case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryOutput;
                case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedDissolvingFactoryOutput;
                case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumDissolvingFactoryOutput;
                case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseDissolvingFactoryOutput;
                case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalDissolvingFactoryOutput;
                case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeDissolvingFactoryOutput;
                default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
            };
        } else {
            return switch (tier) {
                case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicDissolvingFactoryOutput;
                case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedDissolvingFactoryOutput;
                case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteDissolvingFactoryOutput;
                case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateDissolvingFactoryOutput;
            };
        }
    }
}

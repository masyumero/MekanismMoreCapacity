package io.github.masyumero.mekanismmorecapacity.mixin.moremachine.factory;

import com.jerry.mekaf.common.block.attribute.AttributeAdvancedFactoryType;
import com.jerry.mekaf.common.content.blocktype.AdvancedFactoryType;
import com.jerry.mekaf.common.tile.factory.base.TileEntityChemicalToChemicalFactory;
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

@Mixin(value = TileEntityChemicalToChemicalFactory.class,remap = false)
public abstract class MixinTileEntityChemicalToChemicalFactory extends TileEntityMekanism {

    public MixinTileEntityChemicalToChemicalFactory(Holder<Block> blockProvider, BlockPos pos, BlockState state) {
        super(blockProvider, pos, state);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;createModern(JLjava/util/function/BiPredicate;Ljava/util/function/BiPredicate;Ljava/util/function/Predicate;Lmekanism/api/chemical/attribute/ChemicalAttributeValidator;Lmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long inputModifyArg(long capacity) {
        return mekanismMoreCapacity$getInputConfigValue().get();
    }

    @Unique
    private CachedLongValue mekanismMoreCapacity$getInputConfigValue() {
        FactoryTier tier = Attribute.getTier(getBlockHolder(), FactoryTier.class);
        AdvancedFactoryType type = Attribute.getOrThrow(getBlockHolder(), AttributeAdvancedFactoryType.class).getAdvancedFactoryType();
        if (type == AdvancedFactoryType.CENTRIFUGING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryinput;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryinput;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryinput;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryinput;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedCentrifugingFactoryinput;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumCentrifugingFactoryinput;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseCentrifugingFactoryinput;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalCentrifugingFactoryinput;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeCentrifugingFactoryinput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryinput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryinput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryinput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryinput;
                };
            }
        } else if (type == AdvancedFactoryType.WASHING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryInput;
                    case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryInput;
                    case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryInput;
                    case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryInput;
                    case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedWashingFactoryInput;
                    case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumWashingFactoryInput;
                    case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseWashingFactoryInput;
                    case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalWashingFactoryInput;
                    case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeWashingFactoryInput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryInput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryInput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryInput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryInput;
                };
            }
        }
        throw new IllegalStateException("Unexpected value: " + type);
    }

    @ModifyArg(method = "addTanks", at = @At(value = "INVOKE", target = "Lmekanism/api/chemical/BasicChemicalTank;output(JLmekanism/api/IContentsListener;)Lmekanism/api/chemical/IChemicalTank;"))
    private long outputModifyArg(long capacity) {
        return mekanismMoreCapacity$getOutputConfigValue().get();
    }

    @Unique
    private CachedLongValue mekanismMoreCapacity$getOutputConfigValue() {
        FactoryTier tier = Attribute.getTier(getBlockHolder(), FactoryTier.class);
        AdvancedFactoryType type = Attribute.getOrThrow(getBlockHolder(), AttributeAdvancedFactoryType.class).getAdvancedFactoryType();
        if (type == AdvancedFactoryType.CENTRIFUGING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryoutput;
                    case "Advanced" -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryoutput;
                    case "Elite" -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryoutput;
                    case "Ultimate" -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryoutput;
                    case "Overclocked" -> MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedCentrifugingFactoryoutput;
                    case "Quantum" -> MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumCentrifugingFactoryoutput;
                    case "Dense" -> MMCConfig.MEK_MM_MACHINE_CONFIG.DenseCentrifugingFactoryoutput;
                    case "Multiversal" -> MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalCentrifugingFactoryoutput;
                    case "Creative" -> MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeCentrifugingFactoryoutput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicCentrifugingFactoryoutput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedCentrifugingFactoryoutput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteCentrifugingFactoryoutput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateCentrifugingFactoryoutput;
                };
            }
        } else if (type == AdvancedFactoryType.WASHING) {
            if (ModList.get().isLoaded("evolvedmekanism")) {
                return switch (TierUtil.getTierName(tier)) {
                    case "Basic" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryOutput;
                    case "Advanced" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryOutput;
                    case "Elite" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryOutput;
                    case "Ultimate" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryOutput;
                    case "Overclocked" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.OverclockedWashingFactoryOutput;
                    case "Quantum" ->       MMCConfig.MEK_MM_MACHINE_CONFIG.QuantumWashingFactoryOutput;
                    case "Dense" ->         MMCConfig.MEK_MM_MACHINE_CONFIG.DenseWashingFactoryOutput;
                    case "Multiversal" ->   MMCConfig.MEK_MM_MACHINE_CONFIG.MultiversalWashingFactoryOutput;
                    case "Creative" ->      MMCConfig.MEK_MM_MACHINE_CONFIG.CreativeWashingFactoryOutput;
                    default -> throw new IllegalStateException("Unexpected value: " + TierUtil.getTierName(tier));
                };
            } else {
                return switch (tier) {
                    case BASIC -> MMCConfig.MEK_MM_MACHINE_CONFIG.BasicWashingFactoryOutput;
                    case ADVANCED -> MMCConfig.MEK_MM_MACHINE_CONFIG.AdvancedWashingFactoryOutput;
                    case ELITE -> MMCConfig.MEK_MM_MACHINE_CONFIG.EliteWashingFactoryOutput;
                    case ULTIMATE -> MMCConfig.MEK_MM_MACHINE_CONFIG.UltimateWashingFactoryOutput;
                };
            }
        }
        throw new IllegalStateException("Unexpected value: " + type);
    }
}

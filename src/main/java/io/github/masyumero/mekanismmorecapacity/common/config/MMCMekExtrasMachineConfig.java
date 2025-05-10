package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MMCMekExtrasMachineConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;
    public final CachedLongValue AbsoluteMetallurgicInfuserFactoryExtras;
    public final CachedLongValue SupremeMetallurgicInfuserFactoryExtras;
    public final CachedLongValue CosmicMetallurgicInfuserFactoryExtras;
    public final CachedLongValue InfiniteMetallurgicInfuserFactoryExtras;
    public final CachedLongValue AbsoluteFactories;
    public final CachedLongValue SupremeFactories;
    public final CachedLongValue CosmicFactories;
    public final CachedLongValue InfiniteFactories;
    public final CachedIntValue AdvancedElectricPump;

    public MMCMekExtrasMachineConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Mekanism_Extras").push("ExtrasCompressing, Extrasinjecting, Extraspurifying");
        AbsoluteFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 2541000, Vanilla: 25410").defineInRange("absoluteChemicalTankCapacity", 2541000, 1, Long.MAX_VALUE));
        SupremeFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3549000, Vanilla: 35490").defineInRange("supremeChemicalTankCapacity", 3549000, 1, Long.MAX_VALUE));
        CosmicFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Default: 4725000, Vanilla: 47250").defineInRange("cosmicChemicalTankCapacity", 4725000, 1, Long.MAX_VALUE));
        InfiniteFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 6069000, Vanilla: 60690").defineInRange("infiniteChemicalTankCapacity", 6069000, 1, Long.MAX_VALUE));
        builder.pop().push("InfusingFactoryExtras");
        AbsoluteMetallurgicInfuserFactoryExtras = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 12100000, Vanilla: 121000").defineInRange("absoluteChemicalTankCapacity", 12100000, 1, Long.MAX_VALUE));
        SupremeMetallurgicInfuserFactoryExtras = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 16900000, Vanilla: 169000").defineInRange("supremeChemicalTankCapacity", 16900000, 1, Long.MAX_VALUE));
        CosmicMetallurgicInfuserFactoryExtras = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 22500000, Vanilla: 225000").defineInRange("cosmicChemicalTankCapacity", 22500000, 1, Long.MAX_VALUE));
        InfiniteMetallurgicInfuserFactoryExtras = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 28900000, Vanilla: 289000").defineInRange("infiniteChemicalTankCapacity", 28900000, 1, Long.MAX_VALUE));
        builder.pop().push("AdvancedElectricPump");
        AdvancedElectricPump = CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000000, Vanilla: 10000000").defineInRange("fluidTankCapacity", 1000000000, 1, Integer.MAX_VALUE));
        builder.pop().pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCMekExtrasMachine";
    }

    @Override
    public String getTranslation() {
        return null;
    }

    @Override
    public ModConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}

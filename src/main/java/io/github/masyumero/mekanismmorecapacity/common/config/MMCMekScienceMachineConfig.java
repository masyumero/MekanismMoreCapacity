package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MMCMekScienceMachineConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedIntValue SeawaterPump;
    public final CachedLongValue RadiationIrradiatorInput;
    public final CachedLongValue RadiationIrradiatorOutput;
    public final CachedLongValue ChemicalDemolition;
    public final CachedLongValue AirCompressor;
    public final CachedLongValue AdsorptionSeparatorInput;
    public final CachedLongValue AdsorptionSeparatorOutput;

    public MMCMekScienceMachineConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Mekanism_Science").push("SeawaterPump");
        SeawaterPump = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("RadiationIrradiatorInput");
        RadiationIrradiatorInput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        RadiationIrradiatorOutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("ChemicalDemolition");
        ChemicalDemolition = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("AirCompressor");
        AirCompressor = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("AdsorptionSeparator");
        AdsorptionSeparatorInput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        AdsorptionSeparatorOutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCMekScienceMachine";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }
}

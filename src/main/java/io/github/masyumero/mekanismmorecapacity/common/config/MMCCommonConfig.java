package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MMCCommonConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedLongValue sps;
    public final CachedLongValue AntiprotonicNucleosynthesizer;
    public final CachedLongValue ChemicalCrystallizer;
    public final CachedLongValue ChemicalDissolutionChamberInput;
    public final CachedLongValue ChemicalDissolutionChamberOutput;
    public final CachedLongValue ChemicalInfuser;
    public final CachedLongValue ChemicalOxidizer;
    public final CachedLongValue ChemicalWasherSlurry;
    public final CachedIntValue ChemicalWasherFluid;
    public final CachedLongValue ElectrolyticSeparatorChemical;
    public final CachedIntValue ElectrolyticSeparatorFluid;
    public final CachedLongValue IsotopicCentrifuge;
    public final CachedLongValue MetallurgicInfuser;
    public final CachedIntValue NutritionalLiquifier;
    public final CachedLongValue PressurizedReactionChamberChemical;
    public final CachedIntValue PressurizedReactionChamberFluid;
    public final CachedLongValue RotaryCondensentratorChemical;
    public final CachedIntValue RotaryCondensentratorFluid;
    public final CachedLongValue SolarNeutronActivator;

    public MMCCommonConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank").push("sps");
        sps = CachedLongValue.wrap(this, builder.comment("Amount of input gas (mB) that the sps can store. Multiply mekanism/general/sps/inputPerAntimatter by this number. Default: 200, Vanilla: 2").defineInRange("inputTankCapacity", 200, 1,1000000000L));
        builder.pop().push("AntiprotonicNucleosynthesizer");
        AntiprotonicNucleosynthesizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalCrystallizer");
        ChemicalCrystallizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalDissolutionChamberInput");
        ChemicalDissolutionChamberInput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalDissolutionChamberOutput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalInfuser");
        ChemicalInfuser = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalOxidizer");
        ChemicalOxidizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalWasher");
        ChemicalWasherSlurry = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalWasherFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("ElectrolyticSeparator");
        ElectrolyticSeparatorChemical = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 2400000, Vanilla: 2400").defineInRange("chemicalTankCapacity",2400000,1,Long.MAX_VALUE));
        ElectrolyticSeparatorFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 2400000, Vanilla: 24000").defineInRange("fluidTankCapacity",2400000,1,Integer.MAX_VALUE));
        builder.pop().push("IsotopicCentrifuge");
        IsotopicCentrifuge = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("MetallurgicInfuser");
        MetallurgicInfuser = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 100000, Vanilla: 1000").defineInRange("chemicalTankCapacity",100000,1,(Long.MAX_VALUE/10)));
        builder.pop().push("NutritionalLiquifier");
        NutritionalLiquifier = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("PressurizedReactionChamber");
        PressurizedReactionChamberChemical = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        PressurizedReactionChamberFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("RotaryCondensentrator");
        RotaryCondensentratorChemical = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        RotaryCondensentratorFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("SolarNeutronActivator");
        SolarNeutronActivator = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCcommon";
    }

    @Override
    public ForgeConfigSpec getConfigSpec() {
        return configSpec;
    }

    @Override
    public ModConfig.Type getConfigType() {
        return ModConfig.Type.SERVER;
    }

    @Override
    public boolean addToContainer() {
        return false;
    }
}

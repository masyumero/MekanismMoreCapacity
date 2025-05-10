package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MMCMekMachineConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;
    public final CachedLongValue AntiprotonicNucleosynthesizer;
    public final CachedLongValue ChemicalCrystallizer;
    public final CachedLongValue ChemicalDissolutionChamberInput;
    public final CachedLongValue ChemicalDissolutionChamberOutput;
    public final CachedLongValue ChemicalInfuserCenter;
    public final CachedLongValue ChemicalInfuserRight;
    public final CachedLongValue ChemicalInfuserLeft;
    public final CachedLongValue ChemicalOxidizer;
    public final CachedLongValue ChemicalWasherSlurry;
    public final CachedIntValue ChemicalWasherFluid;
    public final CachedLongValue CompressingInjectingPurifying;
    public final CachedLongValue ElectrolyticSeparatorChemicalRight;
    public final CachedLongValue ElectrolyticSeparatorChemicalLeft;
    public final CachedIntValue ElectrolyticSeparatorFluid;
    public final CachedLongValue IsotopicCentrifugeInput;
    public final CachedLongValue IsotopicCentrifugeOutput;
    public final CachedLongValue MetallurgicInfuser;
    public final CachedIntValue NutritionalLiquifier;
    public final CachedLongValue PressurizedReactionChamberChemical;
    public final CachedIntValue PressurizedReactionChamberFluid;
    public final CachedLongValue RotaryCondensentratorChemical;
    public final CachedIntValue RotaryCondensentratorFluid;
    public final CachedLongValue SolarNeutronActivatorInput;
    public final CachedLongValue SolarNeutronActivatorOutput;
    public final CachedLongValue sps;
    public final CachedLongValue BasicMetallurgicInfuserFactory;
    public final CachedLongValue AdvancedMetallurgicInfuserFactory;
    public final CachedLongValue EliteMetallurgicInfuserFactory;
    public final CachedLongValue UltimateMetallurgicInfuserFactory;
    public final CachedLongValue BasicFactories;
    public final CachedLongValue AdvancedFactories;
    public final CachedLongValue EliteFactories;
    public final CachedLongValue UltimateFactories;

    public MMCMekMachineConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("AntiprotonicNucleosynthesizer");
        AntiprotonicNucleosynthesizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalCrystallizer");
        ChemicalCrystallizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalDissolutionChamberInput");
        ChemicalDissolutionChamberInput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalDissolutionChamberOutput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalInfuser");
        ChemicalInfuserRight = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("rightChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalInfuserLeft = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("leftChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalInfuserCenter = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("centerChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalOxidizer");
        ChemicalOxidizer = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("ChemicalWasher");
        ChemicalWasherSlurry = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        ChemicalWasherFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("Compressing, injecting, purifying");
        CompressingInjectingPurifying = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 21000, Vanilla: 210").defineInRange("chemicalTankCapacity",21000,1,(Long.MAX_VALUE/9)));
        builder.pop().push("ElectrolyticSeparator");
        ElectrolyticSeparatorChemicalLeft = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 2400000, Vanilla: 2400").defineInRange("leftChemicalTankCapacity",2400000,1,Long.MAX_VALUE));
        ElectrolyticSeparatorChemicalRight = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 2400000, Vanilla: 2400").defineInRange("rightChemicalTankCapacity",2400000,1,Long.MAX_VALUE));
        ElectrolyticSeparatorFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 2400000, Vanilla: 24000").defineInRange("fluidTankCapacity",2400000,1,Integer.MAX_VALUE));
        builder.pop().push("IsotopicCentrifuge");
        IsotopicCentrifugeInput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        IsotopicCentrifugeOutput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("MetallurgicInfuser");
        MetallurgicInfuser = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 100000, Vanilla: 1000").defineInRange("chemicalTankCapacity",100000,1,(Long.MAX_VALUE/9)));
        builder.pop().push("NutritionalLiquifier");
        NutritionalLiquifier = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("PressurizedReactionChamber");
        PressurizedReactionChamberChemical = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        PressurizedReactionChamberFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("RotaryCondensentrator");
        RotaryCondensentratorChemical = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("chemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        RotaryCondensentratorFluid = CachedIntValue.wrap(this,builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity",1000000,1,Integer.MAX_VALUE));
        builder.pop().push("SolarNeutronActivator");
        SolarNeutronActivatorInput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("inputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        SolarNeutronActivatorOutput = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("outputChemicalTankCapacity",1000000,1,Long.MAX_VALUE));
        builder.pop().push("sps");
        sps = CachedLongValue.wrap(this, builder.comment("Amount of input gas (mB) that the sps can store. Multiply mekanism/general/sps/inputPerAntimatter by this number. Default: 200, Vanilla: 2").defineInRange("inputTankCapacity", 200, 1,1000000000L));
        builder.pop().push("factories").push("InfusingFactory");
        BasicMetallurgicInfuserFactory = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 300000, Vanilla: 3000").defineInRange("basicChemicalTankCapacity",300000,1,Long.MAX_VALUE));
        AdvancedMetallurgicInfuserFactory = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 500000, Vanilla: 5000").defineInRange("advancedChemicalTankCapacity",500000,1,Long.MAX_VALUE));
        EliteMetallurgicInfuserFactory = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 700000, Vanilla: 7000").defineInRange("eliteChemicalTankCapacity",700000,1,Long.MAX_VALUE));
        UltimateMetallurgicInfuserFactory = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 900000, Vanilla: 9000").defineInRange("ultimateChemicalTankCapacity",900000,1,Long.MAX_VALUE));
        builder.pop().push("CompressingFactory, injectingFactory, purifyingFactory");
        BasicFactories = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 63000, Vanilla: 630").defineInRange("basicChemicalTankCapacity",63000,1,Long.MAX_VALUE));
        AdvancedFactories = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 105000, Vanilla: 1050").defineInRange("advancedChemicalTankCapacity",105000,1,Long.MAX_VALUE));
        EliteFactories = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 147000 , Vanilla: 1470").defineInRange("eliteChemicalTankCapacity",147000,1,Long.MAX_VALUE));
        UltimateFactories = CachedLongValue.wrap(this,builder.comment("Chemical tank capacity (mB). Default: 189000 , Vanilla: 1890").defineInRange("ultimateChemicalTankCapacity",189000,1,Long.MAX_VALUE));
        builder.pop().pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCMekMachine";
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

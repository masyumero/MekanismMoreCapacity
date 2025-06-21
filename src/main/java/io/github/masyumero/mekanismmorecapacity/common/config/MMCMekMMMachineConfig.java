package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MMCMekMMMachineConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;
    public final CachedLongValue BasicOxidizingFactory;
    public final CachedLongValue AdvancedOxidizingFactory;
    public final CachedLongValue EliteOxidizingFactory;
    public final CachedLongValue UltimateOxidizingFactory;
    public final CachedLongValue BasicDissolvingFactory;
    public final CachedLongValue AdvancedDissolvingFactory;
    public final CachedLongValue EliteDissolvingFactory;
    public final CachedLongValue UltimateDissolvingFactory;
//    public final CachedLongValue BasicCentrifugingFactoryoutput;
//    public final CachedLongValue AdvancedCentrifugingFactoryoutput;
//    public final CachedLongValue EliteCentrifugingFactoryoutput;
//    public final CachedLongValue UltimateCentrifugingFactoryoutput;
//    public final CachedLongValue BasicCentrifugingFactoryinput;
//    public final CachedLongValue AdvancedCentrifugingFactoryinput;
//    public final CachedLongValue EliteCentrifugingFactoryinput;
//    public final CachedLongValue UltimateCentrifugingFactoryinput;
    public final CachedLongValue BasicChemicalToChemicalFactoryinputR;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryinputR;
    public final CachedLongValue EliteChemicalToChemicalFactoryinputR;
    public final CachedLongValue UltimateChemicalToChemicalFactoryinputR;
    public final CachedLongValue BasicChemicalToChemicalFactoryoutput;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryoutput;
    public final CachedLongValue EliteChemicalToChemicalFactoryoutput;
    public final CachedLongValue UltimateChemicalToChemicalFactoryoutput;
    public final CachedLongValue BasicChemicalToChemicalFactoryinputL;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryinputL;
    public final CachedLongValue EliteChemicalToChemicalFactoryinputL;
    public final CachedLongValue UltimateChemicalToChemicalFactoryinputL;
//    public final CachedLongValue BasicChemicalInfusingFactoryinputR;
//    public final CachedLongValue AdvancedChemicalInfusingFactoryinputR;
//    public final CachedLongValue EliteChemicalInfusingFactoryinputR;
//    public final CachedLongValue UltimateChemicalInfusingFactoryinputR;
//    public final CachedLongValue BasicChemicalInfusingFactoryoutput;
//    public final CachedLongValue AdvancedChemicalInfusingFactoryoutput;
//    public final CachedLongValue EliteChemicalInfusingFactoryoutput;
//    public final CachedLongValue UltimateChemicalInfusingFactoryoutput;
//    public final CachedLongValue BasicChemicalInfusingFactoryinputL;
//    public final CachedLongValue AdvancedChemicalInfusingFactoryinputL;
//    public final CachedLongValue EliteChemicalInfusingFactoryinputL;
//    public final CachedLongValue UltimateChemicalInfusingFactoryinputL;
//    public final CachedLongValue BasicSolarNeutronActivatingFactoryinput;
//    public final CachedLongValue AdvancedSolarNeutronActivatingFactoryinput;
//    public final CachedLongValue EliteSolarNeutronActivatingFactoryinput;
//    public final CachedLongValue UltimateSolarNeutronActivatingFactoryinput;
//    public final CachedLongValue BasicSolarNeutronActivatingFactoryoutput;
//    public final CachedLongValue AdvancedSolarNeutronActivatingFactoryoutput;
//    public final CachedLongValue EliteSolarNeutronActivatingFactoryoutput;
//    public final CachedLongValue UltimateSolarNeutronActivatingFactoryoutput;
//    public final CachedLongValue BasicWashingFactoryinput;
//    public final CachedLongValue AdvancedWashingFactoryinput;
//    public final CachedLongValue EliteWashingFactoryinput;
//    public final CachedLongValue UltimateWashingFactoryinput;
//    public final CachedLongValue BasicWashingFactoryoutput;
//    public final CachedLongValue AdvancedWashingFactoryoutput;
//    public final CachedLongValue EliteWashingFactoryoutput;
//    public final CachedLongValue UltimateWashingFactoryoutput;
    public final CachedLongValue BasicCrystallizingFactory;
    public final CachedLongValue AdvancedCrystallizingFactory;
    public final CachedLongValue EliteCrystallizingFactory;
    public final CachedLongValue UltimateCrystallizingFactory;
    public final CachedLongValue BasicPressurizedReactingFactoryinput;
    public final CachedLongValue AdvancedPressurizedReactingFactoryinput;
    public final CachedLongValue ElitePressurizedReactingFactoryinput;
    public final CachedLongValue UltimatePressurizedReactingFactoryinput;
    public final CachedLongValue BasicPressurizedReactingFactoryoutput;
    public final CachedLongValue AdvancedPressurizedReactingFactoryoutput;
    public final CachedLongValue ElitePressurizedReactingFactoryoutput;
    public final CachedLongValue UltimatePressurizedReactingFactoryoutput;
    public final CachedLongValue PlantingStation;
    public final CachedLongValue BasicPlantingStationFactory;
    public final CachedLongValue AdvancedPlantingStationFactory;
    public final CachedLongValue ElitePlantingStationFactory;
    public final CachedLongValue UltimatePlantingStationFactory;
    public final CachedLongValue Replicator;
    public final CachedLongValue BasicReplicatorFactory;
    public final CachedLongValue AdvancedReplicatorFactory;
    public final CachedLongValue EliteReplicatorFactory;
    public final CachedLongValue UltimateReplicatorFactory;

    public MMCMekMMMachineConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Mekanism_More_Machine").push("OxidizingFactory");
        BasicOxidizingFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedOxidizingFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteOxidizingFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateOxidizingFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalTankCapacity", 9000000, 1, Long.MAX_VALUE));
        builder.pop().push("DissolvingFactory");
        BasicDissolvingFactory =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedDissolvingFactory = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteDissolvingFactory =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateDissolvingFactory = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        builder.pop().push("CentrifugingFactory");
//        BasicCentrifugingFactoryinput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedCentrifugingFactoryinput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteCentrifugingFactoryinput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateCentrifugingFactoryinput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        BasicCentrifugingFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedCentrifugingFactoryoutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteCentrifugingFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateCentrifugingFactoryoutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        builder.pop().push("ChemicalInfusingFactory");
        builder.pop().push("ChemicalToChemicalFactory");
        BasicChemicalToChemicalFactoryinputR =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalRightInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryinputR = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalRightInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryinputR =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalRightInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryinputR = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalRightInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        BasicChemicalToChemicalFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryoutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryoutput = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        BasicChemicalToChemicalFactoryinputL =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryinputL = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryinputL =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryinputL = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        builder.pop().push("CrystallizingFactory");
        BasicCrystallizingFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedCrystallizingFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteCrystallizingFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateCrystallizingFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalTankCapacity", 9000000, 1, Long.MAX_VALUE));
        builder.pop().push("PressurizedReactingFactory");
        BasicPressurizedReactingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedPressurizedReactingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        ElitePressurizedReactingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimatePressurizedReactingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        BasicPressurizedReactingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedPressurizedReactingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        ElitePressurizedReactingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimatePressurizedReactingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        builder.pop().push("PlantingStation");
        PlantingStation =                   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 21000, Vanilla: 210").defineInRange("ChemicalInputTankCapacity", 21000, 1, Long.MAX_VALUE));
        BasicPlantingStationFactory  =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 63000, Vanilla: 630").defineInRange("basicChemicalTankCapacity",63000,1,Long.MAX_VALUE));
        AdvancedPlantingStationFactory =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 105000, Vanilla: 1050").defineInRange("advancedChemicalTankCapacity",105000,1,Long.MAX_VALUE));
        ElitePlantingStationFactory =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 147000 , Vanilla: 1470").defineInRange("eliteChemicalTankCapacity",147000,1,Long.MAX_VALUE));
        UltimatePlantingStationFactory =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 189000 , Vanilla: 1890").defineInRange("ultimateChemicalTankCapacity",189000,1,Long.MAX_VALUE));
        builder.pop().push("Replicator");
        Replicator = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalInputTankCapacity", 1000000, 1, Long.MAX_VALUE));
        BasicReplicatorFactory = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedReplicatorFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteReplicatorFactory = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateReplicatorFactory = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        builder.pop().push("SolarNeutronActivatingFactory");
//        BasicSolarNeutronActivatingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedSolarNeutronActivatingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteSolarNeutronActivatingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateSolarNeutronActivatingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        BasicSolarNeutronActivatingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedSolarNeutronActivatingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteSolarNeutronActivatingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateSolarNeutronActivatingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        builder.pop().push("WashingFactory");
//        BasicWashingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedWashingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteWashingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateWashingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        BasicWashingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedWashingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteWashingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateWashingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCMekMMMachine";
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

package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MMCMekMMMachineConfig extends BaseMekanismConfig {

//    Overclocked
//    Quantum
//    Dense
//    Multiversal
//    Creative

    private final ForgeConfigSpec configSpec;
    public final CachedLongValue BasicOxidizingFactory;
    public final CachedLongValue AdvancedOxidizingFactory;
    public final CachedLongValue EliteOxidizingFactory;
    public final CachedLongValue UltimateOxidizingFactory;
    public final CachedLongValue OverclockedOxidizingFactory;
    public final CachedLongValue QuantumOxidizingFactory;
    public final CachedLongValue DenseOxidizingFactory;
    public final CachedLongValue MultiversalOxidizingFactory;
    public final CachedLongValue CreativeOxidizingFactory;

    public final CachedLongValue BasicDissolvingFactoryInput;
    public final CachedLongValue AdvancedDissolvingFactoryInput;
    public final CachedLongValue EliteDissolvingFactoryInput;
    public final CachedLongValue UltimateDissolvingFactoryInput;
    public final CachedLongValue OverclockedDissolvingFactoryInput;
    public final CachedLongValue QuantumDissolvingFactoryInput;
    public final CachedLongValue DenseDissolvingFactoryInput;
    public final CachedLongValue MultiversalDissolvingFactoryInput;
    public final CachedLongValue CreativeDissolvingFactoryInput;
    public final CachedLongValue BasicDissolvingFactoryOutput;
    public final CachedLongValue AdvancedDissolvingFactoryOutput;
    public final CachedLongValue EliteDissolvingFactoryOutput;
    public final CachedLongValue UltimateDissolvingFactoryOutput;
    public final CachedLongValue OverclockedDissolvingFactoOutput;
    public final CachedLongValue QuantumDissolvingFactoryOutput;
    public final CachedLongValue DenseDissolvingFactoryOutput;
    public final CachedLongValue MultiversalDissolvingFactoOutput;
    public final CachedLongValue CreativeDissolvingFactoryOutput;

    public final CachedLongValue BasicChemicalToChemicalFactoryinputR;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryinputR;
    public final CachedLongValue EliteChemicalToChemicalFactoryinputR;
    public final CachedLongValue UltimateChemicalToChemicalFactoryinputR;
    public final CachedLongValue OverclockedChemicalToChemicalFactoryinputR;
    public final CachedLongValue QuantumChemicalToChemicalFactoryinputR;
    public final CachedLongValue DenseChemicalToChemicalFactoryinputR;
    public final CachedLongValue MultiversalChemicalToChemicalFactoryinputR;
    public final CachedLongValue CreativeChemicalToChemicalFactoryinputR;

    public final CachedLongValue BasicChemicalToChemicalFactoryoutput;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryoutput;
    public final CachedLongValue EliteChemicalToChemicalFactoryoutput;
    public final CachedLongValue UltimateChemicalToChemicalFactoryoutput;
    public final CachedLongValue OverclockedChemicalToChemicalFactoryoutput;
    public final CachedLongValue QuantumChemicalToChemicalFactoryoutput;
    public final CachedLongValue DenseChemicalToChemicalFactoryoutput;
    public final CachedLongValue MultiversalChemicalToChemicalFactoryoutput;
    public final CachedLongValue CreativeChemicalToChemicalFactoryoutput;

    public final CachedLongValue BasicChemicalToChemicalFactoryinputL;
    public final CachedLongValue AdvancedChemicalToChemicalFactoryinputL;
    public final CachedLongValue EliteChemicalToChemicalFactoryinputL;
    public final CachedLongValue UltimateChemicalToChemicalFactoryinputL;
    public final CachedLongValue OverclockedChemicalToChemicalFactoryinputL;
    public final CachedLongValue QuantumChemicalToChemicalFactoryinputL;
    public final CachedLongValue DenseChemicalToChemicalFactoryinputL;
    public final CachedLongValue MultiversalChemicalToChemicalFactoryinputL;
    public final CachedLongValue CreativeChemicalToChemicalFactoryinputL;

    public final CachedLongValue BasicCentrifugingFactoryinput;
    public final CachedLongValue AdvancedCentrifugingFactoryinput;
    public final CachedLongValue EliteCentrifugingFactoryinput;
    public final CachedLongValue UltimateCentrifugingFactoryinput;
    public final CachedLongValue OverclockedCentrifugingFactoryinput;
    public final CachedLongValue QuantumCentrifugingFactoryinput;
    public final CachedLongValue DenseCentrifugingFactoryinput;
    public final CachedLongValue MultiversalCentrifugingFactoryinput;
    public final CachedLongValue CreativeCentrifugingFactoryinput;
    public final CachedLongValue BasicCentrifugingFactoryoutput;
    public final CachedLongValue AdvancedCentrifugingFactoryoutput;
    public final CachedLongValue EliteCentrifugingFactoryoutput;
    public final CachedLongValue UltimateCentrifugingFactoryoutput;
    public final CachedLongValue OverclockedCentrifugingFactoryoutput;
    public final CachedLongValue QuantumCentrifugingFactoryoutput;
    public final CachedLongValue DenseCentrifugingFactoryoutput;
    public final CachedLongValue MultiversalCentrifugingFactoryoutput;
    public final CachedLongValue CreativeCentrifugingFactoryoutput;

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
    public final CachedLongValue BasicCrystallizingFactory;
    public final CachedLongValue AdvancedCrystallizingFactory;
    public final CachedLongValue EliteCrystallizingFactory;
    public final CachedLongValue UltimateCrystallizingFactory;
    public final CachedLongValue OverclockedCrystallizingFactory;
    public final CachedLongValue QuantumCrystallizingFactory;
    public final CachedLongValue DenseCrystallizingFactory;
    public final CachedLongValue MultiversalCrystallizingFactory;
    public final CachedLongValue CreativeCrystallizingFactory;

    public final CachedIntValue BasicWashingFactory;
    public final CachedIntValue AdvancedWashingFactory;
    public final CachedIntValue EliteWashingFactory;
    public final CachedIntValue UltimateWashingFactory;
    public final CachedIntValue OverclockedWashingFactory;
    public final CachedIntValue QuantumWashingFactory;
    public final CachedIntValue DenseWashingFactory;
    public final CachedIntValue MultiversalWashingFactory;
    public final CachedIntValue CreativeWashingFactory;

    public final CachedLongValue BasicWashingFactoryInput;
    public final CachedLongValue AdvancedWashingFactoryInput;
    public final CachedLongValue EliteWashingFactoryInput;
    public final CachedLongValue UltimateWashingFactoryInput;
    public final CachedLongValue OverclockedWashingFactoryInput;
    public final CachedLongValue QuantumWashingFactoryInput;
    public final CachedLongValue DenseWashingFactoryInput;
    public final CachedLongValue MultiversalWashingFactoryInput;
    public final CachedLongValue CreativeWashingFactoryInput;

    public final CachedLongValue BasicWashingFactoryOutput;
    public final CachedLongValue AdvancedWashingFactoryOutput;
    public final CachedLongValue EliteWashingFactoryOutput;
    public final CachedLongValue UltimateWashingFactoryOutput;
    public final CachedLongValue OverclockedWashingFactoryOutput;
    public final CachedLongValue QuantumWashingFactoryOutput;
    public final CachedLongValue DenseWashingFactoryOutput;
    public final CachedLongValue MultiversalWashingFactoryOutput;
    public final CachedLongValue CreativeWashingFactoryOutput;

    public final CachedLongValue BasicPressurizedReactingFactoryinput;
    public final CachedLongValue AdvancedPressurizedReactingFactoryinput;
    public final CachedLongValue ElitePressurizedReactingFactoryinput;
    public final CachedLongValue UltimatePressurizedReactingFactoryinput;
    public final CachedLongValue OverclockedPressurizedReactingFactoryinput;
    public final CachedLongValue QuantumPressurizedReactingFactoryinput;
    public final CachedLongValue DensePressurizedReactingFactoryinput;
    public final CachedLongValue MultiversalPressurizedReactingFactoryinput;
    public final CachedLongValue CreativePressurizedReactingFactoryinput;

    public final CachedLongValue BasicPressurizedReactingFactoryoutput;
    public final CachedLongValue AdvancedPressurizedReactingFactoryoutput;
    public final CachedLongValue ElitePressurizedReactingFactoryoutput;
    public final CachedLongValue UltimatePressurizedReactingFactoryoutput;
    public final CachedLongValue OverclockedPressurizedReactingFactoryoutput;
    public final CachedLongValue QuantumPressurizedReactingFactoryoutput;
    public final CachedLongValue DensePressurizedReactingFactoryoutput;
    public final CachedLongValue MultiversalPressurizedReactingFactoryoutput;
    public final CachedLongValue CreativePressurizedReactingFactoryoutput;

    public final CachedLongValue PlantingStation;
    public final CachedLongValue BasicPlantingStationFactory;
    public final CachedLongValue AdvancedPlantingStationFactory;
    public final CachedLongValue ElitePlantingStationFactory;
    public final CachedLongValue UltimatePlantingStationFactory;
    public final CachedLongValue OverclockedPlantingStationFactory;
    public final CachedLongValue QuantumPlantingStationFactory;
    public final CachedLongValue DensePlantingStationFactory;
    public final CachedLongValue MultiversalPlantingStationFactory;
    public final CachedLongValue CreativePlantingStationFactory;

    public final CachedLongValue Replicator;
    public final CachedLongValue BasicReplicatorFactory;
    public final CachedLongValue AdvancedReplicatorFactory;
    public final CachedLongValue EliteReplicatorFactory;
    public final CachedLongValue UltimateReplicatorFactory;
    public final CachedLongValue OverclockedReplicatorFactory;
    public final CachedLongValue QuantumReplicatorFactory;
    public final CachedLongValue DenseReplicatorFactory;
    public final CachedLongValue MultiversalReplicatorFactory;
    public final CachedLongValue CreativeReplicatorFactory;

    public final CachedLongValue AmbientGasCollector;
    public final CachedLongValue FluidReplicatorGasInput;
    public final CachedIntValue FluidReplicatorFluidInput;
    public final CachedIntValue FluidReplicatorFluidOutput;

    public MMCMekMMMachineConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Mekanism_More_Machine").push("OxidizingFactory");
        BasicOxidizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedOxidizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteOxidizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateOxidizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedOxidizingFactory =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumOxidizingFactory =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseOxidizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalOxidizingFactory =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeOxidizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("DissolvingFactory");
        BasicDissolvingFactoryInput =           CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedDissolvingFactoryInput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteDissolvingFactoryInput =           CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateDissolvingFactoryInput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedDissolvingFactoryInput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumDissolvingFactoryInput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseDissolvingFactoryInput =           CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalDissolvingFactoryInput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeDissolvingFactoryInput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativecChemicalInputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicDissolvingFactoryOutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedDissolvingFactoryOutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteDissolvingFactoryOutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateDissolvingFactoryOutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedDissolvingFactoOutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalOutputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumDissolvingFactoryOutput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalOutputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseDissolvingFactoryOutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalOutputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalDissolvingFactoOutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalOutputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeDissolvingFactoryOutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativecChemicalOutputTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("CentrifugingFactory");
        BasicCentrifugingFactoryinput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedCentrifugingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteCentrifugingFactoryinput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateCentrifugingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedCentrifugingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumCentrifugingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseCentrifugingFactoryinput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalCentrifugingFactoryinput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeCentrifugingFactoryinput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalInputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicCentrifugingFactoryoutput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedCentrifugingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteCentrifugingFactoryoutput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateCentrifugingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedCentrifugingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalOutputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumCentrifugingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalOutputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseCentrifugingFactoryoutput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalOutputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalCentrifugingFactoryoutput =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalOutputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeCentrifugingFactoryoutput =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalOutputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        builder.pop().push("ChemicalInfusingFactory");
//        builder.pop().push("ChemicalToChemicalFactory");
        BasicChemicalToChemicalFactoryinputR =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalRightInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryinputR =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalRightInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryinputR =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalRightInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryinputR =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalRightInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedChemicalToChemicalFactoryinputR =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalRightInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumChemicalToChemicalFactoryinputR =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalRightInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseChemicalToChemicalFactoryinputR =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalRightInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalChemicalToChemicalFactoryinputR =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalRightInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeChemicalToChemicalFactoryinputR =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB) Chemical Infusing Factory only. Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalRightInputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicChemicalToChemicalFactoryoutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryoutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryoutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryoutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedChemicalToChemicalFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalOutputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumChemicalToChemicalFactoryoutput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalOutputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseChemicalToChemicalFactoryoutput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalOutputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalChemicalToChemicalFactoryoutput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalOutputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeChemicalToChemicalFactoryoutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalOutputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicChemicalToChemicalFactoryinputL =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalLeftInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedChemicalToChemicalFactoryinputL =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalLeftInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteChemicalToChemicalFactoryinputL =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalLeftInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateChemicalToChemicalFactoryinputL =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalLeftInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedChemicalToChemicalFactoryinputL =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalLeftInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumChemicalToChemicalFactoryinputL =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalLeftInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseChemicalToChemicalFactoryinputL =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalLeftInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalChemicalToChemicalFactoryinputL =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalLeftInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeChemicalToChemicalFactoryinputL =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalLeftInputTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("CrystallizingFactory");
        BasicCrystallizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedCrystallizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteCrystallizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateCrystallizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedCrystallizingFactory =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumCrystallizingFactory =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseCrystallizingFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalCrystallizingFactory =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeCrystallizingFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("PressurizedReactingFactory");
        BasicPressurizedReactingFactoryinput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedPressurizedReactingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        ElitePressurizedReactingFactoryinput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimatePressurizedReactingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedPressurizedReactingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumPressurizedReactingFactoryinput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DensePressurizedReactingFactoryinput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalPressurizedReactingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativePressurizedReactingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalInputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicPressurizedReactingFactoryoutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedPressurizedReactingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        ElitePressurizedReactingFactoryoutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimatePressurizedReactingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedPressurizedReactingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalOutputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumPressurizedReactingFactoryoutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalOutputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DensePressurizedReactingFactoryoutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalOutputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalPressurizedReactingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalOutputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativePressurizedReactingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalOutputTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("PlantingStation");
        PlantingStation =                       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 21000, Vanilla: 210").defineInRange("ChemicalInputTankCapacity", 21000, 1, Long.MAX_VALUE));
        BasicPlantingStationFactory  =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 63000, Vanilla: 630").defineInRange("basicChemicalTankCapacity",63000,1,Long.MAX_VALUE));
        AdvancedPlantingStationFactory =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 105000, Vanilla: 1050").defineInRange("advancedChemicalTankCapacity",105000,1,Long.MAX_VALUE));
        ElitePlantingStationFactory =           CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 147000 , Vanilla: 1470").defineInRange("eliteChemicalTankCapacity",147000,1,Long.MAX_VALUE));
        UltimatePlantingStationFactory =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 189000 , Vanilla: 1890").defineInRange("ultimateChemicalTankCapacity",189000,1,Long.MAX_VALUE));
        OverclockedPlantingStationFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 231000, Vanilla: 2310").defineInRange("OverclockedChemicalTankCapacity", 231000, 1, Long.MAX_VALUE));
        QuantumPlantingStationFactory =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 273000, Vanilla: 2730").defineInRange("QuantumChemicalTankCapacity", 273000, 1, Long.MAX_VALUE));
        DensePlantingStationFactory =           CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 315000, Vanilla: 3150").defineInRange("DenseChemicalTankCapacity", 315000, 1, Long.MAX_VALUE));
        MultiversalPlantingStationFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 357000, Vanilla: 3570").defineInRange("MultiversalChemicalTankCapacity", 357000, 1, Long.MAX_VALUE));
        CreativePlantingStationFactory=         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 399000, Vanilla: 3990").defineInRange("CreativeChemicalTankCapacity", 399000, 1, Long.MAX_VALUE));
        builder.pop().push("Replicator");
        Replicator =                    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalInputTankCapacity", 1000000, 1, Long.MAX_VALUE));
        BasicReplicatorFactory =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedReplicatorFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteReplicatorFactory =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateReplicatorFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedReplicatorFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumReplicatorFactory =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseReplicatorFactory =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalReplicatorFactory =  CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeReplicatorFactory =     CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalTankCapacity", 19000000, 1, Long.MAX_VALUE));
//        builder.pop().push("SolarNeutronActivatingFactory");
//        BasicSolarNeutronActivatingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedSolarNeutronActivatingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteSolarNeutronActivatingFactoryinput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateSolarNeutronActivatingFactoryinput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
//        BasicSolarNeutronActivatingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
//        AdvancedSolarNeutronActivatingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
//        EliteSolarNeutronActivatingFactoryoutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
//        UltimateSolarNeutronActivatingFactoryoutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        builder.pop().push("WashingFactory");
        BasicWashingFactory =               CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicFluidInputTankCapacity", 3000000, 1, Integer.MAX_VALUE));
        AdvancedWashingFactory =            CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedFluidInputTankCapacity", 5000000, 1, Integer.MAX_VALUE));
        EliteWashingFactory =               CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteFluidInputTankCapacity", 7000000, 1, Integer.MAX_VALUE));
        UltimateWashingFactory =            CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateFluidInputTankCapacity", 9000000, 1, Integer.MAX_VALUE));
        OverclockedWashingFactory =         CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedFluidInputTankCapacity", 11000000, 1, Integer.MAX_VALUE));
        QuantumWashingFactory =             CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumFluidInputTankCapacity", 13000000, 1, Integer.MAX_VALUE));
        DenseWashingFactory =               CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseFluidInputTankCapacity", 15000000, 1, Integer.MAX_VALUE));
        MultiversalWashingFactory =         CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalFluidInputTankCapacity", 17000000, 1, Integer.MAX_VALUE));
        CreativeWashingFactory =            CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeFluidInputTankCapacity", 19000000, 1, Integer.MAX_VALUE));

        BasicWashingFactoryInput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalInputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedWashingFactoryInput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalInputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteWashingFactoryInput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalInputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateWashingFactoryInput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalInputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedWashingFactoryInput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalInputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumWashingFactoryInput =        CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalInputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseWashingFactoryInput =          CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalInputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalWashingFactoryInput =    CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalInputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeWashingFactoryInput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalInputTankCapacity", 19000000, 1, Long.MAX_VALUE));

        BasicWashingFactoryOutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 3000000, Vanilla: 30000").defineInRange("basicChemicalOutputTankCapacity", 3000000, 1, Long.MAX_VALUE));
        AdvancedWashingFactoryOutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 5000000, Vanilla: 50000").defineInRange("advancedChemicalOutputTankCapacity", 5000000, 1, Long.MAX_VALUE));
        EliteWashingFactoryOutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 7000000, Vanilla: 70000").defineInRange("eliteChemicalOutputTankCapacity", 7000000, 1, Long.MAX_VALUE));
        UltimateWashingFactoryOutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 9000000, Vanilla: 90000").defineInRange("ultimateChemicalOutputTankCapacity", 9000000, 1, Long.MAX_VALUE));
        OverclockedWashingFactoryOutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 11000000, Vanilla: 110000").defineInRange("OverclockedChemicalOutputTankCapacity", 11000000, 1, Long.MAX_VALUE));
        QuantumWashingFactoryOutput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 13000000, Vanilla: 130000").defineInRange("QuantumChemicalOutputTankCapacity", 13000000, 1, Long.MAX_VALUE));
        DenseWashingFactoryOutput =         CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 15000000, Vanilla: 150000").defineInRange("DenseChemicalOutputTankCapacity", 15000000, 1, Long.MAX_VALUE));
        MultiversalWashingFactoryOutput =   CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 17000000, Vanilla: 170000").defineInRange("MultiversalChemicalOutputTankCapacity", 17000000, 1, Long.MAX_VALUE));
        CreativeWashingFactoryOutput =      CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 19000000, Vanilla: 190000").defineInRange("CreativeChemicalOutputTankCapacity", 19000000, 1, Long.MAX_VALUE));
        builder.pop().push("AmbientGasCollector");
        AmbientGasCollector = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalInputTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("FluidReplicator");
        FluidReplicatorGasInput =       CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalInputTankCapacity", 1000000, 1, Long.MAX_VALUE));
        FluidReplicatorFluidInput =     CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 100000, Vanilla: 1000").defineInRange("FluidOutputTankCapacity", 100000, 1, Integer.MAX_VALUE));
        FluidReplicatorFluidOutput =    CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla:10000").defineInRange("FluidOutputTankCapacity", 1000000, 1, Integer.MAX_VALUE));
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCMekMMMachine";
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

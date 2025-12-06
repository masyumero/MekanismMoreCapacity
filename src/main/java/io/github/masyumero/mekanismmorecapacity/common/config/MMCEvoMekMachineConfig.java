package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.ModConfigSpec;

public class MMCEvoMekMachineConfig extends BaseMekanismConfig {

    private final ModConfigSpec configSpec;
    public final CachedLongValue OverclockedCompressing;
    public final CachedLongValue QuantumCompressing;
    public final CachedLongValue DenseCompressing;
    public final CachedLongValue MultiversalCompressing;
    public final CachedLongValue CreativeCompressing;
    public final CachedLongValue Overclockedinjecting;
    public final CachedLongValue Quantuminjecting;
    public final CachedLongValue Denseinjecting;
    public final CachedLongValue Multiversalinjecting;
    public final CachedLongValue Creativeinjecting;
    public final CachedLongValue Overclockedpurifying;
    public final CachedLongValue Quantumpurifying;
    public final CachedLongValue Densepurifying;
    public final CachedLongValue Multiversalpurifying;
    public final CachedLongValue Creativepurifying;
    public final CachedLongValue OverclockedMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue QuantumMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue DenseMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue MultiversalMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue CreativeMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue Chemixer;
    public final CachedIntValue Thermalizer;
    public final CachedIntValue SolidifierCoolantTank;
    public final CachedIntValue SolidifierMoltenMaterial;

    public MMCEvoMekMachineConfig() {
        ModConfigSpec.Builder builder = new ModConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Evolved_Mekanism")
                .push("EvolvedCompressing");
        OverclockedCompressing = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 231000, Vanilla: 2310").defineInRange("overclockedChemicalTankCapacity", 231000, 1, Long.MAX_VALUE));
        QuantumCompressing = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 273000, Vanilla: 2730").defineInRange("quantumChemicalTankCapacity", 273000, 1, Long.MAX_VALUE));
        DenseCompressing = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 315000, Vanilla: 3150").defineInRange("denseChemicalTankCapacity", 315000, 1, Long.MAX_VALUE));
        MultiversalCompressing = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 357000, Vanilla: 3570").defineInRange("multiversalChemicalTankCapacity", 357000, 1, Long.MAX_VALUE));
        CreativeCompressing = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 399000, Vanilla: 3990").defineInRange("CreativeChemicalTankCapacity", 399000, 1, Long.MAX_VALUE));
        builder.pop().push("Evolvedinjecting");
        Overclockedinjecting = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 231000, Vanilla: 2310").defineInRange("overclockedChemicalTankCapacity", 231000, 1, Long.MAX_VALUE));
        Quantuminjecting = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 273000, Vanilla: 2730").defineInRange("quantumChemicalTankCapacity", 273000, 1, Long.MAX_VALUE));
        Denseinjecting = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 315000, Vanilla: 3150").defineInRange("denseChemicalTankCapacity", 315000, 1, Long.MAX_VALUE));
        Multiversalinjecting = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 357000, Vanilla: 3570").defineInRange("multiversalChemicalTankCapacity", 357000, 1, Long.MAX_VALUE));
        Creativeinjecting = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 399000, Vanilla: 3990").defineInRange("CreativeChemicalTankCapacity", 399000, 1, Long.MAX_VALUE));
        builder.pop().push("EvolvedPurifying");
        Overclockedpurifying = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 231000, Vanilla: 2310").defineInRange("overclockedChemicalTankCapacity", 231000, 1, Long.MAX_VALUE));
        Quantumpurifying = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 273000, Vanilla: 2730").defineInRange("quantumChemicalTankCapacity", 273000, 1, Long.MAX_VALUE));
        Densepurifying = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 315000, Vanilla: 3150").defineInRange("denseChemicalTankCapacity", 315000, 1, Long.MAX_VALUE));
        Multiversalpurifying = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 357000, Vanilla: 3570").defineInRange("multiversalChemicalTankCapacity", 357000, 1, Long.MAX_VALUE));
        Creativepurifying = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 399000, Vanilla: 3990").defineInRange("CreativeChemicalTankCapacity", 399000, 1, Long.MAX_VALUE));
        builder.pop().push("InfusingFactoryEvolved");
        OverclockedMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1100000, Vanilla: 13000").defineInRange("overclockedChemicalTankCapacity", 1100000, 1, Long.MAX_VALUE));
        QuantumMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1300000, Vanilla: ").defineInRange("quantumChemicalTankCapacity", 1300000, 1, Long.MAX_VALUE));
        DenseMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1500000, Vanilla: 15000").defineInRange("denseChemicalTankCapacity", 1500000, 1, Long.MAX_VALUE));
        MultiversalMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1700000, Vanilla: 17000").defineInRange("multiversalChemicalTankCapacity", 1700000, 1, Long.MAX_VALUE));
        CreativeMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1900000, Vanilla: 19000").defineInRange("CreativeChemicalTankCapacity", 1900000, 1, Long.MAX_VALUE));
        builder.pop().push("Chemixer");
        Chemixer = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("Thermalizer");
        Thermalizer = CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1600000, Vanilla: 16000").defineInRange("fluidTankCapacity", 1600000, 1, Integer.MAX_VALUE));
        builder.pop().push("Solidifier");
        SolidifierCoolantTank = CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity", 1000000, 1, Integer.MAX_VALUE));
        SolidifierMoltenMaterial =  CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("extraFluidTankCapacity", 1000000, 1, Integer.MAX_VALUE));
        builder.pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCEvoMekMachine";
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

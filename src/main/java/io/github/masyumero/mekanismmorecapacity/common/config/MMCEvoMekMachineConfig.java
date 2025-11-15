package io.github.masyumero.mekanismmorecapacity.common.config;

import mekanism.common.config.BaseMekanismConfig;
import mekanism.common.config.value.CachedIntValue;
import mekanism.common.config.value.CachedLongValue;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.config.ModConfig;

public class MMCEvoMekMachineConfig extends BaseMekanismConfig {

    private final ForgeConfigSpec configSpec;
    public final CachedLongValue OVERCLOCKEDFactories;
    public final CachedLongValue QUANTUMFactories;
    public final CachedLongValue DENSEFactories;
    public final CachedLongValue MULTIVERSALFactories;
    public final CachedLongValue CREATIVEFactories;
    public final CachedLongValue OVERCLOCKEDMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue QUANTUMFMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue DENSEMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue MULTIVERSALMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue CREATIVEMetallurgicInfuserFactoryEvolved;
    public final CachedLongValue CHEMIXER;
    public final CachedIntValue THERMALIZER;
    public final CachedIntValue SOLIDIFIERCOOLANTTANK;
    public final CachedIntValue SOLIDIFIERMOLTENMATERIAL;

    public MMCEvoMekMachineConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        builder.comment("Adjustment of the capacity of the machine's internal tank");
        builder.push("Evolved_Mekanism").push("EvolvedCompressing, Evolvedinjecting, Evolvedspurifying");
        OVERCLOCKEDFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 231000, Vanilla: 2310").defineInRange("overclockedChemicalTankCapacity", 231000, 1, Long.MAX_VALUE));
        QUANTUMFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 273000, Vanilla: 2730").defineInRange("quantumChemicalTankCapacity", 273000, 1, Long.MAX_VALUE));
        DENSEFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 315000, Vanilla: 3150").defineInRange("denseChemicalTankCapacity", 315000, 1, Long.MAX_VALUE));
        MULTIVERSALFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 357000, Vanilla: 3570").defineInRange("multiversalChemicalTankCapacity", 357000, 1, Long.MAX_VALUE));
        CREATIVEFactories = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 399000, Vanilla: 3990").defineInRange("CreativeChemicalTankCapacity", 399000, 1, Long.MAX_VALUE));
        builder.pop().push("InfusingFactoryEvolved");
        OVERCLOCKEDMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1100000, Vanilla: 13000").defineInRange("overclockedChemicalTankCapacity", 1100000, 1, Long.MAX_VALUE));
        QUANTUMFMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1300000, Vanilla: ").defineInRange("quantumChemicalTankCapacity", 1300000, 1, Long.MAX_VALUE));
        DENSEMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1500000, Vanilla: 15000").defineInRange("denseChemicalTankCapacity", 1500000, 1, Long.MAX_VALUE));
        MULTIVERSALMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1700000, Vanilla: 17000").defineInRange("multiversalChemicalTankCapacity", 1700000, 1, Long.MAX_VALUE));
        CREATIVEMetallurgicInfuserFactoryEvolved = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1900000, Vanilla: 19000").defineInRange("CreativeChemicalTankCapacity", 1900000, 1, Long.MAX_VALUE));
        builder.pop().push("Chemixer");
        CHEMIXER = CachedLongValue.wrap(this, builder.comment("Chemical tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("ChemicalTankCapacity", 1000000, 1, Long.MAX_VALUE));
        builder.pop().push("Thermalizer");
        THERMALIZER = CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1600000, Vanilla: 16000").defineInRange("fluidTankCapacity", 1600000, 1, Integer.MAX_VALUE));
        builder.pop().push("Solidifier");
        SOLIDIFIERCOOLANTTANK = CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("fluidTankCapacity", 1000000, 1, Integer.MAX_VALUE));
        SOLIDIFIERMOLTENMATERIAL =  CachedIntValue.wrap(this, builder.comment("Fluid tank capacity (mB). Default: 1000000, Vanilla: 10000").defineInRange("extraFluidTankCapacity", 1000000, 1, Integer.MAX_VALUE));
        builder.pop();
        configSpec = builder.build();
    }

    @Override
    public String getFileName() {
        return "MMCEvoMekMachine";
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

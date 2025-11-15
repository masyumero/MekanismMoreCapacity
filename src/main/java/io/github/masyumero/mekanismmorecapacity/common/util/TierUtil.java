package io.github.masyumero.mekanismmorecapacity.common.util;

import mekanism.common.tier.FactoryTier;

public class TierUtil {

    public static String getTierName(FactoryTier tier) {
        return tier.getBaseTier().getSimpleName();
    }
}

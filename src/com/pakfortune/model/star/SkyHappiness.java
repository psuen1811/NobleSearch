package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  天喜
 */
@SuppressWarnings("NonAsciiCharacters")
public enum SkyHappiness {
    申("酉"),
    子("申"),
    辰("未"),
    亥("午"),
    卯("巳"),
    未("辰"),
    寅("卯"),
    午("寅"),
    戌("丑"),
    巳("子"),
    酉("亥"),
    丑("戌");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    SkyHappiness(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(SkyHappiness.class, branch).getInformation();
    }
}

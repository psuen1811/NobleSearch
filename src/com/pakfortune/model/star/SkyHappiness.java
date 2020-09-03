package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  天喜
 */
@SuppressWarnings("NonAsciiCharacters")
public enum SkyHappiness {
    子("酉"),
    丑("申"),
    寅("未"),
    卯("午"),
    辰("巳"),
    巳("辰"),
    午("卯"),
    未("寅"),
    申("丑"),
    酉("子"),
    戌("亥"),
    亥("戌");

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

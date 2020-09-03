package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  紅鸞
 */
@SuppressWarnings("NonAsciiCharacters")
public enum RedFlower {
    子("卯"),
    丑("寅"),
    寅("丑"),
    卯("子"),
    辰("亥"),
    巳("戌"),
    午("酉"),
    未("申"),
    申("未"),
    酉("午"),
    戌("巳"),
    亥("辰");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    RedFlower(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(RedFlower.class, branch).getInformation();
    }
}

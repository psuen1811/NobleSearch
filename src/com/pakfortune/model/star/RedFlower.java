package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  紅鸞
 */
@SuppressWarnings("NonAsciiCharacters")
public enum RedFlower {
    申("卯"),
    子("寅"),
    辰("丑"),
    亥("子"),
    卯("亥"),
    未("戌"),
    寅("酉"),
    午("申"),
    戌("未"),
    巳("午"),
    酉("巳"),
    丑("辰");

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

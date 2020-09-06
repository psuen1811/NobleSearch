package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  喪門
 */
@SuppressWarnings("NonAsciiCharacters")
public enum DeadDoor {
    子("寅"),
    丑("卯"),
    寅("辰"),
    卯("巳"),
    辰("午"),
    巳("未"),
    午("申"),
    未("酉"),
    申("戌"),
    酉("亥"),
    戌("子"),
    亥("丑");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    DeadDoor(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(DeadDoor.class, branch).getInformation();
    }
}

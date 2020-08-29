package com.pakfortune.model.star;

import com.google.common.base.Enums;
import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
 灾煞的歌诀为
 申子辰见午, 亥卯未见酉, 寅午戌见子, 巳酉丑见卯
*/
@SuppressWarnings("NonAsciiCharacters")
public enum Disaster {
    申("午"),
    子("午"),
    辰("午"),
    亥("酉"),
    卯("酉"),
    未("酉"),
    寅("子"),
    午("子"),
    戌("子"),
    巳("卯"),
    酉("卯"),
    丑("卯");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    Disaster(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(Disaster.class, branch).getInformation();
    }
}

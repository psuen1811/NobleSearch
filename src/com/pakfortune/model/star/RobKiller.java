package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
 劫煞的歌诀为：
 申子辰见巳，亥卯未见申，寅午戌见亥，巳酉丑见寅
 */
@SuppressWarnings("NonAsciiCharacters")
public enum RobKiller {
    申("巳"),
    子("巳"),
    辰("巳"),
    亥("申"),
    卯("申"),
    未("申"),
    寅("亥"),
    午("亥"),
    戌("亥"),
    巳("寅"),
    酉("寅"),
    丑("寅");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    RobKiller(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(RobKiller.class, branch).getInformation();
    }
}

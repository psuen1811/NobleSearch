package com.pakfortune.model.star;

import com.google.common.base.Enums;

/*
 歲煞的歌诀为
 申子辰煞在未, 巳酉丑煞在辰, 寅午戌煞在丑, 亥卯未煞在未
 */
@SuppressWarnings("NonAsciiCharacters")
public enum YearKiller {
    申 ("未"),
    子 ("未"),
    辰 ("未"),
    巳 ("辰"),
    酉 ("辰"),
    丑 ("辰"),
    寅 ("丑"),
    午 ("丑"),
    戌 ("丑"),
    亥 ("戌"),
    卯 ("戌"),
    未 ("戌");

    private final String information;

    YearKiller(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return getIfPresent(branch).getInformation();
    }

    public static YearKiller getIfPresent(String name) {
        return Enums.getIfPresent(YearKiller.class, name).orNull();
    }

}

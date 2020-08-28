package com.pakfortune.model.star;

import com.google.common.base.Enums;

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

    RobKiller(String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return getIfPresent(branch).getInformation();
    }

    public static RobKiller getIfPresent(String name) {
        return Enums.getIfPresent(RobKiller.class, name).orNull();
    }
}

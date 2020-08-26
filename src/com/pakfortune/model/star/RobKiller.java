package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

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
    private static final Map<String, String> lookup = Maps.newHashMapWithExpectedSize(RobKiller.values().length);

    RobKiller(String information) {
        this.information = information;
    }

    static {
        for (RobKiller robKiller : values())
            lookup.put(robKiller.name(), robKiller.information);
    }

    public static Map<String, String> getLookup() {
        return ImmutableMap.copyOf(lookup);
    }
}

package com.pakfortune.model.star;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import java.util.Map;

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
    private static final Map<String, String> lookup = Maps.newHashMapWithExpectedSize(Disaster.values().length);

    Disaster(String information) {
        this.information = information;
    }

    static {
        for (Disaster disaster : values())
            lookup.put(disaster.name(), disaster.information);
    }

    public static Map<String, String> getLookup() {
        return ImmutableMap.copyOf(lookup);
    }
}

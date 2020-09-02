package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  桃花
 */
@SuppressWarnings("NonAsciiCharacters")
public enum Flower {
    申("酉"),
    子("午"),
    辰("卯"),
    亥("子"),
    卯("酉"),
    未("午"),
    寅("卯"),
    午("子"),
    戌("酉"),
    巳("午"),
    酉("卯"),
    丑("子");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    Flower(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(Flower.class, branch).getInformation();
    }
}

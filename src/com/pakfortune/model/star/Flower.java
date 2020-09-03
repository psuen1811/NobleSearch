package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  桃花
 */
@SuppressWarnings("NonAsciiCharacters")
public enum Flower {
    子("酉"),
    丑("午"),
    寅("卯"),
    卯("子"),
    辰("酉"),
    巳("午"),
    午("卯"),
    未("子"),
    申("酉"),
    酉("午"),
    戌("卯"),
    亥("子");

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

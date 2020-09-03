package com.pakfortune.model.star;

import com.pakfortune.common.LookupImpl;
import com.pakfortune.common.LookupInterface;

/*
  吊客
 */
@SuppressWarnings("NonAsciiCharacters")
public enum Hangman {
    子("戌"),
    丑("亥"),
    寅("子"),
    卯("丑"),
    辰("寅"),
    巳("卯"),
    午("辰"),
    未("巳"),
    申("午"),
    酉("未"),
    戌("申"),
    亥("酉");

    private final String information;
    private static final LookupInterface lookup = new LookupImpl();

    Hangman(final String information) {
        this.information = information;
    }

    public String getInformation() {
        return information;
    }

    public static String calculate(String branch) {
        return lookup.getIfPresent(Hangman.class, branch).getInformation();
    }
}

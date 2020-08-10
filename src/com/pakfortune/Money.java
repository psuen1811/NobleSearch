package com.pakfortune;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NonAsciiCharacters")
public enum Money {
    甲("丙寅"),
    乙("己卯"),
    丙("癸巳"),
    丁("丙午"),
    戊("丁巳"),
    己("庚午"),
    庚("甲申"),
    辛("丁酉"),
    壬("辛亥"),
    癸("甲子");

    private final String moneyResult;
    private static final Map<Money, String> lookup = new HashMap<>();

    Money(String moneyResult) {
        this.moneyResult = moneyResult;
    }

    static {
        for (Money env : values()) lookup.put(env, env.getMoneyResult());
    }

    protected String getMoneyResult() {
        return this.moneyResult;
    }

    public static Map<Money, String> getLookup() {
        return Collections.unmodifiableMap(lookup); }
}

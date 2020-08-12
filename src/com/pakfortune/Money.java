package com.pakfortune;

@SuppressWarnings({"NonAsciiCharacters", "unused"})
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

    Money(String moneyResult) {
        this.moneyResult = moneyResult;
    }

    public String getMoneyResult() {
        return this.moneyResult;
    }

    public static String calculate(String input) {
        // 取天干
        String s;
        for( Stem stem : Stem.values() ) {
            if( input.contains(stem.name()) ) {
                s = stem.name();
                Money key = Money.valueOf(s);
                return key.getMoneyResult();
            }
        }
        return null;
    }
}

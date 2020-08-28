package com.pakfortune.model.star;

import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.element.Branch;

@SuppressWarnings("NonAsciiCharacters")
public enum Horse {
    寅午戌 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.equals("甲"))
                result = SixtyJiaziTable.壬申;
            if (input.equals("丙"))
                result = SixtyJiaziTable.丙申;
            if (input.equals("戊"))
                result = SixtyJiaziTable.庚申;
            if (input.equals("庚"))
                result = SixtyJiaziTable.甲申;
            if (input.equals("壬"))
                result = SixtyJiaziTable.戊申;
            return result;
        }
    },
    申子辰 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.equals("甲"))
                result = SixtyJiaziTable.丙寅;
            if (input.equals("丙"))
                result = SixtyJiaziTable.庚寅;
            if (input.equals("戊"))
                result = SixtyJiaziTable.甲寅;
            if (input.equals("庚"))
                result = SixtyJiaziTable.戊寅;
            if (input.equals("壬"))
                result = SixtyJiaziTable.壬寅;
            return result;
        }
    },
    亥卯未 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.equals("乙"))
                result = SixtyJiaziTable.辛巳;
            if (input.equals("丁"))
                result = SixtyJiaziTable.乙巳;
            if (input.equals("己"))
                result = SixtyJiaziTable.己巳;
            if (input.equals("辛"))
                result = SixtyJiaziTable.癸巳;
            if (input.equals("癸"))
                result = SixtyJiaziTable.丁巳;
            return result;
        }
    },

    巳酉丑 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.equals("乙"))
                result = SixtyJiaziTable.丁巳;
            if (input.equals("丁"))
                result = SixtyJiaziTable.辛巳;
            if (input.equals("己"))
                result = SixtyJiaziTable.乙巳;
            if (input.equals("辛"))
                result = SixtyJiaziTable.己巳;
            if (input.equals("癸"))
                result = SixtyJiaziTable.癸巳;
            return result;
        }
    };

    abstract SixtyJiaziTable checkStemBranch(String input);

    public static String calculate(String stem, String branch) {
        for (Horse key : Horse.values())
            if (key.name().contains(branch)) return key.checkStemBranch(stem).toString();
        return null;
    }
}

package com.pakfortune.model.stars;

import com.google.common.base.Preconditions;
import com.pakfortune.model.elements.SixtyJiaziTable;
import com.pakfortune.model.elements.Branch;

@SuppressWarnings("NonAsciiCharacters")
public enum Horse {
    寅午戌 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.contains("甲"))
                result = SixtyJiaziTable.壬申;
            if (input.contains("丙"))
                result = SixtyJiaziTable.丙申;
            if (input.contains("戊"))
                result = SixtyJiaziTable.庚申;
            if (input.contains("庚"))
                result = SixtyJiaziTable.甲申;
            if (input.contains("壬"))
                result = SixtyJiaziTable.戊申;
            return result;
        }
    },
    申子辰 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.contains("甲"))
                result = SixtyJiaziTable.丙寅;
            if (input.contains("丙"))
                result = SixtyJiaziTable.庚寅;
            if (input.contains("戊"))
                result = SixtyJiaziTable.甲寅;
            if (input.contains("庚"))
                result = SixtyJiaziTable.戊寅;
            if (input.contains("壬"))
                result = SixtyJiaziTable.壬寅;
            return result;
        }
    },
    亥卯未 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.contains("乙"))
                result = SixtyJiaziTable.辛巳;
            if (input.contains("丁"))
                result = SixtyJiaziTable.乙巳;
            if (input.contains("己"))
                result = SixtyJiaziTable.己巳;
            if (input.contains("辛"))
                result = SixtyJiaziTable.癸巳;
            if (input.contains("癸"))
                result = SixtyJiaziTable.丁巳;
            return result;
        }
    },

    巳酉丑 {
        @Override
        SixtyJiaziTable checkStemBranch(String input) {
            SixtyJiaziTable result = null;
            if (input.contains("乙"))
                result = SixtyJiaziTable.丁巳;
            if (input.contains("丁"))
                result = SixtyJiaziTable.辛巳;
            if (input.contains("己"))
                result = SixtyJiaziTable.乙巳;
            if (input.contains("辛"))
                result = SixtyJiaziTable.己巳;
            if (input.contains("癸"))
                result = SixtyJiaziTable.癸巳;
            return result;
        }
    };

    abstract SixtyJiaziTable checkStemBranch(String input);

    public static String calculate(String input) {
        // 取地支
        String s = null;
        for (Branch branch : Branch.values())
            if (input.contains(branch.name()))
                s = branch.name();
        for (Horse key : Horse.values())
            if (key.name().contains(Preconditions.checkNotNull(s))) return key.checkStemBranch(input).toString();
        return null;
    }

}

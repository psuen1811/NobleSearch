package com.pakfortune;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("NonAsciiCharacters")
public enum Richman {
    甲 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.甲)) {
                list.add(SixtyJiaziTable.丁丑);
                list.add(SixtyJiaziTable.辛未);
            }
            return list;
        }
    },
    乙 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.乙)) {
                list.add(SixtyJiaziTable.甲申);
                list.add(SixtyJiaziTable.戊子);
            }
            return list;
        }
    },
    丙 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.丙)) {
                list.add(SixtyJiaziTable.丁酉);
                list.add(SixtyJiaziTable.己亥);
            }
            return list;
        }
    },
    丁 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if (Stem.valueOf(stem.name()).equals(Stem.丁)) {
                list.add(SixtyJiaziTable.己酉);
                list.add(SixtyJiaziTable.辛亥);
            }
            return list;
        }
    },
    戊 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.戊)) {
                list.add(SixtyJiaziTable.乙丑);
                list.add(SixtyJiaziTable.己未);
            }
            return list;
        }
    },
    己 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.己)) {
                list.add(SixtyJiaziTable.丙子);
                list.add(SixtyJiaziTable.壬申);
            }
            return list;
        }
    },
    庚 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.庚)) {
                list.add(SixtyJiaziTable.己丑);
                list.add(SixtyJiaziTable.癸未);
            }
            return list;
        }
    },
    辛 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.辛)) {
                list.add(SixtyJiaziTable.甲午);
                list.add(SixtyJiaziTable.庚寅);
            }
            return list;
        }
    },
    壬 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.壬)) {
                list.add(SixtyJiaziTable.乙巳);
                list.add(SixtyJiaziTable.癸卯);
            }
            return list;
        }
    },
    癸 {
        @Override
        List<SixtyJiaziTable> getRichmanResult(Stem stem) {
            List<SixtyJiaziTable> list = new ArrayList<>(2);
            if( Stem.valueOf(stem.name()).equals(Stem.癸)) {
                list.add(SixtyJiaziTable.乙卯);
                list.add(SixtyJiaziTable.丁巳);
            }
            return list;
        }
    };

    abstract List<SixtyJiaziTable> getRichmanResult(Stem stem);

    public static List<SixtyJiaziTable> calculate(String input) {
        for (Stem stem : Stem.values()) {
            if (input.contains(stem.name())) {
                for (Richman richman : Richman.values()) {
                    if (stem.name().equals(richman.name()))
                        return richman.getRichmanResult(stem);
                }
            }
        }
        return null;
    }
}

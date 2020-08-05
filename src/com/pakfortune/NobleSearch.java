package com.pakfortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NobleSearch {

    private static final int MAGIC_NUMBER = 9;

    public static void main(String [] arg) {
        ArrayList<Integer> arrayList = new ArrayList<>(SixtyJiaziTable.getSixJiaziList());
        //noinspection rawtypes
        CircularArrayList circularArrayList = new CircularArrayList<>(arrayList);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());

        // 祿
        int result = 0;
        String location = "";
        Map<Money, String> money = Money.getLookup();
        for (Money key : money.keySet()) {
            if (input.contains(key.name())) {
                location = key.getMoneyResult();
                result = SixtyJiaziTable.valueOf(location).ordinal();
            }
        }

        System.out.println("祿：" + location + "在" + Direction.findByValue((Integer)circularArrayList.get(result) % MAGIC_NUMBER));

        // 馬
        SixtyJiaziTable stemBranch = null;
        for( Branch branch : Branch.values() ) {
            if( input.contains(branch.name()) ) {
                for( Horse key : Horse.values()) {
                    if( key.name().contains(branch.name()) ) {
                        stemBranch = key.checkStemBranch(input);
                        break;
                    }
                }
                break;
            }
        }
        assert stemBranch != null;
        System.out.println("馬：" + stemBranch.name() + "在" + Direction.findByValue((Integer)circularArrayList
                .get(stemBranch.ordinal()) % MAGIC_NUMBER));

        // 貴人
        List<SixtyJiaziTable> list = null;
        for( Stem stem : Stem.values() ) {
            if( input.contains(stem.name())) {
                for( Richman richman : Richman.values() ) {
                    if( stem.name().equals(richman.name())) {
                        list = richman.getRichmanResult(stem);
                        break;
                    }
                }
                break;
            }
        }
        assert list != null;
        System.out.println("貴人：" + list.get(0) + "在" + Direction.findByValue((Integer)circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(0).name()).ordinal()) % MAGIC_NUMBER));
        System.out.println("貴人：" + list.get(1) + "在" + Direction.findByValue((Integer)circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(1).name()).ordinal()) % MAGIC_NUMBER));
    }
}

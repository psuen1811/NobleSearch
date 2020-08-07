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
        System.out.println("---- 尋找真祿馬貴人 ----\n" + "請輸入流年干支：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());

        // 祿
        int result = 0;
        String moneyLocation = "";
        Map<Money, String> money = Money.getLookup();
        for (Money key : money.keySet()) {
            if (input.contains(key.name())) {
                moneyLocation = key.getMoneyResult();
                result = SixtyJiaziTable.valueOf(moneyLocation).ordinal();
                break;
            }
        }

        System.out.println("祿：\t" + moneyLocation + "在" + Direction.findByValue((Integer)circularArrayList.get(result) % MAGIC_NUMBER));

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
        System.out.println("馬：\t" + stemBranch.name() + "在" + Direction.findByValue((Integer)circularArrayList
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
        System.out.println("貴人：\t" + list.get(0) + "在" + Direction.findByValue((Integer)circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(0).name()).ordinal()) % MAGIC_NUMBER));
        System.out.println("貴人：\t" + list.get(1) + "在" + Direction.findByValue((Integer)circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(1).name()).ordinal()) % MAGIC_NUMBER));

        // 當年月份
        System.out.println("請輸入流月干支：");
        Scanner scannerMonth = new Scanner(System.in);
        String inputMonth = scannerMonth.nextLine();
        int resultMonth = SixtyJiaziTable.valueOf(moneyLocation).ordinal() - SixtyJiaziTable.valueOf(inputMonth).ordinal();
        if (Integer.signum(resultMonth) < 0) {
            System.out.println("今年流月祿已過");
        } else if (Integer.signum(resultMonth) > 0) {
            System.out.println("流月祿" + moneyLocation + "在" + Direction.findByValue(arrayList.get(resultMonth)
                    % MAGIC_NUMBER));
        } else {
            System.out.println("流月祿：" + moneyLocation + "在" + Direction.findByValue((Integer)circularArrayList
                    .get(result) % MAGIC_NUMBER));
        }
    }
}

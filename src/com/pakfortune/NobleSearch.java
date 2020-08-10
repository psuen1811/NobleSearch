package com.pakfortune;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class NobleSearch {

    private static final int MAGIC_NUMBER = 9;

    public static void main(String[] arg) {
        ArrayList<Integer> arrayList = new ArrayList<>(SixtyJiaziTable.getSixJiaziList());
        //noinspection rawtypes
        CircularArrayList circularArrayList = new CircularArrayList<>(arrayList);
        System.out.println("---- 尋找真祿馬貴人 ----\n" + "請輸入流年干支：");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        boolean stemBranchExists = false;
        for( SixtyJiaziTable s : SixtyJiaziTable.values() ) {
            if( input.equals( s.name() ) ) {
                stemBranchExists = true;
                break;
            }
        }
        try {
            if( !stemBranchExists ) {
                throw new InputStemBranchException();
                // exit program here or throw some exception
            }
        } catch (InputStemBranchException e) {
            System.err.println(e.getMessage());
        }

        circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());

        // 祿
        int moneyResult = 0;
        String moneyLocation = "";
        Map<Money, String> money = Money.getLookup();
        for (Money key : money.keySet()) {
            if (input.contains(key.name())) {
                moneyLocation = key.getMoneyResult();
                moneyResult = SixtyJiaziTable.valueOf(moneyLocation).ordinal();
                break;
            }
        }

        System.out.println("祿：\t" + moneyLocation + "在" + Direction.findByValue((Integer) circularArrayList.get(moneyResult) % MAGIC_NUMBER));

        // 馬
        SixtyJiaziTable stemBranch = null;
        int horseStemBranch = 0;
        for (Branch branch : Branch.values()) {
            if (input.contains(branch.name())) {
                for (Horse key : Horse.values()) {
                    if (key.name().contains(branch.name())) {
                        stemBranch = key.checkStemBranch(input);
                        horseStemBranch = stemBranch.ordinal();
                        break;
                    }
                }
                break;
            }
        }
        assert stemBranch != null;
        System.out.println("馬：\t" + stemBranch.name() + "在" + Direction.findByValue((Integer) circularArrayList
                .get(horseStemBranch) % MAGIC_NUMBER));

        // 貴人
        List<SixtyJiaziTable> list = null;
        for (Stem stem : Stem.values()) {
            if (input.contains(stem.name())) {
                for (Richman richman : Richman.values()) {
                    if (stem.name().equals(richman.name())) {
                        list = richman.getRichmanResult(stem);
                        break;
                    }
                }
                break;
            }
        }
        assert list != null;
        System.out.println("貴人：\t" + list.get(0) + "在" + Direction.findByValue((Integer) circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(0).name()).ordinal()) % MAGIC_NUMBER));
        System.out.println("貴人：\t" + list.get(1) + "在" + Direction.findByValue((Integer) circularArrayList
                .get(SixtyJiaziTable.valueOf(list.get(1).name()).ordinal()) % MAGIC_NUMBER));

        // 當年月份
        System.out.println("請輸入流月干支：");
        Scanner scannerMonth = new Scanner(System.in);
        String inputMonth = scannerMonth.nextLine();
        // 流月祿
        calculateMonth(inputMonth, moneyLocation, arrayList, circularArrayList, moneyResult,
                "流月祿");
        // 流月馬
        calculateMonth(inputMonth, stemBranch.name(), arrayList, circularArrayList, horseStemBranch,
                "流月馬");
        // 流月貴人
        calculateMonth(inputMonth, list.get(0).name(), arrayList, circularArrayList, list.get(0).ordinal(),
                "流月貴人");
        // 流月貴人
        calculateMonth(inputMonth, list.get(1).name(), arrayList, circularArrayList, list.get(1).ordinal(),
                "流月貴人");

    }

    @SuppressWarnings("rawtypes")
    public static void calculateMonth(String inputMonth, String location, ArrayList<Integer> arrayList,
                                      CircularArrayList circularArrayList, int result, String type) {
        int resultMonth = SixtyJiaziTable.valueOf(location).ordinal() - SixtyJiaziTable.valueOf(inputMonth).ordinal();
        if (Integer.signum(resultMonth) < 0) {
            System.out.println("今年" + type + "已過");
        } else if (Integer.signum(resultMonth) > 0) {
            System.out.println(type + location + "在" + Direction.findByValue(arrayList.get(resultMonth)
                    % MAGIC_NUMBER));
        } else {
            // 不變
            System.out.println(type + location + "在" + Direction.findByValue((Integer) circularArrayList
                    .get(result) % MAGIC_NUMBER));
        }

    }
}

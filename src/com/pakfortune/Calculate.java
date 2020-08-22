package com.pakfortune;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculate {
    private static final int MAGIC_NUMBER = 9;
    private static String input;
    private static String moneyLocation;
    private static int moneyResult;
    private static String horseLocation;
    private static int horseResult;
    private static List<String> list;

    @SuppressWarnings("rawtypes")
    private static CircularArrayList circularArrayList;

    public Calculate(ArrayList<Integer> arrayList) {
        circularArrayList = new CircularArrayList<>(arrayList);
    }

    public void getYearlyResult() {
        Scanner scanner;
        boolean stemBranchExists = false;
        while (!stemBranchExists) {
            try {
                System.out.println("---- 尋找真祿馬貴人 ----\n" + "請輸入流年干支：");
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                stemBranchExists = SixtyJiaziTable.ifStemBranchInputExists(SixtyJiaziTable.class, input);

                if (!stemBranchExists) {
                    throw new InputStemBranchException();
                    // exit program here or throw some exception
                } else {
                    // 根據輸入干支飛遁六十甲子
                    circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());
                    // 找真祿干支
                    moneyLocation = Money.calculate(input);
                    moneyResult = searchPrintMoneyHorse(moneyLocation, "真祿: \t");
                    // 找真馬干支
                    horseLocation = Horse.calculate(input);
                    horseResult = searchPrintMoneyHorse(horseLocation, "真馬: \t");
                    // 找貴人干支
                    searchPrintRichman();
                }
            } catch (InputStemBranchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void getMonthlyResult(final ArrayList<Integer> arrayList) {
        boolean stemBranchExists = false;
        // 當年月份
        Scanner scannerMonth;
        String inputMonth;
        while (!stemBranchExists) {
            try {
                System.out.println("\n請輸入流月干支：");
                scannerMonth = new Scanner(System.in);
                inputMonth = scannerMonth.nextLine();
                stemBranchExists = SixtyJiaziTable.ifStemBranchInputExists(SixtyJiaziTable.class, inputMonth);

                if (!stemBranchExists) {
                    throw new InputStemBranchException();
                    // exit program here or throw some exception
                } else {
                    // 流月祿
                    calculatePrintMonth(inputMonth, moneyLocation, arrayList, circularArrayList, moneyResult,
                            "祿");

                    // 流月馬
                    calculatePrintMonth(inputMonth, SixtyJiaziTable.valueOf(horseLocation).name(), arrayList,
                            circularArrayList, horseResult, "馬");

                    // 流月二貴人
                    for (String s : list)
                        calculatePrintMonth(inputMonth, s, arrayList, circularArrayList,
                                SixtyJiaziTable.valueOf(s).ordinal(),
                                "貴");
                }
            } catch (InputStemBranchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private int searchPrintMoneyHorse(String location, String type) {
        /*
          真祿馬干支 & 飛度序數
         */
        int temp = SixtyJiaziTable.valueOf(location).ordinal();
        int index = (Integer) circularArrayList.get(temp) % MAGIC_NUMBER;
        // 真祿馬飛度方向
        System.out.println(type + location + "在" + Direction.findByValue(index));

        // 印位圖
        printOutputGraph(index);
        return temp;
    }

    private static void searchPrintRichman() {
        /*
          真貴人干支
         */
        list = Richman.calculate(input);
        // 貴人1
        int richManIndex1 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Preconditions.checkNotNull(list)
                .get(0)).ordinal()) % MAGIC_NUMBER;
        // 貴人2
        int richManIndex2 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Preconditions.checkNotNull(list)
                .get(1)).ordinal()) % MAGIC_NUMBER;
        System.out.println("貴人：\t" + list.get(0) + "在" + Direction.findByValue(richManIndex1));
        System.out.println("貴人：\t" + list.get(1) + "在" + Direction.findByValue(richManIndex2));

        // 印位圖
        printOutputGraph(richManIndex1);
        printOutputGraph(richManIndex2);
    }

    @SuppressWarnings("rawtypes")
    private static void calculatePrintMonth(String inputMonth, String location, ArrayList<Integer> arrayList,
                                            CircularArrayList circularArrayList, int result, String type) {
        int index;
        // Calculate the # of jumps within Direction
        int resultMonth = SixtyJiaziTable.valueOf(location).ordinal() - SixtyJiaziTable.valueOf(inputMonth).ordinal();
        // 負數即月份已過
        if (Integer.signum(resultMonth) < 0) System.out.println("流月真" + type + "已過");
        else {
            if (Integer.signum(resultMonth) > 0) {
                index = arrayList.get(resultMonth) % MAGIC_NUMBER;
            } else {
                // 不變
                index = (Integer) circularArrayList.get(result) % MAGIC_NUMBER;

            }
            System.out.println(type + ": \t" + location + "在" + Direction.findByValue(index));

            // 印位圖
            printOutputGraph(index);
        }
    }

    private static void printOutputGraph(int index) {
        NineBoxBoard.setSixBoard(index, "X");
        System.out.println();
        NineBoxBoard.printBoard();
        System.out.println();
        NineBoxBoard.resetNineBoard();
    }
}

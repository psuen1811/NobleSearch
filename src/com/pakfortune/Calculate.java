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

    public static void getMonthlyResult(final ArrayList<Integer> arrayList ) {
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
                    calculateMonth(inputMonth, moneyLocation, arrayList, circularArrayList, moneyResult,
                            "祿");

                    // 流月馬
                    calculateMonth(inputMonth, SixtyJiaziTable.valueOf(horseLocation).name(), arrayList,
                            circularArrayList, horseResult, "馬");

                    // 流月貴人
                    calculateMonth(inputMonth, list.get(0), arrayList, circularArrayList,
                            SixtyJiaziTable.valueOf(list.get(0)).ordinal(),
                            "貴");
                    // 流月貴人
                    calculateMonth(inputMonth, list.get(1), arrayList, circularArrayList,
                            SixtyJiaziTable.valueOf(list.get(1)).ordinal(),
                            "貴");
                }
            } catch (InputStemBranchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private static <T extends Enum<T>> void searchMoneyHorse(Class<T> enumKey) {
        int tempInt = 0;
        String tempStr = null;
        String name = null;
        // 真祿馬干支 & 飛度序數
        if (enumKey == Money.class) {
            moneyLocation = Money.calculate(input);
            tempStr = moneyLocation;
            moneyResult = SixtyJiaziTable.valueOf(moneyLocation).ordinal();
            tempInt = moneyResult;
            name = "祿: \t";
        }
        else if (enumKey == Horse.class) {
            horseLocation = Horse.calculate(input);
            tempStr = horseLocation;
            horseResult = SixtyJiaziTable.valueOf(horseLocation).ordinal();
            tempInt = horseResult;
            name = "馬: \t";
        }
        int index = (Integer) circularArrayList.get(tempInt) % MAGIC_NUMBER;
        // 真祿/馬飛度方向
        System.out.println(name + tempStr + "在" + Direction.findByValue(index));
        printOutputGraph(index);
    }

    private static void searchRichman() {
        // 真貴人干支
        list = Richman.calculate(input);
        // 貴人1
        int richManIndex1 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Preconditions
                .checkNotNull(list).get(0)).ordinal()) % MAGIC_NUMBER;
        // 貴人2
        int richManIndex2 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Preconditions
                .checkNotNull(list).get(1)).ordinal()) % MAGIC_NUMBER;
        System.out.println("貴人：\t" + list.get(0) + "在" + Direction.findByValue(richManIndex1));
        System.out.println("貴人：\t" + list.get(1) + "在" + Direction.findByValue(richManIndex2));

        printOutputGraph(richManIndex1);
        printOutputGraph(richManIndex2);
    }

    public static void getYearlyResult() {
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
                    // 飛遁六十甲子
                    circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());
                    // 找真祿干支
                    searchMoneyHorse(Money.class);
                    // 找真馬干支
                    searchMoneyHorse(Horse.class);
                    // 找貴人干支
                    searchRichman();
                }
            } catch (InputStemBranchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @SuppressWarnings("rawtypes")
    private static void calculateMonth(String inputMonth, String location, ArrayList<Integer> arrayList,
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

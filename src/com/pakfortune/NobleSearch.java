package com.pakfortune;

import java.util.*;

public class NobleSearch {

    private static final int MAGIC_NUMBER = 9;

    public static void main(String[] arg) {
        ArrayList<Integer> arrayList = new ArrayList<>(SixtyJiaziTable.getSixJiaziList());
        //noinspection rawtypes
        CircularArrayList circularArrayList = new CircularArrayList<>(arrayList);
        Scanner scanner;
        String input;
        boolean stemBranchExists = false;
        while(!stemBranchExists) {
            try {
                System.out.println("---- 尋找真祿馬貴人 ----\n" + "請輸入流年干支：");
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                stemBranchExists = SixtyJiaziTable.checkStemBranchInput(input);

                if (!stemBranchExists) {
                    throw new InputStemBranchException();
                    // exit program here or throw some exception
                } else {
                    circularArrayList.shiftRight(SixtyJiaziTable.valueOf(input).ordinal());

                    // 真祿干支
                    String moneyLocation = Money.calculate(input);
                    int moneyResult = SixtyJiaziTable.valueOf(moneyLocation).ordinal();
                    // 真祿飛度序數
                    int moneyIndex = (Integer)circularArrayList.get(moneyResult) % MAGIC_NUMBER;
                    // 真祿飛度方向
                    System.out.println("祿：\t" + moneyLocation + "在" + Direction.findByValue(moneyIndex));
                    printOutputGraph(moneyIndex);

                    // 真馬干支
                    String stemBranch = Horse.calculate(input);
                    int horseStemBranch = SixtyJiaziTable.valueOf(stemBranch).ordinal();
                    // 真馬飛度序數
                    int horseIndex = (Integer) circularArrayList.get(horseStemBranch) % MAGIC_NUMBER;
                    // 真馬飛度方向
                    System.out.println("馬：\t" + SixtyJiaziTable.valueOf(stemBranch).name() + "在" +
                            Direction.findByValue(horseIndex));
                    printOutputGraph(horseIndex);

                    // 真貴人干支
                    List<SixtyJiaziTable> list = Richman.calculate(input);
                    // 貴人1
                    int richManIndex1 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Objects
                            .requireNonNull(list).get(0).name()).ordinal()) % MAGIC_NUMBER;
                    // 貴人2
                    int richManIndex2 = (Integer) circularArrayList.get(SixtyJiaziTable.valueOf(Objects
                            .requireNonNull(list).get(1).name()).ordinal()) % MAGIC_NUMBER;
                    System.out.println("貴人：\t" + list.get(0) + "在" + Direction.findByValue(richManIndex1));
                    System.out.println("貴人：\t" + list.get(1) + "在" + Direction.findByValue(richManIndex2));

                    printOutputGraph(richManIndex1);
                    printOutputGraph(richManIndex2);

                    stemBranchExists = false;
                    // 當年月份
                    Scanner scannerMonth;
                    String inputMonth;
                    while (!stemBranchExists) {
                        try {

                            System.out.println("\n請輸入流月干支：");
                            scannerMonth = new Scanner(System.in);
                            inputMonth = scannerMonth.nextLine();
                            stemBranchExists = SixtyJiaziTable.checkStemBranchInput(inputMonth);

                            if (!stemBranchExists) {
                                throw new InputStemBranchException();
                                // exit program here or throw some exception
                            } else {
                                // 流月祿
                                calculateMonth(inputMonth, moneyLocation, arrayList, circularArrayList, moneyResult,
                                        "祿");

                                // 流月馬
                                calculateMonth(inputMonth, SixtyJiaziTable.valueOf(stemBranch).name(), arrayList,
                                        circularArrayList, horseStemBranch,"馬");

                                // 流月貴人
                                calculateMonth(inputMonth, list.get(0).name(), arrayList, circularArrayList,
                                        list.get(0).ordinal(),
                                        "貴");
                                // 流月貴人
                                calculateMonth(inputMonth, list.get(1).name(), arrayList, circularArrayList,
                                        list.get(1).ordinal(),
                                        "貴");
                            }
                        } catch (InputStemBranchException e) {
                            System.err.println(e.getMessage());
                        }
                    }
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
        if (Integer.signum(resultMonth) < 0) System.out.println("今年真" + type + "已過");
        else {
            if (Integer.signum(resultMonth) > 0) {
                index = arrayList.get(resultMonth) % MAGIC_NUMBER;
            } else {
                // 不變
                index = (Integer) circularArrayList.get(result) % MAGIC_NUMBER;

            }
            System.out.println(type + location + "在" + Direction.findByValue(index));
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

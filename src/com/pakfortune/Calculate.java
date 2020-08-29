package com.pakfortune;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.pakfortune.common.CircularArrayList;
import com.pakfortune.common.ThreeKillers;
import com.pakfortune.exception.InputStemBranchException;
import com.pakfortune.model.element.Direction;
import com.pakfortune.model.element.SixtyJiaziTable;
import com.pakfortune.model.star.*;
import com.pakfortune.output.NineBoxBoard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculate {
    private static final int MAGIC_NUMBER = 9;
    private String moneyLocation;
    private int moneyResult;
    private String horseLocation;
    private int horseResult;
    private List<String> richManLocations;
    private final List<Integer> richManResult = Lists.newArrayList();
    private String studyLocation;
    private int studyResult;

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
                String input = scanner.nextLine();
                stemBranchExists = SixtyJiaziTable.ifStemBranchInputExists(SixtyJiaziTable.class, input);
                String[] arr = input.split("(?!^)");
                String tempStem = arr[0];
                String tempBranch = arr[1];

                if (!stemBranchExists) {
                    throw new InputStemBranchException();
                    // exit program here or throw some exception
                } else {
                    // 根據輸入干支飛遁六十甲子
                    circularArrayList.shiftRight(SixtyJiaziTable.getIfPresent(input).ordinal());
                    // 找真祿干支
                    moneyLocation = Money.calculate(tempStem);
                    moneyResult = searchAllAndPrint(moneyLocation, "真祿: \t");
                    // 找真馬干支
                    horseLocation = Horse.calculate(tempStem, tempBranch);
                    horseResult = searchAllAndPrint(horseLocation, "真馬: \t");
                    // 找貴人干支
                    richManLocations = Richman.calculate(tempStem);
                    for (String s : Preconditions.checkNotNull(richManLocations)) {
                        richManResult.add(searchAllAndPrint(s, "真貴人：\t"));
                    }
                    // 真文昌
                    studyLocation = Study.calculate(tempStem);
                    studyResult = searchAllAndPrint(studyLocation, "真文昌: \t");

                    // No need global variables here since this is used for "Year" /////////
                    // 歲煞

                    String location = YearKiller.calculate(tempBranch);
                    String yearKillerLocation = ThreeKillers.calculate(tempStem, location);
                    searchAllAndPrint(yearKillerLocation, "真歲煞: \t");

                    // 劫煞
                    location = RobKiller.calculate(tempBranch);
                    String robKillerLocation = ThreeKillers.calculate(tempStem, location);
                    searchAllAndPrint(robKillerLocation, "真劫煞: \t");

                    // 災煞
                    location = Disaster.calculate(tempBranch);
                    String disasterLocation = ThreeKillers.calculate(tempStem, location);
                    searchAllAndPrint(disasterLocation, "真災煞: \t");
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
                            "真流月祿");

                    // 流月馬
                    calculatePrintMonth(inputMonth, SixtyJiaziTable.getIfPresent(horseLocation).name(), arrayList,
                            circularArrayList, horseResult, "真流月馬");

                    // 流月二貴人
                    for (int i = 0; i < 2; i++) {
                        calculatePrintMonth(inputMonth, richManLocations.get(i), arrayList, circularArrayList,
                                richManResult.get(i), "真流月貴人");
                    }

                    calculatePrintMonth(inputMonth, studyLocation, arrayList, circularArrayList, studyResult,
                            "真流月文昌");

                }
            } catch (InputStemBranchException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    private int searchAllAndPrint(String location, String type) {
        /*
          真祿馬,煞星干支 & 飛度序數
         */
        int temp = SixtyJiaziTable.getIfPresent(location).ordinal();
        int index = (Integer) circularArrayList.get(temp) % MAGIC_NUMBER;
        // 真祿馬飛度方向
        System.out.println(type + location + "在" + Direction.findByValue(index));

        // 印位圖
        printOutputGraph(index);
        return temp;
    }

    @SuppressWarnings("rawtypes")
    private void calculatePrintMonth(String inputMonth, String location, ArrayList<Integer> arrayList,
                                     CircularArrayList circularArrayList, int result, String type) {
        int index;
        // Calculate the # of jumps within Direction
        int resultMonth = SixtyJiaziTable.getIfPresent(location).ordinal() - SixtyJiaziTable.getIfPresent(inputMonth)
                .ordinal();
        // 負數即月份已過
        if (Integer.signum(resultMonth) < 0) System.out.println(type + "已過");
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

    private void printOutputGraph(int index) {
        NineBoxBoard.setSixBoard(index, 'X');
        System.out.println();
        NineBoxBoard.printBoard();
        System.out.println();
        NineBoxBoard.resetNineBoard();
    }
}

package com.pakfortune;

public class NineBoxBoard {
    private static char[][] nineBoxes = {{' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '},
            {'-', '+', '-', '+', '-'},
            {' ', '|', ' ', '|', ' '}};

    public static void printBoard() {
        for (char[] row : nineBoxes) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void resetNineBoard() {
        nineBoxes = new char[][]{{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};
    }

    public static void setSixBoard(int pos, String type) {
        char c = type.charAt(0);
        switch (pos) {
            case 0: // 中
                nineBoxes[2][2] = c;
            case 1: // 坤
                nineBoxes[4][4] = c;
                break;
            case 2: // 兑
                nineBoxes[2][4] = c;
                break;
            case 3: // 艮
                nineBoxes[4][0] = c;
                break;
            case 4: // 離
                nineBoxes[0][2] = c;
                break;
            case 5: // 坎
                nineBoxes[4][2] = c;
                break;
            case 6: // 乾
                nineBoxes[0][4] = c;
                break;
            case 7: // 震
                nineBoxes[2][0] = c;
                break;
            case 8: // 巽
                nineBoxes[0][0] = c;
                break;
            default:
                break;

        }
    }
}

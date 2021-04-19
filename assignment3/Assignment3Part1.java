package com.shpp.p2p.cs.ngrishchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: "Aerobics health calculator"
        This program counts minutes that you spend to aerobics
 */

public class Assignment3Part1 extends TextProgram {

    public void run() {
        int[] arr = fillMinutes();
        int[] arrCount = counter(arr);
        printResults(arrCount);
    }

    /**
     * print results to see how many times you need to do aerobics
     * or to see good results
     * countCH - cardiovacular health exercise tracker
     * countBP - blood pressure exercise tracker
     * @param count - array with counters
     */
    private void printResults(int[] count) {
        int countCH = count[0];
        int countBP = count[1];

        println("Cardiovacular health:");
        if (countCH >= 5) {
            println("   Great job! You've done enough exercise for cardiovacular health.");
        }
        else {
            println("   You needed to train hard for at least " + (5 - countCH) + " more day(s) a week!");
        }
        println("Blood pressure:");
        if (countBP >= 3) {
            println("   Great job! You've done enough exercise to keep a low blood pressure.");
        }
        else {
            println("   You needed to train hard for at least " + (3 - countBP) + " more day(s) a week!");
        }
    }

    /**
     * count days in which there was at least a minimum amount of aerobics
     * countCH - cardiovacular health exercise tracker
     * countBP - blood pressure exercise tracker
     * @param arr - array with filled numbers
     * @return array with counters
     */
    private int[] counter(int[] arr) {
        int[] arrCount = new int[2];

        int countCH = 0;
        int countBP = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 30) {
                countCH ++;
            }
            if (arr[i] >= 40) {
                countBP ++;
            }
            arrCount[0] = countCH;
            arrCount[1] = countBP;
        }
        return arrCount;
    }

    /**
     * user fill how many minutes spend to aerobics a day
     * arr - empty array for numbers that user will fill
     * @return array with filled numbers
     */
    private int[] fillMinutes() {
        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = readInt("How many minutes did you do on day " + (i+1) + "?");
            if (arr[i] < 0) {
                println("Incorrect number at day " + (i + 1));
                System.exit(1);
            }
        }
        return arr;
    }
}

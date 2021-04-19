package com.shpp.p2p.cs.ngrishchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;
/*
    TODO: adding numbers into a stack
 */

public class Assignment5Part2 extends TextProgram {

    public void run() {
        /* Sit in a loop, reading numbers and adding them. */
        while (true) {
            String n1 = readLine("Enter first number:  ");
            String n2 = readLine("Enter second number: ");
            if (n1.equals("") || n2.equals("")) continue;
            println(n1 + " + " + n2 + " = " + addNumericStrings(n1, n2));
            println();
        }
    }

    /**
     * Given two string representations of nonnegative integers, adds the
     * numbers represented by those strings and returns the result.
     *
     * @param n1 The first number.
     * @param n2 The second number.
     * @return A String representation of n1 + n2
     */
    private String addNumericStrings(String n1, String n2) {
        StringBuilder result = new StringBuilder();
        int remainder = 0;

        for (int i = 0; i < Math.min(n1.length(), n2.length()); i++) {
            int a = Integer.parseInt(n1.substring(n1.length()-i-1, n1.length()-i));
            int b = Integer.parseInt(n2.substring(n2.length()-i-1, n2.length()-i));

            int sum = a + b + remainder;

            remainder = sum / 10;
            result.insert(0,sum % 10);
        }
        if (remainder > 0) result.insert(0, getResultBegin(n1, n2) + remainder);

        return result.toString();
    }

    /**
     * Checks the size of result string
     * @param n1 - first number in string
     * @param n2 - second number in string
     * @return size of result string
     */
    private int getResultBegin(String n1, String n2) {
        if (n1.length() > n2.length()) {
            return Integer.parseInt(n1.substring(0, n1.length() - n2.length()));
        } else if (n2.length() > n1.length()) {
            return Integer.parseInt(n2.substring(0, n2.length() - n1.length()));
        }
        return 0;
    }
}

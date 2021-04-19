package com.shpp.p2p.cs.ngrishchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: Take some positive integer and call it n
        If n is even, then divide it by 2
        If n is odd, then multiply by 3 and add 1
        Continue this process until n is 1
 */

public class Assignment3Part2 extends TextProgram {

    public void run() {
        int n = readInt("Enter number: ");

        checker(n);
        mathOperations(n);
    }

    /**
     * check number to be >= 1
     * @param n - number that enter user
     */
    private void checker(int n) {
        if (n < 1) {
            println("Try one more time. Don`t use numbers that < 1!");
            System.exit(1);
        }
        if (n == 1) {
            println(1);
        }
    }

    /**
     * do math operations
     * If n is even, then divide it by 2
     * If n is odd, then multiply by 3 and add 1
     * @param n - number that enter user
     */
    private void mathOperations(int n) {
        while (n != 1) {
            if (n % 2 == 0) {
                println(n + " is even so I take half: " + (n = n / 2));
            }
            else {
                println(n + " is odd so I make 3n + 1: " + (n = n * 3 + 1));
            }
        }
    }
}

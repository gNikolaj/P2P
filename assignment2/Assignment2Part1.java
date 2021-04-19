package com.shpp.p2p.cs.ngrishchenko.assignment2;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: program that takes 3 numbers as input and outputs the roots of a quadratic equation
 */

public class Assignment2Part1 extends TextProgram {

    public void run() {
        double a = readDouble("Please enter a: ");
        double b = readDouble("Please enter b: ");
        double c = readDouble("Please enter c: ");
        checkNumber(a);
        double d;

        d = (b * b) - (4 * a * c);

        printOneResult(d, a, b);
        printTwoResults(d, a, b, c);
        printNoResults(d);
    }

    /**
     * check number
     * number a cant be zero
     * if a = 0 program will restart
     * @param a number that checked
     */
    private void checkNumber(double a) {
        if (a == 0) {
            println("Number a cannot equal 0! Try one more time.");
            System.exit(1);
        }
    }

    /**
     * method print text when equation has no results (d < 0)
     * @param d discriminant
     */
    private void printNoResults(double d) {
        if (d < 0) {
            println("There are no real roots!");
        }
    }

    /**
     * method print text with two equation results
     * (if d > 0)
     * @param d discriminant
     * @param a first number
     * @param b second number
     * @param c third number
     */
    private void printTwoResults(double d, double a, double b, double c) {
        double x1;
        double x2;
        if (d > 0) {
            double sqrt = Math.sqrt((b * b - (4.0 * a * c)));
            x1 = (-b - sqrt) / 2.0 * a;
            x2 = (-b + sqrt) / 2.0 * a;
            println("There are two roots: " + x1 + "and " + x2);
        }
    }

    /**
     * method print text with one equation result
     * (if d == 0)
     * @param d discriminant
     * @param a first number
     * @param b second number
     */
    private void printOneResult(double d, double a, double b) {
        double x;
        if (d == 0) {
            x = -b / (2*a);
            println("There is one root: " + x);
        }
    }
}

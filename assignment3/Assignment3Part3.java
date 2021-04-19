package com.shpp.p2p.cs.ngrishchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: method that elevation to the exponent
 */

public class Assignment3Part3 extends TextProgram {

    public void run() {
        double base = readDouble("Enter number: ");
        int exponent = readInt("Enter the pow: ");
        double result = raiseToPow(base, exponent);
        println(result);
    }

    /**
     * method that do math operations to elevation to the degree
     * @param base - the number that will be promoted to the exponent
     * @param exponent - the exponent
     * @return the result of this operation
     */
    private double raiseToPow(double base, int exponent) {
        double result = 1.0;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                result = result * base;
            }
        }

        if (exponent < 0) {
            for (int i = 0; i > exponent; i--) {
                result = result * (1 / base);
            }
        }
        return result;
    }
}

package com.shpp.p2p.cs.ngrishchenko.assignment6.tm;

public class ToneMatrixLogic {
    /**
     * Given the contents of the tone matrix, returns a string of notes that should be played
     * to represent that matrix.
     *
     * @param toneMatrix The contents of the tone matrix.
     * @param column     The column number that is currently being played.
     * @param samples    The sound samples associated with each row.
     * @return A sound sample corresponding to all notes currently being played.
     */
    public static double[] matrixToMusic(boolean[][] toneMatrix, int column, double[][] samples) {
        double[] result = new double[ToneMatrixConstants.sampleSize()];

        double min = 0.0;
        double max = 0.0;

        double split;

        /**
         * Checks the cells that are included
         * connection of all sounds and normalization of the sound range
         */
        for(int row = 0; row < toneMatrix.length; row++) {
            if(toneMatrix[row][column]) {
                for(int col = 0; col < result.length; col++) {
                    result[col] += samples[row][col];
                }
            }
        }

        for (double temp : result) {
            if (temp > 1.0 || temp < -1.0) {
                if (temp > max)
                    max = temp;
                else if (temp < min)
                    min = temp;
            }
        }
        double minAndMax = max + min;

        if(minAndMax == 0) return result;
        else if(minAndMax > 0) split = max;
        else split = min;

        for(int i = 0; i < result.length; i++) {
            result[i] /= split;
        }

        return result;
    }
}

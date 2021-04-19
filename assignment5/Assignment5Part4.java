package com.shpp.p2p.cs.ngrishchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
    TODO: Read file and find column that will be entered
 */

public class Assignment5Part4 extends TextProgram {

    /** Directory with file and file name*/
    private static final String CSV = "testFile.csv";

    public void run() {
        try {
            int column  = readInt("Enter number of column: ");
            extractColumn(CSV, column);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * which opens a CSV file named filename, finds the column and assigns it an index
     * (0 for the first column, 1 for the second, and so on),
     * then returns an ArrayList that contains information from that column
     * result - string that contains information from file
     * lines - array with lines
     * @param filename - CSV file
     * @param columnIndex - column that method should find and print
     * @throws IOException
     */
    private void extractColumn(String filename, int columnIndex) throws IOException {
        String result = readFromFile(filename);
        String[] lines = result.split(System.lineSeparator());
        ArrayList<String> column = new ArrayList<>();

        for (String line : lines) {
            column.add(fieldsIn(line).get(columnIndex));
            println(fieldsIn(line));
        }
        println(column.toString());
    }

    /**
     * Method that takes line with words from file
     * listOfWords - contains all words from line
     * word - create word from letters
     * @param line - line from file
     * @return array list with words from line
     */
    private ArrayList<String> fieldsIn(String line){
        ArrayList<String> listOfWords = new ArrayList<>();
        StringBuilder word = new StringBuilder();

        /** Cycle where checks '"' and ',' to create words in right way */
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '"') {
                int indexSecondQuote = line.indexOf('"', i + 1);
                listOfWords.add(line.substring(i + 1, indexSecondQuote));
                i = indexSecondQuote;
                continue;
            }

            if (line.charAt(i) == ',') {
                listOfWords.add(word.toString());
                word.setLength(0);
            } else {
                word.append(line.charAt(i));
            }
        }

        if (word.length() != 0) {
            listOfWords.add(word.toString());
        }
        return listOfWords;
    }

    /**
     * File reader
     * @param filename - name of file
     * @return all file information in one string
     * @throws IOException
     */
    private String readFromFile(String filename) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(filename));
        while ((line = br.readLine()) != null) {
            result.append(line).append(System.lineSeparator());
        }
        return result.toString();
    }
}

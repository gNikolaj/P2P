package com.shpp.p2p.cs.ngrishchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
    TODO: take a line with three letters
     and deduce words that can be composed of these letters
 */

public class Assignment5Part3 extends TextProgram {

    /** Directory with file and file name*/
    private static final String WORDS = "en-dictionary.txt";

    public void run() {
        try {
            findWords();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method where creates array with strings
     * and then find words with three letters that was entered
     * result - one string that contain all file with words
     * words - array with strings
     * checker - uses to check if method find words
     * letters - line which contains three letters to compare with words
     * @throws IOException
     */
    private void findWords() throws IOException {
        String letters;
        String result = readFromFile();
        String[] words = result.split(System.lineSeparator());
        boolean checker = false;

        while (true) {
            println("Enter three letters: ");
            letters = readLine().toLowerCase();

            if (!wordHasThreeLetters(letters)) {
                println("You should enter 3 letters! Try one more time.");
                continue;
            }

            for (String word : words) {
                if (compareLetters(word, letters)) {
                    println(word);
                    checker = true;
                }
            }
            if (!checker) {
                println("No results!");
            }
            checker = false;
        }
    }

    /**
     * File reader
     * word - word that reads from file
     * result - word with line separator
     * @return line
     * @throws IOException
     */
    private String readFromFile() throws IOException {
        String word;
        StringBuilder result = new StringBuilder();

        BufferedReader br = new BufferedReader(new FileReader(WORDS));
        while ((word = br.readLine()) != null) {
            result.append(word).append(System.lineSeparator());
        }
        return result.toString();
    }

    /**
     * Check size of entered letters
     * @param letters - letters that entered
     * @return if size = 3
     */
    private boolean wordHasThreeLetters(String letters) {
        return letters.length() == 3;
    }

    /**
     * Find letters that was entered in words
     * @param word - word that compare with letters
     * @param letters - letters that search in word
     * @return if the word is find
     */
    private boolean compareLetters(String word, String letters) {
        int index1 = word.indexOf(letters.charAt(0), 0);
        int index2 = word.indexOf(letters.charAt(1), 1);
        int index3 = word.indexOf(letters.charAt(2), 2);

        if (index1 != -1 && index2 != -1 && index3 != -1) {
            return index1 < index2 && index2 < index3;
        }
        return false;
    }
}

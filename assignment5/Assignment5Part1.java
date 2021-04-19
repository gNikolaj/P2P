package com.shpp.p2p.cs.ngrishchenko.assignment5;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: counts the number of syllables in a word
 */

public class Assignment5Part1 extends TextProgram{

    public void run() {
        /* Repeatedly prompt the user for a word and print out the estimated
         * number of syllables in that word.
         */
        while (true) {
            String word = readLine("Enter a single word: ");
            println("  Syllable count: " + syllablesIn(word));
        }
    }

    /**
     * Given a word, estimates the number of syllables in that word according to the
     * heuristic specified in the handout.
     *
     * @param word A string containing a single word.
     * @return An estimate of the number of syllables in that word.
     */
    private int syllablesIn(String word) {
        int syllable = 0;
        char e = 'e';
        int count = 0;
        int count_E = 0;

        String vowels = "aeiouy";
        word = word.toLowerCase();

        /* Checks if word has < than 3 letters to count min 1 syllable */
        if (word.length() <= 3) {
            syllable = 1;
            return syllable;
        }

        /* Cycle that works while word has letters */
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < vowels.length(); j++) {
                if (word.charAt(i) == vowels.charAt(j)) {

                    /* Cycle where checks vowels to count syllable*/
                    for (int k = 0; k < vowels.length(); k++) {
                        count = checkVovels(i, word, vowels, k, count);
                        syllable = addSyllable(count, vowels, syllable);
                        count_E = checkE(i, k, word, vowels, count_E);
                    }
                    count = 0;
                    if (word.charAt(0) == vowels.charAt(j)) {
                        syllable++;
                        break;
                    }
                }
            }

            /* Checks when "E" in the end of the word */
            if (i + 1 == word.length() && word.charAt(i) == e) {
                if (count_E == 1) {
                    break;
                }
                else {
                    syllable--;
                }
            }
        }
        return syllable;
    }

    /**
     * Check e at the end
     * @param i - counter from cycle
     * @param k - counter from cycle
     * @param word - word that was entered
     * @param vowels - vowels at string
     * @param count_E - contain number when "E" in the end
     * @return "e" at the end of word
     */
    private int checkE(int i, int k, String word, String vowels, int count_E) {
        if (i + 2 == word.length() && word.charAt(i) == vowels.charAt(k) ) {
            count_E++;
        }
        return count_E;
    }

    /**
     * Add syllable
     * @param count - counter of vowels to find consonants
     * @param vowels - vowels at string
     * @param syllable - number of syllables
     * @return number of syllables
     */
    private int addSyllable(int count, String vowels, int syllable) {
        if (count > vowels.length()-1) {
            syllable++;
        }
        return syllable;
    }

    /**
     * Check vowels in word
     * @param i - counter from cycle
     * @param word - word that was entered
     * @param vowels - vowels at string
     * @param k - counter from cycle
     * @param count - counter to find consonants
     * @return counter to find consonants
     */
    private int checkVovels(int i, String word, String vowels, int k, int count) {
        if (i != 0 && word.charAt(i - 1) != vowels.charAt(k)) {
            count++;
        }
        return count;
    }
}

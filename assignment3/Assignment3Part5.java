package com.shpp.p2p.cs.ngrishchenko.assignment3;

import com.shpp.cs.a.console.TextProgram;

/*
    TODO: "Saint Petersburg game"
        This is a hypothetical game for a casino.
        Two people play: lucky and sweaty.
        The game ends when the first one earns $ 20 or more.
        Sweaty puts $ 1 on the table, and the lucky one starts tossing a coin.
        If the eagle - then sweaty adds to the amount on the table exactly the same amount.
        If the tail - everything on the table, goes to the lucky one. If the lucky winner is less than $ 20, the game is repeated.
 */

public class Assignment3Part5 extends TextProgram {

    public void run() {
        startTossingCoin();
    }

    /**
     * start playing game to win
     * bank - all money that player have
     * counter - count tries to win
     * gameMoney - money in one try
     */
    private void startTossingCoin() {
        int bank = 0;
        int counter = 0;
        int gameMoney;

        int minimalSum = 20;

        while (bank < minimalSum) {
            gameMoney = 1;
            gameMoney = playGame(gameMoney);
            counter++;
            bank += gameMoney;
            println("This game, you earned $" + gameMoney);
            println("Your total is $" + bank);
        }
        println("It took " + counter + " games to earn $" + minimalSum);
    }

    /**
     * start game and flip coin
     * @param gameMoney - money in one try
     * @return money that earn player in one try
     */
    private int playGame(int gameMoney) {
        int random;
        while (true) {
            random = (int) (Math.random() * 2);
            if (random == 1) {
                gameMoney *= 2;
            }
            else break;
        }
        return gameMoney;
    }
}

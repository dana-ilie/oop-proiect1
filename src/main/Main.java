package main;

import checker.Checker;
import database.Database;
import input.Input;
import input.InputLoader;
import simulationFlow.InitialRound;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) {
        InputLoader inputLoader = new InputLoader("tests/test1.json");
        Input input = inputLoader.readData();

        Database database = new Database(input);


        Checker.calculateScore();
    }
}

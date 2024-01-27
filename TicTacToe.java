import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner scan = new Scanner(System.in);
    static String[] board;

    static void  generateBoard() { 
        System.out.println(
            "      |***|***|***|\r\n" + //
            "      | " + board[0] + " | " +board[1] + " | " + board[2] + " |\r \n" + //
            "      |***-***-***|\r\n" + //
            "      | " + board[3] + " | " + board[4] + " | " + board[5] + " |\r\n" + //
            "      |***-***-***|\r\n" + //
            "      | " + board[6] + " | " + board[7] + " | " + board[8] + " |\r\n" + //
            "      |***|***|***| ");
    }

    /**
     * Function tha takes user's choice to be matched against a random number of 0-1 where "heads" = 0 and "tails" = 1.
     * Based on a coinFLip silumalation conditions results, a response is then returned
     * @param playerChoice (String)
     * @return wonCoinFLip (boolean)
     */
    public Object[] coinFlip(String playerChoice) {
        Random rand = new Random();
        Object wonCoinFlip[] = new Object[3];
        int playerOneId = 1;
        int playerTwoId = 2;
        int randNum = rand.nextInt(2);
        System.out.println(randNum);
        if (playerChoice.equals("heads") && randNum == 0 || playerChoice.equals("tails") && randNum == 1) {
            wonCoinFlip[0] = playerChoice;
            wonCoinFlip[1] = randNum;
            wonCoinFlip[2] = playerOneId;
        } else if(playerChoice.equals("heads")) {
            wonCoinFlip[0] = "tails";
            wonCoinFlip[1] = randNum;
            wonCoinFlip[2] = playerTwoId;
        } else {
            wonCoinFlip[0] = "heads";
            wonCoinFlip[1] = randNum;
            wonCoinFlip[2] = playerTwoId;
        }
        return wonCoinFlip;
    }

    public boolean isGameOn(boolean isGameOn, String playerOneSymbol, String playerTwoSymbol) {
        board = new String[9];

        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }
        generateBoard();
        while (isGameOn) {
            System.out.println("Please enter a number from the board layout displayed above to insert your " + playerOneSymbol + " symbol.");
            int playerA = scan.nextInt();
            board[playerA - 1] = playerOneSymbol;
            generateBoard();
            System.out.println("Please enter a number from the board layout displayed above to insert your " + playerTwoSymbol + " symbol.");
            int playerB = scan.nextInt();
            board[playerB - 1] = playerTwoSymbol;
            generateBoard();
        }
        return false;
    }

    // public void userSelection(int setPosition, String playerSymbol) {
    //     String[] board = gameBoard();
    //     board[setPosition] = playerSymbol;
    // }

}

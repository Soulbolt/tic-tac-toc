import java.lang.reflect.Array;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner scan = new Scanner(System.in);
    /*
     * Method to create a 3x3 matrix as a game board with "_" values.
     */
    public String[] gameBoard() {
    
        String board[] = new String[9];

        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                board[i] = "_";
            }
        }  

        //Print the matrix in a readable format
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++){
                System.out.print(board[i] + " ");
            }
            System.out.println();
        }

        return board;
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

    public boolean isGameOn(boolean isGameOn, String playerSymbol) {
        String gameBoardLayout = CONSTANT.GAMEBOARD_LAYOUT;
        String[] board = gameBoard();
        System.out.println(gameBoardLayout);
        while (isGameOn) {
            System.out.println("Please enter a number from the board layout displayed above to insert your " + playerSymbol + " symbol.");
            int playerA = scan.nextInt();
            board[playerA] = playerSymbol;
            System.out.println("Please enter a number from the board layout displayed above to insert your " + playerSymbol + " symbol.");
            int playerB = scan.nextInt();
            board[playerB] = playerSymbol;
        }
        return false;
    }

    // public void userSelection(int setPosition, String playerSymbol) {
    //     String[] board = gameBoard();
    //     board[setPosition] = playerSymbol;
    // }

}

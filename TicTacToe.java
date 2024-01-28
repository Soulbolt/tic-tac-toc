import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    Scanner scan = new Scanner(System.in);
    static String[] board;
    
    /**
     * 
     * Generattes tic tac toe gameboard layout for 1-9 slots (3x3).
     */
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
     * @return wonCoinFLip (Array Object)
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

    /**
     * Function: takes 2 String parameters to determine players symbols. Renders game board to provide visual aid to help with slot selection.
     * Uses a while loop on winner = null. Prompts for players slot selection, adds it to the respective slot on the board and renders it.
     * Assigns winner var to checkWinner() call then call on checkNull(). If statements to verify that winner != null and break loop to declare
     * winner or draw respectively.
     * @param playerOneSymbol (String)
     * @param playerTwoSymbol (String)
     * @return (boolean)
     */
    public boolean isGameOn(String playerOneSymbol, String playerTwoSymbol) {
        board = new String[9];
        String winner = null;
        for (int i = 0; i < 9; i++) {
            board[i] = String.valueOf(i + 1);
        }

        generateBoard();
        while (winner == null) {

                System.out.println("Please enter a number from the board layout displayed above to enter your " + playerOneSymbol + " symbol.");
                int playerA = scan.nextInt();
                board[playerA - 1] = playerOneSymbol;
                winner = checkWinner();
                checkNull(winner);
                generateBoard();
                if (winner != null) {
                    break;
                }
    
                System.out.println("Please enter a number from the board layout displayed above to enter your " + playerTwoSymbol + " symbol.");
                int playerB = scan.nextInt();
                board[playerB - 1] = playerTwoSymbol;
                winner = checkWinner();
                checkNull(winner);
                generateBoard();
                if (winner != null) {
                    break;
                }
            }

        scan.close();
        return false;
    }

    /**
     * Function: Takes 1 parameter and catches if the value is null. If value is not null, it prints out corresponding message
     * of declaring a winner or draw based on the winner string value.
     * @param winner (String)
     * @return (String)
     */
    public String checkNull(String winner) {
                    try {
                if (winner.equalsIgnoreCase("draw")) {
                    System.out.println("It's a draw! Thanks for playing!");
                }
                else {
                    System.out.println("Congratulations! " + winner + "'s has won! Thanks for playing!");
                }
                
            } catch (NullPointerException e) {
                System.out.println("");;
            }
            return winner;
    }

    /**
     * Function: iterates thorugh 8 conditional cases to verify is there is a tic tac toe (Three consecutive symbols)
     *  e. x."XXX" or "OOO", to return if "X" or "O" is the winner. If neither and all slots have been filled. returns "draw"
     * @return (String)
     */
    public String checkWinner() {
        for (int i = 0; i < 8; i++) {
            String line = null;

            switch (i) {
                case 0:
                    line = board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = board[3] + board[4] + board[5];
                    break;
                case 2:
                    line = board[6] + board[7] + board[8];
                    break;
                case 3:
                    line = board[0] + board[3] + board[6];
                    break;
                case 4:
                    line = board[1] + board[4] + board[7];
                    break;
                case 5:
                    line = board[2] + board[5] + board[8];
                    break;
                case 6:
                    line = board[0] + board[4] + board[8];
                    break;
                case 7:
                    line = board[2] + board[4] + board[6];
                    break;
            }

            //Current player playing X
            if (line.equals("XXX")) {
                return "X";
            } 
            //Current player playing O
            else if (line.equals("OOO")) {
                return "O";
            }
        }

        for (int i = 0; i < 9; i++) {
            if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
                break;
            }
            else if (i == 8) {
                return "Draw";
            }
        }
        return null;

    }
}

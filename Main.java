import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Player variables
        String playerOne = "";
        String playerTwo = "";

        System.out.println("Welcome to Tic Tac TOE!");
        //Imitiallize board
        TicTacToe board = new TicTacToe();
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Enter letter 'X' or 'O' to choose playing piece: ");
        playerOne = scan.next().toUpperCase();
        
        //Depending on player's one selection, apply 'X' or 'O' to playerTwo respectably
        if (playerOne.equals("X")) {
            playerTwo = "O";
        } else {
            playerTwo = "X";
        }
        System.out.println("PlayerOne is: " + playerOne + "\nPlayerTwo is: " + playerTwo);
        System.out.println("We will flip a coin to decide who gets first turn.");
        System.out.println("PlayerOne please enter 'heads' or 'tails'.\n");
        String playerChoice = scan.next();

        Object[] coinFlipResult = board.coinFlip(playerChoice);
        boolean gameOn = true;

        if ((int)coinFlipResult[2] == 1) {
            System.out.println("Coin Landed " + coinFlipResult[0] +"!");
            System.out.println("PlayerOne wins first turn!");
            board.isGameOn(gameOn, playerOne);
        } else {
            System.out.println("Coin Landed " + coinFlipResult[0] +"!");
            System.out.println("PlayerTwo wins first turn!");
            board.isGameOn(gameOn, playerTwo);
        }

      

        //render game board
        // board.gameBoard();

        scan.close();
    }
}

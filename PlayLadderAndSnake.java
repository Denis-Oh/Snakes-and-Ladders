// -----------------------------------------------------
// COMP249 Assignment 1
// Question: Snakes and Ladders
// Written by: Denis Oh 40208580
// Feb 7, 2022
// -----------------------------------------------------
// This program simulates a game of snakes and ladders with
// 2 to 4 players. Before the game begins, each player has
// a chance to roll a die. The order of the players will go 
// from highest rolled number to lowest. Each player will then 
// take turns rolling the die to move their piece along the board
// with ladders giving them a boost and snakes bringing them backwards.
// The first player to land exactly on the 100th square is
// named the winner of the game and the program terminates.
// -----------------------------------------------------

/**
 * This Class is the driver class which welcomes the user and asks for the number of players
 * @author Denis Oh
 * @version 1.0
 */

package Assignment1;
import java.util.Scanner;
public class PlayLadderAndSnake {

	public static void main(String[] args) {
		Scanner KeyIn = new Scanner(System.in);
		int input, tries=1;
		
		//Welcome user
		System.out.println("---------------WELCOME TO SNAKES AND lADDERS---------------\n");
		
		//Check number of players
		System.out.println("Please Enter the # of player for SNAKES & LADDERS (2 to 4 players):\t");
		input = KeyIn.nextInt();
		
		while (input<2 || input>4) {
			System.out.println("Bad Attempt "+tries+" - MUST be between 2 and 4 players inclusively:\t");
			tries++;
			input = KeyIn.nextInt();
			
			if (tries>3) {
				System.out.println("Bad Attempt "+tries+" - You have no more tries left. Program will terminate...");
				System.exit(0);
			}
		}
		
		KeyIn.close();
		
		//Start the game
		LadderAndSnake game = new LadderAndSnake(input);
		System.out.println("Number of players: "+game.getNumPlayers());
		
		game.play();
	}

}

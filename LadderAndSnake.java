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
 * This Class contains all the needed methods for the game to work
 * @author Denis Oh
 * @version 1.0
 */

package Assignment1;

import java.util.Random;
public class LadderAndSnake {

	private int numPlayers, x=1;
	private int[] pieceLocation = new int[4];
	private int[] player = new int[4];
	private boolean win = false;
	
	//constructors
	/**
	 * This constructs a LadderAndSnake game with the default 2 players
	 */
	public LadderAndSnake() {
		this.numPlayers = 2;
	}
	/**
	 * This constructs a LadderAndSnake game with a specific number of players
	 * @param nPlayers the number of players in the game
	 */
	public LadderAndSnake(int nPlayers) {
		this.numPlayers = nPlayers;
	}
	
	//accessors and mutators
	/**
	 * This method gets the current value of the instance numPlayers
	 * @return number of players
	 */
	public int getNumPlayers() {
		return numPlayers;
	}
	/**
	 * This method sets a new value of the instance numPlayers
	 * @param numPlayers new number of players
	 */
	public void setNumPlayers(int numPlayers) {
		this.numPlayers = numPlayers;
	}
	
	//flip dice method
	/**
	 * This method flips the dice
	 * @return a value between 1 and 6 inclusively
	 */
	public int flipDice() {
		Random r = new Random();
		return r.nextInt(5+1)+1;
	}
	
	//play method
	/**
	 * This method starts the game. Each player will roll a die to decide who plays first (highest to lowest number). 
	 * Then each player will take turns rolling the die to advance on the game board. Ladders will move your piece forward, 
	 * while Snakes will send your piece backwards. A piece must land exactly on the 100th square to win the game and end the program.
	 * Landing further than the 100th square will send a piece backwards in the excess amount rolled.
	 */
	public void play() {
		
		//decide order of players
		System.out.println("Time to decide the order of players. Highest number starts!\n------------------------------------------------------------");
		int[] order = new int[this.numPlayers];
		
		for (int i=0; i<this.numPlayers; i++) {
			order[i] = this.flipDice();
			System.out.println("Player-"+(i+1)+" rolled a "+order[i]);
		}
		
		
		for (int i=6; i>0; i--) {
			for (int j=0; j<this.numPlayers; j++) {
				
				if (order[j]==i) {
					player[j] = x;
					x++;
				}
			}
		}	
		
		System.out.println("\nPlayer Order:");
		for (int i=0; i<this.numPlayers; i++) {
			System.out.println("\t"+(i+1)+": Player-"+player[i]);	
		}
		
		
		//start playing
		System.out.println("\nSTART!");
		while (win == false) {
			
		for (int i=0; i<this.numPlayers && win==false; i++) {
			int roll = this.flipDice();
			pieceLocation[i] += roll;			
			System.out.println("Player-"+player[i]+" rolled a "+roll);
			
			//snakes and ladders
			switch (pieceLocation[i]) {
			case 1:
				pieceLocation[i] = 38;
				System.out.println("LADDER!!");
				break;
			case 4:
				pieceLocation[i] = 14;
				System.out.println("LADDER!!");
				break;
			case 9:
				pieceLocation[i] = 31;
				System.out.println("LADDER!!");
				break;
			case 16:
				pieceLocation[i] = 6;
				System.out.println("SNAKE!!");
				break;
			case 21:
				pieceLocation[i] = 42;
				System.out.println("LADDER!!");
				break;
			case 28:
				pieceLocation[i] = 84;
				System.out.println("LADDER!!");
				break;
			case 36:
				pieceLocation[i] = 44;
				System.out.println("LADDER!!");
				break;
			case 48:
				pieceLocation[i] = 30;
				System.out.println("SNAKE!!");
				break;
			case 51:
				pieceLocation[i] = 67;
				System.out.println("LADDER!!");
				break;
			case 62:
				pieceLocation[i] = 19;
				System.out.println("SNAKE!!");
				break;
			case 63:
				pieceLocation[i] = 60;
				System.out.println("SNAKE!!");
				break;
			case 71:
				pieceLocation[i] = 91;
				System.out.println("LADDER!!");
				break;
			case 80:
				pieceLocation[i] = 100;
				System.out.println("LADDER!!");
				break;
			case 87:
				pieceLocation[i] = 24;
				System.out.println("SNAKE!!");
				break;
			case 93:
				pieceLocation[i] = 68;
				System.out.println("SNAKE!!");
				break;
			case 97:
				pieceLocation[i] = 76;
				System.out.println("SNAKE!!");
				break;
			case 98:
				pieceLocation[i] = 78;
				System.out.println("SNAKE!!");
				break;
			}
			
			//player above 100
			if (pieceLocation[i] > 100) {
				pieceLocation[i] = 100-(pieceLocation[i]-100);
				System.out.println("TOO FAR!!");
			}
			System.out.println("Now at square #"+pieceLocation[i]);
			
			
			
			//display location of all pieces on the board
			int loc;
			
			for (int row=0; row<10; row++) {
				
				for (int col=0; col<10; col++) {
					loc=0;
					
					for (int p=0; p<this.numPlayers; p++) {
						
						if (pieceLocation[p] == ((row*10)+col)+1) {
							loc=player[p];
						}
						
					}
					System.out.print(" "+loc);				
				}
				System.out.println();
			}
			System.out.println();			
			
			//winner
			if (pieceLocation[i] == 100) {
				win = true;
				System.out.println("PLAYER-"+player[i]+" IS THE WINNER!\n\nThanks for playing");			
			}			
	
		}
		}
	}
	
}

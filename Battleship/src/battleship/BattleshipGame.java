package battleship;

import java.util.Scanner;

public class BattleshipGame {
	public static void main(String args[]) {
		//print out a friendly message
		System.out.println("Hail Commander! Welcome to the Battleship!");
		System.out.println("Please note that coordinates should be entered in the form such as \"0,1\" or \"3,3\". Thanks.");
		//get an object from the class
		Ocean ocean = new Ocean();
		//place the ships
		ocean.placeAllShipsRandomly();
		//get a scanner to read the input;
		Scanner scanner = new Scanner(System.in);
		while(!ocean.isGameOver()) {
			System.out.println("\nTactical advisor updated:");
			ocean.print();
			int[] coordinates = ask(scanner);
			if(ocean.shootAt(coordinates[0], coordinates[1])) {
				//messaging a hit
				System.out.println("Hit! Well done, commander.");
				if(ocean.getShipArray()[coordinates[0]][coordinates[1]].isSunk()) {
					//reports a ship sunk
					System.out.println("You just sank a " + ocean.getShipArray()[coordinates[0]][coordinates[1]].getShipType() + ".");
				}
			}
		}
		//close the scanner
		scanner.close();
		//saying that the game is over
		System.out.println("\nWe have destroyed all enemy ships.");
		System.out.println(ocean.getShotsFired() + " shots were required.");
		//arbitrarily calculate a score
		int score = 0;
		if(ocean.getShotsFired() < 40) {
			score = 20;
		} else if(ocean.getShotsFired() < 120) {
			score = (120 - ocean.getShotsFired())/4;
		} else {
			score = 0;
		}
		//print out the score
		System.out.println("Your score is " + score + ".");
	}
	
	//ask involves I/O and is not to be tested
	//this function seeks to receive a valid coordinate from the player to shoot at
	public static int[] ask(Scanner scanner) {
		int row = - 1;
		int column = - 1;
		String answer = null;
		while(!(row > -1 && row < 10 && column > -1 && column < 10)) {
			//tell the user what to enter
			System.out.print("Please specify the coordinates of our next strike: ");
			//get the input
			if(scanner.hasNextLine())
				answer = scanner.nextLine();
			//must enter something
			String test = answer.replaceAll(" ", "");
			test = test.replaceAll("\t", "");
			if(answer == null || answer.isEmpty() || test.isEmpty()) {
				//reset
				row = - 1;
				column = -1;
				//print a message
				System.out.println("Please enter valid coordinates.");
			} 
			String parts[] = test.split(",");
			if(parts.length == 2) {
				//valid integers must have length 1
				if(parts[0].length() == 1 && parts[1].length() == 1) {
					//check if they are numbers
					char rowInt = parts[0].charAt(0);
					char colInt = parts[1].charAt(0);
					if(rowInt < '0' || rowInt > '9' || colInt < '0' || colInt > '9') {
						//reset
						row = - 1;
						column = -1;
						//print a message
						System.out.println("Please enter integer coordinates within attack range (0-9).");
					} else {
						//retrieve the coordinates
						row = Integer.parseInt(parts[0]);
						column = Integer.parseInt(parts[1]);
					}
				} else {
					//reset
					row = - 1;
					column = -1;
					//print a message
					System.out.println("Please enter integer coordinates within attack range (0-9).");
				}
			} else {
				//reset
				row = - 1;
				column = -1;
				//print a message
				System.out.println("Please enter valid coordinates.");
			}
		}
		return new int[] {row, column};
	}
}

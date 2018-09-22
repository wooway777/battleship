package battleship;

import java.util.Random;

public class Ocean {
	//Used to quickly determine which ship is in any given location
	Ship[][] ships = new Ship[10][10];
	
	//The total number of shots fired by the user
	int shotsFired;
	
	//The number of times a shot hit a ship. If the user shoots the same part of a ship more than once, every hit is counted, even though the additional "hits" don't do the user any good
	int hitCount;
	
	//The constructor. Creates an "empty" ocean (fills the ships array with EmptySeas). Also initializes any game variables, such as how many shots have been fired
	Ocean() {
		//initializing
		shotsFired = 0;
		hitCount = 0;
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				this.getShipArray()[i][j] = new EmptySea();
			}
		}
	}
	
	//Place all ten ships randomly on the (initially empty) ocean, making certain that all ships are placed legally
	void placeAllShipsRandomly() {
		//get the ships ready
		Battleship battleship = new Battleship();
		Cruiser cruiser0 = new Cruiser();
		Cruiser cruiser1 = new Cruiser();
		Destroyer destroyer0 = new Destroyer();
		Destroyer destroyer1 = new Destroyer();
		Destroyer destroyer2 = new Destroyer();
		Submarine submarine0 = new Submarine();
		Submarine submarine1 = new Submarine();
		Submarine submarine2 = new Submarine();
		Submarine submarine3 = new Submarine();
		//wrap the ships
		Ship[] ships = new Ship[] {battleship, cruiser0, cruiser1,
				destroyer0, destroyer1, destroyer2,
				submarine0, submarine1, submarine2, submarine3};
		//place the ships
		//get a random number generator
		Random random = new Random();
		//get a ship count
		int count = 0;
		while(count < ships.length) {
			//get some random coordinates
			int row = random.nextInt(10);
			int column = random.nextInt(10);
			//randomly choosing horizontal
			int horizontal = random.nextInt(2);
			//if can place
			if(ships[count].okToPlaceShipAt(row, column, horizontal == 1, this)) {
				//place a ship
				ships[count].placeShipAt(row, column, horizontal == 1, this);
				count += 1;
			}
		}
	}
	
	//Returns true if the given location contains a ship, false if it does not
	boolean isOccupied(int row, int column) {
		//check the ship type
		if(ships[row][column].getShipType().equals("EmptySea")) {
			return false;
		} else {
			return true;
		}
	}
	
	//Returns true if the given location contains a "real" ship, still afloat, (not an EmptySea), false if it does not
	boolean shootAt(int row, int column) {
		//updating shots fired
		this.shotsFired += 1;
		//has an ship afloat
		if(!this.getShipArray()[row][column].getShipType().equals("EmptySea") && !this.getShipArray()[row][column].isSunk()) {
			//updating hits counted
			this.hitCount += 1;
		}
		return this.getShipArray()[row][column].shootAt(row, column);
	}
	
	//Returns the number of shots fired (in this game)
	int getShotsFired() {
		return this.shotsFired;
	}
	
	//Returns the number of hits recorded (in this game)
	int getHitCount() {
		return this.hitCount;
	}
	
	//Returns true if all ships have been sunk, otherwise false
	boolean isGameOver() {
		//scan the map
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				//if an afloat ship exists
				if(!this.getShipArray()[i][j].getShipType().equals("EmptySea") && !this.getShipArray()[i][j].isSunk()) {
					return false;
				}
			}
		}
		return true;
	}
	
	//Returns the actual 10x10 array of ships, not a copy
	Ship[][] getShipArray() {
		return this.ships;
	}
	
	//Prints the ocean
	void print() {
		//navigate through the map
		System.out.println("  0 1 2 3 4 5 6 7 8 9");
		for(int i = 0; i < 10; i++) {
			System.out.print(i);
			for(int j = 0; j < 10; j++) {
				System.out.print(" ");
				if(this.getShipArray()[i][j].getShipType().equals("EmptySea")) {
					//if it's an empty sea
					if(this.getShipArray()[i][j].hit[0]) {
						//if it's hit
						System.out.print(this.getShipArray()[i][j].toString());
					} else {
						//else
						System.out.print(".");
					}
				} else {
					//get an index indicating the location in the hit array
					int index = i - this.getShipArray()[i][j].getBowRow() + j - this.getShipArray()[i][j].getBowColumn();
					if(this.getShipArray()[i][j].hit[index]) {
						//if it's hit
						System.out.print(this.getShipArray()[i][j].toString());
					} else {
						//else
						System.out.print(".");
					}
				}
			}
			System.out.println();
		}
	}
}

package battleship;

public abstract class Ship {
	//the row (0 to 9) which contains the bow (front) of the ship
	int bowRow;
	//the column (0 to 9) which contains the bow (front) of the ship
	int bowColumn;
	//the number of squares occupied by the ship. An "EmptySea" location has length 1
	int length;
	//true if the ship occupies a single row, false otherwise
	boolean horizontal;
	//an array of booleans telling whether that part of the ship has been hit
	boolean [] hit = new boolean[4];
	
	//Returns the length of this particular ship
	abstract int getLength();
	
	//Returns bowRow
	int getBowRow() {
		return this.bowRow;
	}
	
	//Returns bowColumn
	int getBowColumn() {
		return this.bowColumn;
	}
	
	//Returns horizontal
	boolean isHorizontal() {
		return this.horizontal;
	}
	
	//Sets the value of bowRow
	void setBowRow(int row) {
		this.bowRow = row;
	}
	
	//Sets the value of bowColumn
	void setBowColumn(int Column) {
		this.bowColumn = Column;
	}
	
	//Sets the value of the instance variable horizontal
	void setHorizontal(boolean newHorizontal) {
		this.horizontal = newHorizontal;
	}
	
	//Returns the type of this ship
	abstract String getShipType();
	
	//Returns true if it is okay to put a ship of this length with its bow in this location, with the given orientation, and returns false otherwise
	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//determine the scan range
		int startRow = row - 1;
		int startColumn = column - 1;
		int endRow = row + 1;
		int endColumn = column + 1;
		//set direction
		if(horizontal) {
			endColumn = column + this.getLength();
		} else {
			endRow = row + this.getLength();
		}
		//check if within board
		if(row < 0 || row > 9 || column < 0 || column > 9) {
			return false;
		}
		if(startRow < 0)
			startRow = 0;
		if(startColumn < 0)
			startColumn = 0;
		if(endRow > 10) {
			return false;
		} else if(endRow > 9) {
			endRow = 9;
		}
		if(endColumn > 10) {
			return false;
		} else if(endColumn > 9) {
			endColumn = 9;
		}
		//scan this area
		for(int i = startRow; i <= endRow; i++) {
			for(int j = startColumn; j <= endColumn; j++) {
				if(ocean.isOccupied(i, j)) {
					return false;
				}
			}
		}
		return true;
	}
	
	//"Puts" the ship in the ocean
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		//initialize instance variables
		this.setBowRow(row);
		this.setBowColumn(column);
		this.setHorizontal(horizontal);
		//deploy the ship
		if(horizontal) {
			for(int i = column; i < column + this.getLength(); i++) {
				ocean.getShipArray()[row][i] = this;
			}
		} else {
			for(int i = row; i < row + this.getLength(); i++) {
				ocean.getShipArray()[i][column] = this;
			}
		}
	}
	
	//If a part of the ship occupies the given row and column, and the ship hasn't already been sunk, mark that part of the ship as "hit" (in the hit array, 0 indicates the bow) and return true, otherwise return false
	boolean shootAt(int row, int column) {
		//check if it's shooting at the right ship, must not be another ship or empty sea
		if(this.isHorizontal()) {
			if(column - this.getBowColumn() < 0 || column - this.getBowColumn() >= this.getLength() || row != this.getBowRow()) {
				return false;
			}
		} else {
			if(row - this.getBowRow() < 0 || row - this.getBowRow() >= this.getLength() || column != this.getBowColumn()) {
				return false;
			}
		}
		//get the corresponding location in hit array
		int index = row - this.getBowRow() + column - this.getBowColumn();
		if(!this.getShipType().equals("EmptySea") && !this.isSunk()) {
			//if has an afloat ship
			this.hit[index] = true;
			return true;
		} else {
			return false;
		}
	}
	
	//Return true if every part of the ship has been hit, false otherwise
	boolean isSunk() {
		boolean sunk = true;
		//check the proper part of hit array
		for(int i = 0; i < this.getLength(); i++) {
			if(this.hit[i] == false) {
				//if some part is not hit
				sunk = false;
			}
		}
		return sunk;
	}
	
	//This method should return "x" if the ship has been sunk, "S" if it has not been sunk.
	@Override
	public String toString() {
		if(this.isSunk()) {
			return "x";
		} else {
			return "S";
		}
	}
}

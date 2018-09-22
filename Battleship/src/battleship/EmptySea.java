package battleship;

public class EmptySea extends Ship {
	EmptySea() {
		this.length = 1;
		this.hit = new boolean[]{false, false, false, false};
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "EmptySea";
	}
	
	//This method overrides shootAt(int row, int column) that is inherited from Ship, and always returns false to indicate that nothing was hit
	@Override
	boolean shootAt(int row, int column) {
		this.hit[0] = true;
		return false;
	}
	
	//This method overrides isSunk() that is inherited from Ship, and always returns false to indicate that you didn't sink anything
	@Override
	boolean isSunk() {
		return false;
	}
	
	//Returns a single-character String "-" to use in the Ocean's print method (see below)
	@Override
	public String toString() {
		return "-";
	}
}

package battleship;

public class Cruiser extends Ship {
	Cruiser() {
		this.length = 3;
		this.hit = new boolean[]{false, false, false, false};
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "cruiser";
	}
}

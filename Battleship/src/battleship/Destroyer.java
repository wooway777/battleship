package battleship;

public class Destroyer extends Ship {
	Destroyer() {
		this.length = 2;
		this.hit = new boolean[]{false, false, false, false};
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "destroyer";
	}
}

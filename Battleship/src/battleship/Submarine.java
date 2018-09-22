package battleship;

public class Submarine extends Ship {
	Submarine() {
		this.length = 1;
		this.hit = new boolean[]{false, false, false, false};
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "submarine";
	}
}

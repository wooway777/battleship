package battleship;

public class Battleship extends Ship {
	Battleship() {
		this.length = 4;
		this.hit = new boolean[]{false, false, false, false};
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "battleship";
	}
}

package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipTest {

	@Test
	void testGetLength() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		new Cruiser().placeShipAt(3, 4, false, ocean);
		new Destroyer().placeShipAt(8, 5, true, ocean);
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray()[0][0].getLength(), 1);
		assertEquals(ocean.getShipArray()[1][3].getLength(), 4);
		assertEquals(ocean.getShipArray()[1][4].getLength(), 4);
		assertEquals(ocean.getShipArray()[3][4].getLength(), 3);
		assertEquals(ocean.getShipArray()[5][4].getLength(), 3);
		assertEquals(ocean.getShipArray()[8][5].getLength(), 2);
		assertEquals(ocean.getShipArray()[8][6].getLength(), 2);
		assertEquals(ocean.getShipArray()[8][7].getLength(), 1);
		assertEquals(ocean.getShipArray()[6][2].getLength(), 1);
	}

	@Test
	void testGetBowRow() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		assertEquals(ocean.getShipArray()[1][3].getBowRow(), 1);
		assertEquals(ocean.getShipArray()[1][4].getBowRow(), 1);
		assertEquals(ocean.getShipArray()[1][5].getBowRow(), 1);
		assertEquals(ocean.getShipArray()[1][6].getBowRow(), 1);
		new Cruiser().placeShipAt(3, 4, false, ocean);
		assertEquals(ocean.getShipArray()[3][4].getBowRow(), 3);
		assertEquals(ocean.getShipArray()[4][4].getBowRow(), 3);
		assertEquals(ocean.getShipArray()[5][4].getBowRow(), 3);
		new Destroyer().placeShipAt(8, 5, true, ocean);
		assertEquals(ocean.getShipArray()[8][5].getBowRow(), 8);
		assertEquals(ocean.getShipArray()[8][6].getBowRow(), 8);
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray()[6][2].getBowRow(), 6);
		
	}
	
	@Test
	void testGetBowColumn() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		assertEquals(ocean.getShipArray()[1][3].getBowColumn(), 3);
		assertEquals(ocean.getShipArray()[1][4].getBowColumn(), 3);
		assertEquals(ocean.getShipArray()[1][5].getBowColumn(), 3);
		assertEquals(ocean.getShipArray()[1][6].getBowColumn(), 3);
		new Cruiser().placeShipAt(3, 4, false, ocean);
		assertEquals(ocean.getShipArray()[3][4].getBowColumn(), 4);
		assertEquals(ocean.getShipArray()[4][4].getBowColumn(), 4);
		assertEquals(ocean.getShipArray()[5][4].getBowColumn(), 4);
		new Destroyer().placeShipAt(8, 5, true, ocean);
		assertEquals(ocean.getShipArray()[8][5].getBowColumn(), 5);
		assertEquals(ocean.getShipArray()[8][6].getBowColumn(), 5);
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray()[6][2].getBowColumn(), 2);
	}
	
	@Test
	void testIsHorizontal() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		assertTrue(ocean.getShipArray()[1][3].isHorizontal());
		assertTrue(ocean.getShipArray()[1][4].isHorizontal());
		assertTrue(ocean.getShipArray()[1][5].isHorizontal());
		assertTrue(ocean.getShipArray()[1][6].isHorizontal());
		new Cruiser().placeShipAt(3, 4, false, ocean);
		assertFalse(ocean.getShipArray()[3][4].isHorizontal());
		assertFalse(ocean.getShipArray()[4][4].isHorizontal());
		assertFalse(ocean.getShipArray()[5][4].isHorizontal());
		new Destroyer().placeShipAt(8, 5, true, ocean);
		assertTrue(ocean.getShipArray()[8][5].isHorizontal());
		assertTrue(ocean.getShipArray()[8][6].isHorizontal());
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertFalse(ocean.getShipArray()[6][2].isHorizontal());
	}
	
	@Test
	void testSetBowRow() {
		Battleship battleship = new Battleship();
		battleship.setBowRow(1);
		assertEquals(battleship.getBowRow(), 1);
		Cruiser cruiser = new Cruiser();
		cruiser.setBowRow(3);
		assertEquals(cruiser.getBowRow(), 3);
		Destroyer destroyer = new Destroyer();
		destroyer.setBowRow(5);
		assertEquals(destroyer.getBowRow(), 5);
		Submarine submarine = new Submarine();
		submarine.setBowRow(7);
		assertEquals(submarine.getBowRow(), 7);
	}
	
	@Test
	void testSetBowColumn() {
		Battleship battleship = new Battleship();
		battleship.setBowColumn(1);
		assertEquals(battleship.getBowColumn(), 1);
		Cruiser cruiser = new Cruiser();
		cruiser.setBowColumn(3);
		assertEquals(cruiser.getBowColumn(), 3);
		Destroyer destroyer = new Destroyer();
		destroyer.setBowColumn(5);
		assertEquals(destroyer.getBowColumn(), 5);
		Submarine submarine = new Submarine();
		submarine.setBowColumn(7);
		assertEquals(submarine.getBowColumn(), 7);
	}
	
	@Test
	void testSetHorizontal() {
		Battleship battleship = new Battleship();
		battleship.setHorizontal(true);
		assertEquals(battleship.isHorizontal(), true);
		Cruiser cruiser = new Cruiser();
		cruiser.setHorizontal(false);
		assertEquals(cruiser.isHorizontal(), false);
		Destroyer destroyer = new Destroyer();
		destroyer.setHorizontal(true);
		assertEquals(destroyer.isHorizontal(), true);
		Submarine submarine = new Submarine();
		submarine.setHorizontal(false);
		assertEquals(submarine.isHorizontal(), false);
	}
	
	@Test
	void testGetShipType() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		assertEquals(ocean.getShipArray()[1][3].getShipType(), "battleship");
		assertEquals(ocean.getShipArray()[1][4].getShipType(), "battleship");
		assertEquals(ocean.getShipArray()[1][5].getShipType(), "battleship");
		assertEquals(ocean.getShipArray()[1][6].getShipType(), "battleship");
		assertEquals(ocean.getShipArray()[1][7].getShipType(), "EmptySea");
		new Cruiser().placeShipAt(3, 4, false, ocean);
		assertEquals(ocean.getShipArray()[3][4].getShipType(), "cruiser");
		assertEquals(ocean.getShipArray()[4][4].getShipType(), "cruiser");
		assertEquals(ocean.getShipArray()[5][4].getShipType(), "cruiser");
		new Destroyer().placeShipAt(8, 5, true, ocean);
		assertEquals(ocean.getShipArray()[8][5].getShipType(), "destroyer");
		assertEquals(ocean.getShipArray()[8][6].getShipType(), "destroyer");
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray()[6][2].getShipType(), "submarine");
	}
	
	@Test
	void testOkToPlaceShipAt() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		new Cruiser().placeShipAt(3, 4, false, ocean);
		new Destroyer().placeShipAt(8, 5, true, ocean);
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertTrue(new Battleship().okToPlaceShipAt(0, 0, false, ocean));
		assertFalse(new Battleship().okToPlaceShipAt(0, 0, true, ocean));
		assertTrue(new Battleship().okToPlaceShipAt(4, 6, true, ocean));
		assertFalse(new Battleship().okToPlaceShipAt(4, 7, true, ocean));
		assertTrue(new Cruiser().okToPlaceShipAt(4, 6, true, ocean));
		assertFalse(new Cruiser().okToPlaceShipAt(4, 5, false, ocean));
		assertTrue(new Destroyer().okToPlaceShipAt(8, 1, false, ocean));
		assertFalse(new Destroyer().okToPlaceShipAt(9, 3, true, ocean));
		assertFalse(new Destroyer().okToPlaceShipAt(9, 1, false, ocean));
		assertTrue(new Submarine().okToPlaceShipAt(2, 1, true, ocean));
		assertTrue(new Submarine().okToPlaceShipAt(2, 1, false, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(2, 7, true, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(2, 7, false, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(-1, 7, true, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(10, 7, false, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(2, -7, true, ocean));
		assertFalse(new Submarine().okToPlaceShipAt(2, 17, false, ocean));
	}
	
	@Test
	void testPlaceShipAt() {
		Ocean ocean = new Ocean();
		new Battleship().placeShipAt(1, 3, true, ocean);
		new Cruiser().placeShipAt(3, 4, false, ocean);
		new Destroyer().placeShipAt(8, 5, true, ocean);
		new Submarine().placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray()[1][4].getLength(), 4);
		assertEquals(ocean.getShipArray()[3][4].getLength(), 3);
		assertEquals(ocean.getShipArray()[8][6].getBowRow(), 8);
		assertEquals(ocean.getShipArray()[6][2].getBowRow(), 6);
		assertEquals(ocean.getShipArray()[1][5].getBowColumn(), 3);
		assertEquals(ocean.getShipArray()[1][6].getBowColumn(), 3);
		assertTrue(ocean.getShipArray()[1][3].isHorizontal());
		assertEquals(ocean.getShipArray()[4][4].getShipType(), "cruiser");
		assertTrue(new Cruiser().okToPlaceShipAt(4, 6, true, ocean));
		assertFalse(new Cruiser().okToPlaceShipAt(4, 5, false, ocean));
		assertTrue(new Destroyer().okToPlaceShipAt(8, 1, false, ocean));
		assertFalse(new Destroyer().okToPlaceShipAt(9, 3, true, ocean));
		assertFalse(ocean.getShipArray()[1][4].hit[0]);
		assertFalse(ocean.getShipArray()[1][4].hit[1]);
		assertFalse(ocean.getShipArray()[1][5].hit[2]);
		assertFalse(ocean.getShipArray()[1][4].hit[3]);
		assertFalse(ocean.getShipArray()[3][4].hit[0]);
		assertFalse(ocean.getShipArray()[4][4].hit[1]);
		assertFalse(ocean.getShipArray()[3][4].hit[2]);
	}
	
	@Test
	void testShootAt() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		for(int i = 0; i < 4; i++) {
			assertFalse(battleship.hit[i]);
			assertFalse(cruiser.hit[i]);
			assertFalse(destroyer.hit[i]);
			assertFalse(submarine.hit[i]);
		}
		assertFalse(ocean.getShipArray()[0][0].hit[0]);
		assertFalse(battleship.shootAt(2, 3));
		assertFalse(ocean.getShipArray()[2][3].hit[0]);
		assertFalse(battleship.shootAt(0, 0));
		assertFalse(ocean.getShipArray()[0][0].hit[0]);
		assertFalse(cruiser.shootAt(0, 0));
		assertFalse(destroyer.shootAt(0, 0));
		assertFalse(submarine.shootAt(0, 0));
		assertTrue(battleship.shootAt(1, 3));
		assertTrue(battleship.shootAt(1, 3));
		assertTrue(battleship.hit[0]);
		assertTrue(battleship.shootAt(1, 4));
		assertTrue(battleship.hit[1]);
		assertTrue(battleship.shootAt(1, 5));
		assertTrue(battleship.shootAt(1, 3));
		assertTrue(battleship.hit[1]);
		assertTrue(battleship.hit[2]);
		assertTrue(battleship.shootAt(1, 6));
		assertFalse(battleship.shootAt(1, 3));
		assertFalse(battleship.shootAt(1, 4));
		assertFalse(battleship.shootAt(1, 5));
		assertFalse(battleship.shootAt(1, 6));
		assertTrue(cruiser.shootAt(3, 4));
		assertTrue(cruiser.hit[0]);
		assertTrue(cruiser.shootAt(4, 4));
		assertTrue(cruiser.shootAt(3, 4));
		assertTrue(cruiser.hit[1]);
		assertTrue(cruiser.shootAt(5, 4));
		assertFalse(cruiser.shootAt(3, 4));
		assertTrue(cruiser.hit[2]);
		assertFalse(cruiser.shootAt(4, 4));
		assertFalse(cruiser.shootAt(5, 4));
		assertTrue(destroyer.shootAt(8, 5));
		assertTrue(destroyer.shootAt(8, 6));
		assertFalse(destroyer.shootAt(8, 5));
		assertFalse(destroyer.shootAt(8, 6));
		assertTrue(submarine.shootAt(6, 2));
		assertFalse(submarine.shootAt(6, 2));
	}
	
	@Test
	void testIsSunk() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		for(int i = 0; i < 4; i++) {
			assertFalse(battleship.isSunk());
			assertFalse(cruiser.isSunk());
			assertFalse(destroyer.isSunk());
			assertFalse(submarine.isSunk());
		}
		battleship.shootAt(1, 3);
		assertFalse(battleship.isSunk());
		battleship.shootAt(1, 4);
		assertFalse(battleship.isSunk());
		battleship.shootAt(1, 5);
		assertFalse(battleship.isSunk());
		battleship.shootAt(1, 6);
		assertTrue(battleship.isSunk());
		cruiser.shootAt(3, 4);
		assertFalse(cruiser.isSunk());
		cruiser.shootAt(4, 4);
		assertFalse(cruiser.isSunk());
		cruiser.shootAt(5, 4);
		assertTrue(cruiser.isSunk());
		destroyer.shootAt(8, 5);
		assertFalse(destroyer.isSunk());
		destroyer.shootAt(8, 6);
		assertTrue(destroyer.isSunk());
		submarine.shootAt(6, 2);
		assertTrue(submarine.isSunk());
	}
	
	@Test
	void testToString() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertEquals(battleship.toString(), "S");
		battleship.shootAt(1, 3);
		assertEquals(battleship.toString(), "S");
		battleship.shootAt(1, 4);
		assertEquals(battleship.toString(), "S");
		battleship.shootAt(1, 5);
		assertEquals(battleship.toString(), "S");
		battleship.shootAt(1, 6);
		assertEquals(battleship.toString(), "x");
		assertEquals(cruiser.toString(), "S");
		cruiser.shootAt(3, 4);
		assertEquals(cruiser.toString(), "S");
		cruiser.shootAt(4, 4);
		assertEquals(cruiser.toString(), "S");
		cruiser.shootAt(5, 4);
		assertEquals(cruiser.toString(), "x");
		assertEquals(destroyer.toString(), "S");
		destroyer.shootAt(8, 5);
		assertEquals(destroyer.toString(), "S");
		destroyer.shootAt(8, 6);
		assertEquals(destroyer.toString(), "x");
		assertEquals(submarine.toString(), "S");
		submarine.shootAt(6, 2);
		assertEquals(submarine.toString(), "x");
		assertEquals(ocean.getShipArray()[0][0].toString(), "-");
	}
}

package battleship;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OceanTest {
	
	@Test
	void testOcean() {
		Ocean ocean = new Ocean();
		assertEquals(ocean.getShotsFired(), 0);
		assertEquals(ocean.getHitCount(), 0);
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				assertTrue(ocean.ships[i][j].getShipType().equals("EmptySea"));
			}
		}
	}
	
	@Test
	void testPlaceAllShipsRandomly() {
		Ocean ocean = new Ocean();
		ocean.placeAllShipsRandomly();
		int battleshipTagCount = 0;
		int cruiserTagCount = 0;
		int destroyerTagCount = 0;
		int submarineTagCount = 0;
		for(int i = 0; i <10; i++) {
			for(int j = 0; j < 10; j++) {
				if(ocean.ships[i][j].getShipType().equals("battleship")) {
					battleshipTagCount += 1;
				} else if(ocean.ships[i][j].getShipType().equals("cruiser")) {
					cruiserTagCount += 1;
				} else if(ocean.ships[i][j].getShipType().equals("destroyer")) {
					destroyerTagCount += 1;
				} else if(ocean.ships[i][j].getShipType().equals("submarine")) {
					submarineTagCount += 1;
				}
			}
		}
		assertEquals(battleshipTagCount, 4);
		assertEquals(cruiserTagCount, 6);
		assertEquals(destroyerTagCount, 6);
		assertEquals(submarineTagCount, 4);
	}
	
	@Test
	void testIsOccupied() {
		Ocean ocean = new Ocean();
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				assertEquals(ocean.isOccupied(i, j), false);
			}
		}
		
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		assertTrue(ocean.isOccupied(1, 3));
		assertTrue(ocean.isOccupied(1, 4));
		assertTrue(ocean.isOccupied(1, 5));
		assertTrue(ocean.isOccupied(1, 6));
		assertFalse(ocean.isOccupied(1, 7));
		
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		assertTrue(ocean.isOccupied(3, 4));
		assertTrue(ocean.isOccupied(4, 4));
		assertTrue(ocean.isOccupied(5, 4));
		assertFalse(ocean.isOccupied(6, 4));
		
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		assertTrue(ocean.isOccupied(8, 5));
		assertTrue(ocean.isOccupied(8, 6));
		assertFalse(ocean.isOccupied(8, 7));
		
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertTrue(ocean.isOccupied(6, 2));
		assertFalse(ocean.isOccupied(6, 3));
		assertFalse(ocean.isOccupied(6, 1));
		assertFalse(ocean.isOccupied(7, 2));
		assertFalse(ocean.isOccupied(5, 2));
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
		assertEquals(ocean.shotsFired, 0);
		assertEquals(ocean.hitCount, 0);
		assertFalse(ocean.shootAt(2, 3));
		assertEquals(ocean.shotsFired, 1);
		assertEquals(ocean.hitCount, 0);
		assertTrue(ocean.getShipArray()[2][3].hit[0]);
		assertFalse(ocean.shootAt(0, 0));
		assertEquals(ocean.shotsFired, 2);
		assertEquals(ocean.hitCount, 0);
		assertTrue(ocean.getShipArray()[0][0].hit[0]);
		assertTrue(ocean.shootAt(1, 3));
		assertEquals(ocean.shotsFired, 3);
		assertEquals(ocean.hitCount, 1);
		assertTrue(ocean.shootAt(1, 3));
		assertEquals(ocean.shotsFired, 4);
		assertEquals(ocean.hitCount, 2);
		assertTrue(ocean.shootAt(1, 4));
		assertEquals(ocean.shotsFired, 5);
		assertEquals(ocean.hitCount, 3);
		assertTrue(ocean.shootAt(1, 5));
		assertEquals(ocean.shotsFired, 6);
		assertEquals(ocean.hitCount, 4);
		assertTrue(ocean.shootAt(1, 3));
		assertEquals(ocean.shotsFired, 7);
		assertEquals(ocean.hitCount, 5);
		assertTrue(ocean.shootAt(1, 6));
		assertEquals(ocean.shotsFired, 8);
		assertEquals(ocean.hitCount, 6);
		assertFalse(ocean.shootAt(1, 3));
		assertEquals(ocean.shotsFired, 9);
		assertEquals(ocean.hitCount, 6);
		assertFalse(ocean.shootAt(1, 4));
		assertEquals(ocean.shotsFired, 10);
		assertEquals(ocean.hitCount, 6);
		assertFalse(ocean.shootAt(1, 5));
		assertEquals(ocean.shotsFired, 11);
		assertEquals(ocean.hitCount, 6);
		assertFalse(ocean.shootAt(1, 6));
		assertEquals(ocean.shotsFired, 12);
		assertEquals(ocean.hitCount, 6);
		assertTrue(ocean.shootAt(3, 4));
		assertEquals(ocean.shotsFired, 13);
		assertEquals(ocean.hitCount, 7);
		assertTrue(ocean.shootAt(4, 4));
		assertEquals(ocean.shotsFired, 14);
		assertEquals(ocean.hitCount, 8);
		assertTrue(ocean.shootAt(3, 4));
		assertEquals(ocean.shotsFired, 15);
		assertEquals(ocean.hitCount, 9);
		assertTrue(ocean.shootAt(5, 4));
		assertEquals(ocean.shotsFired, 16);
		assertEquals(ocean.hitCount, 10);
		assertFalse(ocean.shootAt(3, 4));
		assertEquals(ocean.shotsFired, 17);
		assertEquals(ocean.hitCount, 10);
		assertFalse(ocean.shootAt(4, 4));
		assertEquals(ocean.shotsFired, 18);
		assertEquals(ocean.hitCount, 10);
		assertFalse(ocean.shootAt(5, 4));
		assertEquals(ocean.shotsFired, 19);
		assertEquals(ocean.hitCount, 10);
		assertTrue(ocean.shootAt(8, 5));
		assertEquals(ocean.shotsFired, 20);
		assertEquals(ocean.hitCount, 11);
		assertTrue(ocean.shootAt(8, 6));
		assertEquals(ocean.shotsFired, 21);
		assertEquals(ocean.hitCount, 12);
		assertFalse(ocean.shootAt(8, 5));
		assertEquals(ocean.shotsFired, 22);
		assertEquals(ocean.hitCount, 12);
		assertFalse(ocean.shootAt(8, 6));
		assertEquals(ocean.shotsFired, 23);
		assertEquals(ocean.hitCount, 12);
		assertTrue(ocean.shootAt(6, 2));
		assertEquals(ocean.shotsFired, 24);
		assertEquals(ocean.hitCount, 13);
		assertFalse(ocean.shootAt(6, 2));
		assertEquals(ocean.shotsFired, 25);
		assertEquals(ocean.hitCount, 13);
	}
	
	@Test
	void testGetShotsFired() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShotsFired(), 0);
		ocean.shootAt(2, 3);
		assertEquals(ocean.getShotsFired(), 1);
		ocean.shootAt(0, 0);
		assertEquals(ocean.getShotsFired(), 2);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getShotsFired(), 3);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getShotsFired(), 4);
		ocean.shootAt(1, 4);
		assertEquals(ocean.getShotsFired(), 5);
		ocean.shootAt(1, 5);
		assertEquals(ocean.getShotsFired(), 6);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getShotsFired(), 7);
		ocean.shootAt(1, 6);
		assertEquals(ocean.getShotsFired(), 8);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getShotsFired(), 9);
		ocean.shootAt(1, 4);
		assertEquals(ocean.getShotsFired(), 10);
		ocean.shootAt(1, 5);
		assertEquals(ocean.getShotsFired(), 11);
		ocean.shootAt(1, 6);
		assertEquals(ocean.getShotsFired(), 12);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getShotsFired(), 13);
		ocean.shootAt(4, 4);
		assertEquals(ocean.getShotsFired(), 14);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getShotsFired(), 15);
		ocean.shootAt(5, 4);
		assertEquals(ocean.getShotsFired(), 16);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getShotsFired(), 17);
		ocean.shootAt(4, 4);
		assertEquals(ocean.getShotsFired(), 18);
		ocean.shootAt(5, 4);
		assertEquals(ocean.getShotsFired(), 19);
		ocean.shootAt(8, 5);
		assertEquals(ocean.getShotsFired(), 20);
		ocean.shootAt(8, 6);
		assertEquals(ocean.getShotsFired(), 21);
		ocean.shootAt(8, 5);
		assertEquals(ocean.getShotsFired(), 22);
		ocean.shootAt(8, 6);
		assertEquals(ocean.getShotsFired(), 23);
		ocean.shootAt(6, 2);
		assertEquals(ocean.getShotsFired(), 24);
		ocean.shootAt(6, 2);
		assertEquals(ocean.getShotsFired(), 25);
	}
	
	@Test
	void testGetHitCount() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getHitCount(), 0);
		ocean.shootAt(2, 3);
		assertEquals(ocean.getHitCount(), 0);
		ocean.shootAt(0, 0);
		assertEquals(ocean.getHitCount(), 0);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getHitCount(), 1);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getHitCount(), 2);
		ocean.shootAt(1, 4);
		assertEquals(ocean.getHitCount(), 3);
		ocean.shootAt(1, 5);
		assertEquals(ocean.getHitCount(), 4);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getHitCount(), 5);
		ocean.shootAt(1, 6);
		assertEquals(ocean.getHitCount(), 6);
		ocean.shootAt(1, 3);
		assertEquals(ocean.getHitCount(), 6);
		ocean.shootAt(1, 4);
		assertEquals(ocean.getHitCount(), 6);
		ocean.shootAt(1, 5);
		assertEquals(ocean.getHitCount(), 6);
		ocean.shootAt(1, 6);
		assertEquals(ocean.getHitCount(), 6);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getHitCount(), 7);
		ocean.shootAt(4, 4);
		assertEquals(ocean.getHitCount(), 8);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getHitCount(), 9);
		ocean.shootAt(5, 4);
		assertEquals(ocean.getHitCount(), 10);
		ocean.shootAt(3, 4);
		assertEquals(ocean.getHitCount(), 10);
		ocean.shootAt(4, 4);
		assertEquals(ocean.getHitCount(), 10);
		ocean.shootAt(5, 4);
		assertEquals(ocean.getHitCount(), 10);
		ocean.shootAt(8, 5);
		assertEquals(ocean.getHitCount(), 11);
		ocean.shootAt(8, 6);
		assertEquals(ocean.getHitCount(), 12);
		ocean.shootAt(8, 5);
		assertEquals(ocean.getHitCount(), 12);
		ocean.shootAt(8, 6);
		assertEquals(ocean.getHitCount(), 12);
		ocean.shootAt(6, 2);
		assertEquals(ocean.getHitCount(), 13);
		ocean.shootAt(6, 2);
		assertEquals(ocean.getHitCount(), 13);
	}
	
	@Test
	void testIsGameOver() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(2, 3);
		ocean.shootAt(0, 0);
		ocean.shootAt(1, 3);
		ocean.shootAt(1, 3);
		ocean.shootAt(1, 4);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(1, 5);
		ocean.shootAt(1, 3);
		ocean.shootAt(1, 6);
		ocean.shootAt(1, 3);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(1, 4);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(1, 5);
		ocean.shootAt(1, 6);
		ocean.shootAt(3, 4);
		ocean.shootAt(4, 4);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(3, 4);
		ocean.shootAt(5, 4);
		ocean.shootAt(3, 4);
		ocean.shootAt(4, 4);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(5, 4);
		ocean.shootAt(8, 5);
		ocean.shootAt(8, 6);
		ocean.shootAt(8, 5);
		assertFalse(ocean.isGameOver());
		ocean.shootAt(8, 6);
		ocean.shootAt(6, 2);
		ocean.shootAt(6, 2);
		assertTrue(ocean.isGameOver());
	}
	
	@Test
	void testGetShipArray() {
		Ocean ocean = new Ocean();
		Battleship battleship = new Battleship();
		battleship.placeShipAt(1, 3, true, ocean);
		Cruiser cruiser = new Cruiser();
		cruiser.placeShipAt(3, 4, false, ocean);
		Destroyer destroyer = new Destroyer();
		destroyer.placeShipAt(8, 5, true, ocean);
		Submarine submarine = new Submarine();
		submarine.placeShipAt(6, 2, false, ocean);
		assertEquals(ocean.getShipArray(), ocean.ships);
		assertEquals(ocean.getShipArray()[1][3], battleship);
		assertEquals(ocean.getShipArray()[1][4], battleship);
		assertEquals(ocean.getShipArray()[1][5], battleship);
		assertEquals(ocean.getShipArray()[1][6], battleship);
		assertEquals(ocean.getShipArray()[3][4], cruiser);
		assertEquals(ocean.getShipArray()[4][4], cruiser);
		assertEquals(ocean.getShipArray()[5][4], cruiser);
		assertEquals(ocean.getShipArray()[8][5], destroyer);
		assertEquals(ocean.getShipArray()[8][6], destroyer);
		assertEquals(ocean.getShipArray()[6][2], submarine);
	}
}

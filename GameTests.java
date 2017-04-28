import static org.junit.Assert.*;

import org.junit.Test;

public class GameTests {

	@Test
	public void testSmallKillerResize() {
	  SmallKiller newKiller = new SmallKiller(0, 0, 20);
	  newKiller.resize(2);
	  assertEquals("Resize called once", (20 / 2), newKiller.getSize());
	  SmallKiller newKiller2 = new SmallKiller(0, 0, 30);
	  SmallKiller newKiller3 = new SmallKiller(0, 0, 40);
	  SmallKiller newKiller4 = new SmallKiller(0, 0, 50);
	  newKiller3.resize(1);
	  assertEquals("Resize called twice", 40, newKiller3.getSize());
		
	}
	
	@Test
	public void testBigKillerResize() {
	  BigKiller newKiller = new BigKiller(0, 0, 70);
	  newKiller.resize(2);
	  assertEquals("Resize called once", (70 * 2), newKiller.getSize());
	  BigKiller newKiller2 = new BigKiller(0, 0, 80);
	  BigKiller newKiller3 = new BigKiller(0, 0, 90);
	  BigKiller newKiller4 = new BigKiller(0, 0, 100);
	  newKiller4.resize(1);
	  assertEquals("Resize called twice", 100, newKiller4.getSize());
		
	}
	
	@Test
	public void testBigKillerXPos() {
		BigKiller newKiller = new BigKiller(100, 100, 70);
		assertEquals("First Killer", 0, newKiller.getPx());
		BigKiller newKiller2 = new BigKiller(20, 20, 80);
		assertEquals("Second Killer", 50, newKiller2.getPx());
		BigKiller newKiller3 = new BigKiller(200, 200, 90);
		assertEquals("Third Killer", 0, newKiller3.getPx());
		BigKiller newKiller4 = new BigKiller(200, 200, 100);
		assertEquals("Fourth Killer", 50, newKiller4.getPx());
		
	}
	
	@Test
	public void testSmallKillerXPos() {
		SmallKiller newKiller = new SmallKiller(100, 100, 70);
		assertEquals("First Killer", 0, newKiller.getPx());
		SmallKiller newKiller2 = new SmallKiller(20, 20, 80);
		assertEquals("Second Killer", 30, newKiller2.getPx());
		SmallKiller newKiller3 = new SmallKiller(200, 200, 90);
		assertEquals("Third Killer", 0, newKiller3.getPx());
		SmallKiller newKiller4 = new SmallKiller(200, 200, 100);
		assertEquals("Fourth Killer", 30, newKiller4.getPx());
		
	}
	
	

}

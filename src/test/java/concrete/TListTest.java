package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TListTest {
	
	TList l1;
	TList l2;

	@BeforeEach
	void setUp() throws Exception {
		l1 = new TList("l1");
		l2 = new TList("l2");
	}

	@Test
	void testSetName() {
		l1.setName("list1");
		assertEquals("list1", l1.l_name);
	}

	@Test
	void testCreateCard() {
		Card c = l1.createCard("card1");
		assertEquals(true, l1.cards.contains(c));
	}

	@Test
	void testRemoveCard() {
		Card c1 = l1.createCard("card1");
		assertEquals(true, l1.cards.contains(c1));
		assertEquals(true, l1.removeCard("card1"));
		assertEquals(false, l1.removeCard("card1"));
		assertEquals(false, l1.removeCard("n"));
	}

	@Test
	void testSwapCard() {
		l1.createCard("card1");
		l1.createCard("card2");
		l1.createCard("card3");
		l1.createCard("card4");

		assertEquals(true, l1.swapCard("card3", 0));
		assertEquals(true, l1.swapCard("card2", 3));
		assertEquals(false, l1.swapCard("card5", 0));
		assertEquals("card3", l1.cards.get(0).c_name);
		assertEquals("card1", l1.cards.get(1).c_name);
		assertEquals("card2", l1.cards.get(3).c_name);
	}

	@Test
	void testMoveCard() {
		l1.createCard("card1");
		l2.createCard("card3");
		l2.createCard("card4");
		
		assertEquals(true, l1.moveCard(l2, "card1", 1));
		assertEquals("card1", l2.cards.get(1).c_name);
		l2.moveCard(l1, "card4", 0);
		assertEquals("card4", l1.cards.get(0).c_name);
	}

}

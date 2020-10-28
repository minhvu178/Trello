package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XMLTest {
	
	User M;
	User T;
	User P;
	Board b1;
	TList l1;
	TList l2;
	Card c1;
	Card c2;
	Card c3;

	@BeforeEach
	void setUp() throws Exception {
		M = new User("minh", "1");
		T = new User("tram", "2");
		P = new User("ngoc", "3");
		T.createBoard(T, "board1");
		b1 = T.selectBoard("board1");
		b1.addUser(T.getUsr(), M);
		b1.addUser(T.getUsr(), P);
		l1 = b1.createList("list1");
		l2 = b1.createList("list2");
		c1 = l1.createCard("card1");
		c2 = l2.createCard("card2");
		c3 = l1.createCard("card3");
		c1.addLabel("minh");
		c2.addLabel("tram");
		c1.addComponent(1);
		c2.addComponent(2);
	}

	@Test
	void testXML() {
		T.storeToDisk();
		User diskU = User.loadFromDisk();
		assertTrue(T.equals(diskU));
	}

}

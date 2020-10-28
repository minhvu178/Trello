package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XMLTest {
	
	User M;
	User T;
	Board b1;
	TList l1;
	TList l2;
	Card c1;
	Card c2;

	@BeforeEach
	void setUp() throws Exception {
		M = new User("minh", "1");
		T = new User("tram", "2");
		M.createBoard(M, "board1");
		b1 = M.selectBoard("board1");
		b1.addUser(M.getUsr(), T);
		l1 = b1.createList("list1");
		l2 = b1.createList("list2");
		c1 = l1.createCard("card1");
		c2 = l2.createCard("card2");
		c1.addLabel("minh");
		c2.addLabel("tram");
		c1.addComponent(1);
		c2.addComponent(2);
	}

	@Test
	void testXML() {
		M.storeToDisk();
		
		User diskU = User.loadFromDisk();
		
		assertTrue(M.equals(diskU));
	}

}

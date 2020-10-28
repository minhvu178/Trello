package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

	Board b1;
	User M;
	User T;
	TList list1;
	@BeforeEach
	void setUp() throws Exception {
		
		M = new User("m", "1");
		T = new User("t", "1");
		b1 = new Board(M.getUsr(), "b1");
	}

	@Test
	void testSetName() {
		b1.setName("tram");
		assertEquals("tram", b1.b_name);
	}

	@Test
	void testAddUser() {
		assertEquals(true, b1.addUser(M.getUsr(), T));
		assertEquals(false, b1.addUser(T.getUsr(), M));
		assertEquals(true, T.boards.contains(b1));
	}

	@Test
	void testRemoveUser() {
		b1.addUser(M.getUsr(), T);
		assertEquals(true, b1.removeUser(M.getUsr(), T));
		assertEquals(false, b1.removeUser(M.getUsr(), T));
	}

	@Test
	void testCreateList() {
		list1 = b1.createList("list1");
		assertEquals(true, b1.lists.contains(list1));
	}

	@Test
	void testRemoveList() {
		list1 = b1.createList("list1");
		assertEquals(true, b1.lists.contains(list1));
		assertEquals(true, b1.removeList("list1"));
		assertEquals(false, b1.removeList("list1"));
		assertEquals(false, b1.removeList("n"));
	}

	@Test
	void testMoveList() {
		b1.createList("list1");
		b1.createList("list2");
		b1.createList("list3");
		b1.createList("list4");

		assertEquals(true, b1.moveList("list3", 0));
		assertEquals(true, b1.moveList("list2", 3));
		assertEquals(false, b1.moveList("list5", 0));
		assertEquals("list3", b1.lists.get(0).l_name);
		assertEquals("list1", b1.lists.get(1).l_name);
		assertEquals("list2", b1.lists.get(3).l_name);

		
	}

}

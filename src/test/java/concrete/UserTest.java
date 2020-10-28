package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

	User M;
	User T;
	Board b1;
	Board b2;
	
	@BeforeEach
	void setUp() throws Exception {
		M = new User("minh", "1");
		T = new User("tram", "2");
		b1 = new Board(M.getUsr(), "board1");
		b2 = new Board(T.getUsr(), "board2");
	}

	@Test
	void testUser() {
		
	}

	@Test
	void testLogin() {
		assertEquals(true, M.login("1"));
		assertEquals(false, T.login("3"));
	}

	@Test
	void testCreateBoard() {
		M.createBoard(M, "board1");
		M.createBoard(M, "board2");
		T.createBoard(T, "board2");
		
		assertEquals(2, M.boards.size());
		assertEquals(M, M.boards.get(0).owner);
		assertEquals("board1", M.boards.get(0).b_name);
		assertEquals("board2", M.boards.get(1).b_name);
		assertEquals(T, T.boards.get(0).owner);
	}

	@Test
	void testXML() {
		
	}
	
}

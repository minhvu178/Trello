package concrete;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CardTest {

	Card c1;
	Card c2;
	User u1;
	User u2;
	User u3;

	@BeforeEach
	void setUp() throws Exception {
		c1 = new Card("c1");
		c2 = new Card("c2");
		u1 = new User("u1", "1");
		u2 = new User("u2", "1");
		u3 = new User("u3", "1");
	}

	@Test
	void testSetName() {
		c1.setName("card1");
		assertEquals("card1", c1.c_name);
	}

	@Test
	void testAddLabel() {
		c1.addLabel("des");
		c1.addLabel("check");
		assertEquals(true, c1.labels.contains("des"));
		assertEquals(true, c1.labels.contains("check"));

	}

	@Test
	void testAddMember() {
		c1.addMember(u1);
		c1.addMember(u2);
		
		assertEquals(true, c1.members.contains(u1));
		assertEquals(true, c1.members.contains(u2));
		assertEquals(false, c2.members.contains(u1));
		assertEquals(false, c2.members.contains(u3));
	}

	@Test
	void testRemoveMember() {
		c1.addMember(u1);
		c1.addMember(u2);
		assertEquals(true, c1.members.contains(u1));
		assertEquals(true, c1.members.contains(u2));
		
		c1.removeMember(u1);
		c2.removeMember(u2);
		assertEquals(false, c1.members.contains(u1));
		assertEquals(false, c1.members.contains(u1));
		
	}

	@Test
	void testAddComponent() {
		Component comp1 = c1.addComponent(1);
		assertEquals(true, c1.comps.contains(comp1));
		
		Component comp2 = c1.addComponent(2);
		assertEquals(true, c1.comps.contains(comp2));
	}

	@Test
	void testAccessComp() {
		Component comp1 = c1.addComponent(1);
		Component comp2 = c1.addComponent(2);
		
		assertEquals(comp1, c1.accessComp(0));
		assertEquals(comp2, c1.accessComp(1));
	}

}

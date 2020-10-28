package concrete;
import java.util.*;

public class Board {
	String b_name;
	String  owner;
	ArrayList<TList> lists;
	HashSet<String> users;

	public Board(String owner, String b_name) {
		this.owner = owner;
		this.b_name = b_name;
		lists = new ArrayList<TList>();
		users = new HashSet<String>();
	}
	
	public Board() {
		this(null, "m");
	}
	
	public boolean addUser(String owner, User user) {
		if (Objects.equals(owner, this.owner)) {
			users.add(user.getUsr());
			user.addBoard(this);
			return true;
		}
		return false;
	}
	
	public void setName(String name) {
		this.b_name = name;
	}
	
	public boolean removeUser(String owner, User user) {
		if (Objects.equals(owner, this.owner)) {
			
			user.removeBoard(this);
			return users.remove(user.getUsr());
		}
		return false;
	}
	
	public TList createList(String l_name) {
		TList list = new TList(l_name);
		lists.add(list);
		return list;
	}
	
	public TList selectList(String l_name) {
		for(TList list : lists) {
			if (Objects.equals(l_name, list.l_name)){
				return list;
			}
		}
		return null;
	}
	
	public boolean removeList(String list_name) {
		for(TList list : lists) {
			if (Objects.equals(list_name, list.l_name)){
				return lists.remove(list);
			}
		}
		return false;
	}
	
	public boolean moveList(String l_name, int index) {
		for(TList list : lists) {
			if (Objects.equals(l_name, list.l_name)){
				TList temp = list;
				lists.remove(list);
				lists.add(index, temp);
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the b_name
	 */
	public String getB_name() {
		return b_name;
	}

	/**
	 * @param b_name the b_name to set
	 */
	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the lists
	 */
	public ArrayList<TList> getLists() {
		return lists;
	}

	/**
	 * @param lists the lists to set
	 */
	public void setLists(ArrayList<TList> lists) {
		this.lists = lists;
	}

	/**
	 * @return the users
	 */
	public HashSet<String> getUsers() {
		return users;
	}
	
	public boolean equals(Board that) {
		if(lists.size() != that.lists.size() || users.size() != that.users.size()
				|| owner != that.owner ||  b_name != that.b_name) {
			return false;
		}
		
		for (TList l : lists) {
			if (!that.containsL(l)) {
				return false;
			}
		}
		
		for (String u : users) {
			if (!that.containsU(u)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean containsL(TList list) {
		for (TList l : lists) {
			if (l.equals(list)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean containsU(String usr) {
		for (String u : users) {
			if (u.equals(usr)) {
				return true;
			}
		}
		return false;
	}
	
}

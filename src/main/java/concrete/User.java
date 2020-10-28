package concrete;
import java.beans.*;
import java.io.*;
import java.util.*;


public class User {
	private String usr;
	private String pwd;
	ArrayList<Board> boards;

	public User(String usr, String pwd) {
		this.usr = usr;
		this.pwd = pwd;
		this.boards = new ArrayList<Board>();
	}
	
	public User() {
		this("m", "1");
	}
	
	public boolean login(String pwd) {
		if (Objects.equals(pwd, this.pwd)) {
			return true;
		}
		else {
			return false;
		}
	}

	public void createBoard(User user, String b_name) {
		Board board = new Board(user.getUsr(), b_name);
		boards.add(board);
	}
	
	public void addBoard(Board board) {
		boards.add(board);
	}
	
	public void removeBoard(Board board) {
		boards.remove(board);
	}
	
	public Board selectBoard(String b_name) {
		for(Board board : boards) {
			if (Objects.equals(b_name, board.b_name)){
				return board;
			}
		}
		return null;
	}

	public String getUsr() {
		return usr;
	}
	
	public void setUsr(String name) {
		this.usr = name;
	}

	public String getPwd() {
		return pwd;
	}
	
	public void storeToDisk() {
		XMLEncoder encoder=null;
		try{
		encoder=new XMLEncoder(new BufferedOutputStream(
				new FileOutputStream("User.xml")));
		}catch(FileNotFoundException fileNotFound){
			System.out.println("ERROR: While Creating or Opening the File dvd.xml");
		}
		encoder.writeObject(this);
		encoder.close();
	}
	
	public static User loadFromDisk() {
		XMLDecoder decoder=null;
		try {
			decoder=new XMLDecoder(new BufferedInputStream(
					new FileInputStream("User.xml")));
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File dvd.xml not found");
		}
		User usr = (User) decoder.readObject();
		return usr;
	}
	
	public boolean equals(User that) {
		if(boards.size() != that.boards.size() || pwd != that.pwd || usr != that.usr) {
			return false;
		}
		
		for (Board b : boards) {
			if (!that.contains(b)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean contains(Board board) {
		for (Board b : boards) {
			if (b.equals(board)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return the boards
	 */
	public ArrayList<Board> getBoards() {
		return boards;
	}

	/**
	 * @param boards the boards to set
	 */
	public void setBoards(ArrayList<Board> boards) {
		this.boards = boards;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}

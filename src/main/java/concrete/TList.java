package concrete;
import java.util.*;

public class TList {
	
	String l_name;
	ArrayList<Card> cards;

	public TList(String l_name) {
		this.l_name = l_name;
		cards = new ArrayList<Card>();
	}
	
	public TList() {
		this("list");
	}
	
	public void setName(String name) {
		this.l_name = name;
	}

	public Card createCard(String c_name) {
		Card card = new Card(c_name);
		cards.add(card);
		return card;
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public boolean removeCard(String c_name) {
		for(Card card : cards) {
			if (Objects.equals(c_name, card.c_name)){
				return cards.remove(card);
			}
		}
		return false;
	}
	
	public boolean swapCard(String c_name, int index) {
		for(Card card : cards) {
			if (Objects.equals(c_name, card.c_name)){
				Card temp = card;
				cards.remove(card);
				cards.add(index, temp);
				return true;
			}
		}
		return false;
	}
	
	public boolean moveCard(TList list, String c_name, int index) {
		
		for(Card card : cards) {
			if (Objects.equals(c_name, card.c_name)){
				Card temp = card;
				cards.remove(card);
				list.addCard(temp);
				list.swapCard(c_name, index);
				return true;
			}
		}
		
		return false;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * @return the cards
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

	/**
	 * @param cards the cards to set
	 */
	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}
	
	public boolean equals(TList that) {
		if(cards.size() != that.cards.size() || l_name != that.l_name) {
			return false;
		}
		
		for (Card c : cards) {
			if (!that.contains(c)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean contains(Card card) {
		for (Card c : cards) {
			if (c.equals(card)) {
				return true;
			}
		}
		return false;
	}
}

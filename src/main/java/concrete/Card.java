package concrete;
import java.util.*;

public class Card {
	String c_name;
	HashSet<String> labels;
	HashSet<String> members;
	ArrayList<Component> comps;

	public Card(String c_name) {
		this.c_name = c_name;
		labels = new HashSet<String>();
		members = new HashSet<String>();
		comps = new ArrayList<Component>();
	}
	
	public Card() {
		this("name");
	}
	
	public void setName(String c_name) {
		this.c_name = c_name;
	}
	
	public boolean addLabel(String label) {
		return labels.add(label);
	}
	
	public boolean removeLabel(String label) {
		return labels.remove(label);
	}
	
	public boolean addMember(User user) {
		return members.add(user.getUsr());
	}
	
	public boolean removeMember(User user) {
		return members.remove(user.getUsr());
	}
	
	public Component addComponent(int num_type) {
		 if (num_type == 1) {
			 
			 DescriptionCP comp = new DescriptionCP();
			 comps.add(comp);
			 return comp;
		 }
		 else if(num_type == 2) {
			 ChecklistCP comp = new ChecklistCP();
			 comps.add(comp);
			 return comp;
		 }
		 else {
			 return null;
		 }
	}
	
	public Component accessComp(int index) {
		
		return comps.get(index);
	}
	
	public boolean removeComponent(int index) {
		
		return comps.remove(comps.get(index));
	}

	/**
	 * @return the c_name
	 */
	public String getC_name() {
		return c_name;
	}

	/**
	 * @param c_name the c_name to set
	 */
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	/**
	 * @return the labels
	 */
	public HashSet<String> getLabels() {
		return labels;
	}

	/**
	 * @param labels the labels to set
	 */
	public void setLabels(HashSet<String> labels) {
		this.labels = labels;
	}

	/**
	 * @return the members
	 */
	public HashSet<String> getMembers() {
		return members;
	}

	/**
	 * @return the comps
	 */
	public ArrayList<Component> getComps() {
		return comps;
	}

	/**
	 * @param comps the comps to set
	 */
	public void setComps(ArrayList<Component> comps) {
		this.comps = comps;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c_name == null) ? 0 : c_name.hashCode());
		result = prime * result + ((comps == null) ? 0 : comps.hashCode());
		result = prime * result + ((labels == null) ? 0 : labels.hashCode());
		result = prime * result + ((members == null) ? 0 : members.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (c_name == null) {
			if (other.c_name != null)
				return false;
		} else if (!c_name.equals(other.c_name))
			return false;
		if (comps == null) {
			if (other.comps != null)
				return false;
		} else if (!comps.equals(other.comps))
			return false;
		if (labels == null) {
			if (other.labels != null)
				return false;
		} else if (!labels.equals(other.labels))
			return false;
		if (members == null) {
			if (other.members != null)
				return false;
		} else if (!members.equals(other.members))
			return false;
		return true;
	}
	
}

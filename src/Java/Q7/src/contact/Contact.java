package contact;

import group.GManager;
import show.Showable;

public abstract class Contact implements Showable {
	String name;
	String email;
	int groupID;
	
	public Contact(String name, String email, int groupID) {
		this.name = name;
		this.email = email;
		this.groupID = groupID;
	}
	
	public String getName() {
		return name;
	}
	
	public abstract void showData(GManager gManager);
}

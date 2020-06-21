package contact;

import group.GManager;

public class SimpleContact extends Contact {
	public SimpleContact(String name, String email, int groupID) {
		super(name, email, groupID);
	}
	
	public void showData(GManager gManager) {
		System.out.println(String.format("%s   %s    %s", name, email, gManager.getGroupByIdx(groupID).getName()));
	}

}
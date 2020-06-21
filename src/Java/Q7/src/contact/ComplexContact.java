package contact;

import group.GManager;

public class ComplexContact extends Contact {
	String address;
	public ComplexContact(String name, String email, String address, int groupID) {
		super(name, email, groupID);
		this.address = address;
	}
	
	public void showData(GManager gManager) {
		System.out.println(String.format("%s   %s    %s     %s", name, email, gManager.getGroupByIdx(groupID).getName(), address));
	}
}

package contact;

import group.Group;

public class Contact {
	String name, email;
	Group group;
	
	public Contact(String name, String email, Group group) {
		this.name = name;
		this.email = email;
		this.group = group;
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Group getGroup() {
		return group;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
}

package contact;

import group.Group;

public class FullContact extends Contact {
	String addr;
	
	FullContact(String name, String email, String addr, Group group) {
		super(name, email, group);
		this.addr = addr;
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}

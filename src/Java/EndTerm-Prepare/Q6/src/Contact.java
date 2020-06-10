
public class Contact {
	String name, email;
	ContactGroup group;
	
	public Contact(String name, String email, ContactGroup group) {
		this.name = name;
		this.email = email;
		this.group = group;
	}
	
	public void showData() {
		System.out.println(String.format("%s      %s        %s", name, email, group.getName()));
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public ContactGroup getGroup() {
		return group;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGroup(ContactGroup group) {
		this.group = group;
	}
}

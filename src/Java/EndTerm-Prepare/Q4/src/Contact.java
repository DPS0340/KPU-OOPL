
public class Contact {
	String name, email, group;
	
	public Contact(String name, String email, String group) {
		this.name = name;
		this.email = email;
		this.group = group;
	}
	
	public void showData() {
		System.out.println(String.format("%s      %s        %s", name, email, group));
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getGroup() {
		return group;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setGroup(String group) {
		this.group = group;
	}
}

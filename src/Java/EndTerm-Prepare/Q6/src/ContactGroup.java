
public class ContactGroup {
	int id;
	String name;
	public ContactGroup() {
		
	}
	public ContactGroup(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public void showData() {
		System.out.printf("%d      %s\n", id, name);
	}
	
	public int getid() {
		return id;
	}
	public String getName() {
		return name;
	}
}

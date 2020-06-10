
public class Company extends Contact {
	String city;
	
	public Company(String name, String email, String group, String city) {
		super(name, email, group);
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	@Override
	public void showData() {
		System.out.println(String.format("%s      %s        %s     %s", name, email, group, city));
	}

}

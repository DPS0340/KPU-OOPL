package kpu.member;

public class Student extends Member {
	private int year;
	private String major;
	
	public Student(int id, String name, String major, int year) {
		super(id, name);
		this.major = major;
		this.year = year;
	}
	
	public String getMajor() {
		return major;
	}

	
	@Override
	public void showData() {
		System.out.println(String.format("%d   %s    %s   %d", id, name, major, year));
	}
	
	@Override
	public void showWithType() {
		System.out.printf("ÇÐ»ý    ");
		showData();
	}
	

	public int getYear() {
		return year;
	}
}

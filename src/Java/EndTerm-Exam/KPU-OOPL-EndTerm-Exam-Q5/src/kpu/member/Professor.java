package kpu.member;

public class Professor extends Member {
	String school;
	public Professor(int id, String name, String school) {
		super(id, name);
		this.school = school;
	}
	
	@Override
	public void showData() {
		System.out.println(String.format("%d   %s    %s", id, name, school));
	}
	
	@Override
	public void showWithFormat() {
		System.out.println("----------------------");
		System.out.println("ID    이름      소속");
		System.out.println("----------------------");
		showData();
		System.out.println("----------------------");
	}
	
	@Override
	public void showWithType() {
		System.out.printf("교수   ");
		showData();
	}
}

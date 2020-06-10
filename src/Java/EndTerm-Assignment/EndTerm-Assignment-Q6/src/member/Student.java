package member;

import team.Team;

public class Student extends Member {
	String major;
	int year;
	public Student(int id, String name, Team team, String major, int year) {
		super(id, name, team);
		this.major = major;
		this.year = year;
	}
	
	@Override
	public void show() {
		System.out.println(String.format("%d    %s     %s     %s  %d", this.getID(), this.getName(), this.getTeam().getTitle(), this.getMajor(), this.getYear()));
	}
	
	@Override
	public void showWithType() {
		System.out.printf("학생   ");
		show();
	}
	
	@Override
	public void showFormat() {
		System.out.println("--------------------------------------");
		System.out.println("ID      이름        Team      전공       학년");
		System.out.println("--------------------------------------");
		show();
		System.out.println("--------------------------------------");
	}
	
	public String getMajor() {
		return major;
	}
	public int getYear() {
		return year;
	}
}

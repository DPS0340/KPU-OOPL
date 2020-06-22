package kpu.member;

import kpu.app.show.Showable;

public class Student implements Showable {
	private int id;
	private String name;
	private String major;
	private int year;
	
	public Student(int id, String name, String major, int year) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.year = year;
	}
	
	public void showData() {
		System.out.println(String.format("%d   %s    %s   %d", id, name, major, year));
	}
	
	public void showWithFormat() {
		System.out.println("----------------------");
		System.out.println("ID    이름      전공       학년");
		System.out.println("----------------------");
		showData();
		System.out.println("----------------------");
	}
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getMajor() {
		return major;
	}
	public int getYear() {
		return year;
	}
}

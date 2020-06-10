package team;

import show.Showable;

public class Team implements Showable {
	int id;
	String title;
	
	public Team(int id, String title) {
		this.id = id;
		this.title = title;
	}
	
	public int getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
	@Override
	public void show() {
		System.out.println(String.format("%d       %s", getID(), getTitle()));
	}
	public void showFormat() {
		System.out.println("-------------------");
		System.out.println("ID      Team ¿Ã∏ß");
		System.out.println("-------------------");
		show();
		System.out.println("-------------------");
	}
}

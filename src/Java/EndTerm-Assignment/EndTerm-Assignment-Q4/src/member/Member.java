package member;

import show.Showable;
import team.Team;

public abstract class Member implements Showable {
	int id;
	String name;
	Team team;
	
	public Member(int id, String name, Team team) {
		this.id = id;
		this.name = name;
		this.team = team;
	}
	
	public void show() {
		// 상속시 @Override
		return;
	}
	
	public void showFormat() {
		// 상속시 @Override
		return;
	}
	
	public int getID() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Team getTeam() {
		return team;
	}
}

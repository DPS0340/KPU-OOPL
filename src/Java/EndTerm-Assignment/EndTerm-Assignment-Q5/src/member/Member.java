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
		// ��ӽ� @Override
		return;
	}
	
	public void showWithType() {
		// ��ӽ� @Override
		return;
	}
	
	public void showFormat() {
		// ��ӽ� @Override
		return;
	}
	
	public void showFormatWithType() {
		System.out.println("------------------------------------------------");
		System.out.println("����   ID      �̸�        Team      ����/ȸ��        �г�");
		System.out.println("------------------------------------------------");
		showWithType();
		System.out.println("------------------------------------------------");
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

package member;

import team.Team;

public class Mentor extends Member {
	String org;
	public Mentor(int id, String name, Team team, String org) {
		super(id, name, team);
		this.org = org;
	}
	
	@Override
	public void show() {
		System.out.println(String.format("%d    %s     %s     %s", this.getID(), this.getName(), this.getTeam().getTitle(), this.getOrg()));
	}
	
	@Override
	public void showFormat() {
		System.out.println("--------------------------------------");
		System.out.println("ID      �̸�        Team      ȸ��");
		System.out.println("--------------------------------------");
		show();
		System.out.println("--------------------------------------");
	}
	
	public String getOrg() {
		return org;
	}
}

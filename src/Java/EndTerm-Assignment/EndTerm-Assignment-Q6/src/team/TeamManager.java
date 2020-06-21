package team;

import java.util.Scanner;

import member.MemberManager;

public class TeamManager {
	Team[] teamList;
	int index;
	int max_length;
	
	public TeamManager(int length) {
		index = 0;
		max_length = length;
		teamList = new Team[length];
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public boolean insert(Team elem) {
		if(index >= max_length) {
			return false;
		}
		teamList[index++] = elem;
		return true;
	}
	
	public Team getTeamByIndex(int idx) {
		if(idx > index) {
			return null;
		}
		return teamList[idx-1];
	}
	
	public void showAll() {
		System.out.println("-------------------");
		System.out.println("ID      Team 이름");
		System.out.println("-------------------");
		for(int i=0;i<index;i++) {
			teamList[i].show();
		}
		System.out.println("-------------------");
	}
	
	public void insertTeamByUserInput(Scanner scanner, MemberManager memberManager) {
		int id = this.getNextIndex();
		String name;
		System.out.println(String.format("- ID: %d", id));
		System.out.printf("- 타이틀: ");
		name = scanner.next();
		Team team = new Team(id, name);
		boolean isInserted = insert(team);
		if(isInserted == false) {
			System.out.println("Team 추가 실패..");
		}
		System.out.println(String.format(">>%s: Team을 추가하였습니다.", name));
	}
	
	public void showTeamMembersByUserInput(Scanner scanner, MemberManager memberManager) {
		int teamID;
		Team team;
		System.out.println("<모든 Team 목록>");
		this.showAll();
		System.out.printf("- Team ID: ");
		teamID = scanner.nextInt();
		team = this.getTeamByIndex(teamID);
		if(team == null) {
			System.out.println("그런 팀은 없습니다");
			return;
		}
		System.out.println(String.format("<%s: 멤버 목록>", team.getTitle()));
		memberManager.showByTeam(team);
	}
}

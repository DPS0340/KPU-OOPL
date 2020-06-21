package mainctrl;

import java.util.Scanner;

import member.Student;
import team.Team;
import team.TeamManager;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeamManager teamManager = new TeamManager(50);
		teamManager.insert(new Team(teamManager.getNextIndex(), "아침이다"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "점심먹고"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "놀다가자"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "꿈꾼다"));
		System.out.println("디폴트 Team 목록 출력...");
		teamManager.showAll();
		System.out.printf("- Team ID:");
		int res = scanner.nextInt();
		Team found = teamManager.getTeamByIndex(res);
		if(found != null) {
			System.out.println("<<찾은 Team>>");
			found.showFormat();
		} else {
			System.out.println("찾지 못했습니다..");
		}
	}
}

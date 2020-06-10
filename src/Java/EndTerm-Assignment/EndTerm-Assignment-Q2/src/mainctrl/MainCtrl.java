package mainctrl;

import java.util.Scanner;

import member.Student;
import team.Team;
import team.TeamManager;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TeamManager teamManager = new TeamManager(50);
		teamManager.insert(new Team(teamManager.getNextIndex(), "��ħ�̴�"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "���ɸ԰�"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "��ٰ���"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "�޲۴�"));
		System.out.println("����Ʈ Team ��� ���...");
		teamManager.showAll();
		System.out.printf("- Team ID:");
		int res = scanner.nextInt();
		Team found = teamManager.getTeamByIndex(res);
		if(found != null) {
			System.out.println("<<ã�� Team>>");
			found.showFormat();
		} else {
			System.out.println("ã�� ���߽��ϴ�..");
		}
	}
}

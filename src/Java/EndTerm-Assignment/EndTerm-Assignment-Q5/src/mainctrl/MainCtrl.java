package mainctrl;

import java.util.Scanner;

import member.MemberManager;
import member.Mentor;
import member.Student;
import team.Team;
import team.TeamManager;

public class MainCtrl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberManager memberManager = new MemberManager(50);
		TeamManager teamManager = new TeamManager(50);
		teamManager.insert(new Team(teamManager.getNextIndex(), "��ħ�̴�"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "���ɸ԰�"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "��ٰ���"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "�޲۴�"));
		
		memberManager.insert(new Student(memberManager.getNextIndex(), "ȫ�л�", teamManager.getTeamByIndex(1), "����Ʈ����", 1));
		memberManager.insert(new Student(memberManager.getNextIndex(), "���л�", teamManager.getTeamByIndex(2), "���Ӱ���", 2));
		memberManager.insert(new Student(memberManager.getNextIndex(), "���л�", teamManager.getTeamByIndex(1), "��ǻ�Ͱ���", 3));
		memberManager.insert(new Mentor(memberManager.getNextIndex(), "ȫ����", teamManager.getTeamByIndex(1), "Happy co."));
		memberManager.insert(new Mentor(memberManager.getNextIndex(), "�ڸ���", teamManager.getTeamByIndex(3), "(��)�ູ"));

		int res;
		while (true) {
			res = MainMenu.issueMenu(scanner);
			switch (res) {
			case 0:
				System.out.println("���α׷� ����");
				return;
			case 1:
				System.out.println("<�л� ��� �߰�>");
				memberManager.insertStudentWithUserInput(scanner, teamManager);
				break;
			case 2:
				System.out.println("<�л� ��� ���>");
				memberManager.showStudents();
				break;
			case 3:
				System.out.println("<���� ��� �߰�>");
				memberManager.insertMentorWithUserInput(scanner, teamManager);
				break;
			case 4:
				System.out.println("<���� ��� ���>");
				memberManager.showMentors();
				break;
			case 5:
				System.out.println("<��� ��ȸ>");
				memberManager.findMemberWithUserInput(scanner);
				break;
			case 6:
				System.out.println("<��� ��� ���>");
				memberManager.showAll();
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}

package mainctrl;

import java.util.Scanner;

import member.MemberManager;
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
		int res;
		while (true) {
			res = MainMenu.issueMenu(scanner);
			switch (res) {
			case 0:
				System.out.println("���α׷� ����");
				return;
			case 1:
				int id = memberManager.getNextIndex();
				int year, teamID;
				String name, major;
				Team team;
				System.out.println("<�л� ��� �߰�>");
				System.out.println(String.format(" - ID: %d", id));
				System.out.printf(" - �̸�: ");
				name = scanner.next();
				System.out.printf(" - ����: ");
				major = scanner.next();
				System.out.printf(" - �г�: ");
				year = scanner.nextInt();
				teamManager.showAll();
				System.out.printf(" - Team ID: ");
				teamID = scanner.nextInt();
				team = teamManager.getTeamByIndex(teamID);
				if(team == null) {
					System.out.println("�׷� ���� �����ϴ�.");
					break;
				}
				Student student = new Student(id, name, team, major, year);
				boolean isInserted = memberManager.insert(student);
				
				if(isInserted == false) {
					System.out.println("�л� �߰��� �����߽��ϴ�");
					break;
				}
				
				System.out.println(String.format("=> %s: �л��� �߰��߽��ϴ�", name));
				break;
			case 2:
				System.out.println("<�л� ��� ���>");
				memberManager.showStudents();
				break;
			case 3:
				System.out.println("�̱���");
				break;
			case 4:
				System.out.println("�̱���");
				break;
			case 5:
				System.out.println("�̱���");
				break;
			case 6:
				System.out.println("�̱���");
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}

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
		teamManager.insert(new Team(teamManager.getNextIndex(), "아침이다"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "점심먹고"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "놀다가자"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "꿈꾼다"));
		
		memberManager.insert(new Student(memberManager.getNextIndex(), "홍학생", teamManager.getTeamByIndex(1), "소프트웨어", 1));
		memberManager.insert(new Student(memberManager.getNextIndex(), "김학생", teamManager.getTeamByIndex(2), "게임공학", 2));
		memberManager.insert(new Student(memberManager.getNextIndex(), "박학생", teamManager.getTeamByIndex(1), "컴퓨터공학", 3));
		int res;
		while (true) {
			res = MainMenu.issueMenu(scanner);
			switch (res) {
			case 0:
				System.out.println("프로그램 종료");
				return;
			case 1:
				int id = memberManager.getNextIndex();
				int year, teamID;
				String name, major;
				Team team;
				System.out.println("<학생 멤버 추가>");
				System.out.println(String.format(" - ID: %d", id));
				System.out.printf(" - 이름: ");
				name = scanner.next();
				System.out.printf(" - 전공: ");
				major = scanner.next();
				System.out.printf(" - 학년: ");
				year = scanner.nextInt();
				teamManager.showAll();
				System.out.printf(" - Team ID: ");
				teamID = scanner.nextInt();
				team = teamManager.getTeamByIndex(teamID);
				if(team == null) {
					System.out.println("그런 팀은 없습니다.");
					break;
				}
				Student student = new Student(id, name, team, major, year);
				boolean isInserted = memberManager.insert(student);
				
				if(isInserted == false) {
					System.out.println("학생 추가에 실패했습니다");
					break;
				}
				
				System.out.println(String.format("=> %s: 학생을 추가했습니다", name));
				break;
			case 2:
				System.out.println("<학생 멤버 목록>");
				memberManager.showStudents();
				break;
			case 3:
				System.out.println("미구현");
				break;
			case 4:
				System.out.println("미구현");
				break;
			case 5:
				System.out.println("미구현");
				break;
			case 6:
				System.out.println("미구현");
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}

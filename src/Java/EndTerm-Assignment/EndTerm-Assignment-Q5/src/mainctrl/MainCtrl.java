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
		teamManager.insert(new Team(teamManager.getNextIndex(), "아침이다"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "점심먹고"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "놀다가자"));
		teamManager.insert(new Team(teamManager.getNextIndex(), "꿈꾼다"));
		
		memberManager.insert(new Student(memberManager.getNextIndex(), "홍학생", teamManager.getTeamByIndex(1), "소프트웨어", 1));
		memberManager.insert(new Student(memberManager.getNextIndex(), "김학생", teamManager.getTeamByIndex(2), "게임공학", 2));
		memberManager.insert(new Student(memberManager.getNextIndex(), "박학생", teamManager.getTeamByIndex(1), "컴퓨터공학", 3));
		memberManager.insert(new Mentor(memberManager.getNextIndex(), "홍멘토", teamManager.getTeamByIndex(1), "Happy co."));
		memberManager.insert(new Mentor(memberManager.getNextIndex(), "박멘토", teamManager.getTeamByIndex(3), "(주)행복"));

		int res;
		while (true) {
			res = MainMenu.issueMenu(scanner);
			switch (res) {
			case 0:
				System.out.println("프로그램 종료");
				return;
			case 1:
				System.out.println("<학생 멤버 추가>");
				memberManager.insertStudentWithUserInput(scanner, teamManager);
				break;
			case 2:
				System.out.println("<학생 멤버 목록>");
				memberManager.showStudents();
				break;
			case 3:
				System.out.println("<멘토 멤버 추가>");
				memberManager.insertMentorWithUserInput(scanner, teamManager);
				break;
			case 4:
				System.out.println("<멘토 멤버 목록>");
				memberManager.showMentors();
				break;
			case 5:
				System.out.println("<멤버 조회>");
				memberManager.findMemberWithUserInput(scanner);
				break;
			case 6:
				System.out.println("<모든 멤버 목록>");
				memberManager.showAll();
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}

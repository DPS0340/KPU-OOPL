package member;

import java.util.Scanner;

import team.Team;
import team.TeamManager;

public class MemberManager {
	Member[] memberList;
	int index;
	int max_length;
	
	public MemberManager(int length) {
		index = 0;
		max_length = length;
		memberList = new Member[length];
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public boolean insert(Member elem) {
		if(index >= max_length) {
			return false;
		}
		memberList[index++] = elem;
		return true;
	}
	
	public Member getMemberByIndex(int idx) {
		if(idx > index) {
			return null;
		}
		return memberList[idx-1];
	}
	
	public Member getMemberByName(String name) {
		for(int i=0;i<index;i++) {
			if(memberList[i].getName().equals(name)) {
				return memberList[i];
			}
		}
		return null;
	}
	
	public void showAll() {
		System.out.println("------------------------------------");
		System.out.println("구분   ID   이름     Team    전공/회사      학년");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			memberList[i].showWithType();
		}
		System.out.println("------------------------------------");
	}
	
	public void showStudents() {
		System.out.println("------------------------------------");
		System.out.println("ID   이름     Team    전공           학년");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			if(memberList[i] instanceof Student) {
				memberList[i].show();
			}
		}
		System.out.println("------------------------------------");
	}
	
	public void showMentors() {
		System.out.println("------------------------------------");
		System.out.println("ID   이름     Team    전공           학년");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			if(memberList[i] instanceof Mentor) {
				memberList[i].show();
			}
		}
		System.out.println("------------------------------------");
	}
	
	public void findMemberWithUserInput(Scanner scanner) {
		String name;
		System.out.printf("- 이름: ");
		name = scanner.next();
		Member found = getMemberByName(name);
		if(found == null) {
			System.out.println("그런 멤버는 없습니다.");
			return;
		}
		System.out.println("<찾은 멤버>");
		found.showFormatWithType();
	}
	
	public void insertStudentWithUserInput(Scanner scanner, TeamManager teamManager) {
		int id = this.getNextIndex();
		int year, teamID;
		String name, major;
		Team team;
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
			return;
		}
		Student student = new Student(id, name, team, major, year);
		boolean isInserted = this.insert(student);
		
		if(isInserted == false) {
			System.out.println("학생 추가에 실패했습니다");
			return;
		}
		
		System.out.println(String.format("=> %s: 학생을 추가했습니다", name));
	}
	
	public void insertMentorWithUserInput(Scanner scanner, TeamManager teamManager) {
		int id = this.getNextIndex();
		int teamID;
		String name, org;
		Team team;
		System.out.println(String.format(" - ID: %d", id));
		System.out.printf(" - 이름: ");
		name = scanner.next();
		System.out.printf(" - 회사: ");
		org = scanner.next();
		teamManager.showAll();
		System.out.printf(" - Team ID: ");
		teamID = scanner.nextInt();
		team = teamManager.getTeamByIndex(teamID);
		if(team == null) {
			System.out.println("그런 팀은 없습니다.");
			return;
		}
		Mentor student = new Mentor(id, name, team, org);
		boolean isInserted = this.insert(student);
		
		if(isInserted == false) {
			System.out.println("멘토 추가에 실패했습니다");
			return;
		}
		
		System.out.println(String.format("=> %s: 멘토를 추가했습니다", name));
	}
}

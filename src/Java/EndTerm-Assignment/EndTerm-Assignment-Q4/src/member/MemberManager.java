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
	
	public void showAll() {
		System.out.println("------------------------------------");
		System.out.println("ID   �̸�     Team    ����/ȸ��      �г�");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			memberList[i].show();
		}
		System.out.println("------------------------------------");
	}
	
	public void showStudents() {
		System.out.println("------------------------------------");
		System.out.println("ID   �̸�     Team    ����           �г�");
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
		System.out.println("ID   �̸�     Team    ����           �г�");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			if(memberList[i] instanceof Mentor) {
				memberList[i].show();
			}
		}
		System.out.println("------------------------------------");
	}
	
	public void insertStudentWithUserInput(Scanner scanner, TeamManager teamManager) {
		int id = this.getNextIndex();
		int year, teamID;
		String name, major;
		Team team;
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
			return;
		}
		Student student = new Student(id, name, team, major, year);
		boolean isInserted = this.insert(student);
		
		if(isInserted == false) {
			System.out.println("�л� �߰��� �����߽��ϴ�");
			return;
		}
		
		System.out.println(String.format("=> %s: �л��� �߰��߽��ϴ�", name));
	}
	
	public void insertMentorWithUserInput(Scanner scanner, TeamManager teamManager) {
		int id = this.getNextIndex();
		int teamID;
		String name, org;
		Team team;
		System.out.println(String.format(" - ID: %d", id));
		System.out.printf(" - �̸�: ");
		name = scanner.next();
		System.out.printf(" - ȸ��: ");
		org = scanner.next();
		teamManager.showAll();
		System.out.printf(" - Team ID: ");
		teamID = scanner.nextInt();
		team = teamManager.getTeamByIndex(teamID);
		if(team == null) {
			System.out.println("�׷� ���� �����ϴ�.");
			return;
		}
		Mentor student = new Mentor(id, name, team, org);
		boolean isInserted = this.insert(student);
		
		if(isInserted == false) {
			System.out.println("���� �߰��� �����߽��ϴ�");
			return;
		}
		
		System.out.println(String.format("=> %s: ���並 �߰��߽��ϴ�", name));
	}
}

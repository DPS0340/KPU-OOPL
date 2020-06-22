package kpu.subjclass;

import java.util.Scanner;

import kpu.member.Member;
import kpu.member.MemberList;

public class ClassManager {
	SubjectClass[] scList;
	int max_length;
	int index;
	
	public ClassManager(int length) {
		scList = new SubjectClass[length];
		index = 0;
		this.max_length = length;
	}
	
	public boolean insert(SubjectClass subj) {
		if(index >= max_length) {
			return false;
		}
		scList[index++] = subj;
		return true;
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public SubjectClass getElemByIndex(int idx) {
		if(idx - 1 >= index) {
			return null;
		}
		return scList[idx-1];
	}
	
	public void showAll() {
		System.out.println("--------------------");
		System.out.println("ID   클래스   이름");
		System.out.println("--------------------");
		for(int i=0;i<index;i++) {
			scList[i].showData();
		}
		System.out.println("--------------------");
	}
	
	public void insertClassWithUserInput(Scanner scanner) {
		int id = getNextIndex();
		String title;
		System.out.println(String.format("- ID: %d", id));
		System.out.printf("- 타이틀: ");
		title = scanner.next();
		boolean res = insert(new SubjectClass(id, title));
		if(!res) {
			System.out.println("클래스 추가 실패..");
		} else {
			System.out.println(String.format(">>%s: 클래스 추가", title));
		}
	}
	
	public void showClassComponentsWithUserInput(Scanner scanner) {
		showAll();
		System.out.printf(" - 클래스 ID: ");
		int id = scanner.nextInt();
		if(id > getNextIndex() || id <= 0) {
			System.out.println("그런 클래스는 없습니다.");
			return;
		}
		id--;
		System.out.println(String.format("[%s: 구성원 목록]", scList[id].getSubject()));
		scList[id].showAll();
	}
	
	public void insertClassComponentWithUserInput(Scanner scanner, MemberList memberList) {
		showAll();
		System.out.printf(" - 클래스 ID: ");
		int id = scanner.nextInt();
		if(id >= getNextIndex() || id <= 0) {
			System.out.println("그런 클래스는 없습니다.");
			return;
		}
		id--;
		memberList.showAll();
		int res;
		int cnt = 0;
		while(true) {
			System.out.printf(" - 구성원 ID(0=끝내기): ");
			res = scanner.nextInt();
			if(res == 0) {
				System.out.println(String.format(">> %s 클래스에 구성원 %d명 추가", scList[id].getSubject(), cnt));
				break;
			}
			if(res >= memberList.getNextIndex() || res < 0) {
				System.out.println("그런 구성원은 없습니다.");
				continue;
			}
			Member member = memberList.getMemberByIndex(res);
			if(scList[id].getMemberByName(member.getName()) != null) {
				System.out.println("이미 있는 구성원입니다.");
				continue;
			}
			boolean isInserted = scList[id].insert(member);
			if(!isInserted) {
				System.out.println("구성원 추가 실패...");
				System.out.println(String.format(">> %s 클래스에 구성원 %d명 추가", scList[id].getSubject(), cnt));
				break;
			}
			cnt++;
		}
	}
	
	public void showAllComponents() {
		for(int i=0;i<index;i++) {
			System.out.println(String.format("[%d %s: 구성원 목록]", scList[i].getID(), scList[i].getSubject()));
			scList[i].showAll();
			System.out.println("");
		}
	}
}

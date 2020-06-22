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
		System.out.println("ID   Ŭ����   �̸�");
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
		System.out.printf("- Ÿ��Ʋ: ");
		title = scanner.next();
		boolean res = insert(new SubjectClass(id, title));
		if(!res) {
			System.out.println("Ŭ���� �߰� ����..");
		} else {
			System.out.println(String.format(">>%s: Ŭ���� �߰�", title));
		}
	}
	
	public void showClassComponentsWithUserInput(Scanner scanner) {
		showAll();
		System.out.printf(" - Ŭ���� ID: ");
		int id = scanner.nextInt();
		if(id > getNextIndex() || id <= 0) {
			System.out.println("�׷� Ŭ������ �����ϴ�.");
			return;
		}
		id--;
		System.out.println(String.format("[%s: ������ ���]", scList[id].getSubject()));
		scList[id].showAll();
	}
	
	public void insertClassComponentWithUserInput(Scanner scanner, MemberList memberList) {
		showAll();
		System.out.printf(" - Ŭ���� ID: ");
		int id = scanner.nextInt();
		if(id >= getNextIndex() || id <= 0) {
			System.out.println("�׷� Ŭ������ �����ϴ�.");
			return;
		}
		id--;
		memberList.showAll();
		int res;
		int cnt = 0;
		while(true) {
			System.out.printf(" - ������ ID(0=������): ");
			res = scanner.nextInt();
			if(res == 0) {
				System.out.println(String.format(">> %s Ŭ������ ������ %d�� �߰�", scList[id].getSubject(), cnt));
				break;
			}
			if(res >= memberList.getNextIndex() || res < 0) {
				System.out.println("�׷� �������� �����ϴ�.");
				continue;
			}
			Member member = memberList.getMemberByIndex(res);
			if(scList[id].getMemberByName(member.getName()) != null) {
				System.out.println("�̹� �ִ� �������Դϴ�.");
				continue;
			}
			boolean isInserted = scList[id].insert(member);
			if(!isInserted) {
				System.out.println("������ �߰� ����...");
				System.out.println(String.format(">> %s Ŭ������ ������ %d�� �߰�", scList[id].getSubject(), cnt));
				break;
			}
			cnt++;
		}
	}
	
	public void showAllComponents() {
		for(int i=0;i<index;i++) {
			System.out.println(String.format("[%d %s: ������ ���]", scList[i].getID(), scList[i].getSubject()));
			scList[i].showAll();
			System.out.println("");
		}
	}
}

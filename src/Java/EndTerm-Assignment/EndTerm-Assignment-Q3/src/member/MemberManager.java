package member;

import java.util.Scanner;

import team.Team;

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
		System.out.println("ID   이름     Team    전공           학년");
		System.out.println("------------------------------------");
		for(int i=0;i<index;i++) {
			memberList[i].show();
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
}

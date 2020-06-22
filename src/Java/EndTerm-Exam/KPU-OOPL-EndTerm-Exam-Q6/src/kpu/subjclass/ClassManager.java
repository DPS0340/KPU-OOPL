package kpu.subjclass;

import java.util.Scanner;

public class ClassManager {
	SubjectClass[] arr;
	int max_length;
	int index;
	
	public ClassManager(int length) {
		arr = new SubjectClass[length];
		index = 0;
		this.max_length = length;
	}
	
	public boolean insert(SubjectClass subj) {
		if(index >= max_length) {
			return false;
		}
		arr[index++] = subj;
		return true;
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public void showAll() {
		System.out.println("--------------------");
		System.out.println("ID   클래스   이름");
		System.out.println("--------------------");
		for(int i=0;i<index;i++) {
			arr[i].showData();
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
}

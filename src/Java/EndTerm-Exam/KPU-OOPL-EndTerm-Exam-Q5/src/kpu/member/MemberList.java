package kpu.member;

import java.util.Scanner;

public class MemberList {
	Member[] arr;
	int index;
	int max_length;
	
	public MemberList(int length) {
		index = 0;
		arr = new Member[length];
		this.max_length = length;
	}
	
	public int getNextIndex() {
		return index + 1;
	}
	
	public void insertStudentByUserInput(Scanner scanner) {
		int id = getNextIndex();
		int year;
		String name, major;
		System.out.println(String.format(" - ID = %d", id));
		System.out.printf(" - 이름: ");
		name = scanner.next();
		System.out.printf(" - 전공: ");
		major = scanner.next();
		System.out.printf(" - 학년: ");
		year = scanner.nextInt();
		
		boolean res = insert(new Student(id, name, major, year));
		if(!res) {
			System.out.println("학생 추가에 실패했습니다.");
		} else {
			System.out.println(String.format("=> %s: 학생으로 추가했습니다.", name));
		}
	}
	
	public void insertProfessorByUserInput(Scanner scanner) {
		int id = getNextIndex();
		String name, org;
		System.out.println(String.format(" - ID = %d", id));
		System.out.printf(" - 이름: ");
		name = scanner.next();
		System.out.printf(" - 소속: ");
		org = scanner.next();
		
		boolean res = insert(new Professor(id, name, org));
		if(!res) {
			System.out.println("교수 추가에 실패했습니다.");
		} else {
			System.out.println(String.format("=> %s: 교수로 추가했습니다.", name));
		}
	}
	
	public boolean insert(Member member) {
		if(index >= max_length) {
			return false;
		}
		arr[index++] = member;
		return true;
	}
	
	public void showStudents() {
		System.out.println("----------------------");
		System.out.println("ID    이름      전공       학년");
		System.out.println("----------------------");
		for(int i=0;i<index;i++) {
			if(arr[i] instanceof Student) {
				arr[i].showData();
			}
		}
		System.out.println("----------------------");
	}
	
	public void showProfessors() {
		System.out.println("----------------------");
		System.out.println("ID    이름      소속");
		System.out.println("----------------------");
		for(int i=0;i<index;i++) {
			if(arr[i] instanceof Professor) {
				arr[i].showData();
			}
		}
		System.out.println("----------------------");
	}
	
	public void showAll() {
		System.out.println("----------------------");
		System.out.println("구분    ID    이름      전공/소속       학년");
		System.out.println("----------------------");
		for(int i=0;i<index;i++) {
			arr[i].showWithType();
		}
		System.out.println("----------------------");
	}
	public Member getMemberByIndex(int idx) {
		if(idx-1 >= index) {
			return null;
		}
		return arr[idx-1];
	}
	public Member getMemberByName(String name) {
		for(int i=0;i<index;i++) {
			if(arr[i].getName().equals(name)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public void findElemByUserInput(Scanner scanner) {
		System.out.println(" - 이름?: ");
		String name = scanner.next();
		Member res = getMemberByName(name);
		if(res == null) {
			System.out.println("찾지 못했습니다.");
		} else {
			System.out.println("<찾은 구성원>");
			res.showWithTypeAndFormat();
		}
	}
}

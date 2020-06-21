
public class Q1 {
	public static void main(String[] args) {
		Contact hongContact = new Contact("홍길동", "kdhong@kpu.ac.kr", "고딩친구");
		
		System.out.println("-----------------------------------");
		System.out.println("이름            이메일                그룹");
		System.out.println("-----------------------------------");
		hongContact.showData();
		System.out.println("-----------------------------------");
	}
}

package kpu.subjclass;
import kpu.app.show.Showable;

public class SubjectClass implements Showable {
	private int id;
	private String name;
	public SubjectClass(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getID() {
		return id;
	}
	public String getString() {
		return name;
	}
	@Override
	public void showData() {
		System.out.println(String.format("%d     %s", id, name));
	}
	@Override
	public void showWithFormat() {
		System.out.println("--------------------");
		System.out.println("ID   클래스   이름");
		System.out.println("--------------------");
		showData();
		System.out.println("--------------------");
	}
	@Override
	public void showWithType() {
		showData();
	}
	@Override
	public void showWithTypeAndFormat() {
		showWithFormat();
	}
}

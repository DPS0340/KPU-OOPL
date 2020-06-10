package geometry;

public class Circle implements Transformable {
	public int x, y, radius;
	public Circle(int radius) {
		this.x = 0;
		this.y = 0;
		this.radius = radius;
	}
	public Circle(int x, int y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void moveBy(int xOffset, int yOffset) {
		this.x += xOffset;
		this.y += yOffset;
	}

	@Override
	public void resize(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return radius * radius * 3.14;
	}
	
}

package Transporteur1;

public class Dimension {

	public int length, width, height;

	public Dimension() {
		this.length = 0;
		this.width = 0;
		this.height = 0;
	}

	public Dimension(int length, int width, int height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public int volume() {
		return length * width * height;
	}
}

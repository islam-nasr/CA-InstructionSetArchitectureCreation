package memory;

public class Register {
	private int value;
	private String name;

	public Register(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {

		return (this.name + " : " + this.value);
	}

}

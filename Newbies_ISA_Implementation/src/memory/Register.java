package memory;

public class Register {
	private int value;
	private String name;

	public Register(int value) {
		this.value = value;
	}

	public Register(String name, int value) {
		this.value = value;
		this.name = name;
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

	@Override
	public String toString() {
		if (this.name == "$zero")
			return (this.name + " : " + this.value);
		else if (this.name == "$one")
			return (this.name + "  : " + this.value);
		else
			return (this.name + "   : " + this.value);
	}

}

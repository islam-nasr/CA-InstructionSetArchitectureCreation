package memory;

public class RegisterFile {
	Register[] registers;

	public RegisterFile() {
		registers = new Register[16];
		for (int i = 0; i < registers.length; i++) {
			registers[i] = new Register(16);
		}
	}

	public Register[] getRegisters() {
		return registers;
	}

	public void setRegisters(Register[] registers) {
		this.registers = registers;
	}

	public Register readRegister(int index) {
		return registers[index];
	}
	public int readRegisterValue(int index) {
		return registers[index].getValue();
	}

	public void writeRegister(int index, int value) {
		registers[index].setValue(value);
	}

	public String toString() {
		String r = "";
		for (int i = 0; i < 16; i++)
			r += registers[i].toString() + "\n";
		return r;
	}
}

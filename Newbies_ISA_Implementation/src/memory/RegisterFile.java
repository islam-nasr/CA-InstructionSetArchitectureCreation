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

	public void initialize() {
		Register[] registers = new Register[16];
		for (int i = 0; i < registers.length; i++) {
			registers[i] = new Register(16);
		}
		registers[0].setName("$zero");
		registers[1].setName("$one");
		registers[2].setName("$sp");
		registers[3].setName("$ra");
		registers[4].setName("$s0");
		registers[5].setName("$s1");
		registers[6].setName("$s2");
		registers[7].setName("$s3");
		registers[8].setName("$t0");
		registers[9].setName("$t1");
		registers[10].setName("$t2");
		registers[11].setName("$t3");
		registers[12].setName("$a0");
		registers[13].setName("$a1");
		registers[14].setName("$a2");
		registers[15].setName("$v0");
		setRegisters(registers);

	}
}

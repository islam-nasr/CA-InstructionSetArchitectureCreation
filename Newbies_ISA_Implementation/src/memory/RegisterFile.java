package memory;

public class RegisterFile {
	static Register[] registers;

	public RegisterFile() {
		registers = new Register[16];
		for (int i = 0; i < registers.length; i++) {
			if (i == 1)
				registers[i] = new Register(1);
			else
				registers[i] = new Register(0);
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
	}

	/**
	 * reads complete register from the registers array
	 * 
	 * @param index
	 *            the register number to return
	 * @return the register
	 */
	public Register readRegister(int index) {
		return registers[index];
	}

	/**
	 * reads a value from a register
	 * 
	 * @param index
	 *            the register number to read that value at
	 * @return the value in the register
	 */
	public static int readRegisterValue(int index) {
		return registers[index].getValue();
	}

	/**
	 * writes a value into a register
	 * 
	 * @param index
	 *            the register number to write that value at
	 * @param value
	 *            the value being written in the register
	 */
	public static void writeRegister(int index, int value) {
		registers[index].setValue(value);
	}

	public static void toPrint() {
		// TODO Auto-generated method stub
		String r = "Register File Being Printed: " + "\n";
		for (int i = 0; i < 16; i++)
			r += registers[i].toString() + "\n";
		System.out.println(r);

	}
}

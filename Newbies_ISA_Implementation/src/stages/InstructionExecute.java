package stages;

import alu.ALU;
import alu.ALU_Controller;
import alu.MUXsim;
import memory.ControlUnit;

public class InstructionExecute extends Stage {
	private String result;

	private ControlUnit control;
	private int readData1;
	private int readData2;
	private String signExtend;
	private int writeRegisterNumber;
	
	public InstructionExecute(ControlUnit control, int readData1, int readData2, String signExtend, int writeRegisterNumber) {
		super();
		this.control = control;
		this.readData1 = readData1;
		this.readData2 = readData2;
		this.signExtend = signExtend;
		this.writeRegisterNumber=writeRegisterNumber;
	}

	public void execute() {
		System.out.println("Executing executing....");
		int ALUSrc = control.getALUSrc();
		int not = control.getNot();
		String ALUControl = ALU_Controller.getALUoperation("hi");

		String first = MUXsim.MUX(Integer.toBinaryString(readData2), signExtend, ALUSrc);
		String second = MUXsim.MUX(first, "0000000000000000", not);

		ALU alu = new ALU();
		alu.operate(ALUControl, readData1, Integer.parseInt(second, 2));

		this.result = Integer.toBinaryString(alu.getResult());
	}

	public String getResult() {
		return result;
	}

	public ControlUnit getControl() {
		return control;
	}

	public int getReadData1() {
		return readData1;
	}

	public int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

}

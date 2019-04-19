package stages;

import alu.ALU;
import alu.ALU_Controller;
import alu.MUXsim;
import memory.ControlUnit;

public class InstructionExecute extends Stage {
	String name = "Ex";

	public InstructionExecute() {
		super();
	}

	public void execute() {

	}

	public void execute(int readData1, int readData2, int signExtended, ControlUnit control) {
		System.out.println("Executing executing....");
		int ALUSrc = control.getALUSrc();
		int not = control.getNot();
		String ALUControl = ALU_Controller.getALUoperation("hi");

		String first = MUXsim.MUX(Integer.toBinaryString(readData2), Integer.toBinaryString(signExtended), ALUSrc);
		String second = MUXsim.MUX(first, "0000000000000000", not);

		ALU alu = new ALU();
		alu.operate(ALUControl, readData1, Integer.parseInt(second, 2));

		int result = alu.getResult();
	}

}

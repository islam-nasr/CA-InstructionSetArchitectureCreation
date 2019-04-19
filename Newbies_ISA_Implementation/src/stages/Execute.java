package stages;

import alu.ALU;
import alu.ALU_Controller;
import alu.MUXsim;
import memory.ControlUnit;

public class Execute {
	public static int ExecuteStage(int input1, int input2, ControlUnit control) {
		int ALUSrc = control.getALUSrc();
		int not = control.getNot();
		String ALUControl = ALU_Controller.alucontrol("hi");

		String first = MUXsim.MUX(Integer.toBinaryString(input1), Integer.toBinaryString(input2), ALUSrc);
		String second = MUXsim.MUX(first, "0000000000000000", not);

		ALU alu = new ALU();
		alu.Operation(ALUControl, input1, Integer.parseInt(second, 2));

		int result = alu.getResult();
		return result;
	}
}

package test;

import memory.RegisterFileInitialization;
import stages.InstructionIntialization;
import stages.InstructionsFetch;

import java.io.IOException;

import alu.integerConverter;
import memory.InstructionMemory;

public class testingfetching {
	public static void main(String[] args) {
		// we must initialize the Instructions and registers first
		InstructionIntialization.initialize();
		RegisterFileInitialization.initialize();
		try {
			InstructionsFetch.readInstructions("src/trial.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
		}

		for (int i = 0; i < InstructionMemory.numberOfInstructions; i++) {
			String instruction = InstructionsFetch.fetchInstruction(i);
			String signExtend = instruction.substring(instruction.length() - 8, instruction.length());
			boolean positive = true;
			if (signExtend.charAt(0) == '1') {
				positive = false;
			}
			while (signExtend.length() < 16) {
				if (positive)
					signExtend = "0" + signExtend;
				else
					signExtend = "1" + signExtend;

			}
			System.out.println(integerConverter.getTwosComplement(signExtend));
			System.out.println(instruction + '\n' + signExtend);
		}
	}
}

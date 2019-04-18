package test;

import memory.RegisterFileInitialization;
import stages.InstructionIntialization;
import stages.InstructionsFetch;

import java.io.IOException;

import memory.InstructionMemory;

public class testingfetching {
	public static void main(String[] args) {
		//we must initialize the Instructions and registers first
		InstructionIntialization.initialize();
		RegisterFileInitialization.initialize();
		try {
			InstructionsFetch.readInstructions("src/trial.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("FILE NOT FOUND");
		}

		for (int i = 0; i < InstructionMemory.numberOfInstructions; i++) {
			String x = Integer.toBinaryString(InstructionMemory.getInstruction(i * 2));
			while (x.length() < 16) {
				x = "0" + x;
			}
			System.out.println(x);
		}
	}
}

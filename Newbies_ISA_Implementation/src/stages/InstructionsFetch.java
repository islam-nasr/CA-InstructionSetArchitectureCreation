package stages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import memory.InstructionMemory;
import memory.RegisterFileInitialization;

public class InstructionsFetch {

	public static void readInstructions() throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File("program.txt")));
		String line = bf.readLine();
		int i = 0;
		while (line != null) {
			InstructionMemory.instructions[i] = parse(line);
			i++;
			line = bf.readLine();
		}

	}

	public static int parse(String line) {
		String[] parts = line.split(" ");
		HashMap<String, Integer> bitStrings = InstructionIntialization.bitStrings;
		HashMap<String, String> StringType = InstructionIntialization.StringType;
		HashMap<String, Integer> regStrings = RegisterFileInitialization.regStrings;

		int instruction = 0;
		if (parts[0].charAt(0) == '1' || parts[0].charAt(0) == '0') {
			instruction = Integer.parseInt(parts[0], 2);
		} else {
			int function = bitStrings.get(parts[0]) << 12;
			if (StringType.get(parts[0]).equals("R")) {

				String rdName = parts[1];
				int rd = regStrings.get(rdName) << 8;

				String rsName = parts[2];
				int rs = regStrings.get(rsName) << 4;

				String rtName = parts[3];
				int rt = regStrings.get(rtName);
				instruction = function | rd | rs | rt;

			} else {
				if (StringType.get(parts[0]).equals("J")) {
					int offset = Integer.parseInt(parts[1], 2);
					instruction = function | offset;// we will handle this error later
				} else {
					String rdName = parts[1];
					int rd = regStrings.get(rdName) << 8;

					int immediate = Integer.parseInt(parts[2], 2);
					instruction = function | rd | immediate;

				}
			}
		}

		return instruction;
	}

	public static void main(String[] args) {
		String x = "0011";
		int y = Integer.parseInt(x, 2) << 12;
		String x2 = "1111";
		int y2 = Integer.parseInt(x2, 2) << 8;

		System.out.println(Integer.toBinaryString(y | y2));
		System.out.println(Integer.toBinaryString(y >> 12));

	}
}

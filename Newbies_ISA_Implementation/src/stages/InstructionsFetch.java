package stages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import memory.InstructionMemory;

public class InstructionsFetch {

	public static void readInstructions() throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File("program.txt")));
		String line = bf.readLine();
		int i = 0;
		while (line != null) {
			int lineInt = parse(line);
		}

	}

	public static int parse(String line) {
		String[] parts = line.split(" ");
		HashMap<String, Integer> bitStrings = InstructionIntialization.bitStrings;
		int instruction = 0;
		if (parts[0].charAt(0) == '1' || parts[0].charAt(0) == '0') {
			instruction = Integer.parseInt(parts[0], 2);
		} else {
			int function = bitStrings.get(parts[0]) << 12;

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

package stages;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import alu.integerConverter;
import memory.InstructionMemory;
import memory.RegisterFileInitialization;

public class InstructionFetch extends Stage {
	String inst;

	public InstructionFetch() {
		super();
	}

	public String execute(int i) {
		System.out.println("Executing fetching........");
		String instruction = Integer.toBinaryString(InstructionMemory.getInstruction(i));
		while (instruction.length() < 16) {
			instruction = "0" + instruction;
		}
		inst = instruction;
		this.toPrint();
		return instruction;

	}

	/***
	 * reads the instructions and writes them to the instruction memory
	 * 
	 * @param filePath
	 *            takes the path of the instructions we want to execute
	 **
	 */
	public static void readInstructions(String filePath) throws IOException {
		BufferedReader bf = new BufferedReader(new FileReader(new File(filePath)));
		String line = bf.readLine();
		int i = 0;
		while (line != null) {
			InstructionMemory.setInstruction(i, parse(line));
			i += 2;
			line = bf.readLine();
		}
		bf.close();
	}

	/***
	 * takes the line of code to translate it to binary code to be written to the
	 * instruction memory
	 * 
	 * @param line
	 *            code currently being decoded
	 * @return the int value of the binary code
	 **
	 */
	public static int parse(String line) {
		String[] parts = line.split(" ");
		HashMap<String, Integer> bitStrings = InstructionIntialization.bitStrings;
		HashMap<String, String> StringType = InstructionIntialization.StringType;
		HashMap<String, Integer> regStrings = RegisterFileInitialization.regStrings;
		int instruction = 0;
		if (line.equals("WAIT")) {
			parts[0] = "0011000000000000";
		}
		if (parts[0].charAt(0) == '1' || parts[0].charAt(0) == '0') {
			instruction = Integer.parseInt(parts[0], 2);
		} else {
			int function = bitStrings.get(parts[0]) << 12;
			if (StringType.get(parts[0]).equals("R")) {
				if (bitStrings.get(parts[0]) == Integer.parseInt("1001", 2)) {
					String rsName = parts[1];
					int rs = regStrings.get(rsName) << 8;
					instruction = function | rs;
				} else {
					if (bitStrings.get(parts[0]) == Integer.parseInt("1111", 2)
							|| bitStrings.get(parts[0]) == Integer.parseInt("0111", 2)) {
						String rsName = parts[1];
						int rs = regStrings.get(rsName) << 8;

						String rtName = parts[2];
						int rt = regStrings.get(rtName) << 4;
						instruction = function | rs | rt;

					} else {

						String rdName = parts[1];
						int rd = regStrings.get(rdName) << 8;

						String rsName = parts[2];
						int rs = regStrings.get(rsName) << 4;

						String rtName = parts[3];
						int rt = regStrings.get(rtName);
						instruction = function | rd | rs | rt;

					}
				}
			} else {
				if (StringType.get(parts[0]).equals("J")) {
					int offset = Integer.parseInt(parts[1]);
					instruction = function | offset;// we will handle this error later in decoding (HOP AND HAT)
				}
				// I TYPE
				else {
					String rdName = parts[1];
					int rdNumber = regStrings.get(rdName) << 8;
					// immediate is 16 bits. needs to be changed to 8
					byte immediate = Byte.parseByte(parts[2]);
					String immediateTrimmed = integerConverter.toBinaryString(immediate).substring(8);
					// updating the immediate after trimming the first 8 bits
					immediate = (byte) integerConverter.getTwosComplement(immediateTrimmed);
					instruction = Integer.parseInt(integerConverter.artificialOR(function, rdNumber, immediateTrimmed),
							2);
				}
			}
		}

		return instruction;
	}

	public void toPrint() {
		// TODO Auto-generated method stub
		System.out.println("Fetch stage  got instruction: " + inst);
	}
}

package simulation;

import java.io.IOException;
import java.util.Vector;

import memory.ControlUnit;
import memory.InstructionMemory;
import memory.Register;
import memory.RegisterFile;
import memory.RegisterFileInitialization;
import stages.InstructionDecode;
import stages.InstructionExecute;
import stages.InstructionFetch;
import stages.InstructionIntialization;
import stages.MemoryStage;
import stages.Stage;
import stages.WriteBackStage;

public class Simulator {
	static Vector<Stage> processes = new Vector<Stage>(6);
	static Register PC = new Register("PC", 0);

	public static void main(String[] args) {
		InstructionIntialization.initialize();
		RegisterFileInitialization.initialize();
		new RegisterFile();
		try {
			InstructionFetch.readInstructions("src/trial.txt");
		} catch (IOException e) {
			System.out.println("mesh la2y om el file");
		}

		int clockcycles = 1;
		while (PC.getValue() < InstructionMemory.numberOfInstructions * 2) {
			System.out.println("Clockcycle: " + clockcycles + '\n' + "____________________");
			Stage s = new InstructionFetch();
			processes.add(s);
			// for loop over all current processes
			for (int i = 0; i < processes.size(); i++) {
				// get the process at this index
				Stage stage = processes.get(i);
				// remove the process
				// processes.remove(i);
				if (stage instanceof InstructionFetch) {
					// execute the process
					String instruction = ((InstructionFetch) stage).execute(PC.getValue());
					String opcode = instruction.substring(0, 4);
					ControlUnit control = new ControlUnit();
					control.setControlSignals(opcode);
					control.toPrint();
					processes.remove(i);
					processes.add(i, new InstructionDecode(instruction, control));
				}

				else if (stage instanceof InstructionDecode) {
					// execute the process
					((InstructionDecode) stage).execute();
					ControlUnit cpu = ((InstructionDecode) stage).getControl();
					int readData1 = ((InstructionDecode) stage).getReadData1();
					int readData2 = ((InstructionDecode) stage).getReadData2();
					int writeRegisterNumber = ((InstructionDecode) stage).getWriteRegisterNumber();
					String signExtend = ((InstructionDecode) stage).getSignExtend();
					processes.remove(i);
					processes.add(i,
							new InstructionExecute(cpu, readData1, readData2, signExtend, writeRegisterNumber));
				}

				else if (stage instanceof InstructionExecute) {
					// execute the process
					((InstructionExecute) stage).execute();
					int writeRegisterNumber = ((InstructionExecute) stage).getWriteRegisterNumber();
					ControlUnit cpu = ((InstructionExecute) stage).getControl();
					String result = ((InstructionExecute) stage).getResult();
					int readData1 = ((InstructionExecute) stage).getReadData1();
					int readData2 = ((InstructionExecute) stage).getReadData2();
					int fifteenthBit = ((InstructionExecute) stage).getLastBit();
					boolean isEqual = ((InstructionExecute) stage).isEqual();
					if (isEqual)
						PC.setValue(PC.getValue() + 2);
					processes.remove(i);
					// call memory stage with these stuff
					// passing readData1 twice as it is taken twice
					processes.add(i, new MemoryStage(cpu, readData1, readData1, readData2, result, writeRegisterNumber,
							fifteenthBit));
				}

				else if (stage instanceof MemoryStage) {
					// execute the process
					((MemoryStage) stage).execute();
					int writeRegisterNumber = ((MemoryStage) stage).getWriteRegisterNumber();
					String result = ((MemoryStage) stage).getResult();
					int readData = ((MemoryStage) stage).getDataOut();
					int readData1 = ((MemoryStage) stage).getReadData1();
					int readData2 = ((MemoryStage) stage).getReadData2();
					ControlUnit cpu = ((MemoryStage) stage).getControl();
					String signExtend = ((MemoryStage) stage).getSignExtend();
					int fifteenthBit = ((MemoryStage) stage).getLastBit();
					processes.remove(i);
					processes.add(i, new WriteBackStage(cpu, writeRegisterNumber, result, readData, readData1,
							readData2, fifteenthBit));
				}

				else if (stage instanceof WriteBackStage) {
					// execute the process
					((WriteBackStage) stage).execute();
					processes.remove(i);
					i--;
				}

			}
			clockcycles++;
			if (PC.getValue() == (InstructionMemory.numberOfInstructions - 1) * 2) {
				while (!processes.isEmpty()) {
					System.out.println("____________________" + '\n' + "Clockcycle: " + clockcycles);

					for (int i = 0; i < processes.size(); i++) {
						// get the process at this index
						Stage stage = processes.get(i);
						// remove the process
						// processes.remove(i);
						if (stage instanceof InstructionFetch) {
							// execute the process
							ControlUnit control = new ControlUnit();
							String instruction = ((InstructionFetch) stage).execute(PC.getValue());
							String opcode = instruction.substring(0, 5);
							control.setControlSignals(opcode);
							processes.remove(i);
							processes.add(i, new InstructionDecode(instruction, control));
						}

						else if (stage instanceof InstructionDecode) {
							// execute the process
							((InstructionDecode) stage).execute();
							ControlUnit cpu = ((InstructionDecode) stage).getControl();
							int readData1 = ((InstructionDecode) stage).getReadData1();
							int readData2 = ((InstructionDecode) stage).getReadData2();
							String signExtend = ((InstructionDecode) stage).getSignExtend();
							int writeRegister = ((InstructionDecode) stage).getWriteRegisterNumber();
							processes.remove(i);
							processes.add(i,
									new InstructionExecute(cpu, readData1, readData2, signExtend, writeRegister));
						}

						else if (stage instanceof InstructionExecute) {
							// execute the process
							((InstructionExecute) stage).execute();
							int writeRegisterNumber = ((InstructionExecute) stage).getWriteRegisterNumber();
							ControlUnit cpu = ((InstructionExecute) stage).getControl();
							String result = ((InstructionExecute) stage).getResult();
							int readData1 = ((InstructionExecute) stage).getReadData1();
							int readData2 = ((InstructionExecute) stage).getReadData2();
							int fifteenthBit = ((InstructionExecute) stage).getLastBit();
							processes.remove(i);
							// call memory stage with these stuff
							// passing readData1 twice as it is taken twice
							processes.add(i, new MemoryStage(cpu, readData1, readData1, readData2, result,
									writeRegisterNumber, fifteenthBit));
						}

						else if (stage instanceof MemoryStage) {
							// execute the process
							((MemoryStage) stage).execute();
							int writeRegisterNumber = ((MemoryStage) stage).getWriteRegisterNumber();
							String result = ((MemoryStage) stage).getResult();
							int readData = ((MemoryStage) stage).getDataOut();
							int readData1 = ((MemoryStage) stage).getReadData1();
							int readData2 = ((MemoryStage) stage).getReadData2();
							ControlUnit cpu = ((MemoryStage) stage).getControl();
							String signExtend = ((MemoryStage) stage).getSignExtend();
							int fifteenthBit = ((MemoryStage) stage).getLastBit();
							processes.remove(i);
							processes.add(i, new WriteBackStage(cpu, writeRegisterNumber, result, readData, readData1,
									readData2, fifteenthBit));
						}

						else if (stage instanceof WriteBackStage) {
							// execute the process
							((WriteBackStage) stage).execute();
							processes.remove(i);
							i--;
						}
					}
					clockcycles++;
				}
			}
			PC.setValue(PC.getValue() + 2);
			System.out
					.println("______________________________________________________________________________________");
		}
	}
}
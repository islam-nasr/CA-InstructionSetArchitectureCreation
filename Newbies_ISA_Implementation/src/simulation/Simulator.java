package simulation;

import java.io.IOException;
import java.util.Vector;

import memory.ControlUnit;
import memory.InstructionMemory;
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

	public static void main(String[] args) {
		InstructionIntialization.initialize();
		RegisterFileInitialization.initialize();
		RegisterFile registerFile = new RegisterFile();
		try {
			InstructionFetch.readInstructions("src/trial.txt");
		} catch (IOException e) {
			System.out.println("mesh la2y om el file");
		}

		int clockcycles = 1;
		for (int pc = 0; pc < InstructionMemory.numberOfInstructions; pc++) {
			System.out.println("____________________" + '\n' + "Clockcycle: " + clockcycles);
			Stage s = new InstructionFetch();
			processes.add(s);
			clockcycles++;
			// for loop over all current processes
			for (int i = 0; i < processes.size(); i++) {
				// get the process at this index
				Stage stage = processes.get(i);
				// remove the process
				// processes.remove(i);
				if (stage instanceof InstructionFetch) {
					// execute the process
					String instruction = ((InstructionFetch) stage).execute(pc);
					String opcode = instruction.substring(0, 5);
					ControlUnit control = new ControlUnit();
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
					processes.remove(i);
					// call memory stage with these stuff
					processes.add(i, new MemoryStage(cpu, readData1, result,writeRegisterNumber));
				}

				else if (stage instanceof MemoryStage) {
					// execute the process
					((MemoryStage) stage).execute();
					int writeRegisterNumber = ((MemoryStage) stage).getWriteRegisterNumber();
					String result = ((MemoryStage) stage).getResult();
					ControlUnit cpu = ((InstructionExecute) stage).getControl();
					processes.remove(i);
					//processes.add(i, new WriteBackStage(cpu,writeRegisterNumber,result,));
				}

				else if (stage instanceof WriteBackStage) {
					// execute the process
					((WriteBackStage) stage).execute();
					processes.remove(i);
					i--;
				}
			}
			if (pc == InstructionMemory.numberOfInstructions - 1) {
				while (!processes.isEmpty()) {
					clockcycles++;
					System.out.println("____________________" + '\n' + "Clockcycle: " + clockcycles);

					for (int i = 0; i < processes.size(); i++) {
						// get the process at this index
						Stage stage = processes.get(i);
						// remove the process
						// processes.remove(i);
						if (stage instanceof InstructionFetch) {
							// execute the process
							ControlUnit control = new ControlUnit();
							String instruction = ((InstructionFetch) stage).execute(pc);
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
							processes.remove(i);
							processes.add(i, new InstructionExecute(cpu, readData1, readData2, signExtend));
						}

						else if (stage instanceof InstructionExecute) {
							// execute the process
							((InstructionExecute) stage).execute();
							ControlUnit cpu = ((InstructionExecute) stage).getControl();
							String result = ((InstructionExecute) stage).getResult();
							int readData1 = ((InstructionExecute) stage).getReadData1();
							processes.remove(i);
							// call memory stage with these stuff
							processes.add(i, new MemoryStage(cpu, readData1, result));
						}

						else if (stage instanceof MemoryStage) {
							// execute the process
							((MemoryStage) stage).execute();
							processes.remove(i);
							processes.add(i, new WriteBackStage());
						}

						else if (stage instanceof WriteBackStage) {
							// execute the process
							((WriteBackStage) stage).execute();
							processes.remove(i);
							i--;
						}
					}
				}

			}

		}

	}

}
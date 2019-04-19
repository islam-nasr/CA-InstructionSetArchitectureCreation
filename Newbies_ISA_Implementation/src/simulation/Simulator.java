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
		
		
		for(int pc=0;pc<InstructionMemory.numberOfInstructions;pc++) {
			System.out.println("____________________");
			Stage s = new InstructionFetch();
			processes.add(s);
			ControlUnit control = new ControlUnit();
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
					control.setControlSignals(opcode);
					processes.remove(i);
					processes.add(i, new InstructionDecode(instruction, control));
				}

				else if (stage instanceof InstructionDecode) {
					// execute the process
					((InstructionDecode) stage).execute();
					int readData1 = ((InstructionDecode) stage).getReadData1();
					int readData2 = ((InstructionDecode) stage).getReadData2();
					String signExtend = ((InstructionDecode) stage).getSignExtend();
					processes.remove(i);
					processes.add(i, new InstructionExecute(control, readData1, readData2, signExtend));
				}

				else if (stage instanceof InstructionExecute) {
					// execute the process
					((InstructionExecute) stage).execute();
					ControlUnit cpu = ((InstructionExecute) stage).getControl();
					String result = ((InstructionExecute) stage).getResult();
					int readData1 = ((InstructionExecute) stage).getReadData1();
					processes.remove(i);
					// call memory stage with these stuff
					processes.add(i, new MemoryStage());
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
		if(pc==InstructionMemory.numberOfInstructions-1) {
			while(!processes.isEmpty()) {
				System.out.println("____________________");

			
			for (int i = 0; i < processes.size(); i++) {
				// get the process at this index
				Stage stage = processes.get(i);
				// remove the process
				// processes.remove(i);
				if (stage instanceof InstructionFetch) {
					// execute the process
					String instruction = ((InstructionFetch) stage).execute(pc);
					String opcode = instruction.substring(0, 5);
					control.setControlSignals(opcode);
					processes.remove(i);
					processes.add(i, new InstructionDecode(instruction, control));
				}

				else if (stage instanceof InstructionDecode) {
					// execute the process
					((InstructionDecode) stage).execute();
					int readData1 = ((InstructionDecode) stage).getReadData1();
					int readData2 = ((InstructionDecode) stage).getReadData2();
					String signExtend = ((InstructionDecode) stage).getSignExtend();
					processes.remove(i);
					processes.add(i, new InstructionExecute(control, readData1, readData2, signExtend));
				}

				else if (stage instanceof InstructionExecute) {
					// execute the process
					((InstructionExecute) stage).execute();
					ControlUnit cpu = ((InstructionExecute) stage).getControl();
					String result = ((InstructionExecute) stage).getResult();
					int readData1 = ((InstructionExecute) stage).getReadData1();
					processes.remove(i);
					// call memory stage with these stuff
					processes.add(i, new MemoryStage());
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
			}}
			
			
			
		}
		
		
		}
		
	}

}
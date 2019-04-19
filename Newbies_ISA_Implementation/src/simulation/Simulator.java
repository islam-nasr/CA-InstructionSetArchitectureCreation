package simulation;

import java.util.Vector;

import memory.ControlUnit;
import stages.InstructionDecode;
import stages.InstructionExecute;
import stages.InstructionFetch;
import stages.MemoryStage;
import stages.Stage;
import stages.WriteBackStage;

public class Simulator {
	static Vector<Stage> processes = new Vector<Stage>(6);

	public static void main(String[] args) {
		int j = 0;
		while (j < 10) {
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
					String instruction = ((InstructionFetch) stage).execute(j);
					String opcode = instruction.substring(0, 5);
					control.getControlSignals(opcode);
					processes.remove(i);
					processes.add(i, new InstructionDecode(instruction, control));
				}

				else if (stage instanceof InstructionDecode) {
					// execute the process
					((InstructionDecode) stage).execute();

					processes.remove(i);
					processes.add(i, new InstructionExecute());
				}

				else if (stage instanceof InstructionExecute) {
					// execute the process
					((InstructionExecute) stage).execute();
					processes.remove(i);
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
			j++;
		}
	}

}
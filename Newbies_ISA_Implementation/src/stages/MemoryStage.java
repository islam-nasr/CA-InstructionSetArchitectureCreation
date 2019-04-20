package stages;

import memory.ControlUnit;
import memory.DataMemory;

public class MemoryStage extends Stage {
	ControlUnit control;
	int writeData;
	String address;
	int readData;
	int writeRegisterNumber;

	public MemoryStage(ControlUnit cpu, int writeData, String address, int writeRegisterNumber) {
		super();
		control = cpu;
		this.writeData = writeData;
		this.address = address;
		this.writeRegisterNumber=writeRegisterNumber;
	}

	public void execute() {
		if (control.getMemRead() == 1) {
			readData = DataMemory.read(Integer.parseInt(address, 2));
		} else if (control.getMemWrite() == 1) {
			DataMemory.write(Integer.parseInt(address, 2), writeData);
		}
		System.out.println("Executing memory....");
	}

	public int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

	public String getResult() {
		// TODO Auto-generated method stub
		return address;
	}

}

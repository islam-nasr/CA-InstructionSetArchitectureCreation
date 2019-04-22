package stages;

import memory.ControlUnit;
import memory.DataMemory;

public class MemoryStage extends Stage {
	ControlUnit control;
	String signExtend;
	int writeData;
	String address;
	int dataOut;
	int writeRegisterNumber;
	int readData1;
	int readData2;
	int lastBit;

	public MemoryStage(ControlUnit cpu, int writeData, int readData1, int readData2, String address,
			int writeRegisterNumber, int lastBit) {
		super();
		control = cpu;
		this.writeData = writeData;
		this.address = address;
		this.writeRegisterNumber = writeRegisterNumber;
		this.readData1 = readData1;
		this.readData2 = readData2;
		this.lastBit = lastBit;
	}

	public void execute() {
		System.out.println("Executing memory....");
		if (control.getMemRead() == 1) {
			dataOut = DataMemory.read(Integer.parseInt(address, 2) * 2);
		} else if (control.getMemWrite() == 1) {
			DataMemory.write(Integer.parseInt(address, 2) * 2, writeData);
		} else {
			System.out.println();
		}
		DataMemory.toPrint();
		System.out.println("==================================================================");
	}

	public int getWriteRegisterNumber() {
		return writeRegisterNumber;
	}

	public String getResult() {
		return address;
	}

	public String getSignExtend() {
		return signExtend;
	}

	public ControlUnit getControl() {
		return control;
	}

	public int getDataOut() {
		return dataOut;
	}

	public int getReadData1() {
		return readData1;
	}

	public int getReadData2() {
		return readData2;
	}

	public int getLastBit() {
		return lastBit;
	}

}

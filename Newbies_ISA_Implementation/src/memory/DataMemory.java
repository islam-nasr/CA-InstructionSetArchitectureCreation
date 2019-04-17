package memory;

public class DataMemory {
	private int[] data;
	// private int maximumUsedAddress = -1;

	public DataMemory(int size) {
		data = new int[size];
	}

	public void write(int address, int value) {
		// maximumUsedAddress = Math.max(maximumUsedAddress, address/4);
		data[address / 2] = value;
	}
	
	public int read(int address) {
		return data[address / 2];
	}

	@Override
	public String toString() {
		String r = "";
		// for(int i = 0; i <= maximumUsedAddress; ++i)
		for (int i = 0; i <= data.length; i++)
			r += String.format("%d: %d\n", i, data[i]);
		return r;
	}
}

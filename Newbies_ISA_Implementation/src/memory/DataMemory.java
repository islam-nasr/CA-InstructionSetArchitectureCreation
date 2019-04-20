package memory;

public class DataMemory {
	public static int[] data = new int[61440]; //2^16 - 2^12;
	// private int maximumUsedAddress = -1;


	public static void write(int address, int value) {
		// maximumUsedAddress = Math.max(maximumUsedAddress, address/4);
		data[address / 2] = value;
	}
	
	public static int read(int address) {
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

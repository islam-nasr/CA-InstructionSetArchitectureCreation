package memory;

public class DataMemory {
	public static int[] data = new int[61440]; // 2^16 - 2^12;
	private static int maximumUsedAddress = -1;

	public static void write(int address, int value) {
		System.out.println("!!!!!!!!!!!!!");
		
		maximumUsedAddress = Math.max(maximumUsedAddress, address / 2);
		data[address / 2] = value;
		System.out.println(maximumUsedAddress);
	}

	public static int read(int address) {
		return data[address / 2];
	}

	public static void toPrint() {
		String r = "";
		for (int i = 0; i <= maximumUsedAddress; ++i)
			// for (int i = 0; i <= data.length; i++)
			// r += String.format("%d: %d\n", i, data[i]);
			r += "Memory Location: " + i + " " + data[i];
		System.out.println(r);
	}
}

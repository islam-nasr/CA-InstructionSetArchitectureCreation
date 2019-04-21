package memory;

public class DataMemory {
	public static int[] data = new int[61440]; // 2^16 - 2^12;
	private static int maximumUsedAddress = -1;

	public static void write(int address, int value) {
		if (address > 61440) {
			System.out.println("Not available Memory Location!!");
		} else {
			maximumUsedAddress = Math.max(maximumUsedAddress, address / 2);
			data[address / 2] = value;
		}
	}

	public static int read(int address) {
		return data[address / 2];
	}

	public static void toPrint() {
		String r = "";
		for (int i = 0; i <= maximumUsedAddress; ++i)
			// for (int i = 0; i <= data.length; i++)
			// r += String.format("%d: %d\n", i*2, data[i]);
			r += "Memory Location: " + i * 2 + "       Data: " + data[i] + '\n';
		System.out.println(r);
	}
}

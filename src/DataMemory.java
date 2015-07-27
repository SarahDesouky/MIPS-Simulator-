import java.util.ArrayList;

public class DataMemory {
	static ArrayList<String> dataMem;

	public DataMemory() {
		dataMem = new ArrayList<String>(4000);
		for (int i = 0; i < 4000; i++) {
			dataMem.add(i, "00000000");
		}
	}

	public static int BinToDec(String Bin) {
		return Integer.parseInt(Bin, 2);
	}

	public static void lw() {

		int addr = BinToDec(Wires.aluResult);
		String word = "";
		int i = addr;
		for (i = 0; i < 4; i++) {
			word = word + dataMem.get(addr + i);
		}
		if (Wires.memToReg == 1) {
			Wires.writeData = word;
		} else {
			Wires.writeData = Wires.aluResult;
		}
	}

	public static void sw() {
		int addr = BinToDec(Wires.aluResult);
		String word1 = "";
		String word2 = "";
		String word3 = "";
		String word4 = "";

		for (int i = 0; i < 32; i++) {
			if (i < 8) {
				word1 = word1 + Wires.aluMuX0.charAt(i);
			}
			if (i < 16 && i >= 8) {
				word2 = word2 + Wires.aluMuX0.charAt(i);
			}
			if (i < 24 && i >= 16) {
				word3 = word3 + Wires.aluMuX0.charAt(i);
			}
			if (i < 32 && i >= 24) {
				word4 = word4 + Wires.aluMuX0.charAt(i);
			}
		}

		dataMem.set(addr, word1);
		dataMem.set(addr + 1, word2);
		dataMem.set(addr + 2, word3);
		dataMem.set(addr + 3, word4);

		// if (Wires.memWrite == 1) {
		// dataMem.set(addr, Wires.aluMuX0);
		// }
	}

	public static void lb() {
		int addr = ALU.BinToDec(Wires.aluResult);
		String word = "000000000000000000000000";
		word = word + dataMem.get(addr);
		if (Wires.memToReg == 1) {
			Wires.writeData = word;
		} else {
			Wires.writeData = Wires.aluResult;
		}
	}

	public static void write() {

	}

	public static void main(String[] args) {
		new DataMemory();
//		dataMem.set(3, "00000000");
//		dataMem.set(4, "10010111");
//		dataMem.set(5, "00000110");
		Wires.aluResult = "00000000000000000000000000000010";
		int addr = ALU.BinToDec(Wires.aluResult);
		System.out.println(addr);

		 Wires.memToReg = 1 ;
		dataMem.set(2, "10010111");
		
		Wires.aluMuX0 = "11111111222222223333333344444444";
		lw();
		System.out.println(Wires.writeData);
		System.out.println(dataMem.get(addr));
		System.out.println(dataMem.get(addr + 1));
		System.out.println(dataMem.get(addr + 2));
		System.out.println(dataMem.get(addr + 3));
	}

}


public class Wires {


	
	//control wires
	static int regDes = 0;
	static int branch = 0;
	static int memRead = 0;
	static int memToReg = 0;
	static String aluOp = "111";
	static int memWrite =0;
	static int aluSrc = 0;
	static int regWrite = 0;
	static int zero = 0;
	static int jump = 0;

	//MUX selectors
	int branchMUXSelector = 0;


	//connection wires
	static String fetchedInstruction = "";
	String readAdd = "00000000000000000000000000000000";
	static String controlInput = "00000000000000000000000000000000";
	static String readReg1 = "00000";
	static String readReg2 = "00000";
	static String writeReg = "00000";
	static String writeData = "00000000000000000000000000000000";
	static String signExtendi = "0000000000000000";
	static String signExtendo = "00000000000000000000000000000000";
	static String aluIn1 = "00000000000000000000000000000000";
	static String aluIn2 = "00000000000000000000000000000000";
	static String aluResult = "00000000000000000000000000000000";
	static String functCode = "000000";
	static String aluConOut= "0000";
	String memReadData = "00000000000000000000000000000000";
	String memWriteData = "00000000000000000000000000000000";
	static String jumpAddIn = "00000000000000000000000000";
	static String jumpAddOut = "00000000000000000000000000000000";
	String branchMUX0 = "00000000000000000000000000000000";
	String branchMUX1 = "00000000000000000000000000000000";
	String branchMUXout = "00000000000000000000000000000000";
	static String aluMuX0 = "00000000000000000000000000000000";
	String aluMUX1 = "00000000000000000000000000000000";
	String regDesMUX0 = "00000000000000000000000000000000";
	String regDesMUX1 = "00000000000000000000000000000000";
	String memToRegMUX0 = "00000000000000000000000000000000";
	String memToRegMUX1 = "00000000000000000000000000000000";
	static String PCAddOut = "00000000000000000000000000000000";
	static String branchMUXo = "00000000000000000000000000000000";
	static String shamt = "00000";
	
	public Wires(){
		
	}
	
	public void reset() {
		regDes = 0;
		branch = 0;
		memRead = 0;
	    memToReg = 0;
	    aluOp = "1111";
		memWrite =0;
		aluSrc = 0;
		regWrite = 0;
		zero = 0;
		jump = 0;

		branchMUXSelector = 0;

		readAdd = "00000000000000000000000000000000";
		controlInput = "00000000000000000000000000000000";
		readReg1 = "00000";
		readReg2 = "00000";
		writeReg = "00000";
		writeData = "00000000000000000000000000000000";
		signExtendi = "0000000000000000";
		signExtendo = "00000000000000000000000000000000";
		aluIn1 = "00000000000000000000000000000000";
		aluIn2 = "00000000000000000000000000000000";
		aluResult = "00000000000000000000000000000000";
		functCode = "000000";
		aluConOut= "0000";
		memReadData = "00000000000000000000000000000000";
		memWriteData = "00000000000000000000000000000000";
		jumpAddIn = "00000000000000000000000000";
		jumpAddOut = "00000000000000000000000000000000";
		branchMUX0 = "00000000000000000000000000000000";
		branchMUX1 = "00000000000000000000000000000000";
		branchMUXout = "00000000000000000000000000000000";
		aluMuX0 = "00000000000000000000000000000000";
		aluMUX1 = "00000000000000000000000000000000";
		regDesMUX0 = "00000000000000000000000000000000";
		regDesMUX1 = "00000000000000000000000000000000";
		memToRegMUX0 = "00000000000000000000000000000000";
		memToRegMUX1 = "00000000000000000000000000000000";
		PCAddOut = "00000000000000000000000000000000";
		shamt = "00000";
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

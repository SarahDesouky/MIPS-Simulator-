public class PipelineRegisters {


	
	static String instruction = "00000000000000000000000000000000";
	static String incPC = "00000000000000000000000000000000";
	static String readRegister1 = "00000000000000000000000000000000";
	static String readRegister2 = "00000000000000000000000000000000";
	static String signExtendedOffset = "00000000000000000000000000000000";
	static String Rt = "00000";
	static String Rd = "00000";
	static String WBcontrol = "00";
	static String MEMcontrol = "000";
	static String EXcontrol = "0000";
	static String branchAddress = "00000000000000000000000000000000";
	static String zeroFlag = "0";
	static String aluResultAddress = "00000000000000000000000000000000";
	static String regToMem = "00000000000000000000000000000000";
	static String memWordRead = "00000000000000000000000000000000";
	
	static String [] IF_ID = {instruction,incPC};
	static String [] ID_EX = {incPC, readRegister1,readRegister2,signExtendedOffset, Rt, Rd, WBcontrol, MEMcontrol, EXcontrol};
	static String [] EX_MEM = {branchAddress, zeroFlag, aluResultAddress, regToMem, Rd, WBcontrol, MEMcontrol};
    static String [] MEM_WB = {aluResultAddress, memWordRead, Rd, WBcontrol};
	
	
	public PipelineRegisters(){
		
	}
	
	public void reset() {
		instruction = "00000000000000000000000000000000";
		incPC = "00000000000000000000000000000000";
		readRegister1 = "00000000000000000000000000000000";
		readRegister2 = "00000000000000000000000000000000";
		signExtendedOffset = "00000000000000000000000000000000";
		Rt = "00000";
		Rd = "00000";
		WBcontrol = "00";
		MEMcontrol = "000";
		EXcontrol = "0000";
		branchAddress = "00000000000000000000000000000000";
		zeroFlag = "0";
		aluResultAddress = "00000000000000000000000000000000";
		regToMem = "00000000000000000000000000000000";
		memWordRead = "00000000000000000000000000000000";
		
		
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

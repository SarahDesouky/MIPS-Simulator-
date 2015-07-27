public class Simulator {


	
	public static String shiftLeftTwo(String bin){
		String result = Integer.toBinaryString(ALU.BinToDec(bin) << 2);
		while (result.length() < 32) {
			result= "0" + result;
		}
		return result;
	}
	
	public static String adder(String x , String y) {
		String result = Integer.toBinaryString(ALU.BinToDec(x) + ALU.BinToDec(y));
		while (result.length() < 32) {
			result= "0" + result;
		}
		return result;
	}
	
	public static void InitializeSimulation(){
		new RegisterFiles();
		new Wires();
		new InstructionMemory();
	}
	
	public static void IF(){
		InstructionMemory.FetchInstruction();
	}
	
	public static void ID(){
		
		Decode.setWires(Wires.fetchedInstruction);
		new Control();
		AluControl.aluControlOutput();
		RegisterFiles.readData1();
		RegisterFiles.readData2();
			
	}
	
	
	public static void EX(){
		ALU.AluOperation();
	}
	
	public static void MEM(){
		
	}
	
	public static void WB(){
		RegisterFiles.writeData();
	}
	
	public static void main(String[] args) {

		InitializeSimulation();
		RegisterFiles.PC.value = "00000000000000000000000000000100";
		RegisterFiles.regs[10].value = "00000000000000000000000000000100"; //t2
		RegisterFiles.regs[11].value = "00000000000000000000000000000100"; //t3
		InstructionMemory.Instructions.add(ALU.BinToDec(RegisterFiles.PC.value), "addi $t2, $t3, 3");
		IF();
		ID();
//		System.out.println(Wires.aluIn1);
//		System.out.println(Wires.aluIn2);
//		System.out.println(Wires.aluOp);
		EX();
		WB();
		
		System.out.println(Wires.aluResult);
		
		
	
		
		
	}

}

import java.util.ArrayList;


public class InstructionMemory {
	
	static int size = 100;
	static ArrayList<String> Instructions = new ArrayList<String>(size);
	
	public InstructionMemory() {

		for(int i=0;i<size;i++){
			Instructions.add(i, "");
		}
	}
	
	public static void main(String[] args){
		
		new InstructionMemory();
		Instructions.add(10,"add $t1, $t2, $t3"); 
		RegisterFiles.PC.value = "00000000000000000000000000001010";
		FetchInstruction();	
		System.out.println(RegisterFiles.PC.value);
	}
	
	public static void FetchInstruction(){
		
		String one = "00000000000000000000000000000001";
		int address = ALU.BinToDec(RegisterFiles.PC.value);
		RegisterFiles.PC.value = Simulator.adder(RegisterFiles.PC.value,one);
		Wires.PCAddOut = RegisterFiles.PC.value;
		//System.out.println(RegisterFiles.PC.value);
		String Instruction = Instructions.get(address);
		//System.out.println(Instruction);
		Wires.fetchedInstruction=Instruction;
	}

}

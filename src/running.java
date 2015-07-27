
public class running {

	public running() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args){
	//System.out.println(RegisterFiles.PC.value);
		
		//System.out.println(shiftLeftTwo("00000000000000000000000000000010"));
		//System.out.println(adder(RegisterFiles.PC.value,"00000000000000000000000000000100"));
		
		new InstructionMemory();
		InstructionMemory.Instructions.add(ALU.BinToDec(RegisterFiles.PC.value), "add $t1, $t2, $t3");
		InstructionMemory.Instructions.add(ALU.BinToDec(RegisterFiles.PC.value)+1, "lw $t1, 0($t2)");
		int i = ALU.BinToDec(RegisterFiles.PC.value);
		
		new RegisterFiles();
		new Wires();
//		RegisterFiles.regs[10].value = "00000000000000000000000000000011";
//		RegisterFiles.regs[11].value = "00000000000000000000000000000001";
//		//System.out.println(adder(RegisterFiles.regs[10].value, RegisterFiles.regs[11].value));
//		String Instruction = "add $t1, $t2, $t3;";
//		Decode.setWires(InstructionMemory.Instructions.get(i));
//		//System.out.println(Wires.readReg1);
//		RegisterFiles.readData1();
//		RegisterFiles.readData2();
//		//System.out.println(Wires.readReg2);
//		//System.out.println(Wires.aluIn2);
//		new Control();
//		//System.out.println(Wires.functCode);
//		AluControl.aluControlOutput();
//		//System.out.println(Wires.aluConOut);
//		ALU.AluOperation();
//		//System.out.println(Wires.aluResult);
//		//System.out.println(Wires.writeData);
//		RegisterFiles.writeData();
//		//System.out.println(RegisterFiles.regs[9].value);
//		
		
		RegisterFiles.regs[10].value = "00000000000000000000000000000100"; //t2
		RegisterFiles.regs[11].value = "00000000000000000000000000000001"; //t3
		Decode.setWires(InstructionMemory.Instructions.get(i+1));
		new Control();
		//System.out.println(Wires.readReg1);
		
		String one = "00000000000000000000000000000001";
		RegisterFiles.PC.value = Simulator.adder(RegisterFiles.PC.value,one);
		Wires.PCAddOut = RegisterFiles.PC.value;
		RegisterFiles.readData1();
		RegisterFiles.readData2();
		
		//System.out.println(Wires.aluIn1);
		//System.out.println(Wires.aluSrc);
		//System.out.println(Wires.signExtendi);
		//System.out.println(Wires.aluIn2);
		
		//System.out.println(Wires.functCode);
		AluControl.aluControlOutput();
		//System.out.println(Wires.aluConOut);
		//System.out.println(Wires.shamt);
		ALU.AluOperation();
		//System.out.println(Wires.aluResult);
		RegisterFiles.signExtend();
		System.out.println(Wires.signExtendo);
		Branch.setBranchPCValue();
		Jump.setJumpPCValue();
		
		//System.out.println(Wires.PCAddOut);
		System.out.println("sarah:" + RegisterFiles.PC.value);
		//System.out.println(Wires.zero);
		//System.out.println(Wires.writeData);
		RegisterFiles.writeData();
		
		
		//WriteBack();
		//memory();
		//execute();
		//Decode();
		//Fetch();
	}
}

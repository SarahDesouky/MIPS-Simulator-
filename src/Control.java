public class Control {

	public Control() {
		String opCode = Wires.controlInput;
		if (opCode.equals("000000")) {
			Wires.regDes = 1;
			Wires.regWrite = 1;
			Wires.aluSrc = 0;
			Wires.memWrite = 0;
			Wires.memRead = 0;
			Wires.memToReg = 0;
			Wires.aluOp = "010";
			/*switch (Wires.functCode) {
			case "100000": Wires.aluOp = "010"; break; //add
			case "100010": Wires.aluOp = "110"; break; //sub
			case "100100": Wires.aluOp = "000"; break; //and
			case "000000": Wires.aluOp = "010"; break; //sll
			case "000010": Wires.aluOp = "110"; break; //srl
			case "100111": Wires.aluOp = "001"; break; //or
			case "101010": Wires.aluOp = "111"; break; //slt
			case "101001": Wires.aluOp = "111"; break; //sltu
			}*/
		}
		//lw lb lbu
		else if (opCode.equals("100011") || opCode.equals("100000") || opCode.equals("100100")) {
			Wires.regDes = 0;
			Wires.regWrite = 1;
			Wires.aluSrc = 1;
			Wires.memWrite = 0;
			Wires.memRead = 1;
			Wires.memToReg = 1;
			Wires.aluOp = "000";
			
		}
		//sw sb
		else if (opCode.equals("101011") || opCode.equals("101000")) {
			//Wires.regDes = 0;
			Wires.regWrite = 0;
			Wires.aluSrc = 1;
			Wires.memWrite = 1;
			Wires.memRead = 0;
			//Wires.memToReg = 1;
			Wires.aluOp = "000";
			
		}
		//beq bne
		else if (opCode.equals("000100") || opCode.equals("000101") ) {
			//Wires.regDes = 0;
			Wires.regWrite = 0;
			Wires.aluSrc = 0;
			Wires.memWrite = 0;
			Wires.memRead = 0;
			//Wires.memToReg = 1;
			Wires.branch = 1;
			if (opCode.equals("000100"))
				Wires.aluOp = "001";
			else Wires.aluOp = "011";
			
		}
		//addi
		else if (opCode.equals("001000")) {
			Wires.regDes = 0;
			Wires.regWrite = 1;
			Wires.aluSrc = 1;
			Wires.memWrite = 0;
			Wires.memRead = 0;
			Wires.memToReg = 0;
			Wires.branch = 0;
			Wires.aluOp = "100";
			
		}
		//j
		else if (opCode.equals("000010")) {
			//Wires.regDes = 0;
			Wires.regWrite = 0;
			//Wires.aluSrc = 1;
			Wires.memWrite = 0;
			Wires.memRead = 0;
			//Wires.memToReg = 0;
			//Wires.branch = 0;
			//Wires.aluOp = "000";
			Wires.jump = 1;
			Jump.setJumpPCValue();
			
		}
		
		//lui
		else if (opCode.equals("001000")) {
			Wires.regDes = 0;
			Wires.regWrite = 1;
			Wires.aluSrc = 1;
			Wires.memWrite = 0;
			Wires.memRead = 0;
			Wires.memToReg = 0;
			Wires.branch = 0;
			Wires.aluOp = "100";
			
		}
	}
	public static void main(String[] args) {
		
	}
	
}
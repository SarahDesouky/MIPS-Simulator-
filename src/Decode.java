public class Decode {

	public Decode(){}
	
	public static void main(String[] args) {
		
		//instruction("bne $t0, $t1, 01");
		//System.out.println(Wires.readReg1);
		
		
	}
	public static String opCode(String word){
		switch(word){
		case "add" : return "000000";//
		case "addi": return "001000";//
		case "sub" : return "000000";//
		case "lw" : return "100011";//
		case "lb" : return "100000";
		case "lbu" : return "100100";
		case "sw" : return "101011";//
		case "sb" : return "101000";
		case "lui" : return "001111";
		case "sll" : return "000000";
		case "srl" : return "000000";
		case "and" : return "000000";//
		case "nor" : return "000000";
		case "beq" : return "000100";//
		case "bne" : return "000101";
		case "j" : return "000010";
		case "jal" : return "000011";
		case "jr" : return "000000";
		case "slt" : return "000000";//
		case "sltu" : return "000000";
		case "mult" : return "000000";
		default : return " ";
		}
	}
	
	public static String decRegisters(String reg) {
		int regNum = 0;
		if (reg.charAt(2) == 'p')
		{
			switch(reg.charAt(1)){
			case 'g' :  return "28";
			case 'f' :  return "30";
			}
		}
		 if (reg.charAt(2) == 'a')
			return "31";
		else if (reg.charAt(2) == '8')
			regNum = 16;
		else if (reg.charAt(2) == '9')
			regNum = 17;
		else regNum = reg.charAt(2);
			
		switch (reg.charAt(1) ) {
		case '0': regNum = 0; return "" + regNum;
		case 'v': regNum += 1; return "" + regNum;
		case 'a': regNum += 4; return "" + regNum;
		case 't': regNum += 8; return "" + regNum;
		case 's': if (reg.charAt(2)== 'p') return "29"; else regNum += 1; return "" + regNum;
		}
		return "";
	}	
	
	public static String Registers(String reg) {
		int regNum = 0;
		String binReg = " ";
		
		if (reg.charAt(2) == 'p')
		{
			switch(reg.charAt(1)){
			case 'g' :  regNum = 28; break;
			case 'f' :  regNum = 30; break;
			case 's' :  regNum = 29;
			}
		}
		else if (reg.charAt(2) == 'a')
			 regNum = 31;
		else if (reg.charAt(2) == '8') {
			//System.out.println("T8");
			regNum = 16;
		}
		else if (reg.charAt(2) == '9') {
			//System.out.println("T9");
			regNum = 17;
		}
		 
		else regNum = Integer.parseInt(reg.charAt(2)+ "");
			
		switch (reg.charAt(1) ) {
		case '0': regNum = 0; break;
		case 'v': regNum += 2; break;
		case 'a': regNum += 4; break;
		case 't': regNum += 8;break;
		case 's': if (reg.charAt(2)== 'p') regNum = 29; else regNum += 16; 
		}
		//System.out.println(regNum);
		binReg = Integer.toBinaryString(regNum);
		while(binReg.length() < 5) {
			
			binReg = "0" + binReg;
		}
		//System.out.println(binReg.length());
		return binReg;
		
	}	
	
	public static String function(String func) {
		switch(func){
		case "add" : return "100000";
		case "sub" : return "100010";
		case "sll" : return "000000";
		case "srl" : return "000010";
		case "and" : return "100100";
		case "nor" : return "100111";
		case "slt" : return "101010";
		case "sltu" : return "101001";
		case "jr" : return "001000";
		case "mult" : return "011000";
		default : return " ";
		}
		
	}
	
	public static String instruction(String inst) {
		inst = inst.replace(",", "");
		inst = inst.replace(";", "");
		
		String[] words = inst.split(" "); 
		
		String binaryOp = opCode(words[0]);
		String destReg = "";
		String sourceReg = "";
		String secReg = "";
		String binaryFn = "";
		String shiftAmount = "";
		//System.out.println(binaryOp);
		if (binaryOp.equals("000000")) {
			binaryFn = function(words[0]);
			destReg = Registers(words[1]);
			//shifters
			if (binaryFn.equals("000000") || binaryFn.equals("000010")) {
				sourceReg = "00000";
				secReg = Registers(words[2]);
				shiftAmount = Integer.toBinaryString(Integer.parseInt(words[3]));
				while(shiftAmount.length() < 5) {
					 shiftAmount = "0" + shiftAmount;
				}
				
				//System.out.println((binaryOp + sourceReg + secReg + destReg + shiftAmount + binaryFn).length());
				System.out.println(binaryOp + sourceReg + secReg + destReg + shiftAmount + binaryFn);
				
				
			}
			else {
			//System.out.println("Mult");
			sourceReg = Registers(words[2]);
			secReg = Registers(words[3]);
			
			shiftAmount = "00000";
			//System.out.println((binaryOp + sourceReg + secReg + destReg + shiftAmount + binaryFn).length());
			System.out.println(binaryOp + sourceReg + secReg + destReg + shiftAmount + binaryFn);
			
			}
			return binaryOp + sourceReg + secReg + destReg + shiftAmount + binaryFn;
		}
		
		//jump
		else if (binaryOp.equals("000010") || binaryOp.equals("000011"))
		{
			System.out.println(words[1]);
			String address = words[1];
			
				address = Integer.toBinaryString(Integer.parseInt(words[1]));
				while(address.length() < 26) {
					if (Integer.parseInt(words[1]) < 0)
						address = "1" + address;
					else address = "0" + address;
				}
			return binaryOp + address;
		}
		
		else {
			//addi
			binaryOp = opCode(words[0]);
			sourceReg = Registers(words[1]);
			
			String immediate = "";
			//System.out.println("Hola");
			if (words[0].equals("lui")) {
				secReg = "00000";
				immediate = Integer.toBinaryString(Integer.parseInt(words[2]));
				//System.out.println(immediate);
				while(immediate.length() < 16) {
					if (Integer.parseInt(words[2]) < 0)
						immediate = "1" + immediate;
					else immediate = "0" + immediate;
				}
				if (immediate.length() > 16)
					immediate = immediate.substring(immediate.length()-16, immediate.length());
				//System.out.println((binaryOp + secReg + sourceReg + immediate).length());
					System.out.println(binaryOp + secReg + sourceReg + immediate);
				return binaryOp + secReg + sourceReg  + immediate;
			}
			else if ((words[0].charAt(words[0].length()-1) == 'i' && !words[0].equals("lui")) || binaryOp.equals("000100") || binaryOp.equals("000101")) {
				secReg = Registers(words[2]);
				immediate = Integer.toBinaryString(Integer.parseInt(words[3]));
				//System.out.println(immediate);
				while(immediate.length() < 16) {
					if (Integer.parseInt(words[3]) < 0)
						immediate = "1" + immediate;
					else immediate = "0" + immediate;
				}
				if (immediate.length() > 16)
					immediate = immediate.substring(immediate.length()-16, immediate.length());
				//System.out.println((binaryOp + secReg + sourceReg + immediate).length());
					System.out.println(binaryOp + secReg + sourceReg + immediate);
				return binaryOp + secReg + sourceReg  + immediate;
			}
			
			//lw sw
			else {
				String[] address;
				sourceReg = Registers(words[1]);
				words[2] = words[2].replace(")", "");
				words[2] = words[2].replace("(", "/");
				//System.out.println(inst);
				//System.out.println(words[2]);
				address = words[2].split("/");
				String offset = Integer.toBinaryString(Integer.parseInt(address[0]));
				while(offset.length() < 16) {
					if (Integer.parseInt(address[0]) < 0)
						offset = "1" + offset;
					else offset = "0" + offset;
				}
				secReg = Registers(address[1]);
				System.out.println(binaryOp +  secReg + sourceReg + offset);
				return binaryOp +  secReg + sourceReg + offset;
				
			}
			
		}
		}
		
		public static void setWires(String instruction){
			String binaryInstruction = instruction(instruction);
			Wires.controlInput = binaryInstruction.substring(0,6);
			Wires.readReg1 = binaryInstruction.substring(6,11);
			Wires.readReg2 = binaryInstruction.substring(11,16);
			Wires.writeReg = binaryInstruction.substring(16,21);
			Wires.shamt = binaryInstruction.substring(21,26);
			Wires.functCode = binaryInstruction.substring(26,32);
			Wires.signExtendi = binaryInstruction.substring(16,32);
			
			Wires.jumpAddIn = binaryInstruction.substring(6,32);
			
			
		}
	}
	
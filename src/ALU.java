
public class ALU {

	public static int BinToDec(String Bin){
		if (Bin.charAt(0) == '1') {
			String temp = Bin;
			temp = temp.replace('0', 't');
			temp = temp.replace('1', '0');
			temp = temp.replace('t', '1');
			int result = Integer.parseInt(temp, 2) + 1;
			return -result;
		}
		else {
			return Integer.parseInt(Bin,2);
		}
	}

	public static void add(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn1) + BinToDec(Wires.aluIn2));
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}
	
	public static void addi(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn1) + BinToDec(Wires.aluIn2));
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void subtract(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn1) - BinToDec(Wires.aluIn2));	
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}

	}

	public static void multiply(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn1) * BinToDec(Wires.aluIn2));
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void sll(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn2) << BinToDec(Wires.shamt));
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void srl(){
		Wires.aluResult = Integer.toBinaryString(BinToDec(Wires.aluIn2) >> BinToDec(Wires.shamt));
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void and(){
		Wires.aluResult = "";
		for (int i=0; i<Wires.aluIn1.length() && i<Wires.aluIn2.length(); i++) {
			if ((Wires.aluIn1.charAt(i)=='0' && Wires.aluIn2.charAt(i)=='0')
					|| (Wires.aluIn1.charAt(i)=='0' && Wires.aluIn2.charAt(i)=='1')
					|| (Wires.aluIn1.charAt(i)=='1' && Wires.aluIn2.charAt(i)=='0')) {
				Wires.aluResult += "0";
			}
			else {
				Wires.aluResult += "1";
			}
		}
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void or() {
		Wires.aluResult = "";
		for (int i=0; i<Wires.aluIn1.length() && i<Wires.aluIn2.length(); i++) {
			if ((Wires.aluIn1.charAt(i)=='0' && Wires.aluIn2.charAt(i)=='1')
					|| (Wires.aluIn1.charAt(i)=='1' && Wires.aluIn2.charAt(i)=='0')) {
				Wires.aluResult += "1";
			}
			else if (Wires.aluIn1.charAt(i)=='0' && Wires.aluIn2.charAt(i)=='0') {
				Wires.aluResult += "0";
			}
			else {
				Wires.aluResult += "1";
			}
		}
		while (Wires.aluResult.length() < 32) {
			Wires.aluResult= "0" +Wires.aluResult;
		}
	}

	public static void slt(){
		Wires.aluResult = (BinToDec(Wires.aluIn1)<BinToDec(Wires.aluIn2))? "1111111111111111111111111111111":"00000000000000000000000000000000" ;
	}

	public static void sltu() {
		int num1 = Integer.parseInt(Wires.aluIn1, 2);
		int num2 = Integer.parseInt(Wires.aluIn2, 2);
		Wires.aluResult = (num1<num2)? "1111111111111111111111111111111":"00000000000000000000000000000000";		
	}

	public static void nor() {
		or();
		String temp = "";
		for (int i=0; i<Wires.aluResult.length(); i++) {
			if (Wires.aluResult.charAt(i) == '0') {
				temp += '1';
			}
			else {
				temp += '0';
			}
		}
		while (temp.length() < 32) {
			temp = "0" + temp;
		}
		Wires.aluResult = temp;
	}

	public static void AluOperation(){
		if(Wires.aluConOut.equals("0010")){
			add();
		}
		else {
			if(Wires.aluConOut.equals("0110")){
				subtract();
			}
			else {
				if(Wires.aluConOut.equals("0000")){
					and();
				}	
				else {
					if(Wires.aluConOut.equals("0001")){
						or();
					}	
					else {
						if(Wires.aluConOut.equals("0111")){
							slt();
						}
						else {
							if(Wires.aluConOut.equals("1000")){
								sltu();
							}
							else {
								if(Wires.aluConOut.equals("1001")){
									nor();
								}
								else {
									if(Wires.aluConOut.equals("1100")){
										multiply();
									}
									else {
										if(Wires.aluConOut.equals("1010")){
											sll();
										}
										else {
											if(Wires.aluConOut.equals("1011")){
												srl();
											}
											else {
												if(Wires.aluConOut.equals("0101")){ //beq 
													subtract();
													if(Integer.parseInt(Wires.aluResult)==0)
														Wires.zero = 1;
													else 
														Wires.zero = 0;
													Branch.setBranchPCValue();
												}
												else {
													if(Wires.aluConOut.equals("0011")){ //bne 
														subtract();
														if(Integer.parseInt(Wires.aluResult)!=0)
															Wires.zero = 1;
														else 
															Wires.zero = 0;
														Branch.setBranchPCValue();
													}
													else {
														if(Wires.aluConOut.equals("0100")){ //addi, lui
															addi();
														}
													
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		if(Wires.memToReg==0) {
			Wires.writeData = Wires.aluResult;
		}
	}

	public static void main (String [] args) {
		Wires.aluIn1 = "00000000000000000000000000000001";
		Wires.aluIn2 = "00000000000000000000000000000011";
		Wires.signExtendo = "00000000000000000000000000000011";
		//nor();
		//add();
		//and();
		//slt();
		//sll();
		//srl();
		//multiply();
		addi();
		System.out.println(Wires.aluResult);

	}

}

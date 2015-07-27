
public class AluControl {

	public static void aluControlOutput(){
		switch(Wires.aluOp){
		case "000": Wires.aluConOut = "0010";break; //lw,sw,lb,lbu as they all depend on add
		case "001": Wires.aluConOut = "0101";break; //beq
		case "010": if(Wires.functCode.equals("100000"))Wires.aluConOut = "0010"; //ADD
		else {
			if(Wires.functCode.equals("100010"))Wires.aluConOut = "0110"; //SUBTRACT
			else {
				if(Wires.functCode.equals("100100"))Wires.aluConOut = "0000"; //AND
				else {
					if(Wires.functCode.equals("100101"))Wires.aluConOut = "0001"; //OR
					else {
						if(Wires.functCode.equals("101010"))Wires.aluConOut = "0111"; //slt
						else {
							if(Wires.functCode.equals("101011"))Wires.aluConOut = "1000"; //sltu
							else {
								if(Wires.functCode.equals("100111"))Wires.aluConOut = "1001"; //nor
								else {
									if(Wires.functCode.equals("011000"))Wires.aluConOut = "1100"; //mul
									else {
										if(Wires.functCode.equals("000000"))Wires.aluConOut = "1010"; //sll
										else {
											if(Wires.functCode.equals("000010"))Wires.aluConOut = "1011"; //srl
										}
									}
								}
							}
						}

					}
				}
			}
		}break;
		case "011": Wires.aluConOut = "0011";break; //bne
		case "100": Wires.aluConOut = "0100";break; //addi, lui both depend on adding

		}
	}

}

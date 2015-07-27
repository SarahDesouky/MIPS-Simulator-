
public class Jump {

	
	public Jump() {
	}
	
	public static void setJumpPCValue(){
		if(Wires.jump==1){
		String PC = RegisterFiles.PC.value;
		String sector = PC.substring(0,4);
		Wires.jumpAddOut = sector+Wires.jumpAddIn + "00";	
			RegisterFiles.PC.value = Wires.jumpAddOut;
		}
		else {
			RegisterFiles.PC.value = Wires.branchMUXo;
		}
	}
	
	public static void main(String[] args){
		Wires.jump = 1;
		RegisterFiles.PC.value = "11110000000000000000000000000000";
		Wires.jumpAddIn = "00000000000000010000000000";
		setJumpPCValue();
		System.out.println(RegisterFiles.PC.value);
	}
}


public class Branch {

	
	public static void setBranchPCValue(){
		if(Wires.branch==1 &&  Wires.zero ==1) {
			RegisterFiles.signExtend();
			System.out.println("branch class print" + Wires.signExtendo + " PC add out" + Wires.PCAddOut);
			String bAddress = Simulator.adder(Wires.signExtendo, Wires.PCAddOut);
			System.out.println("branch address" + bAddress);
			Wires.branchMUXo = bAddress;
			RegisterFiles.PC.value = bAddress;
		}
		else {
			Wires.branchMUXo = Wires.PCAddOut;
		}
	}
	
}

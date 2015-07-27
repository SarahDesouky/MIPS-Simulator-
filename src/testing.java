
public class testing {

	/**
	 * @param args
	 */
	private static String nor(String input1, String input2) {
		int num1 = integerValueOf(input1);
		int num2 = integerValueOf(input2);
		String result = Integer.toBinaryString(~(num1 | num2));
		while (result.length() < 32) {
			result = "0" + result;
		}
		return result;
	}

	public static int integerValueOf(String binaryString) {
		if (binaryString.charAt(0) == '1') {
			String result = binaryString;
			result = result.replace('0', '2');
			result = result.replace('1', '0');
			result = result.replace('2', '1');
			int num = Integer.parseInt(result, 2) + 1;
			return -num;
		} else {
			return Integer.parseInt(binaryString, 2);
		}
	}
	
	public static int BinToDec(String Bin){
		return Integer.parseInt(Bin,2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x = "101";
		int i = Integer.parseInt(x,2);
		System.out.println(i);
		String y = Integer.toBinaryString(i);
		System.out.println(2*2);
		
		int h = 1|0;
		int g = ~h;
		int k = BinToDec("100");
		int m  = BinToDec("110");
		//System.out.println(Integer.toBinaryString(~(k|m)));
		String test = "alaa";
		test += "s";
		
		Wires.aluIn1 = "101";
		Wires.aluIn2 = "110";
		//nor(Wires.aluIn1, Wires.aluIn2);
		
		//System.out.println(test);
		
		//System.out.println(integerValueOf("0101"));
		
		//System.out.println(nor("101","110"));
		
		
		//System.out.println(nor(Wires.aluIn1, Wires.aluIn2));
		
	}

}


public class Decryptor {
	
	/*
	 * initialize data variable as integer
	 * initialize string builder
	 * initialize method to set the value of data
	 * 
	 * method of decryption {
	 * 		convert data to a string of numbers
	 * 		convert the string numbers to a character array of digits named "digits1"
	 * 		initialize an empty array of integers named "digits2"
	 * 		for every element in "digits1" {
	 * 			convert to integer and assign to integer variable xd
	 * 			add 3 to xd
	 * 			find the remainder of xd divided by 10
	 * 			assign the final value of xd to "digits2" element of matching position
	 * 		}
	 * 		in "digits2" swap the elements in the first and second position with the elements in the third and fourth position
	 * 		for every element in "digits2" {
	 * 			build together in a string "y"
	 * 		}
	 * 		convert y to an integer and assign to data
	 * 		return the final value of data
	 * }
	 */
	
	static int data;
	
	static StringBuilder numberString = new StringBuilder();
	
	public static int setData(int newData) {
		return data = newData;
	}
	
	public static int decrypt() {
		String number = String.format("%04d", data);
		char[] digits1 = number.toCharArray();
		int[] digits2 = new int[4];
		for(int i = 0; i < digits1.length; i++) {
			int xd = Character.getNumericValue(digits1[i]) + 3;
			xd = xd % 10;
			digits2[i] = xd;
		}
		int temp1 = digits2[0];
		int temp2 = digits2[1];
		digits2[0] = digits2[2];
		digits2[1] = digits2[3];
		digits2[2] = temp1;
		digits2[3] = temp2;
		for(int y : digits2) {
			numberString.append(y);
		}
		data = Integer.parseInt(numberString.toString());
		return data;
	}
}
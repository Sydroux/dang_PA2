import java.util.Scanner;

public class Application {
	
	/*
	 * initialize answer variable for the first question (encryption)
	 * initialize answer variable for the second question (decryption)
	 * 
	 * forever loop {
	 * 		print "Do you want to encrypt data? Y/N"
	 * 		wait for input
	 * 		if input = Y {
	 * 			print "Enter the four digit number to be encrypted."
	 * 			wait for number input
	 * 			if number input has less than 5 digits {
	 * 				encrypt number
	 * 				print "Your encryption is (encrypted number)"
	 * 			} else {
	 * 			print "Not a valid number. Number must be four digits in length."
	 *			}
	 * 		} else if input = N {
	 * 			break loop
	 * 		} else {
	 * 			print "Not a valid answer. Please answer with Y or N."
	 * 		}
	 * }
	 * 
	 * Same process as above for decryption, replacing every mention of ecryption with decryption
	 */
	
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String decision1 = ("something");
		String decision2 = ("something else");
		
		while (true) {
			System.out.println("Do you want to encrypt data? Y/N");
			decision1 = sc.next();			
			if(decision1.equalsIgnoreCase("Y")) {
				System.out.println("Enter the four digit number to be encrypted.");
				int num = sc.nextInt();
					if (num <= 9999) {
						Encryptor.setData(num);
						int encryption = Encryptor.encrypt();
						System.out.printf("Your encryption is %04d.\n", encryption);
						break;
					} else {
						System.out.println("Not a valid number. Number must be four digits in length.");
					}
			} else if (decision1.equalsIgnoreCase("N")) {
				break;
			} else {
				System.out.println("Not a valid answer. Please answer with Y or N.");
			}
		}
		while (true) {
			System.out.println("Do you want to decrypt data? Y/N");
			decision2 = sc.next();			
			if(decision2.equalsIgnoreCase("Y")) {
				System.out.println("Enter the four digit number to be decrypted.");
				int num = sc.nextInt();
					if (num <= 9999) {
						Decryptor.setData(num);
						int decryption = Decryptor.decrypt();
						System.out.printf("Your decryption is %04d.\n", decryption);
						break;
					} else {
						System.out.println("Not a valid number. Number must be four digits in length.");
					}
			} else if (decision2.equalsIgnoreCase("N")) {
				break;
			} else {
				System.out.println("Not a valid answer. Please answer with Y or N.");
			}
		}
		sc.close();
	}
}

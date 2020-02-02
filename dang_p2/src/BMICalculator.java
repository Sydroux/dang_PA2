import java.util.Scanner;

public class BMICalculator {
	
	/*
	 * initialize a string variable "unitType"
	 * initialize a double variable "weight"
	 * initialize a double variable "height"
	 * initialize a double variable "BMI"
	 * initialize a string variable "BMICategory"
	 * 
	 * method to read user data {
	 * 		calls the method to read unit type
	 * 		calls the method to read measurement data
	 * }
	 * 
	 * method to read unit type {
	 * 		forever loop {
	 * 			print out "Which measurement system do you prefer: imperial or metric?"
	 * 			wait for input
	 * 			if user chose imperial {
	 * 				set unit type as imperial
	 * 				break loop
	 * 			} else if user chose metric {
	 * 				set unit type as metric
	 * 				loop
	 * 			} else {
	 * 				print out "That is not a valid measurement type."
	 * 			}
	 * 		}
	 * }
	 * 
	 * method to read measurement data {
	 * 		if unit type is imperial {
	 * 			call the method to read imperial data
	 * 		} else if unit type is metric {
	 * 			call the method to read metric data
	 * 		}
	 * }
	 * 
	 * method to read metric data {
	 * 		print "What is your weight in kilograms?"
	 * 		call the method to set the weight
	 * 		print "What is your height in meters?"
	 * 		call the method to set the height
	 * }
	 * 
	 * method to read imperial data {
	 * 		print "What is your weight in pounds?"
	 * 		call the method to set the weight
	 * 		print "What is your height in inches?"
	 * 		call the method to set the height
	 * }
	 * 
	 * method to calculate the user's BMI {
	 * 		initialize a double variable "numerator"
	 * 		initialize a double variable "denominator"
	 * 		if unit type is imperial {
	 * 			use the imperial formula to calculate BMI
	 * 		} else if unit type is metric {
	 * 			use the metric formula to calculate BMI
	 * 		}
	 * 		return value of BMI
	 * }
	 * 
	 * method to calculate the user's BMI category {
	 * 		if BMI is less than 18.5 {
	 * 			set category to "under weight"
	 * 		} else if BMI is between 18.5 and 24.9 {
	 * 			set category to "normal weight" 
	 * 		} else if BMI is between 25 and 29.9 {
	 * 			set category to "overweight" {
	 * 		} else if BMI is 30 or over {
	 * 			set category to "obese"
	 * 		}
	 * }
	 * 
	 * method to display the user's BMI and BMI category {
	 * 		print "Your BMI is (BMI value)"
	 * 		call the method to calculate the user's BMI category
	 * 		print "You are (BMI category)"
	 * }
	 * 
	 * method to get weight {
	 * 		return the value of weight
	 * }
	 * 
	 * method to set weight {
	 * 		wait for number input
	 * 		if number input is negative {
	 * 			exit program
	 * 		}
	 * }
	 * 
	 * method to get height {
	 * 		return the value of height
	 * }
	 * 
	 * method to set height {
	 * 		wait for number input
	 * 		if number input is negative {
	 * 			exit program
	 * 		}
	 * }
	 * 
	 * method to get BMI {
	 * 		return the value of BMI
	 * }
	 * 
	 * method to get BMI category {
	 * 		return the BMI category
	 * }
	 * 
	 * main method {
	 * 		initialize a new class instance
	 * 		call the method to read user data
	 * 		call the method to calculate BMI
	 * 		call the method to display BMI
	 * }
	 */
	
	Scanner sc = new Scanner(System.in);
	String unitType;
	double weight;
	double height;
	double BMI;
	String BMICategory;

	
	public void readUserData() {
		this.readUnitType();
		this.readMeasurementData();
	}
	
	private void readUnitType() {
		while(true) {
			System.out.println("Which measurement system do you prefer: imperial or metric?");
			unitType = sc.next();
			if(unitType.equalsIgnoreCase("imperial")) {
				unitType = ("imperial");
				break;
			} else if(unitType.equalsIgnoreCase("metric")) {
				unitType = ("metric");
				break;
			} else {
				System.out.println("That is not a valid measurement type.");
			}
		}
	}
		
	private void readMeasurementData() {
		if(unitType.equalsIgnoreCase("imperial")) {
			this.readImperialData();
		} else if(unitType.equalsIgnoreCase("metric")) {
			this.readMetricData();
		}
	}
	
	private void readMetricData() {
		System.out.println("What is your weight in kilograms?");
		this.setWeight();
		System.out.println("What is your height in meters?");
		this.setHeight();
	}
	
	private void readImperialData() {
		System.out.println("What is your weight in pounds?");
		this.setWeight();
		System.out.println("What is your height in inches?");
		this.setHeight();
	}
	
	public double calculateBmi() {
		double numerator = 0;
		double denominator = 0;
		if(unitType.equalsIgnoreCase("imperial")) {
			numerator = 703 * weight;
			denominator = height * height;
		} else if(unitType.equalsIgnoreCase("metric")) {
			numerator = weight;
			denominator = height * height;
		}
		BMI = numerator / denominator;
		return BMI;
	}
	
	private void calculateBmiCategory() {
		if(BMI < 18.5) {
			BMICategory = ("underweight");
		} else if(BMI >= 18.5 && BMI <= 24.9) {
			BMICategory = ("normal weight");
		} else if(BMI >= 25 && BMI <= 29.9) {
			BMICategory = ("overweight");
		} else if(BMI > 30) {
			BMICategory = ("obese");
		}
	}
	
	public void displayBmi() {
		System.out.printf("Your BMI is %f.\n", BMI);
		this.calculateBmiCategory();
		System.out.println("You are " + BMICategory + ".");
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public void setWeight() {
		weight = sc.nextInt();
		if(weight < 0) {
			System.exit(0);
		}
	}
	
	public double getHeight() {
		return this.height;
	}
	
	public void setHeight() {
		height = sc.nextInt();
		if(height < 0) {
			System.exit(0);
		}
	}
	
	public double getBmi() {
		return this.BMI;
	}
	
	public String getBmiCategory() {
		return this.BMICategory;
	}

	public static void main(String[] args) {
	    BMICalculator app = new BMICalculator();
	    app.readUserData();
	    app.calculateBmi();
	    app.displayBmi();
	}
}

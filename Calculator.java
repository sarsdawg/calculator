
import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		System.out.println("This is a basic calculator program that allows you to "
				+ "add, subtract, multiply, divide, find the square root, and determine "
				+ "the value of number raised to a certain power (exponentiation).");
		System.out.println();
		System.out.println();
		System.out.println("You can do operations on binary, octal, decimal, hexidecimal, "
				+ "and floating point numbers.");
		System.out.println();
		System.out.println();
		Scanner scan = new Scanner(System.in);
		JavaAppMath calc = new JavaAppMath();
		while(true) {
			System.out.println("What operation do you want to perform?");
			System.out.println("     1 = addition");
			System.out.println("     2 = subtraction");
			System.out.println("     3 = multiplication");
			System.out.println("     4 = division");
			System.out.println("     5 = square root");
			System.out.println("     6 = exponentiation");
			System.out.println("     7 = conversion");
			System.out.println("     8 = exit");
			String opChoice = scan.next();
			System.out.println();
			switch(opChoice) {
				case("1"):
					addition(scan, calc);
					break;
				case("2"):
					subtraction(scan, calc);
					break;
				case("3"):
					multiplication(scan, calc); 
					break;
				case("4"):
					division(scan, calc);
					break;
				case("5"):
					squareRoot(scan, calc);
					break;
				case("6"):
					exponentiation(scan, calc);
					break;
				case("7"):
					conversion(scan, calc);
					break;
				case("8"):
					System.out.println("Goodbye!");
					return;
				default:
					System.out.println("Invalid entry. Please enter a choice as "
							+ "1, 2, 3, 4, 5, 6, 7, or 8.");
					System.out.println();
					break;
			} //end switch
		} //end while
	} //end main
	
	private static void addition(Scanner scan, JavaAppMath calc) {
		String a = null;
		String b = null;
		System.out.println("You chose addition.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the first number to add: ");
			a = scan.next();
		} while(!argCheck(base, a));
		do {
			System.out.println();
			System.out.println("Please enter the second number to add: ");
			b = scan.next();
		} while(!argCheck(base, b));
		if (base == 0) 
			calc.setRequest("ADD",
				Float.valueOf(a),
				Float.valueOf(b));
		else
			calc.setRequest("ADD", 
				Integer.parseInt(a,base),
				Integer.parseInt(b,base));
		a = a.toUpperCase();
		b = b.toUpperCase();
		System.out.println();
		System.out.println(a + " + " + b + " = " + showResult(calc, base));
		System.out.println();
	} //end addition
	
	private static void subtraction(Scanner scan, JavaAppMath calc) {
		String a = null;
		String b = null;
		System.out.println("You chose subtraction.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the minuend (number to subtract from): ");
			a = scan.next();
		} while(!argCheck(base, a));
		do {
			System.out.println();
			System.out.println("Please enter the subtrahend (number to subtract): ");
			b = scan.next();
		} while(!argCheck(base, b));
		if (base == 0) 
			calc.setRequest("SUB",
				Float.valueOf(a),
				Float.valueOf(b));
		else
			calc.setRequest("SUB", 
				Integer.parseInt(a,base),
				Integer.parseInt(b,base));
		a = a.toUpperCase();
		b = b.toUpperCase();
		System.out.println();
		System.out.println(a + " - " + b + " = " + showResult(calc, base));
		System.out.println(); 
	} //end subtraction
	
	private static void multiplication(Scanner scan, JavaAppMath calc) {
		String a = null;
		String b = null;
		System.out.println("You chose multiplication.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the first number to multiply: ");
			a = scan.next();
		} while(!argCheck(base, a));
		do {
			System.out.println();
			System.out.println("Please enter the second number to multiply: ");
			b = scan.next();
		} while(!argCheck(base, b));
		if (base == 0) 
			calc.setRequest("MUL",
				Float.valueOf(a),
				Float.valueOf(b));
		else
			calc.setRequest("MUL", 
				Integer.parseInt(a,base),
				Integer.parseInt(b,base));
		a = a.toUpperCase();
		b = b.toUpperCase();
		System.out.println();
		System.out.println(a + " x " + b + " = " + showResult(calc, base));
		System.out.println(); 
	} //end multiplication
	
	private static void division(Scanner scan, JavaAppMath calc) {
		String a = null;
		String b = null;
		System.out.println("You chose division.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the numerator: ");
			a = scan.next();
		} while(!argCheck(base, a));
		do {
			System.out.println();
			System.out.println("Please enter the denominator: ");
			b = scan.next();
		} while(!argCheck(base, b));
		if (base == 0) 
			calc.setRequest("DIV",
				Float.valueOf(a),
				Float.valueOf(b));
		else
			calc.setRequest("DIV", 
				Integer.parseInt(a,base),
				Integer.parseInt(b,base));
		a = a.toUpperCase();
		b = b.toUpperCase();
		System.out.println();
		System.out.println(a + " / " + b + " = " + showResult(calc, base));
		System.out.println(); 
	} //end division
	
	private static void squareRoot(Scanner scan, JavaAppMath calc) {
		String a = null;
		System.out.println("You chose square root.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the number for which you want to find the square root: ");
			a = scan.next();
		} while(!argCheck(base, a));
		if (base == 0) 
			calc.setRequest("SQR",
				Float.valueOf(a));
		else
			calc.setRequest("SQR", 
				Integer.parseInt(a,base));
		a = a.toUpperCase();
		System.out.println();
		System.out.println("The square root of " + a + " is " + showResult(calc, base));
		System.out.println(); 
	} //end squareRoot
	
	private static void exponentiation(Scanner scan, JavaAppMath calc) {
		String a = null;
		String b = null;
		System.out.println("You chose exponentiation.");
		int base = getBase("What base do you want to work with?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the number you want to raise to a power: ");
			a = scan.next();
		} while(!argCheck(base, a));
		do {
			System.out.println();
			System.out.println("Please enter the power to which you want to raise the number: ");
			b = scan.next();
		} while(!argCheck(base, b));
		if (base == 0) 
			calc.setRequest("EXP",
				Float.valueOf(a),
				Float.valueOf(b));
		else
			calc.setRequest("EXP", 
				Integer.parseInt(a,base),
				Integer.parseInt(b,base));
		a = a.toUpperCase();
		b = b.toUpperCase();
		System.out.println();
		System.out.println(a + " to the power of " + b + " = " + showResult(calc, base));
		System.out.println();
	} //end exponentiation
	
	private static void conversion(Scanner scan, JavaAppMath calc) {
		String a = null;
		int baseIn = 0;
		int baseOut = 0;
		String baseInName = null;
		String baseOutName = null;
		System.out.println("You chose conversion.");
		baseIn = getBase("What base do you want to convert from?", scan);
		do {
			System.out.println();
			System.out.println("Please enter the number you want to convert: ");
			a = scan.next();
		} while(!argCheck(baseIn, a));
		baseOut = getBase("What base do you want to convert to?", scan);
		switch(baseIn) {
			case(2):
				calc.setRequest("CON", "BIN", a); 
				baseInName = "binary";
				break;
			case(8):
				calc.setRequest("CON", "OCT", a);
				baseInName = "octal";
				break;
			case(10):
				calc.setRequest("CON", "INT", a);
				baseInName = "decimal";
				break;
			case(16):
				calc.setRequest("CON", "HEX", a);
				baseInName = "hexadecimal";
				break;
			case(0):
				calc.setRequest("CON", "FLO", a);
				baseInName = "floating point";
				break;
			default:
				System.out.println("Unknown error.");
				break;
		} //end switch
		switch(baseOut) {
			case(2):
				baseOutName = "binary";
				break;
			case(8):
				baseOutName = "octal";
				break;
			case(10):
				baseOutName = "decimal";
				break;
			case(16):
				baseOutName = "hexadecimal";
				break;
			case(0):
				baseOutName = "floating point";
				break;
			default:
				System.out.println("Unknown error.");
				break;
		} //end switch
		a = a.toUpperCase();
		System.out.println();
		System.out.println(a + " (" + baseInName + ") converted to " + 
							baseOutName + " = " + showResult(calc, baseOut));
		System.out.println();
	} //end conversion
	
	private static int getBase(String message, Scanner scan) {
		while(true) {
			System.out.println();
			System.out.println(message);
			System.out.println("     B = binary");
			System.out.println("     O = octal");
			System.out.println("     D = decimal");
			System.out.println("     H = hexadecimal");
			System.out.println("     F = floating point");
			String baseChoice = scan.next();
			switch(baseChoice.toUpperCase()) {
				case("B"):
					System.out.println();
					System.out.println("You chose binary (base 2).");
					return(2);
				case("O"):
					System.out.println();
					System.out.println("You chose octal (base 8).");
					return(8);
				case("D"):
					System.out.println();
					System.out.println("You chose decimal (base 10).");
					return(10);
				case("H"):
					System.out.println();
					System.out.println("You chose hexadecimal (base 16).");
					return(16);
				case("F"):
					System.out.println();
					System.out.println("You chose decimal-based floating point.");
					return(0);
				default:
					System.out.println();
					System.out.println("Invalid entry. Please enter "
							+ "B, O, D, H, or F.");
					break;
			} //end switch
		}//end while
	}
	
	// Check string input to ensure that it parses as the indicated base type.
	private static boolean argCheck(int base, String arg) {
		int len = arg.length();
		char c;
		for (int i=0; i<len; i++) {
			c = arg.charAt(i);
			switch (base) {
				case (2) : 
					if (c != '0' && c != '1' && c!= '-') {
						System.out.println();
						System.out.println("Invalid entry. Please enter " 
								+ "only '0-1' for binary numbers.");
						return false;
					}
					break;
				case (8) :
					if (c != '0' && c != '1' && c != '2' && c != '3' &&
					    c != '4' && c != '5' && c != '6' && c != '7' && c != '-') {
						System.out.println();
						System.out.println("Invalid entry. Please enter " 
								+ "only '0-7' for octal numbers.");
						return false;
					}
					break;
				case (10) :
					if (c != '0' && c != '1' && c != '2' && c != '3' &&
				        c != '4' && c != '5' && c != '6' && c != '7' &&
				        c != '8' && c != '9' && c!= '-') {
						System.out.println();
						System.out.println("Invalid entry. Please enter " 
								+ "only '0-9' for decimal numbers.");
						return false;
					}
					break;
				case (16) : 
					if (c != '0' && c != '1' && c != '2' && c != '3' &&
					    c != '4' && c != '5' && c != '6' && c != '7' &&
					    c != '8' && c != '9' && c != 'a' && c != 'A' &&
						c != 'b' && c != 'B' && c != 'c' && c != 'C' &&
						c != 'd' && c != 'D' && c != 'e' && c != 'E' &&
						c != 'f' && c != 'F' && c != '-') {
						System.out.println();
						System.out.println("Invalid entry. Please enter " 
								+ "only '0-9' and 'A-F' for hexadecimal numbers.");
						return false;
					}
					break;
				case (0) :
					if (c != '0' && c != '1' && c != '2' && c != '3' &&
				    	c != '4' && c != '5' && c != '6' && c != '7' &&
				    	c != '8' && c != '9' && c != '.' && c != '-') {
						System.out.println();
						System.out.println("Invalid entry. Please enter " 
								+ "only '0-9', '-' and, '.' for floating point numbers.");
						return false;
					}
					break;
				default :
					return false;
			} //end switch
		} //end for loop
		//check for improperly placed '-'
		for (int i=len-1; i>=0; i--)
			if (arg.charAt(i) == '-' && i!=0) {
				System.out.println();
				System.out.println("Invalid entry. Your '-' must be before all other values.");
				return false;
			}
		//check for unaccompanied '-'
		if (len == 1 && arg.charAt(0) == '-') {
			System.out.println();
			System.out.println("Invalid entry. You must enter a value after the '-'.");
			return false;
		}
		//check for a leading zero
		if (base != 0 && len > 1 && arg.charAt(0) == '0') {
			System.out.println();
			System.out.println("Invalid entry. You cannot have a leading zero.");
			return false;
		}
		if (base == 0) {
			// check for a decimal point with nothing after it:
			if (arg.charAt(len-1) == '.') {
				System.out.println();
				System.out.println("Invalid entry. You must enter a value after the decimal " +
						"point for a floating point number.");
				return false;
			}
			// check for multiple decimal points:
			boolean dPoint = false;
			for (int i=len-2; i>=0; i--) {
				if (dPoint == true) 
					if (arg.charAt(i) == '.') {
						System.out.println();
						System.out.println("Invalid entry. You cannot have multiple decimal " +
								"points.");
						return false;
					}
				if (arg.charAt(i) == '.')
					dPoint = true;
			}
			//check for unaccompanied '.'
			if (len == 1 && arg.charAt(0) == '.') {
				System.out.println();
				System.out.println("Invalid entry. You must have values before and after the " +
						"decimal point.");
				return false;
			}
			//check for a leading zero
			if ((len > 1 && arg.charAt(0) == '0' && arg.charAt(1) != '.') ||
				(len > 1 && arg.charAt(0) == '-' && arg.charAt(1) == '0' && arg.charAt(2) != '.')) {
				System.out.println();
				System.out.println("Invalid entry. You cannot have a leading zero unless it is " +
						"immediately followed by a '.'");
				return false; 
			}
		}
		return true;
	} //end argCheck
	
	private static String showResult(JavaAppMath calc, int base) {
		switch(base) {
			case(2):
				return calc.getBinResult();
			case(8):
				return calc.getOctResult();
			case(10):
				return Integer.toString(calc.getIntResult());
			case(16):
				return calc.getHexResult();
			case(0):
				return Float.toString(calc.getFloatResult());
			default:
				return "Unknown Error";
		}
	} //end showResult
}

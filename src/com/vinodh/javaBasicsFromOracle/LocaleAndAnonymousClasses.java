package com.vinodh.javaBasicsFromOracle;

/**
 * Writing Classes inside Methods: Locale (Class Declarations)+ Anonymous(without Class Name i.e., Expression)
 * static variables or methods are not allowed inside Locale except static final variable
 * 
 * Interfaces cannot be declared in BLock
 * 
 * Anonynous : declare and instantiate at same time 
 * 
 * @author Pavan
 *
 */
public class LocaleAndAnonymousClasses {
	// Locale class can access enclosing class instance variable
	static String regularExpression = "[^0-9]";

	public static void validatePhoneNumber(String phoneNumber1, String phoneNumber2) {
// catured variable :: Locale class can access this local variable(only final) & parameters passing in the block 
		final int numberLength = 10;

		// Valid in JDK 8 and later: no need to mention as final, it is effectively final

		// int numberLength = 10;

		class PhoneNumber {

			String formattedPhoneNumber = null;

			PhoneNumber(String phoneNumber) {
				// numberLength = 7; ==> "local variables referenced from an inner class must be final or effectively final, 
				String currentNumber = phoneNumber.replaceAll(regularExpression, "");
				if (currentNumber.length() == numberLength)
					formattedPhoneNumber = currentNumber;
				else
					formattedPhoneNumber = null;
			}

			public String getNumber() {
				return formattedPhoneNumber;
			}

			// Valid in JDK 8 and later: method parameters can be accessed to Locale class methods

			 public void printOriginalNumbers() {
			System.out.println("Original numbers are " + phoneNumber1 +
			 " and " + phoneNumber2);
			 }
		}

		PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
		PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

		// Valid in JDK 8 and later:

		// myNumber1.printOriginalNumbers();

		if (myNumber1.getNumber() == null)
			System.out.println("First number is invalid");
		else
			System.out.println("First number is " + myNumber1.getNumber());
		if (myNumber2.getNumber() == null)
			System.out.println("Second number is invalid");
		else
			System.out.println("Second number is " + myNumber2.getNumber());

	}

	public static void main(String... args) {
		validatePhoneNumber("123-456-7890", "456-7890");
	}
}

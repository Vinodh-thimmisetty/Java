import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the month in digits like 1 for Jan, 2 for Feb etc.");
		int month =scanner.nextInt();
		switch(month){
		case 1:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.JANUARY.maxLength());
		return;
		case 2:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.FEBRUARY.maxLength());
		return;
		case 3:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.MARCH.maxLength());
		return;
		case 4:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.APRIL.maxLength());
		return;
		case 5:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.MAY.maxLength());
		return;
		case 6:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.JUNE.maxLength());
		return;
		case 7:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.JULY.maxLength());
		return;
		case 8:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.AUGUST.maxLength());
		return;
		case 9:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.SEPTEMBER.maxLength());
		return;
		case 10:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.OCTOBER.maxLength());
		return;
		case 11:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.NOVEMBER.maxLength());
		return;
		case 12:System.out.println("No of Days in "+java.time.Month.of(month)+ " is " + java.time.Month.DECEMBER.maxLength());
		return;
		default:
			System.out.println("We are unable to find your Calendar !! Please enter something humans can understand");
		return;
		}
		
	}

}

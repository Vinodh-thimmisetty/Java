import java.util.Scanner;

public class Program5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a year");
		int year = scanner.nextInt();
		boolean isLeap = ((year%4 == 0 && year%400 == 0))? true:false;
		 if(isLeap){
			 System.out.println("leap year");
		 }else{
			 System.out.println("Not a leap year");
		 }
	}

}

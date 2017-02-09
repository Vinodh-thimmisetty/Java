import java.util.Scanner;

public class Program2 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Enter your name please !!");
		 String name= scanner.nextLine();
		 System.out.println("Enter your salary ($/hour) !!");
		 Double salary= scanner.nextDouble();
		 System.out.println("How many hours did you worked in the past week !!");
		 Double hours = scanner.nextDouble();
		 
		 if(hours>40){
			 System.out.println("Your paycheck for last week ::"+(1.5*salary*hours)+" dollars");
		 }else{
			 System.out.println("Your paycheck for last week ::"+(salary*hours)+" dollars");
			 	 
		 }
		 
		 
		 
		 
	}

}

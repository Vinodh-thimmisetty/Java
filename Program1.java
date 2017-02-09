import java.util.Scanner;

public class Program1 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Total Number of Persons you want to check \n Note: Pass only numeric values");
		int noOfPersons = scanner.nextInt();
		int[] person = new int[noOfPersons];
		for (int i = 0; i < person.length; i++) {
			System.out.println("Enter the age of Person-" + (i + 1));
			int local = scanner.nextInt();
			if (local == 0) {
				System.out.println("How can a kid less than a year write a java code :-)");
				i = i - 1;
				continue;
			}
			boolean isDuplicates = false;
			for (int j = 0; j < person.length; j++) {

				if (local == person[j]) {
					System.out.println("You Kidding me !! I don't allow two persons having same age");
					i = i - 1;
					isDuplicates = true;
					break;
				}
			}
			if (!isDuplicates) {
				person[i] = local;
			}
		}

		int min = 0, max = 0;
		for (int i = 1; i < person.length; i++) {
			if (person[i] < person[min]) {
				min = i;
			}
			if (person[i] > person[max]) {
				max = i;
			}
		}

		System.out.println("The youngest is person-" + (min + 1) + " of age " + person[min]);
		System.out.println("The Oldest is person-" + (max + 1) + " of age " + person[max]);
	}

}

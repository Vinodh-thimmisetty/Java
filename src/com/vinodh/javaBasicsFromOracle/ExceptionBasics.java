package com.vinodh.javaBasicsFromOracle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.List;

/***
 * Checked Exception : Compile time exceptions, Application related & can
 * handled by try/catch blocks ==> like FilenotFoundException Unchecked :
 * Runtime(Applicatin related , which will occur only at runtime NUll Pointer
 * exception) + Errors(Systems error)
 * 
 * 
 * Exception Handler Components: TRY, CATCH, FINALLY
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class ExceptionBasics {

	private List<Integer> list;
	private static final int SiZE = 10;

	public ExceptionBasics() {
		for (int i = 0; i < SiZE; i++) {
			list.add(new Integer(i));

		}
	}

	public void writeList() {
		// Checked Exception if no try-catch block exists
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(new FileWriter("output.txt"));

			for (int i = 0; i < SiZE; i++) {
				// Unchecked Exception of ArrayIndexOF Bound
				printWriter.println("value @@ " + i + " is " + list.get(i));
			}
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
		} catch (IOException e) {
			// TODO: handle exception
		} catch (Exception e) {

		} finally {
			if (printWriter != null) {

				printWriter.close();

			}
		}
	}

	// JAVA SE-7 Try-with resource statement & Multiple Exception handling
	// java.lang.AutoCloseable
	// IF exception occurs @ try & finally(while closing the resource) --> try block exception will be suppressed
	// IF exception occurs @ try-with resource & try--> try-with resource exceptions will be suppressed
	// You can retrieve these suppressed exceptions by calling the Throwable.getSuppressed method from the exception thrown by the try block
	public static String readFirstLine() throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
			return bufferedReader.readLine();

		}
		
		
	}

	public static void main(String[] args) {
		 
	}

}

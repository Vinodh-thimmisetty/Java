package com.vinodh.mustlearn.javaconcepts;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A Stream is a sequence of objects used to read from source or write to
 * destination one item at a time && Can handle any type of data from primitive
 * to Objects
 * 
 * There is two types of I/O operations ==> Bytes Vs Characters
 * 
 * @author Vinodh Kumar Thimmisetty
 *
 */
public class InputAndOutputStreams {

	public static void main(String[] args) throws IOException {
		/**
		 * Byte Streams: input and output of 8-bit bytes
		 */
		String packagePath = "src\\com\\vinodh\\mustlearn\\javaconcepts";

		// prior to java -7
		FileInputStream in = null;
		FileOutputStream out = null;
		try {
			in = new FileInputStream("C:\\Users\\Pavan\\git\\Java\\src\\com\\vinodh\\mustlearn\\javaconcepts\\input");
			out = new FileOutputStream(
					"C:\\Users\\Pavan\\git\\Java\\src\\com\\vinodh\\mustlearn\\javaconcepts\\output");
			System.out.println("inside file stream");
			int oneByte;
			while ((oneByte = in.read()) != -1) {
				out.write(oneByte);
			}
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			if (in != null) {
				in.close();

			}
			if (out != null) {
				out.close();
			}
		}

		// JAva- 7 way==> try with resource
		try (FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + File.separator + packagePath + File.separator + "input");
				FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir") + File.separator
						+ packagePath + File.separator + "byteStreamoutput")) {
			System.out.println("inside file steam --2");
			int oneByte;
			while ((oneByte = fileInputStream.read()) != -1) {
				outputStream.write(oneByte);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		/**
		 * Character Stream: Similar to byte stream but used for Characters
		 * Internalization is supported i.e., translated to and from local
		 * character set (16 bits)
		 * 
		 */

		try (FileReader fileReader = new FileReader(
				System.getProperty("user.dir") + File.separator + packagePath + File.separator + "input");
				FileWriter fileWriter = new FileWriter(System.getProperty("user.dir") + File.separator + packagePath
						+ File.separator + "charStreamOutput")) {
			System.out.println("inside char stream ---");
			int c;
			while ((c = fileReader.read()) != -1) {
				fileWriter.write(c);
			}

			// Line oriented i/o

			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(
					System.getProperty("user.dir") + File.separator + packagePath + File.separator + "input"));
					PrintWriter printWriter = new PrintWriter(new FileWriter(System.getProperty("user.dir")
							+ File.separator + packagePath + File.separator + "linebylineOutput"))) {
				System.out.println("inside char stream to read line by line---");

				String oneLine;
				while ((oneLine = bufferedReader.readLine()) != null) {
					fileWriter.write(oneLine);
				}

			}
		}

		/**
		 * Buffered Streams: Read/write content to buffer before reading/writing
		 * to underlying OS flush the data once buffer is full
		 */
		/*
		 * / BufferedReader bufferedReader = new BufferedReader(new
		 * FileReader("characterReading")); BufferedInputStream
		 * bufferedInputStream = new BufferedInputStream(new
		 * FileInputStream("byteReading"));
		 * 
		 * BufferedWriter bufferedWriter = new BufferedWriter(new
		 * FileWriter("characterWriting")); BufferedOutputStream
		 * bufferedOutputStream = new BufferedOutputStream(new
		 * FileOutputStream("byteWriting"));
		 * 
		 * BufferedWriter bufferedWriter2 = new BufferedWriter(new
		 * PrintWriter("autoFlushCharacterWriting")); BufferedOutputStream
		 * bufferedOutputStream2 = new BufferedOutputStream(new
		 * PrintStream("autoFlushbyteWriting"));
		 */

		/**
		 * Scanning: Breaking down input as tokens (white space is default
		 * token) scanner.useLocale() ==> support all locales support all data
		 * type , nextDouble () like nextInt() etc....
		 * 
		 * Formatting: converting data to specific format mentioned PRINT and
		 * PRINTLN format individual values in a standard way. FORMAT: formats
		 * almost any number of values based on a format string, with many
		 * options for precise formatting.
		 */
		try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(
				System.getProperty("user.dir") + File.separator + packagePath + File.separator + "input")))) {

			while (scanner.hasNext()) {
				System.out.println("scanner output token by token -----> " + scanner.next());
			}

		}

		/***
		 * 
		 * Commandline I/O : Standard streams VS Console System.in & System.out
		 * && System.err ==> standard Streams (Command line Interpreter) && BYTE
		 * Streams Console :: Advanced Standard stream(useful for secured
		 * password entry && CHAR Streams
		 * 
		 */

		/**
		 * DATA STREAMS :: Byte
		 * 
		 */
// Write
		try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(
				System.getProperty("user.dir") + File.separator + packagePath + File.separator + "dataStreamOutput")))) {
			
			for (int i = 0; i < prices.length; i++) {
				dataOutputStream.writeInt(units[i]);
				dataOutputStream.writeDouble(prices[i]);
				dataOutputStream.writeUTF(descs[i]);
				
			}

		}
		
		// Read
		
		try(DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(
				System.getProperty("user.dir") + File.separator + packagePath + File.separator + "dataStreamOutput")))){
			
			double price;
			int unit;
			String desc;
			double total = 0.0;
			
			while(true){
				  price = dataInputStream.readDouble();
			        unit = dataInputStream.readInt();
			        desc = dataInputStream.readUTF();
			        System.out.format("You ordered %d" + " units of %s at $%.2f%n",
			            unit, desc, price);
			        total += unit * price;
			}
		}catch (EOFException e) {
			// TODO: handle exception
		}

	}
	
	
	/**
	 * 
	 * Object Streams
	 *  writeobjects will stream  all of the other objects referring to it
	 * 
	 */

	// Data stream variables 
	static final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	static final int[] units = { 12, 8, 13, 29, 50 };
	static final String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

}

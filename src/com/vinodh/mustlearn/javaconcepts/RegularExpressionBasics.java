package com.vinodh.mustlearn.javaconcepts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionBasics {
	
	/** Similar to PERL Expression
	 * Regular Expressions: The metacharacters supported by this API are: <([{\^-=$!|]})?*+.>
	 * There are two ways to force a metacharacter to be treated as an ordinary character:
			1. precede the metacharacter with a backslash, or
			2. enclose it within \Q (which starts the quote) and \E (which ends it)
 
	 *  
	 */
	public static void main(String[] args) {
 		
// All alphabets and Numbers and CASE INSENSITIVE
				Pattern ptrn = Pattern.compile("[a-zA-Z0-9]",Pattern.CASE_INSENSITIVE);
				Matcher mtchr =ptrn.matcher("vinodhKumar5052");
				while (mtchr.find()) {
					System.out.println("All alphabets and Numbers CASE INSETIVE FLAG is matched with--"+mtchr.group()+"-- with regex @index===>" + mtchr.start());
		 		}
				 System.out.println("--------------------------------");

// All alphabets and Numbers
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]");
		Matcher matcher =pattern.matcher("vinodhKumar5052");
		while (matcher.find()) {
			System.out.println("All alphabets and Numbers is matched with--"+matcher.group()+"-- with regex @index===>" + matcher.start());
 		}
		 System.out.println("--------------------------------");
// only certain numbers and alphabets		
		Pattern pattern2 = Pattern.compile("[abcKUM52]");
		Matcher matcher2 =pattern2.matcher("vin odh Kumar 50 52");

		while(matcher2.find()){
 		 	System.out.println("only certain numbers and alphabets is matched with--"+matcher2.group()+"-- with regex @indexx===>"+matcher2.start());
		}
		System.out.println("--------------------------------");
//Negation of Matching		
		Pattern pattern3 = Pattern.compile("[^123]");
		Matcher matcher3 =pattern3.matcher("vi1n3");
		while(matcher3.find()){
 			 	System.out.println("Negation of Matching is matched with--"+matcher3.group()+"-- with regex @indexx===>"+matcher3.start());
 		}
		System.out.println("--------------------------------");
// UNION
		Pattern pattern4 = Pattern.compile("[1-3[a-c][A-F]]"); // same as [1-3a-cA-F]
		Matcher matcher4 =pattern4.matcher("vi7894aonop1n3");
		while(matcher4.find()){
 			 	System.out.println("string UNION is matched with--"+matcher4.group()+"-- with regex @indexx===>"+matcher4.start());
 		}
 
		System.out.println("--------------------------------");
//Intersection 
		Pattern pattern5 = Pattern.compile("[a-z&&[def]]"); // same as all alphabets i.e.,[def]
		Matcher matcher5 =pattern5.matcher("vi7894aonop1n3");
		while(matcher5.find()){
 			 	System.out.println("string INtersection is matched  with--"+matcher5.group()+"--with regex @indexx===>"+matcher5.start());
 		}


		System.out.println("--------------------------------");
//Subtraction  
		Pattern pattern6 = Pattern.compile("[a-z&&[^def]]"); // same as all alphabets except [def]
		Matcher matcher6 =pattern6.matcher("vi7894aonop1n3");
		while(matcher6.find()){
 			 	System.out.println("string Subtraction is matched with--"+matcher6.group()+"-- with regex @indexx===>"+matcher6.start());
 		}


		System.out.println("--------------------------------");
//Subtraction + Negation  
		Pattern pattern7 = Pattern.compile("[a-z&&[^l-p]]"); // same as all alphabets except from l-p range
		Matcher matcher7 =pattern7.matcher("vi7894aonop1n3");
		while(matcher7.find()){
 			 	System.out.println("string Subtraction with Negation is matched with--"+matcher7.group()+"-- with regex @indexx===>"+matcher7.start());
 		}


		System.out.println("-------Meta Character(.)-------------------------");
//Any Character  
		Pattern pattern8 = Pattern.compile(".");
		Matcher matcher8 =pattern8.matcher("vip1n3");
		while(matcher8.find()){
 			 	System.out.println("Any character is matched with--"+matcher8.group()+"-- with regex @indexx===>"+matcher8.start());
 		}


		System.out.println("-------Meta Character(A Digit)-------------------------");
//Any Digit [0-9]  
		Pattern pattern9 = Pattern.compile("\\d");  
		Matcher matcher9 =pattern9.matcher("4vip1n3");
		while(matcher9.find()){
 			 	System.out.println("Any Digit 0-9   is matched with--"+matcher9.group()+"-- with regex @indexx===>"+matcher9.start());
 		}


		System.out.println("-------Meta Character(A NON Digit)-------------------------");
//Any Non-Digit 0-9  
		Pattern pattern10 = Pattern.compile("\\D");
		Matcher matcher10 =pattern10.matcher("4vip1n3");
		while(matcher10.find()){
 			 	System.out.println("Any NON-Digit  is matched with--"+matcher10.group()+"--  with regex @indexx===>"+matcher10.start());
 		}


		System.out.println("-------Meta Character(A White Space)-------------------------");
//Any whitespace[\t\n\x0B\f\r]
		Pattern pattern11 = Pattern.compile("\\s");  
		Matcher matcher11 =pattern11.matcher("4 vi p1 n3");
		while(matcher11.find()){
 			 	System.out.println("Any whitespace is matched with--"+matcher11.group()+"-- with regex @indexx===>"+matcher11.start());
 		}


		System.out.println("-------Meta Character(A NON White Space)-------------------------");
//Any Non whitespace
		Pattern pattern12 = Pattern.compile("\\S");  
		Matcher matcher12 =pattern12.matcher("4v ip1 n   3");
		while(matcher12.find()){
 			 	System.out.println("Any NON-whitespace  is matched with--"+matcher12.group()+"-- with regex @indexx===>"+matcher12.start());
 		}



		System.out.println("-------Meta Character(A WORD Character)-------------------------");
//Any WORD Character : [a-zA-Z_0-9]
		Pattern pattern13 = Pattern.compile("\\w");  
		Matcher matcher13 =pattern13.matcher("4 vi p1 n3");
		while(matcher13.find()){
 			 	System.out.println("Any WORD Character is matched with--"+matcher13.group()+"-- with regex @indexx===>"+matcher13.start());
 		}


		System.out.println("-------Meta Character(A NON WORD Character)-------------------------");
//Any Non WORD Character
		Pattern pattern14 = Pattern.compile("\\W");  
		Matcher matcher14 =pattern14.matcher("4v ip1 n   3");
		while(matcher14.find()){
 			 	System.out.println("Any NON-WORD Character  is matched with--"+matcher14.group()+"-- with regex @indexx===>"+matcher14.start());
 		}


		System.out.println("-------QUANTIFIERS (X?=> one time X or not at all, individual match for each character & EMPTY string for unmatching)-------------------------");
//ONCE OR NONE
		Pattern pattern15 = Pattern.compile("V?");  
		Matcher matcher15 =pattern15.matcher("VVVVinodh");
		while(matcher15.find()){
 			 	System.out.println("Any Quantifier (?) is matched with--"+matcher15.group()+"-- with regex @indexx===>"+matcher15.start());
 		}


		System.out.println("-------QUANTIFIERS (X*=> ZERO or more times X i.e., ZERO or more chars after/followed by X until last characters & unmatched will be EMPTY strings)-------------------------");
//ZERO OR MANY
		Pattern pattern16 = Pattern.compile("V*");  
		Matcher matcher16 =pattern16.matcher("VVVVinodh");
		while(matcher16.find()){
 			 	System.out.println("Any Quantifier  (*) is matched with--"+matcher16.group()+"--with regex @indexx===>"+matcher16.start());
 		}


		System.out.println("-------QUANTIFIERS (X+=> ONE or more times X i.e., ONE or more chars after/followed by X, only matches, doesn't care for not matchings )-------------------------");
//ONE OR MANY
		Pattern pattern17 = Pattern.compile("V+");  
		Matcher matcher17 =pattern17.matcher("VVVVinodh");
		while(matcher17.find()){
 			 	System.out.println("Any Quantifier  (+) is matched with--"+matcher17.group()+"--with regex @indexx===>"+matcher17.start());
 		}


		System.out.println("-------QUANTIFIERS (X{n}=>  Exactly n matches )-------------------------");
//Exactly n times
		Pattern pattern18 = Pattern.compile("V{2}");  
		Matcher matcher18 =pattern18.matcher("VVVVinodh");
		while(matcher18.find()){
 			 	System.out.println("Any Quantifier  ({n}) is matched with with--"+matcher18.group()+"--regex @indexx===>"+matcher18.start());
 		}


		System.out.println("-------QUANTIFIERS (X{n,}=>  Atleast n matches )-------------------------");
//Atleast n times
		Pattern pattern19 = Pattern.compile("V{2,}");  
		Matcher matcher19 =pattern19.matcher("VVVVinodh");
		while(matcher19.find()){
 			 	System.out.println("Any Quantifier  ({n,}) is matched with--"+matcher19.group()+"--with regex @indexx===>"+matcher19.start());
 		}


		System.out.println("-------QUANTIFIERS (X{n,m}=>  Atleast n matches, not more than m times )-------------------------");
//Atleast n matches, not more than m times
		Pattern pattern20 = Pattern.compile("V{2,4}");  
		Matcher matcher20 =pattern20.matcher("VVVVinodh");
		while(matcher20.find()){
 			 	System.out.println("Any Quantifier  ({n,m}) is matched with--"+matcher20.group()+"--with regex @indexx===>"+matcher20.start());
 		}



		System.out.println("-------Boundary matches=> (^)=> start && ($)=> end ) && (\\G)=> end of previous match-------------------------");
// Start and end of match
		Pattern pattern21 = Pattern.compile("^vin[a-z]");  
		Matcher matcher21 =pattern21.matcher("vinodh");
		while(matcher21.find()){
 			 	System.out.println("Start and end  is matched with--"+matcher21.group()+"-- with regex @indexx===>"+matcher21.start());
 		}


		
	}

}

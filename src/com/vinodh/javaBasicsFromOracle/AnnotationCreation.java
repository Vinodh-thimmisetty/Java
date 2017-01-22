package com.vinodh.javaBasicsFromOracle;

import java.lang.annotation.Documented;

@Documented
@interface DatastructreProperties {
	String dataStructureName();

	String searching();

	String deletion();

	String insertion();

	String sorting();

	String isSynchronized();
}

@DatastructreProperties(
		dataStructureName = "Test", 
		deletion = "easy", 
		insertion = "easy",
		isSynchronized = "No",
		searching = "difficult", 
		sorting = "easy")
// Strong Type checking 
public class AnnotationCreation {
	
	String jaffa;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

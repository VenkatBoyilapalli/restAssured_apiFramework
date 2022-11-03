package ExcelValidation;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.*;



public class Practice {

	static String Name = "Venkat";
	public static void main(String[] args) {
		
		findAWordInString("Venkata Narayana Reddy", "Ve","Narayana");
		findAWordInString("Venkata Narayana Reddy", "Ve", "Re");
//		NumberValidations();
		
		if(Name.equalsIgnoreCase("venkat"))
		{
			System.out.println("Condition is TRUE");
		}else
			System.out.println("Condition is FALSE");
		
		
	}

	public static void findAWordInString(String myString, String startWith, String subString)
	{
		assertThat(myString, allOf(startsWith(startWith), containsString(subString)));
	}
	
	public static void NumberValidations()
	{
		int number = 7;
		assertThat(number, greaterThan(10));
	}
	
	
	
}

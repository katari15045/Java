import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Main
{
	private static BufferedReader bufferedReader;
	private static BufferedOutputStream bufferedOutputStream;
	
	private static Integer totalTests;
	
	public static void main( String[] args ) throws NumberFormatException, IOException
	{
		bufferedReader = new BufferedReader( new InputStreamReader(System.in) );
		bufferedOutputStream = new BufferedOutputStream( System.out );
		
		totalTests = Integer.valueOf( bufferedReader.readLine() );
		Integer currentTest = 1;
		Integer targetNum;
		
		while( currentTest <= totalTests )
		{
			targetNum = Integer.valueOf( bufferedReader.readLine() );
			processTheRequest(targetNum);
			
			currentTest = currentTest + 1;
		}
		
		bufferedReader.close();
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
	
	private static void processTheRequest(Integer targetNum) throws IOException
	{
		ArrayList<Integer> resultArray = getArrayFromNumber(targetNum);
		Integer multiplier = targetNum - 1;
		
		while( multiplier >= 1 )
		{
			ArrayList<Integer> multiplierArray = getArrayFromNumber(multiplier);
			resultArray = multiply(resultArray, multiplierArray);
			
			multiplier = multiplier - 1;
		}
		
		displayNumberFromArray(resultArray);
	}
	
	private static ArrayList<Integer> multiply(ArrayList<Integer> firstArray, ArrayList<Integer> secArray)
	{
		// Assumption : 2nd Number is a small number and is less than 2^32
		
		ArrayList<Integer> resultArray = firstArray;
		Integer secValue = getNumberFromArray(secArray);
		makeArrayLengthsSame(firstArray, secArray);
		Integer currentCount = 2; // Because, resultArray = firstNum
		
		while(currentCount <= secValue)
		{
			resultArray = add(resultArray, firstArray);
			currentCount = currentCount + 1;
		}
		
		return resultArray;
	}
	
	private static void displayNumberFromArray(ArrayList<Integer> array) throws IOException
	{
		Iterator<Integer> iterator = array.iterator();
		
		while( iterator.hasNext() )
		{
			bufferedOutputStream.write( iterator.next().toString().getBytes() );
		}
		
		bufferedOutputStream.write("\n".getBytes());
	}
	
	private static ArrayList<Integer> add(ArrayList<Integer> firstArray, ArrayList<Integer> secArray)
	{
		makeArrayLengthsSame(firstArray, secArray);
		
		ArrayList<Integer> resultantArray = new ArrayList<>();
		Integer firstIndex = firstArray.size() - 1;
		Integer secIndex = secArray.size() - 1;
		Integer sum = 0, carry = 0, temp;
		
		while( firstIndex >= 0 && secIndex >= 0 )
		{
			temp = firstArray.get(firstIndex) + secArray.get(secIndex) + carry;
			
			if( temp >= 10 )
			{
				sum = temp % 10;
				carry = temp / 10;
			}
			
			else
			{
				sum = temp;
				carry = 0;
			}
			
			resultantArray.add(sum);
			
			firstIndex = firstIndex - 1;
			secIndex = secIndex - 1;
		}
		
		if( carry != 0 )
		{
			resultantArray.add(carry);
		}
		
		Collections.reverse(resultantArray);
		return resultantArray;
	}
	
	private static ArrayList<Integer> getArrayFromNumber(Integer num)
	{
		ArrayList<Integer> result = new ArrayList<>();
		String numStr = num.toString();
		int currentIndex = 0;
		Character currentChar;
		
		while( currentIndex < numStr.length() )
		{
			currentChar = numStr.charAt(currentIndex);
			result.add( Integer.valueOf( currentChar.toString() ) );
			
			currentIndex = currentIndex + 1;
		}
		
		return result;
	}
	
	private static Integer getNumberFromArray(ArrayList<Integer> array)
	{
		Integer result = 0;
		Integer currentIndex = 0;
		Integer totalZeroes = array.size() - 1;
		
		while( currentIndex < array.size() )
		{
			result = result + getDecimalPlace(  array.get(currentIndex), totalZeroes);
			totalZeroes = totalZeroes - 1;
			currentIndex = currentIndex + 1;
		}
		
		return result;
	}
	
	private static Integer getDecimalPlace(Integer num, Integer totalZeroes)
	{
		Integer multiplier = 1;
		int currentZero = 1;
		
		while( currentZero <= totalZeroes )
		{
			multiplier = multiplier * 10;
			currentZero = currentZero + 1;
		}
		
		return num*multiplier;
	}
	
	private static void makeArrayLengthsSame(ArrayList<Integer> firstArray, ArrayList<Integer> secArray)
	{
		if( firstArray.size() == secArray.size() )
		{
			return;
		}
		
		if( firstArray.size() < secArray.size() )
		{
			extendArray(firstArray, secArray.size() - firstArray.size());
			return;
		}
		
		extendArray(secArray, firstArray.size() - secArray.size());
		
	}
	
	private static void extendArray(ArrayList<Integer> array, Integer extensionLength)
	{
		Collections.reverse(array);
		int count = 1;
		
		while( count <= extensionLength )
		{
			array.add(0);
			count = count + 1;
		}
		
		Collections.reverse(array);
	}

	
}
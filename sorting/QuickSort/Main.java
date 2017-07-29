import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main
{
	private static BufferedReader bufferedReader;
	private static BufferedOutputStream bufferedOutputStream;
	
	private static Integer length;
	
	public static void main(String[] args) throws IOException
	{
		bufferedReader = new BufferedReader( new InputStreamReader( System.in ) );
		bufferedOutputStream = new BufferedOutputStream(System.out);
		
		length = Integer.valueOf( bufferedReader.readLine() );
		ArrayList<Integer> arrayList = new ArrayList<>(length);
		int count = 0;
		
		while( count < length )
		{
			arrayList.add( Integer.valueOf( bufferedReader.readLine() ) );
			count =  count + 1;
		}
		
		quickSort(arrayList, 0, length-1);
		printArray(arrayList);
		
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
		bufferedReader.close();
	}
	
	private static void printArray(ArrayList<Integer> array) throws IOException
	{
		Iterator<Integer> iterator = array.iterator();
		String tempStr = null;
		
		while( iterator.hasNext() )
		{
			tempStr = iterator.next().toString() + "\n";
			bufferedOutputStream.write( tempStr.getBytes() );
		}
	}
	
	private static void quickSort(ArrayList<Integer> array, int startIndex, int endIndex) throws IOException
	{
		Random random = new Random();
		int pivotIndex = random.nextInt( (endIndex-startIndex) + 1 ) + startIndex;
		int currentIndex = startIndex;
		
		while( currentIndex < pivotIndex )
		{
			if( array.get(currentIndex) > array.get(pivotIndex) )
			{
				int swapPositions = swapForward(array, currentIndex, pivotIndex);
				pivotIndex = pivotIndex - swapPositions;
			}
			
			currentIndex = currentIndex + 1;
		}
		
		currentIndex = pivotIndex + 1;
		
		while( currentIndex <= endIndex )
		{
			if( array.get(currentIndex) <= array.get(pivotIndex) )
			{
				int swapPositions = swapBackward(array, currentIndex, pivotIndex);
				pivotIndex = pivotIndex + swapPositions;
			}
			
			currentIndex = currentIndex + 1;
		}
		
		if( (pivotIndex-1) > startIndex )
		{
			quickSort(array, startIndex, pivotIndex-1);
		}
		
		if( (pivotIndex+1) < endIndex )
		{
			quickSort(array, pivotIndex+1, endIndex);
		}
	}
	
	private static int swapForward(ArrayList<Integer> array, int startIndex, int endIndex) throws IOException
	{
		int swapPositions = 0;
		int currentIndex = startIndex;
		int nextIndex = startIndex+1;
		
		while( nextIndex <= endIndex )
		{
			Collections.swap(array, currentIndex, nextIndex);
			
			swapPositions = swapPositions + 1;
			currentIndex = currentIndex + 1;
			nextIndex = nextIndex + 1;
		}
		
		return swapPositions;
	}
	
	private static int swapBackward(ArrayList<Integer> array, int startIndex, int endIndex) throws IOException
	{
		int swapPositions = 0;
		int currentIndex = startIndex;
		int nextIndex = currentIndex - 1;
		
		while( nextIndex >= endIndex )
		{
			Collections.swap(array, currentIndex, nextIndex);
			
			swapPositions = swapPositions + 1;
			currentIndex = currentIndex - 1;
			nextIndex = nextIndex - 1;
		}
		
		return swapPositions;
	}
	
}
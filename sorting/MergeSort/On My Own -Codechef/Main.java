import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class Main
{
	private static BufferedReader bufferedReader;
	private static BufferedOutputStream bufferedOutputStream;
	
	public static void main(String[] args) throws IOException
	{
		int length;
		int currentIndex = 0;
		ArrayList<Integer> arrayList;
		
		bufferedReader = new BufferedReader( new InputStreamReader(System.in) );
		bufferedOutputStream = new BufferedOutputStream(System.out);
		
		length = Integer.valueOf( bufferedReader.readLine() );
		arrayList = new ArrayList<>(length);
		
		while( currentIndex < length )
		{
			arrayList.add( Integer.valueOf( bufferedReader.readLine() ) );
			currentIndex = currentIndex + 1;
		}
		
		mergeSort(arrayList, 0, length-1);
		printArray(arrayList);
		
		bufferedReader.close();
		bufferedOutputStream.flush();
		bufferedOutputStream.close();
	}
	
	private static void printArray(ArrayList<Integer> array) throws IOException
	{
		Iterator<Integer> iterator = array.iterator();
		
		while( iterator.hasNext() )
		{
			String tempStr = iterator.next().toString() + "\n";
			bufferedOutputStream.write( tempStr.getBytes() );
		}
	}
	
	private static void mergeSort(ArrayList<Integer> array, int startIndex, int endIndex) throws IOException
	{
		int midIndex = (startIndex + endIndex) / 2;
		
		if( midIndex > startIndex )
		{
			mergeSort(array, startIndex, midIndex);
		}
		
		if( endIndex > (midIndex+1) )
		{
			mergeSort(array, midIndex+1, endIndex);
		}
		
		merge(array, startIndex, endIndex);
	}
	
	private static void merge(ArrayList<Integer> array, int startIndex, int endIndex) throws IOException
	{
		ArrayList<Integer> mergedArray = new ArrayList<>( (endIndex-startIndex)+1 );
		int midIndex = (startIndex + endIndex) / 2;
		int indexPointerOne = startIndex;
		int indexPointerTwo = midIndex + 1;
		int currentIndex = 0;
		
		while( indexPointerOne <= midIndex && indexPointerTwo <= endIndex )
		{
			if( array.get(indexPointerOne) <= array.get(indexPointerTwo) )
			{
				mergedArray.add( array.get(indexPointerOne) );
				indexPointerOne = indexPointerOne + 1;
			}
			
			else
			{
				mergedArray.add( array.get(indexPointerTwo) );
				indexPointerTwo = indexPointerTwo + 1;
			}
		}
		
		while( indexPointerOne <= midIndex )
		{
			mergedArray.add( array.get(indexPointerOne) );
			indexPointerOne = indexPointerOne + 1;
		}
		
		while( indexPointerTwo <= endIndex )
		{
			mergedArray.add( array.get(indexPointerTwo) );
			indexPointerTwo = indexPointerTwo + 1;
		}
		
		//String tempStr = "Actual Array -> " + array.toString() + "\n[" + startIndex + ", " + endIndex + "]\nMerged Array -> " + mergedArray.toString() + "\n";
		//System.out.println(tempStr);
		
		while( currentIndex < mergedArray.size() )
		{
			array.set( startIndex+currentIndex, mergedArray.get(currentIndex) );
			currentIndex = currentIndex + 1;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
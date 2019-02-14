import java.util.Stack;
import java.util.Iterator;

public class Main{

	public static void main(String[] args){
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(2);
		stack.push(1);
		while(stack.size() != 0){
			System.out.print(stack.pop() + "|");
		}
		System.out.println();
	}
}
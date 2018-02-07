import java.util.Scanner;

public class Main
{
	private static MyList list = null;

	public static void main(String[] args)
	{
		takeUserInput();
		list.print();
	}

	private static void takeUserInput()
	{
		Scanner scanner = new Scanner(System.in);
		int length, count = 0, currentNum;

		list = new MyList();
		System.out.print("Length : ");
		length = scanner.nextInt();
		System.out.print("Elements : ");

		while( count < length )
		{
			currentNum = scanner.nextInt();
			list.insertAtEnd(currentNum);

			count = count + 1;
		}
	}
}

class MyList
{
	private Node head = null;

	MyList()
	{
		head = new Node();
	}

	public void setHead(Node head)
	{
		this.head = head;
	}

	public Node getHead()
	{
		return head;
	}

	public void insertAtFront(int value)
	{
		Node newNode = new Node();
		newNode.setValue(value);
		newNode.setNext( head.getNext() );
		head.setNext(newNode);
	}

	public void insertAtEnd(int value)
	{
		Node mobile = head;

		while( mobile.getNext() != null )
		{
			mobile = mobile.getNext();
		}

		Node newNode = new Node();
		newNode.setValue(value);
		mobile.setNext(newNode);
	}

	public void print()
	{
		Node mobile = head.getNext();

		while( mobile != null )
		{
			System.out.print( mobile.getValue()  + " " );
			mobile = mobile.getNext();
		}

		System.out.println();
	}
}

class Node
{
	private int value;
	private Node next;

	Node()
	{
		next = null;
	}

	public void setValue(int value)
	{
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

	public void setNext(Node next)
	{
		this.next = next;
	}

	public Node getNext()
	{
		return next;
	}
}
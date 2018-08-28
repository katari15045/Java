import java.util.Scanner;

public class Main
{
    private static MyLinkedlist list;

    private static void takeUserInput()
    {
        int listSize, count = 0, curElement, totalQueries, queryInt;
        String queryString;
        Scanner scanner = new Scanner(System.in);
        list = new MyLinkedlist();

        System.out.print("Length : ");
        listSize = scanner.nextInt();

        System.out.print("Elements : ");
        while( count < listSize )
        {
            curElement = scanner.nextInt();
            list.insertAtEnd(curElement);

            count = count + 1;
        }

        System.out.println("\nInsert at front -> i_f <element>");
        System.out.println("Insert at back -> i_b <element>");
        System.out.println("Delete from front -> d_f <index>");
        System.out.println("Delete last element -> d_b 0");

        System.out.print("\nTotal Queries : ");
        totalQueries = scanner.nextInt();
        count = 0;

        while( count < totalQueries )
        {
            System.out.print("Query : ");
            queryString = scanner.next();
            queryInt = scanner.nextInt();
            handleQuery(queryString, queryInt);

            count = count + 1;
        }
    }

    private static void handleQuery(String queryString, int queryInt)
    {
        if( queryString.equals("i_f") )
        {
            list.insertAtStart(queryInt);
        }

        else if( queryString.equals("i_b") )
        {
            list.insertAtEnd(queryInt);
        }

        else if( queryString.equals("d_f") )
        {
            list.deleteFromLeft(queryInt);
        }

        else if( queryString.equals("d_b") )
        {
            list.deleteLast();
        }

        else
        {
            System.out.println("Invalid input");
        }

        list.print();
    }

    public static void main(String[] args)
    {
        takeUserInput();
    }
}

class MyLinkedlist
{
    private Node head;
    private Node tail;

    MyLinkedlist()
    {
        head = new Node();
        tail = new Node();
        head.setNext(tail);
        tail.setPrev(head);
    }

    public void insertAtStart(int value)
    {
        Node newNode = new Node();
        newNode.setValue(value);
        newNode.setPrev(head);
        newNode.setNext( head.getNext() );
        head.getNext().setPrev(newNode);
        head.setNext(newNode);
    }

    public void insertAtEnd(int value)
    {
        Node newNode = new Node();
        newNode.setValue(value);
        newNode.setNext(tail);
        newNode.setPrev( tail.getPrev() );
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
    }

    public Integer deleteFromLeft(int index)
    {
        Node mobile;
        int count = 0;

        if( head.getNext() == tail )
        {
            return null;
        }

        mobile = head.getNext();

        while( mobile != tail && count <= index)
        {
            if( count == index )
            {
                mobile.getPrev().setNext( mobile.getNext() );
                mobile.getNext().setPrev( mobile.getPrev() );
                return mobile.getValue();
            }   

            count = count + 1;
            mobile = mobile.getNext();
        }

        return null;
    }

    public Integer deleteLast()
    {
       if( head.getNext() == tail )
       {
            return null;
       }

       int ret_val = tail.getPrev().getValue();
       tail.getPrev().getPrev().setNext(tail);
       tail.setPrev( tail.getPrev().getPrev() );
       return ret_val;
    }

    public void print()
    {
        Node mobile;

        mobile = head.getNext();

        if( mobile == tail )
        {
            System.out.print("Empty List!");
        }

        while( mobile != tail )
        {
            System.out.print(mobile);
            mobile = mobile.getNext();
        }

        System.out.println();
    }

    public void setHead(Node head)
    {
        this.head = head;
    }

    public Node getHead()
    {
        return head;
    }

}

class Node
{
    private int value;
    private Node next;
    private Node prev;

    Node()
    {
        value = -1;
        next = null;
        prev = null;
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

    public void setPrev(Node prev)
    {
        this.prev = prev;
    }

    public Node getPrev()
    {
        return prev;
    }

    public String toString()
    {
        return (value + " ");
    }
}
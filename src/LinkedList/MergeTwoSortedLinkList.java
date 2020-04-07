package LinkedList;

//Java Program to merge Two Sorted Link List

public class MergeTwoSortedLinkList{

    static Node head = null;
    static Node list1 = null;
    static Node list2 = null;

    static class Node{
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    Node push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;

        return head;
    }

    void printList(Node node)
    {
        Node temp = node;

        while(temp!= null)
        {
            System.out.print(temp.data +"  ");
            temp = temp.next;
        }
    }



    Node merge(Node list1,Node list2)
    {

        Node mergeList;
        Node temp;

        if(list1.data < list2.data)
        {
            mergeList = list1;
            list1 = list1.next;
        }
        else
        {
            mergeList = list2;
            list2 = list2.next;
        }
        temp = mergeList;

        while(list1 != null && list2 != null)
        {
            if(list1.data < list2.data)
            {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }
        if(list1 == null)
            temp.next = list2;
        else
            temp.next = list1;


        return mergeList;
    }



    //Driver Program
    public static void main(String[] args)
    {
        MergeTwoSortedLinkList mtsl = new MergeTwoSortedLinkList();

        int i;
        int j ;
        for(i = 5 ; i > 0; i = i-2)
            list1 = mtsl.push(i);

        head = null;


        for(j = 6; j > 0 ;j = j-2 )
            list2 = mtsl.push(j);

        head = null;

        System.out.println("List 1 elements");
        mtsl.printList(list1);

        System.out.println("\nList 2 elements");
        mtsl.printList(list2);



        System.out.println("\nAfter merge Linked List is");
        head  = mtsl.merge(list1,list2);

        mtsl.printList(head);

    }
}
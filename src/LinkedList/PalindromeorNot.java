package LinkedList;

//Check if the Single Linked List is Palindrome or not

public class PalindromeorNot{

    static Node head;
    static class Node{
        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    void push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
    }


    Node middleNode(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    Node reverseList(Node head)
    {
        Node curr = head;
        Node next = head;
        Node prev = null;

        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return prev;
    }


    int compareList(Node list1,Node list2)
    {
        while(list2!=null && list1.data == list2.data)
        {
            list1 = list1.next;
            list2 = list2.next;
        }

        if(list2 == null)
            return 1;

        return 0;
    }

    int CheckifPalindrome(Node head)
    {
        Node mn = middleNode(head);
        Node sh = mn.next;
        mn.next = null;

        sh = reverseList(sh);

        int res = compareList(head,sh);

        sh = reverseList(sh);
        mn.next = sh;

        return res;
    }



    //Driver Program
    public static void main(String[] args)
    {
        PalindromeorNot por = new PalindromeorNot();

        por.push(1);
        por.push(2);
        por.push(1);
        por.push(2);
        por.push(1);

        int res = por.CheckifPalindrome(head);
        if(res > 0)
            System.out.println("Linked List is Palindrome");
        else
            System.out.println("Linked List is Not Palindrome");
    }
}

package LinkedList;

//LeetCode Problem Solved

public class ReorderList{
    static Node head = null;
    static class Node{
        int data;
        Node next;
        Node(int d)
        {
            data = d;
        }
    }

    static void push(int new_data)
    {
        Node temp = new Node(new_data);
        temp.next = head;
        head = temp;
    }

    static void printList(Node node)
    {
        Node temp = node;
        while(temp!=null)
        {
            System.out.print(temp.data+"   ");
            temp = temp.next;
        }
    }


    static Node reverse(Node head)
    {
        Node curr = head;
        Node next = head;
        Node prev =  null;

        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    static Node reorderlist(Node head)
    {
        Node l1 = head;

        //1.Find Middle Element and Seperate it
        Node prev = null;
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        //2.Reverse it
        Node l2 = reverse(slow);

         merge(l1,l2);

        return l1;
    }


    static void merge(Node l1,Node l2)
    {
        while(l1!=null)
        {
            Node l1_next = l1.next;
            Node l2_next = l2.next;

            l1.next = l2;

            if(l1_next == null)
                break;

            l2.next = l1_next;

            l1 = l1_next;
            l2 = l2_next;
        }


    }

    //Driver Program
    public static void main(String[] args)
    {
        for(int i = 8 ;i >0;i--)
            push(i);

        System.out.println("Linked List Before Modification");
        printList(head);
        head = reorderlist(head);
        System.out.println("\nLinked List After Modification");
        printList(head);
    }
}

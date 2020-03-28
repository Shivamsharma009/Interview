package LinkedList;

import java.util.Scanner;

class KNodeFromEndLinkedList {
    static Node head = null;
    //KNodeFromEndLinkedList() {
  //  head = null;
//}

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }
    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
    }

    void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    Node KNodeFromEnd(Node node, int k) {
          Node p = node;
          Node q = node;
          int count;
        for (count = 1; count < k && p != null; count++)
            p = p.next;
        if (p == null)
            return null;
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        return q;
    }

    //Driver Program
    public static void main(String[] args) {
       KNodeFromEndLinkedList kn = new KNodeFromEndLinkedList();
        //int k = 3;
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        for (int i = 6; i > 0; i--) {
            kn.push(i);
        }
        kn.printList(head);
        head = kn.KNodeFromEnd(head,k);
        if(head == null)
        {
            System.out.println(k +" is Greater than Number of nodes in a Linked List");
        }
        System.out.println("\n" + k  + "  Element from End in  Linked list is "+head.data);
        //System.out.print(" \n"+head.data);
    }
}





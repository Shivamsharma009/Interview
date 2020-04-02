package LinkedList;

public class IntersectionPoint {
    static Node head1 = null;
    static Node head2 = null;

    static class Node{
        int data;
        Node next;
        Node(int d){
            data = d;
            next = null;
        }
    }

    int GetIntersectionNode(Node head1,Node head2){
        int l1 = countNodes(head1);
        int l2 = countNodes(head2);
        int diff = Math.abs(l1-l2);
        if(l1 > l2)
        return _GetIntersectionNode(diff,head1,head2);
        else
        return _GetIntersectionNode(diff,head2,head1);
    }

    int countNodes(Node head)
    {
        int count;
        for(count=0;head!=null;head = head.next,count++);
        return count;
    }

    int _GetIntersectionNode(int diff,Node head1,Node head2){
        for(int count = 0;count < diff ;count++,head1 = head1.next);

        if(head1==null)
            return -1;

        for(;head1!=null && head2!=null ;head1 = head1.next,head2 = head2.next)
        {
            if(head1 == head2)
                return  head1.data;
        }
        return -1;
    }


    //Driver Program
    public static void main(String[] args){
        IntersectionPoint ip = new IntersectionPoint();
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);

        head2 = new Node(7);
        head2.next = new Node(8);
        head2.next.next = head1.next.next.next.next;

           int data =  ip.GetIntersectionNode(head1,head2);
           if(data > 0)
               System.out.println("Intersect point "+data);
           else
               System.out.println("Intersect point is not present");

    }
}

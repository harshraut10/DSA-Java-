
class Node{
        String data;
        Node next;
        Node(String data){
            this.data=data;
        }
    }
public class pallindrome {
    static Node reversen(Node head){
        Node cur=head;
        Node prev=null;
        while(cur!=null){
            Node temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        head=prev;
        //traverse(head);
        return head;

        
    }

    static Node middle(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    static boolean pallindromes(Node head){
        if(head == null){
            return true;
        }

        Node mid=middle(head);
        Node last=reversen(mid.next);
        Node cur=head;
        while(last!=null){
            if(last.data != cur.data)
            return false;

            last=last.next;
            cur=cur.next;

        }
        return true;
    }
    public static void main(String[] args) {
        Node n1=new Node("A");
        Node n2=new Node("B");
        Node n3=new Node("c");
        Node n4=new Node("B");
        Node n5=new Node("A");

        Node head=n1;
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=null;
        boolean t=pallindromes(head);
        if(t) {
            System.out.println("pallindrome");
         }
         else System.out.println("not pallindrome");


    }
}

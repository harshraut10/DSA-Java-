
class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }


public class reverse {

     static void traverse(Node head){
        Node curhead=head;
        while(curhead !=null){
            System.out.println(curhead.data);
            curhead=curhead.next;
        }
    }
     static Node recurRev(Node head){
        if(head==null || head.next==null){
            return head;
        }

        Node newHead=recurRev(head.next);
        Node headNext=head.next;
        headNext.next=head;
        head.next=null;
        return newHead;

     }
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
        traverse(head);
        return head;

        
    }
    public static void main(String[] args) {
        Node n1=new Node(2);
        Node n2=new Node(4);
        Node n3=new Node(6);

        Node head=n1;
        head.next=n2;
        n2.next=n3;
        n3.next=null;
        traverse(head);
       // System.out.println("reverse");
        //reversen(head);
        System.out.println("After recursion reverse");
        traverse(recurRev(head));
        

    }
}

class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

public class DetectCycle {

    static Node detect(Node head){
        Node fast=head;
        Node slow=head;
        while(fast!=null && slow!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast)
                return slow;
        }

        return null;
    }

    static Node detectcyclepoint(Node head){
        Node meet=detect(head);
        Node start=head;
        Node prev=meet;
        while(start!=meet){
            start=start.next;
            prev=meet;
            meet=meet.next;
        }
        //removing the cycle
        prev.next=null;
        traverse(head);
        return meet;
    }
    static void traverse(Node head){
        Node curhead=head;
        while(curhead !=null){
            System.out.println(curhead.data);
            curhead=curhead.next;
        }
    }
    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        Node n3=new Node(3);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);
        Node n7=new Node(7);

        
        Node head=n1;
        head.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n3;
        Node res=detectcyclepoint(head);
        System.out.println("cycle found at datapoint : "+res.data);
        //traverse(head);
    }
}

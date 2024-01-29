import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}


public class SortA_LL {

    static void Sort(Node head){
        ArrayList<Integer> num=new ArrayList<>();
        Node temp=head;
        while(temp!=null){
            num.add(temp.data);
            temp=temp.next;
        }

        Collections.sort(num);
        temp=head;
        for (int i=0;i<num.size();i++) {
            temp.data=num.get(i);
            temp=temp.next;
        }

        traverse(head);
    }
    static void traverse(Node head){
        Node curhead=head;
        while(curhead !=null){
            System.out.println(curhead.data);
            curhead=curhead.next;
        }
    }
    static void add(int data,Node head){
        Node temp=head;
        Node cur=new Node(data);
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=cur;
        cur.next=null; 
        //traverse(head);
    }
    public static void main(String[] args) {
        System.out.println("hello");
        Node n1=new Node(2);
        Node head=n1;
        head.next=null;
        add(3,head);
        add(5, head);
        add(1, head);
        //traverse(head);
        Sort(head);

    }
}

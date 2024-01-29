class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }

public class basic {
    static void traverse(Node head){
        Node curhead=head;
        while(curhead !=null){
            System.out.println(curhead.data);
            curhead=curhead.next;
        }
    }

    static void delete(int pos, Node head){

        if(pos==0){
            head=head.next;
            return;
        }
        Node prev=head;
        for(int i=0;i<pos-1;i++){
            prev=prev.next;
        }
        prev.next=prev.next.next;
        System.out.println("after delete");
        traverse(head);
    }
    static void insert(int data, Node head, int pos){
        Node toadd=new Node(data);
        if(pos==0){
            toadd.next=head;
            head=toadd;
            return;
        }

        Node prev=head;
        for(int i=0;i<pos-1;i++){
            prev=prev.next;
        }
        toadd.next=prev.next;
        prev.next=toadd;
        System.out.println("After insert");
        traverse(head);
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
        insert(30, head, 2);
        delete(3, head);
    
        //System.out.println(head.data);
    }
}

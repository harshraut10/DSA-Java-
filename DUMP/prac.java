class Node{
    int data;
    Node next;
    public Node(int data){
        this.data=data;
    }
}

public class prac {
    static void traverse(Node cur){
        while (cur!=null) {
            System.out.println(cur.data);
            cur=cur.next;
            
        }
    }

    static Node insert(int data, Node head){
        Node newNode=new Node(data);
        if(head==null){
            head=newNode;
            head.next=null;
            return head;
        }
        Node prev=head;
        
        while(prev.next!=null){
            prev=prev.next;
        }
        prev.next=newNode;
        newNode.next=null;
        return head;
    }

    public static void main(String[] args) {
        Node head=null;
        head=insert(4, head);
        head=insert(8, head);
        traverse(head);

    }
}

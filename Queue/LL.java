class Node{
    int data;
    Node next;
     public Node(int data){
        this.data=data;
    }
}

public class LL {
    static Node front,rear;
    static void enqueue(int data){
        Node newnode=new Node(data);
        if(front==null){
            rear=front=newnode; return;
        }
        rear.next=newnode;
        rear=newnode;
    }

    static int dequeue(){
        if(front == null){
            System.out.println("queue already empty");
        }
        int result=front.data;
        front=front.next;
        return result;
    }
    public static void main(String[] args) {
        enqueue(2);
        enqueue(4);
        enqueue(6);
        System.out.println(dequeue());
         System.out.println(dequeue());
    }
}

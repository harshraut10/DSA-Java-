public class circularArray {
    static int a[],n,front=-1,rear=-1;
    public circularArray(int n){
        this.n=n;
        a=new int[n];
    }

    static void enqueue(int data){
        if((rear+1)%n==front)
        return;

        if(front ==-1) front=0;

        rear=(rear+1)%n;
        a[rear]=data;
    }

    int dequeue(){
        if(front==-1) System.out.println("error");

        int result=a[front];
        if(front == rear)
        rear=front=-1;

        else front=(front+1)%n;

        return result;
    }
    public static void main(String[] args) {
        circularArray a =new circularArray(4);
        a.enqueue(4);
        a.enqueue(5);
        System.out.println(a.dequeue());
    }
}

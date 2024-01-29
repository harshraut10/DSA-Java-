public class array {
    static int a[];
    static int capacity;
    static int rear;
    public array(int n){
        capacity=n;
        a=new int[n];
        rear=-1;
    }

    void enqueue(int data){
        if(rear==capacity-1){
            System.out.println("full array");
        }
        rear++;
        a[rear]=data;
    }

    static int dequeue(){
        if(rear==-1) System.out.println("no element");

        int result=a[0];
        for(int i=0;i<rear;i++){
            a[i]=a[i+1];
        }
        rear--;
        return result;
    }

    static int getfront(){
        if(rear==-1) System.out.println("no elements");

        return a[0];
    }

    public static void main(String[] args) {
        array a=new array(3);
        a.enqueue(4);
        a.enqueue(5);
        System.out.println(getfront());
        System.out.println(dequeue());
        System.out.println(getfront());
    }
}

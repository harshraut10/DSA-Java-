

public class Array {
    static int a[];
    static int top;
    static int capacity;
    public Array(int capacity){
        this.capacity=capacity;
        top=-1;
        a= new int[capacity];
    }

    static void push(int data){
        if(top==capacity-1){
            System.out.println("overflow");
            return;
        }
        top++;
        a[top]=data;
    }

    static int pop(){
        if(top==-1){
            System.out.println("underflow");
        }
        int res=a[top];
        top--;
        return res;
    }

    static int peek(){
        if(top==-1){
            System.out.println("nothing in stack");
            return -1;
        }
        return a[top];
    }
    public static void main(String[] args) {
        Array a=new Array(6);
        push(4);
        push(5);
        push(2);
        push(90);
        pop();
        pop();
        pop();
        pop();
        System.out.println(peek());

    }
}

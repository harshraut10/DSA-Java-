import java.util.*;

public class stack_using_2_q {
    static Queue<Integer> q1=new LinkedList<>();
    static Queue<Integer> q2=new LinkedList<>();
    static void push(int data){
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());

        }
        q1.offer(data);
        while(!q2.isEmpty()){
            q1.offer(q2.poll());
        }
    }

    static int pop(){
        return q1.poll();
    }

    public static void main(String[] args) {
        push(3);
        push(4);
        System.out.println(pop());
    }


}

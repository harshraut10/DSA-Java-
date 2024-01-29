import java.util.*;
public class q_using_2_statcks {
    static Stack<Integer> s1=new Stack<>();
    static Stack<Integer> s2=new Stack<>();
    static void push(int data){
        s1.push(data);
    }

    static int dequeue(){
        int ans=0;
        while (!s1.empty()){
            s2.push(s1.pop());            
        }
        if(!s2.empty())  ans=s2.pop();
        
        while ((!s2.empty())) {
            s1.push(s2.pop());
        }

        return ans;

    }
    public static void main(String[] args) {
        push(3);
        push(5);
        System.out.println(dequeue());
    }

}

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
class prevsmaller{
    public static void main(String[] args) {
        int a[]=new int[]{4,10,5,18,3,12,7};
        Deque<Integer> s=new ArrayDeque<>(); // better than stack
        for(int i=0;i<a.length; i++){
            while(!s.isEmpty() && s.peek()>=a[i]){
                s.pop();
            }
            if(s.isEmpty()){
            System.out.print(" "+-1);
            }
        else{
            System.out.print(" "+s.peek());
        }
        s.push(a[i]);
        }
    }
}
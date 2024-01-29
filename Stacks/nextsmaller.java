import java.util.ArrayDeque;
import java.util.Deque;

public class nextsmaller {
    public static void main(String[] args) {
        int a[]=new int[]{3,10,5,1,15,10,7,6};
        int ans[]=new int[a.length];
        Deque<Integer> s=new ArrayDeque<>(); // better than stack
        for(int i=a.length-1;i>=0; i--){
            while(!s.isEmpty() && s.peek()>=a[i]){
                s.pop();
            }
            if(s.isEmpty()){
            //System.out.print(" "+-1);
            ans[i]=-1;
            }
        else{
            //System.out.print(" "+s.peek());
            ans[i]=s.peek();
        }
        s.push(a[i]);
        }

        for(int i=0;i<ans.length;i++)
            System.out.print(" "+ans[i]);
    }
}

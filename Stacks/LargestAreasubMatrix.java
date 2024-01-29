import java.util.ArrayDeque;
import java.util.Deque;

public class LargestAreasubMatrix {
    public static void main(String[] args) {
        int[][] a={
            {0,1,1,1,1,0},
            {1,1,1,1,0,1},
            {1,1,0,1,1,1},
            {1,1,1,1,1,0}
        };
        System.out.println(largestArea(a));
    }

    static int maxArea(int a[]){
        int maxArea=0;
        int ps[]=prevSmaller(a);
        int ns[]=nextSmaller(a);
        for(int i=0;i<a.length;i++){
            int cur=(ns[i]-ps[i]-1)*a[i];
            maxArea=Math.max(maxArea, cur);
        }
        return maxArea;
    }

    static int[] prevSmaller(int a[]){
         Deque<Integer> s=new ArrayDeque<>(); // better than stack
         int arr[]=new int[a.length];
        for(int i=0;i<a.length; i++){
            while(!s.isEmpty() && a[s.peek()]>=a[i]){
                s.pop();
            }
            if(s.isEmpty()){
            //System.out.print(" "+-1);
            arr[i]=-1;
            }
        else{
            //System.out.print(" "+s.peek());
            arr[i]=s.peek();
        }
        s.push(i);
        }
        return arr;
    }

    static int[] nextSmaller(int a[]){
        int ans[]=new int[a.length];
        Deque<Integer> s=new ArrayDeque<>(); // better than stack
        for(int i=a.length-1;i>=0; i--){
            while(!s.isEmpty() && a[s.peek()]<=a[i]){
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
        s.push(i);
        }
        return ans;
    }

    static int largestArea(int[][] a){
        int curRow[]=a[0];
        int maxAns=maxArea(curRow);
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==1){
                    curRow[j]+=1;
                }else curRow[j]=0;
            }
            int curAns=maxArea(curRow);
            maxAns=Math.max(maxAns, curAns);
        }
        return maxAns;
    }
}

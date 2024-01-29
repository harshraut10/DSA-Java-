import java.util.ArrayDeque;
import java.util.Deque;

public class slidingWindow {
    static void printMax(int arr[],int n,int k){
        Deque<Integer> qi=new ArrayDeque<Integer>();
        int i;
        for(i=0;i<k;++i){
            while (!qi.isEmpty() && arr[i]>= arr[qi.peekLast()]) {
                qi.removeLast();
            }
            qi.addLast(i);
        }

        for(;i<n;++i){
            System.out.print(arr[qi.peek()]+" ");

            while(!qi.isEmpty() && qi.peek() <= i-k)
            qi.removeFirst();

            while (!qi.isEmpty() && arr[i]>= arr[qi.peekLast()]) {
                qi.removeLast();
            }
            qi.addLast(i);
        }
        System.out.println(arr[qi.peek()]);
    }

    public static void main(String[] args) {
        int arr[]=new int[]{4,1,3,5,1,2,3,2,1,1,5};
        printMax(arr, arr.length, 3);
    }
}

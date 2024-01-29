import java.util.*;

public class pq {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int a[]=new int[]{20,10,60,30,50,40};
        int k=4;
        for(int i=0;i<k;i++){
            pq.add(a[i]);

        }

        for(int i=k;i<a.length;i++){
            if(pq.peek() < a[i]){
                pq.poll();
                pq.add(a[i]);
            }
        }

        System.out.println(pq.peek());


    }
}

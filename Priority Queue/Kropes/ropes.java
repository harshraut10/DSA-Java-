import java.util.*;

public class ropes {
        public static void main(String[] args) {
            PriorityQueue<Integer> pq= new PriorityQueue<>();
            int a[]=new int[]{4,3,2,6};
            int n=4;
            for(int i : a){
                pq.add(i);
            }
            int ans=0;
            while(pq.size()>1){
                int first=pq.poll();
                int sec=pq.poll();
                 int sum=first+sec;
                 ans+=sum;
                 pq.add(sum);
            }

            System.out.println(ans);

        }
}

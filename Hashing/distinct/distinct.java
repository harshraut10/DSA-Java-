import java.util.*;

public class distinct {
        public static void main(String [] args){
            int a[]=new int[]{3,4,5,6,5,4,3};
            System.out.println(dist(a));
        }

        static int dist(int a[]){
            HashSet<Integer> set =  new HashSet<>();
            for( int element: a){
                set.add(element);
            }

            return set.size();
        }
}

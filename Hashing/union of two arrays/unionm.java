import java.util.HashSet;

public class unionm {
    public static void main(String[] args){
        int a[]=new int[]{5,10,15,5};
        int b[]=new int[]{10,15,4,5};
        System.out.println(union(a, b));

    }

    static int union(int a[],int b[]){
        HashSet<Integer> set= new HashSet<>();
        for(int element : a){
            set.add(element);
        }

        for(int element :b){
            set.add(element);
        }
        return set.size();

    }
}

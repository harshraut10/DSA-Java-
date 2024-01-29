

import java.util.HashSet;

public class intersection {
    public static void main(String[] args){
        int a[]=new int[]{5,10,15,5,10};
        int b[]=new int[]{10,15,4};
        System.out.println(inter(a, b));
    }

    static int inter(int a[],int b[]){
        HashSet<Integer> set=new HashSet<>();
        for(int x: a){
            set.add(x);
        }
        int count=0;
        for(int x:b){
            if(set.contains(x)){
                set.remove(x);
                count++;
            }
        }

        return count;
    }
}

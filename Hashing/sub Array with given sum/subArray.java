import java.util.HashMap;

public class subArray {
    public static void main(String[] args) {
        HashMap<Integer,Integer> set =new HashMap<>();
        int a[]=new int[]{10,15,-5,15,-10,5};
        int sum=5;
        int cursum=0,end=-1,start=0;
        for(int i=0;i<a.length;i++){
            cursum+=a[i];
            if((cursum-sum)==0){
                start=0;
                end=i;
                break;
            }

            if(set.containsKey(cursum-sum)){
                start=set.get(cursum-sum)+1;
                end=i;
                break;
            }

            set.put(cursum,i);
        }

        if(end==-1) System.out.println("not found");
        else System.out.println(start+" "+ end);

    }
}

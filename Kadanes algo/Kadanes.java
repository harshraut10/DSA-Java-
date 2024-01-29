public class Kadanes {
    public static void main(String[] args){
        int[] a=new int[]{1,2,-3,4};
        System.out.println(maxSubArray(a));
    }
    static int maxSubArray(int a[]){
        int maxsum=0;
        int cursum=0;
        for(int i=0;i<a.length;i++){
            cursum=cursum+a[i];
            if(cursum > maxsum){
                maxsum=cursum;

            }
            if(cursum < 0){
                cursum=0;
            }
        }
        return maxsum;
    }
}

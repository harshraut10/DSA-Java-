

public class stocks_buy {
    public static void main(String[] args){
        int[] a=new int[]{3,1,4,8,7,2,5};
        int[] a2=new int[]{5,2,7,3,6,1,2,4};
        //System.out.println(buySell(a));
        System.out.println(buysell2(a2));
    }

    static int buySell(int a[]){
        int minsofar=0;
        int maxprof=0;
        int curprof=0;
        minsofar=a[0];
        for(int i=0;i<a.length;i++){
            if(a[i]<minsofar){
                minsofar=a[i];
                curprof=a[i]-minsofar;
            }
            else{
                curprof=a[i]-minsofar;
            }

            if(curprof>maxprof){
                maxprof=curprof;
            }
        }

        return maxprof;
    }

    static int buysell2(int a[]){
        int profit=0;
        for(int i=1;i<a.length;i++){
            if(a[i]>a[i-1]){
                profit+=(a[i]-a[i-1]);
            }
        }

        return profit;
    }
}

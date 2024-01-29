

public class alloc {
    public static void main(String[] args){
        int a[]=new int[]{10,5,20};
        System.out.println(minipgs(a,2));

    }

    static int maxof(int a[]){
        int max=0;
        for(int i=0;i<a.length;i++){
            max=Math.max(max,a[i]);
        }
        return max;
    }

    static int sumof(int a[]){
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum+=a[i];
        }
        return sum;
    }
    static int minipgs(int a[],int k){
        int min= maxof(a);
        int max=sumof(a);
        int res=0;
        while(min<=max){
            int mid=(min+max)/2;
            if(isfeasible(a,k,mid)){
                res=mid;
                max=mid-1;
            } else{
                min=mid+1;
            }
        }
        return res;
    }

    static boolean isfeasible(int a[],int k,int res){
        int student=1,sum=0;
        for(int i=0;i<a.length;i++){
            if(sum+ a[i] > res){
                student++;
                sum=a[i];
            }
            else{
                sum+=a[i];
            }
        }

        return student<=k;
    }
}

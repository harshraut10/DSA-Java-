

public class fastPower {
    public static void main(String[] args){
        System.out.println(fastPower(3978432,5,1000000007));
    }

    static long fastPower(int a ,int b, int n){
        long res=1;
        while(b>0){
            if((b&1)!=0){ //b%2 !=0
                res=(res *a % n) % n;
            }
            a=(a % n *a % n) % n;
            b = b >> 1; //divide by 2
        }

        return res;
    }
}

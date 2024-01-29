

public class recursion {
    public static void main(String[] args){
        //print(5);
        //System.out.println(power(2,3));
        //System.out.println(count(4,3));
        //System.out.println(jos(5,3));
        //System.out.println(pal("abbaa",0,4));
        //powerSet("abc", 0,"");
        permute("abc",0,3);
    }
    static void print(int n){
        if(n==0) return;
        System.out.println(n+ " hello");
        print(n-1);
    }

    static int power(int a,int b){
        if(b==0) return 1;

        return (a * power(a, b-1));
    }

    //number of ways in n x m matrix
    static int count(int n,int m){
        if(n==1 || m==1) return 1;

        return count(n-1, m) + count(n, m-1);
    }

    //josephus problem
    static int jos(int n,int k){
        if(n==1) return 0;

        return (jos(n-1, k)+k)%n;
    }

    //string palindrome
    static boolean pal(String s,int l ,int r){
        if(l>=r) return true;

        if(s.charAt(l) != s.charAt(r)) return false;

        return pal(s, l+1, r-1);
    }

    //powerset
    static void powerSet(String s,int i, String cur){
        if(i==s.length()){
            System.out.println(cur);
            return;
        }

        powerSet(s, i+1, cur + s.charAt(i));
        powerSet(s, i+1, cur);
    }
    //permutations of a given string
    static void permute(String s, int l, int r){
        if(l==r){
            System.out.println(s);
            return;
        }
        for(int i=l;i<=r;i++){
            s=swap(s, l, i);
            permute(s, l+1, r);
            s=swap(s, l, i);
        }
    }

    static String swap(String s, int l, int i){
        char ch[] = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[i];
        ch[i] = temp;
        s=ch.toString();
        return s;
        
    }

}

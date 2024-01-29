

public class rainwater {
    public static void main(String[] args){
        int a[]=new int[]{3,1,2,4,0,1,3,2};
        System.out.println();
        int left[]=new int[a.length];
        int right[]=new int[a.length];
        left[0]=a[0];
        int lefmax=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]<lefmax){
                left[i]=lefmax;
            }
            else{
                lefmax=a[i];
                left[i]=lefmax;
            }
        }
        right[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            right[i]=Math.max(right[i+1], a[i]);
        }
        for(int i=0;i<a.length;i++){
            System.out.print(right[i]+" ");
            
        }
        System.out.println();
         for(int i=0;i<a.length;i++){
            System.out.print(right[i]+" ");
            
        }

        System.out.println("\n"+"water is "+calc(a, left, right));


        }

        static int calc(int a[],int left[],int right[]){
            int water=0;
            for (int i=0;i<a.length;i++){
                water=water+(Math.min(left[i], right[i])-a[i]);

            }
            return water;
        }
}

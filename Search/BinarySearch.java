

public class BinarySearch {
    public static void main(String[] args){
        int arr[]=new int[]{-4,-1,3,7,10,11};
        int infinitearr[]=new int[]{1,3,7,8,12,58,72,84,86,91,93,95,97,99};
        int rotated[]=new int[]{20,30,40,50,60,5,10};
        int N=arr.length-1;
        //System.out.println(binarySearchI(arr, 0, N, 11));
        //System.out.println(BSrecur(arr, 0, N, -4));
        //System.out.println(infiniteSearch(infinitearr, 58));
        System.out.println(bsearchRotate(rotated, 10));


    }

    //search an element where array is sorted and rotated
    static int bsearchRotate(int a[],int x){
        int l=0,h=a.length-1;

        while(l<=h){
            int mid=(l+h)/2;
            if(a[mid] == x) return mid;

            //left sorted array
            if(a[l]< a[mid]){
                if(x>a[l] && x<a[mid]){
                    h=mid-1;
                }
                else {
                    l=mid+1;
                }
            }

            else{
                if(x>a[mid] && x<=a[h]){
                    l=mid+1;
                }
                else{
                    h=mid-1;
                }
            }
        }
        return -1;
    }
    // search an element in an infinite sorted array
    static int infiniteSearch(int a[],int x){
        int l=0;
        int high=1;

        while(a[high]< x){
            
            l=high;
            high=2*high;
            System.out.println("low "+l);
            System.out.println("high "+high);
        }

        return binarySearchI(a, l, high, x);
    }




    //binary search Recurssive + Iterative
    static int BSrecur(int a[],int l,int h,int x){
        int mid=(l+h)/2;
        if(l>h) return -1;

        if(a[mid]==x) return mid;

        if(x< a[mid]) return BSrecur(a, l, mid-1, x);

        return BSrecur(a, mid+1, h, x);

    }
    static int binarySearchI(int a[],int l, int h,int x){
        while(l<=h){
            int mid=(l+h)/2;
            if(a[mid]== x){
                return mid;
            }
            else if(x<a[mid]){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}

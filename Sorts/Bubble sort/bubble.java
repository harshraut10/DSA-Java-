

public class bubble {
    public static void main(String args[]){
        int arr[]=new int[]{4,3,7,1,5};
        //bubble(arr);
        //insertion(arr);
        //selection(arr);
        //System.out.println(arr.length);
        int N=arr.length;
        //quickSort(arr, 0, N - 1);
        
        mergeSort(arr, 0, N-1);
        System.out.println("Sorted array:");
        printArr(arr);

    }

    static void bubble(int arr[]){
        int temp;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j+1]<arr[j]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
       for(int i=0;i<arr.length;i++){
        System.out.print(" "+arr[i]);
       }
    }

    static void insertion(int a[]){
        int temp;
        for(int i=1;i<a.length;i++){
            temp=a[i];
            int j=i-1;
            while(j>=0 && a[j]>temp){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=temp;
        }

         for(int i=0;i<a.length;i++){
        System.out.print(" "+a[i]);
       }

    }

    static void selection(int a[]){
        int min,temp;
        int n=a.length;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(a[j]<a[min]){
                    min=j;
                }
            }

            if(min!=i){
                temp=a[min];
                a[min]=a[i];
                a[i]=temp;
            }
        }

         for(int i=0;i<a.length;i++){
        System.out.print(" "+a[i]);
       }

    }
    public static void printArr(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high)
    {
        if (low < high) {
 
            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);
 
            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high)
    {
        // Choosing the pivot
        int pivot = arr[high];
 
        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);
 
        for (int j = low; j <= high - 1; j++) {
 
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
 
                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
 

    static void mergeSort(int a[],int l,int r){
        if(l<r){
            int mid=(l+r)/2;
            mergeSort(a,l,mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid, r);

        }
    }

    static void merge(int a[],int l, int mid, int r){
        int i=l;
        int j=mid +1;
        int k=l;
        int b[]=new int[a.length];
        while(i<=mid && j<=r){
            if(a[i]<a[j]){
                b[k]=a[i]; i++;
            }
            else{
                b[k]=a[j]; j++;
            }
            k++;
        }

        if(i>mid){
            while(j<=r){
                b[k]=a[j];
                j++;k++;
            }
        }
        else{
            while(i<=mid){
                b[k]=a[i];
                i++;k++;
            }
        }
        for(k=l;k<=r;k++){
            a[k]=b[k];
        }
    }
}

public class quicksort {

    public static void main(String argv[]){
        int[] arr = {12,2,35,1,2,0,6,-1,2,3,5,52,89,99};
        qsort(arr,0,arr.length-1);

        for(int i = 0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }

    public static void qsort(int[] arr, int lo, int hi){
        if (lo<hi){
            //pi is partition
            int pi = partition(arr,lo,hi);

            qsort(arr,lo,pi-1);
            qsort(arr,pi+1, hi);
        }
    }
    public static int partition(int [] arr, int lo, int hi){
        //create pivot
        int pivot = arr[hi];

        //create swap variable
        int i = (lo-1);

        for(int j = lo; j<=hi-1; j++){
            // if the current element we are looking at is smaller, we will move the increment up one
            if(arr[j]< pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, hi);
        return (i+1);
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        int b = 0;
    }
}

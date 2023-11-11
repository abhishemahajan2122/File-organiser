import java.util.*;



public class sorting {


  public static void main(String[]args){
    int arr[] = {2, 1, 7,4, 6,2, -10, 3,8,3};
    quicksort(arr, 0, arr.length-1);
    for(int e : arr){

        System.out.println(e);
    }

  }

 public static void quicksort(int[]arr, int si ,int ei ){
     
    if(si>ei)
    return ;

    int pivot = ei;
    int pvtidx = segregate(arr, si , ei , pivot);

    quicksort(arr, si, pvtidx-1);
    quicksort(arr, pvtidx+1, ei);
  }


  public static int segregate(int []arr, int si , int ei , int pivot){
    swap(arr,pivot, ei);

    int p = si-1, itr = si;
    while(itr <= ei){

        if(arr[itr]<= arr[ei])
        swap(arr,++p,itr);
        itr++;
    }
   return p;
  }


  public static void swap(int arr[], int st,int en){
    int temp = arr[st];
    arr[st] = arr[en];
    arr[en] = temp;
  } 
}

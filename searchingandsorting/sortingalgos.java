//bubble sort
import java.util.*;

public class sortingalgos{

    public static void main(String args[]){

        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i =0 ; i< n ; i++){
            arr[i] = scn.nextInt();
           
        }

        insertionsort(arr);
        for(int i =0 ; i < n ; i++){
        System.out.print (arr[i]+"  ");

        }

    }


    public static void swap(int arr[], int i, int j){
     
        int temp = arr[i] ;
        arr[i] = arr[j];
        arr[j] = temp;
    }



    //bubble sort

    public static void bubblesort(int arr[]){
        int n = arr.length;

        for(int i =1 ; i < n ; i++){
            for(int j = 0 ; j < n-i ;j++){
                if(arr[j+1]<arr[j]){
                  swap(arr, j+1,j);
                }
            }
        }

    }


    //selection sort 

    public static void selectionsort(int arr[]){
        int n = arr.length;
        for(int i = 0 ; i <n-1 ; i++){
            int min = i;
            for(int j = i ; j< n ; j++){
              if(arr[min]> arr[j]){
                min= j;
              }

            }
            swap(arr, min , i );
        }
    }





    //insertion sort

    public static void insertionsort(int arr[]){
        int n = arr.length;

        for(int i = 1 ; i<= n-1 ;i++){
          for(int j = i ; j> 0; j--){
            if(arr[j] < arr[j-1]){
               swap(arr, j , j-1);

            }else{
                break;
            }
          }
        }
        
    }


    
}
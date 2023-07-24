import java.util.*;


public class binarysearch {
    
    public static void main(String args[]){
        Scnanner scn = new Scanner(system.in);
        
    }


    //binary search
    public static int binarysearch(int arr[], int data){
        int si =0 , ei = arr.length-1;

        while(si<= ei){
            int mid = (si+ei) /2  // sometimes if int ranger given 2^31 should use si + (ei-si)/2

            if(arr[mid]== data){
             return mid;

            }
            else if(arr[mid] >  data){
             ei = mid -1 ;
            }else{
             si = mid +1 ;
            }

        }
       return -1;

    }



    //last index
    public static int lastindex(int arr[], int data) {
        int n = arr.length, si = 0, ei = n - 1;

        while (si <= ei) {
            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                if (mid + 1 < n && arr[mid + 1] == arr[mid]) {
                    si = mid + 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }



    // first index
    public static int firstindex(int arr[], int data) {

        int n = arr.length, si = 0, ei = n - 1;

        while (si <= ei) {

            int mid = (si + ei) / 2;
            if (arr[mid] == data) {
                if (mid - 1 >= 0 && arr[mid - 1] == arr[mid]) {
                    ei = mid - 1;
                } else {
                    return mid;
                }
            } else if (arr[mid] > data) {
                ei = mid - 1;
            } else {
                si = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[] { firstindex(nums, target), lastindex(nums, target) };
    }



    //insert index
    // works for both distinct and duplicate
    public static int insertlocation(int arr[], int data){
        int n = arr.length , si = 0 , ei = n-1;
        while(si<=ei){
            int mid= si+ei/2;
            if(arr[mid]<= data){
             si = mid+1;
            }else{
             ei = mid-1;
            }
        }
        return si;
    }

    public static int perfectposition(int arr[], int data){
        int insertpos = insertlocation(arr, data);
        int lastidx = insertpos -1;
        return (lastidx >=0 & arr[lastidx] == data)? lastidx : insertpos;
    }




    //nearest element
    
}

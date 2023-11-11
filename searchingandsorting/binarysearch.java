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




    
    

  // Merge sort
  // gfg count inversions : https://practice.geeksforgeeks.org/problems/inversion-of-array-1587115620/1

  static long inversionCount(long arr[], long N)
    {

      return countinversions(arr, 0, (int)N-1);

       
    }

  public static long countinversions(long arr[], int si , int ei ){
    if(si >= ei )
    return 0;

    int mid = (si + ei) /2;

    long leftinversions = countinversions(arr,si , mid);

    long rightinversions = countinversions(arr, mid+1, ei);

    return leftinversions + rightinversions + inversionsacross(arr, si, ei , mid);
  }


  public static long inversionsacross(long arr[], int si , int ei , int mid ){

    int lsi = si , lei = mid, rsi = mid +1 , rei = ei ;
    long sortedarr[] = new long[ei + 1];
    long count = 0 ;
    int k = 0 ;  // this k for iterating over sortedarr

    while(lsi <= lei && rsi <= rei){
       if(arr[lsi] > arr[rsi]){
          count += (lei - lsi +1);
          sortedarr[k++] = arr[rsi++];
       }else{
         sortedarr[k++] = arr[lsi++];
       }
    }

    while(lsi <= lei)
      sortedarr[k++] = arr[lsi++];

    while(rsi <= rei)
      sortedarr[k++] = arr[rsi++];

    k=0; 
    for(int i = si ; i <= ei ; i++){

        arr[i] = sortedarr[k++];

    }
    return count;
  }









  // optimised ismai long sortedarr ek baaar shuru mai hi bana rahe hain
  static long inversionCount(long arr[], long N)
    {
      long sortedarr[] = new long[(int)N];
      return countinversions(arr, 0, (int)N-1, sortedarr);

       
    }

  public static long countinversions(long arr[], int si , int ei, long sortedarr[] ){
    if(si >= ei )
    return 0;

    int mid = (si + ei) /2;

    long leftinversions = countinversions(arr,si , mid, sortedarr);

    long rightinversions = countinversions(arr, mid+1, ei, sortedarr);

    return leftinversions + rightinversions + inversionsacross(arr, si, ei , mid, sortedarr);
  }


  public static long inversionsacross(long arr[], int si , int ei , int mid , long sortedarr[]){

    int lsi = si , lei = mid, rsi = mid +1 , rei = ei ;
   // long sortedarr[] = new long[ei + 1];
    long count = 0 ;
    int k = 0 ;  // this k for iterating over sortedarr

    while(lsi <= lei && rsi <= rei){
       if(arr[lsi] > arr[rsi]){
          count += (lei - lsi +1);
          sortedarr[k++] = arr[rsi++];
       }else{
         sortedarr[k++] = arr[lsi++];
       }
    }

    while(lsi <= lei)
      sortedarr[k++] = arr[lsi++];

    while(rsi <= rei)
      sortedarr[k++] = arr[rsi++];

    k=0; 
    for(int i = si ; i <= ei ; i++){

        arr[i] = sortedarr[k++];

    }
    return count;
  }








//leetcode 33 : https://leetcode.com/problems/search-in-rotated-sorted-array/

public int search(int[] nums, int data) {
        
    int si =0 , ei = nums.length -1;

       while(si <= ei){
           int mid = (si + ei)/2;

           if(nums[mid] == data){
               return mid;

           }else if(nums[mid]>= nums[si]){
                if(nums[si]<= data && nums[mid]> data){
                 ei = mid-1;
                }else{
                 si = mid+1;  
                } 
           }else{
                if(nums[mid]< data && nums[ei]>= data){
                 si = mid+1;
                }else{
                 ei = mid -1;
                }
     
           }
       }

       return -1;

   }









//leetcode 81 : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/  
 //dry run on [1,1,1,1,13,1,1,1,1,1,1]

public boolean search(int[] nums, int data) {
        
    int si =0 , ei = nums.length -1;

    while(si <= ei){
        int mid = (si + ei)/2;

        if(nums[mid] == data || nums[si] == data){ // ismai bhi change hai pichle ques se
            return true;

        }else if(nums[mid]> nums[si]){
             if(nums[si]<= data && nums[mid]> data){
              ei = mid-1;
             }else{
              si = mid+1;  
             } 
        }else if(nums[mid]< nums[ei]){
             if(nums[mid]< data && nums[ei]>= data){
              si = mid+1;
             }else{
              ei = mid -1;
             }
  
        }else{     // special case when u don't both the sides are not sorted and find impossible to decide
            si++;
        }

    }

    return false;

}




//leetcode 153: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
//ismai humesha unsorted region ki taraf jana hai 

public int findMin(int[] nums) {
        
        int si = 0 , ei = nums.length-1;

       if(nums[si]<= nums[ei])
       return nums[si];

        while(si<ei){
            int mid = (si+ei)/2;

            if(nums[mid] < nums[ei]){
                ei = mid;

            }else if(nums[si] <= nums[mid]){
                si = mid+1;
            }
        }
       return nums[si];
        
    }





//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/submissions/1030255668/

     public int findMin(int[] nums) {

        int si = 0 , ei = nums.length -1;
        if(nums[si] < nums[ei]){
          return nums[si];

        }
        while(si < ei){
            int mid = (si+ei)/2;
          //.  System.out.println(ei + " "+si + " "+mid);
            if(nums[mid]<nums[ei]){
              ei = mid; 
            }else if(nums[mid] > nums[ei]){  // iss condition par dhyan dena isse nums[si]< nums[mid] nhi likh sakte as last question mai 
              si = mid +1;
            }else{
              ei--;
            }
        }
        return nums[si];
    }

}

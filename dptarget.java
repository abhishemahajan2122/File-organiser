import java.util.Arrays;

public class dptarget {
    
    public static void main(String[]args){
     
        int arr[] ={2,3,5,7};
        int target =10;
        // int dp[] = new int [target+1];
        // Arrays.fill(dp, -1);
        int dp[][] = new int [arr.length+1][target+1];
        for(int ok[]: dp){
            Arrays.fill(ok,-1);
        }

    //    System.out.println(permutation(arr, target , dp));
    //    display1(dp);

    //    System.out.println(combination(arr, arr.length, target , dp));
    //    display2(dp);

    //     System.out.println(permutationtabu(arr, target , dp));
    //    display1(dp);
 
        System.out.println(combination(arr, arr.length,target , dp));
       display2(dp);
       
    }

    public static void display1(int dp[]){
        for(int i = 0 ; i< dp.length ; i++){
            System.out.println(dp[i]);
        }
    }


    public static void display2(int dp[][]){
        for(int i =0 ; i<dp.length  ; i++){
            for(int j =0 ; j< dp[0].length ; j++){
                System.out.print(dp[i][j]+"   ");
            }
            System.out.println("");
        }
    }




    //permutation infinite supply
    public static int permutation(int arr[],  int target, int dp[]){
       
        int n = arr.length;

        if(target == 0){
            return dp[target]= 1;
        }

        if(dp[target]!=-1){
            return dp[target];
        }
        
        int count =0 ;
        for(int i = 0 ; i < n ; i++ ){
            if(target - arr[i]>=0)
            count += permutation(arr, target - arr[i],dp);
        }

        return dp[target]=count ;

    }

    //tabulation
    public static int permutationtabu(int arr[], int target , int dp[]){
        int n = arr.length;
         dp[0] =1;

        for(int tar = 1 ; tar<= target ; tar++){
            for(int j =0 ; j< n ; j++){
                if(tar- arr[j]>=0)
                dp[tar]+= dp[tar-arr[j]];
            }
           
            
        }
        
        return dp[target];

    }








    //combination with infinte 
    public static int combination(int arr[],int n , int target ,  int dp[][]){


      if(target == 0){
        return dp[n][target] = 1;
      }
      
      if(dp[n][target]!= -1){
        return dp[n][target];
      }
      int count =0;
      for(int i =n ; i> 0 ;i--){
        if(target- arr[i-1]>=0)
        count += combination(arr,i, target - arr[i-1], dp);
      }

      return dp[n][target]=count ;

    }




    public static int combinationtabu(int arr[],int N , int Target ,  int dp[][]){

        for(int n =0 ; n<=N ; n++){
            for(int target =0 ; target <= Target ; target++){
                
                if(target == 0){
                   dp[n][target] = 1;
                   continue;
                }
                
              
                for(int i =n ; i> 0 ;i--){
                  if(target- arr[i-1]>=0)
                   dp[n][target] += dp[i][target-arr[i-1]];                 //combinationtabu(arr,i, target - arr[i-1], dp);
                }
          
            }
        }
    
          return dp[N][Target];
    
        }
}

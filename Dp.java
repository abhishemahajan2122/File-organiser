// import java.util.*;

// public class Dp{

//    public static void main(String[]args){

//     Scanner scn = new Scanner(System.in);

//      int x = scn.nextInt();

//     for(int i = 1 ; i<=x ; i++){
//     System.out.println(fibo(i));
//    }
//    }
//   public static int fibo(int n){
//       if(n==1)
//        return 0;

//       if(n==2)
//        return 1;

//     int fib = fibo(n-1)+fibo(n-2);

//       return fib; 

//   }

// }



// import java.util.*;
// import java.time.Duration;
// import java.time.Instant;

// public class Dp{

//    public static void main(String[]args){
//     Scanner scn = new Scanner(System.in);

//          int x = scn.nextInt();

//    int[]ans;

//    long startTime = System.nanoTime();
//    ans = fibot(x);

//    long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//    for(int i = 1 ; i <= x ; i++){
//      System.out.println(ans[i]);
//     }

//    }

//    public static int[] fibot(int n){

//     int[] qb =  new int[n+1];

//     for(int i = 1 ; i<=n ; i++){

//       if(i==1){
//          qb[i] = 0;
//       }
//       else if(i==2){
//          qb[i] = 1;
//       }else{
//          qb[i] = qb[i-1] + qb[i-2];
//       }

//     }

//        return qb;     

//    }

//   }

      
// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     int[] arr = new int[x + 1];

//     long startTime = System.nanoTime();

//     fibom(x, arr);

//     long stopTime = System.nanoTime();
//     System.out.println(stopTime - startTime);

//     for (int i = 1; i <= x; i++) {
//       System.out.println(arr[i]);
//     }
//   }

//   public static int fibom(int n, int[] qb) {

//     if (n == 1) {
//       return qb[n] = 0;
//     }
//     if (n == 2) {
//       return qb[n] = 1;
//     }
//     if (qb[n] != 0) {
//       return qb[n];
//     } else {
//       int fib = fibom(n - 1, qb) + fibom(n - 2, qb);
//       qb[n] = fib;
//       return qb[n];
//     }

//   }

// }

// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();

//     long startTime = System.nanoTime();

//      int[] arr =  fibom(x);

//     long stopTime = System.nanoTime();
//     System.out.println(stopTime - startTime);

//     for (int i = 1; i <= x; i++) {
//       System.out.println(arr[i]);
//     }
//   }

//   public static int[] fibom(int n) {
//     int[] qb = new int[n + 1];
//    for(int i = 1 ; i<=n ; i++){
//     if (i == 1) {
//        qb[i] = 0;
//        continue;
//     }
//     if (i == 2) {
//        qb[i] = 1;

//     }

//      else {
//       int fib = qb[i - 1] + qb[i - 2];
//       qb[i] = fib;
//     }

//   }
//   return qb;
//   }

// }










// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     long startTime = System.nanoTime();
//     System.out.println(climbstairs(x));
//     long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//   }

//   public static int climbstairs(int n) {
//     int a = 0;
//     if (n == 0)
//       return 1;

//     for (int i = 1; i <= 3; i++) {
//       if (n - i >= 0)
//         a = a + climbstairs(n - i);

//     }
//     return a;

//   }
// }











// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     int[] qb = new int[x + 1];
//     int[] xb;
//     long startTime = System.nanoTime();
//     xb = climbstairst(x, qb);
//     long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//     for (int i = 0; i <= x; i++) {
//       System.out.println(xb[i]);
//     }

//   }

//   public static int[] climbstairst(int n, int[] dp) {
//     for (int i = 0; i <= n; i++) {
//       int a = 0;
//       if (i == 0) {
//         dp[i] = 1;

//       } else {
//         for (int j = 1; j <= 3; j++) {
//           if (i - j >= 0)
//             a = a + dp[i - j];

//         }
//         dp[i] = a;

//       }
//     }
//     return dp;
//   }
// }















// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     long startTime = System.nanoTime();
//     System.out.println(climbstairsm(x,new int[x+1]));
//     long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//   }

//   public static int climbstairsm(int n, int[] dp) {

//     int a = 0;
//     if (n == 0)
//       return dp[n] = 1;
//     if (dp[n] != 0) {
//       return dp[n];
//     } else {

//       for (int i = 1; i <= 3; i++) {
//         if (n - i >= 0)
//           a = a + climbstairsm(n - i, dp);
//       }
//       return dp[n] = a;
//     }

//   }
// }










// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     int[] qb = new int[x + 1];
//     int[] xb;
//     long startTime = System.nanoTime();
//     xb = climbstairsmt(x, qb);
//     long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//     for (int i = 0; i <= x; i++) {
//       System.out.println(xb[i]);
//     }
//   }

//   public static int[] climbstairsmt(int n, int[] dp) {
//   for(int i = 0 ; i <= n ; i++){
//     int a = 0;
//     if (i == 0){
//       dp[i] = 1;
//       continue;
//     }else {

//       for (int j = 1; j <= 3; j++) {
//         if (i - j >= 0)
//           a = a + dp[i-j];
//       }
//        dp[i] = a;
//        continue;
//     }
    
//   }
//   return dp;
//   }
// }









// import java.util.*;

// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();
//     int[] moves = new int[x];
    
//     for(int i=0; i<x; i++){
//       moves[i] = scn.nextInt();
//     }

//     int[] qb = new int[x + 1];
//     int[] xb;
//     long startTime = System.nanoTime();

//     xb = climbstairswithvariablemoves(x, qb, moves);
//     long stopTime = System.nanoTime();
// //    System.out.println(stopTime - startTime);

//     for (int i = 0; i <= x; i++) {
//       System.out.println("ans" + xb[i]);
//     }
//   }
//   public static int[] climbstairswithvariablemoves(int n, int[] dp, int[] moves){
//     for(int i=n; i>=0; i--){
//         int a = 0;
//        if(i==n){
//         dp[i] = 1;
//        }else{
//         int maxmove = moves[i];
//           for(int j=1; j<=maxmove; j++){
//             if(i+j<=n){
//                a = a + dp[i+j];
//             }
//           }
//           dp[i] = a;
//        }
//    }
//     return dp;
//  }
// }









// import java.util.*;
// public class Dp {

//   public static void main(String[] args) {
//     Scanner scn = new Scanner(System.in);

//     int x = scn.nextInt();

//     int[] moves = new int[x+1];
    
//     for(int i=1; i<=x; i++){
//       moves[i] = scn.nextInt();
//     }

//     int[] qb = new int[x + 1];
//     int[] xb;
//     long startTime = System.nanoTime();
//     xb = climbstairswithvariablejump(x, qb, moves);
//     long stopTime = System.nanoTime();
//    System.out.println(stopTime - startTime);

//     for (int i = 0; i <= x; i++) {
//       System.out.println("ans" + xb[i]);
//     }

//   }

//   public static int[] climbstairswithvariablejump(int n, int[] dp, int[] moves) {
//     for (int i = 0; i <= n; i++) {
//       int a = 0;
//       if (i == 0) {
//         dp[i] = 1;

//       } else {
//         int maxmove = moves[i];
//         for (int j = 1; j <= maxmove; j++) {
//           if (i - j >= 0)
//             a = a + dp[i - j];

//         }
//         dp[i] = a;

//       }
//     }
//     return dp;
//   }
// }











// import java.util.*;
 
// public class Dp{
//   public static void main(String[] args){

// Scanner scn = new Scanner(System.in);

//      int n = scn.nextInt();
//      int m = scn.nextInt();
//      int[][] arr = new int[n][m];
// for(int i = 0; i<n; i++){
//    for(int j = 0; j<m;j++){
//        arr[i][j]=scn.nextInt();
//    }
// }

// int[][]dp = new int[n][m];
// int ans = mazepath(dp,arr);
// System.out.println(ans);
//   }

// public static int mazepath(int[][]dp,int[][]arr){

// int n = arr.length;
// int m = arr[0].length;
// System.out.println(n);
// System.out.println(m);


// for(int i = n-1; i>=0 ; i--){
//    for(int j = m-1 ; j>=0; j--){
//       if(i==n-1 && j==m-1){      
//          dp[i][j] = arr[i][j];
//            }else if(j==m-1){
//          dp[i][j]=dp[i+1][j]+arr[i][j];
//             }else if(i==n-1){
//          dp[i][j]=dp[i][j+1]+arr[i][j];
//             }else{
//          dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+arr[i][j];
//             }
//     }
// }



// return dp[0][0];


// }



// }








// import java.util.*;
 
// public class Dp{
//     public static void main(String[]args){
//      Scanner scn = new Scanner(System.in);

//       int nr = scn.nextInt();
//       int nc = scn.nextInt();
//      int[][] arr = new int[nr][nc];
//     for(int i = 0; i < nr; i++){
//         for(int j = 0 ;j<nc; j++){
//             arr[i][j]=scn.nextInt();
//         }
//     }
//     int[][] dp = new int[nr][nc];
//     int x = goldmine(dp,arr);

// System.out.println(x);

//     }

// public static int goldmine(int[][]dp, int[][]arr){
//     int nr = arr.length;
//     int  nc = arr[0].length;
// int max= Integer.MIN_VALUE;

// for(int j = nc-1; j>=0; j--){
//     for(int i = 0; i<nr; i++){

//    if(j == nc-1){
//      dp[i][j]=arr[i][j];
//    //  System.out.println(arr[i][j]);
//    }else if(i==0){
//       dp[i][j] = Math.max(dp[i][j+1],dp[i+1][j+1])+arr[i][j];
//    }else if(i==nr-1){
//       dp[i][j] = Math.max(dp[i-1][j+1],dp[i][j+1])+arr[i][j];
//    }else{
//     dp[i][j] = Math.max(Math.max(dp[i][j+1],dp[i-1][j+1]),dp[i+1][j+1])+ arr[i][j];
//    }

//     }
// }

// // for(int t= 0;t<nr;t++){
// //     for(int r= 0;r<nc;r++){
// //         System.out.print(dp[t][r] + " ");
// //     }
// //   System.out.println();
// // }




// for(int k = 0 ; k<nr; k++){
//     if(dp[k][0]>max){
//         max = dp[k][0];
//        // System.out.println(dp[0][k]);
//     }
// }
//    return max;

// }

// }








// import java.util.*;

// public class Dp{
//     public static void main(String[]args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] cost = new int[n];
//         for(int i= 0 ;i<n;i++){
//             cost[i]=scn.nextInt();
//         }
//         int target = scn.nextInt();

//         int[]dp = new int[target + 1];

//     int x = coinchangecomb(dp,cost);

//     System.out.println(x);



//     }
// public static int coinchangecomb(int[]dp, int[]cost){
//     int n = dp.length;
//      dp[0]=1;

//     for(int coin : cost){
//             for(int i = coin ;i<n;i++){

//         dp[i]= dp[i]+dp[i - coin];

//         }  
        
//     }
//   return dp[n-1];

//  }
// }










// import java.util.*;

// public class Dp{
//     public static void main(String[]args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] cost = new int[n];
//         for(int i= 0 ;i<n;i++){
//             cost[i]=scn.nextInt();
//         }
//         int target = scn.nextInt();

//         boolean[][]dp = new boolean[n+1][target+1];

//     boolean x = targetsumsubset(dp,cost);

//     System.out.println(x);

//     }
//     public static boolean targetsumsubset(boolean[][]dp, int[]cost){
//         int nr= dp.length;
//         int nc = dp[0].length;

//      for(int i = 0 ; i<nr; i++){
//         for(int j=0 ; j<nc; j++){
            
//             if(i==0 && j==0){
//                 dp[i][j] = true;
//             }else if(i==0){
//                 dp[i][j]=false;
//             }else if(j==0){
//                 dp[i][j]=false;
            
//             }else{
//                 boolean exc = dp[i-1][j];
//                 boolean inc = (j-cost[i-1])>=0 ? dp[i-1][j-cost[i-1]]: false;
//                 dp[i][j]= exc||inc;           
//              }

//         }
//      }



//     //  for(int t= 0;t<nr;t++){
//     //         for(int r= 0;r<nc;r++){
//     //             System.out.print(dp[t][r] + " ");
//     //         }
//     //       System.out.println();
//     //     }
        








//      return dp[nr-1][nc-1];
   


//     }

// }













// import java.util.*;


// public class Dp{


// public  static class pair{
//     ArrayList <String> arr= new ArrayList<>();
//     int count =0 ;
//     public pair(){

//     }
//    public   pair(String arr, int count){
//         this .arr.add(arr);                 ;
//         this.count = count;
//     }
//     public pair (int count){
//         this.count = count;
//      }
// }














// /////adding of data






//     public static void main(String[]args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] cost = new int[n];
//         for(int i= 0 ;i<n;i++){
//             cost[i]=scn.nextInt();
//         }
//         int target = scn.nextInt();

//         pair []dp = new pair[target + 1];

//     pair x = coinpermut(dp,cost);

//     System.out.println(x.arr);



//     }
//     public static pair coinpermut(pair []dp,int []cost){
        
        
      
//         dp[0]=   new pair("",1);

    
//         for(int i = 1; i<dp.length ; i++){
//             pair yz = new pair(0);
//             dp[i]= yz;

//             for(int coin:cost){
//              if(i>=coin){
//                 yz.count = dp[i].count + dp[i-coin].count;
//                // System.out.println(yz.count);
//                if(dp[i-coin].count>0){
//                 for(int j = 0 ; j< dp[i-coin].arr.size();j++){

//                    yz.arr.add(coin +" "+dp[i-coin].arr.get(j));
//                 }
//                }
//               }
//             }
//         }
//         return dp[dp.length-1];
//     }
// }










// import java.util.*;

// public class Dp{
//     public static void main(String[]args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] cost = new int[n];
//         for(int i= 0 ;i<n;i++){
//             cost[i]=scn.nextInt();
//         }
//         int []weight = new int[n];
//         for(int j= 0; j<n ; j++){
//             weight[j] = scn.nextInt();
//         }
//         int weightlimit = scn.nextInt();

//         int[][]dp = new int[n+1][weightlimit+1];

//    int x = zeroknapsack(dp,cost,weight);

//     System.out.println(x);


//     }
// public static int zeroknapsack(int[][]dp, int []cost, int[]weight){
//     int nr = dp.length;
//     int nc = dp[0].length; 
//      dp[0][0] = 0;
//     for(int i= 0; i < nr; i++){
//       for(int j = 0 ; j < nc; j++){
//           if(i==0){
//              dp[0][j]=0;
//           }else if(j== 0){
//              dp[i][0]=0;
//           }else if(j< weight[i-1]){
//               dp[i][j]=dp[i-1][j]; 
//           }else{
//               dp[i][j] = Math.max(dp[i-1][j],cost[i-1]+dp[i-1][j-weight[i-1]]);
//           }
//       } 
//     }
//  return dp[nr-1][nc-1];


  
// }
// }










// import java.util.*;
 
// public class Dp{
//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int [][] dp= new int[n+1][2];
//         int x = countbinary(dp,n);
//         System.out .println(x);

//     }
//     public static int countbinary(int dp[][],int n ){
      
//       int nr = dp.length;
//       int nc = dp[0].length;
//       for(int i = 0 ;i < nr ; i++){
//         for(int j = 0 ; j<nc; j++){
//             if(i==0){
//                 dp[0][j]=0;
//             }else if(i==1){
//                 dp[1][j]=1;
//             }else{
//                 if(j==0){
//                 dp[i][j]= dp[i-1][j+1];
//                 }else{
//                  dp[i][j]= dp[i-1][j-1]+dp[i-1][j];
//                 }
//             }
//         }
//       }
//     int ans = dp[nr-1][0]+dp[nr-1][1];
//     return ans;
//     }



// }







//  import java.util.*;
 
// public class Dp{
//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
       
//         long x = arrangebuild(n);
//         System.out .println(x);

//     }
//     public static long arrangebuild( int n){
//        int oldbuild = 1;
//        int oldspace = 1;
//        int num = 1;
    
//        while(num<n){
//           int newbuild = oldspace;
//           int newspace = oldbuild + oldspace;
//            oldbuild = newbuild;
//            oldspace = newspace;
//            num++;
//        }
//        long minans = oldbuild + oldspace;
//        long ans = minans * minans;
//        return ans;
//     }
// }







//  import java.util.*;
 
// public class Dp{
//     public static void main(String[] args){
//         Scanner scn = new Scanner(System.in);
//         String str = scn.nextLine();
//        //System.out.println(str);
//        int x = countsub(str);
//         System.out .println(x);

//     }
// public static int countsub(String str){

//     int n = str.length();

//     int ap = 0;
//     int apbp = 0;
//     int apbpcp = 0;

// for(int i = 0 ; i<n ; i++){
  
//         if(str.charAt(i)=='a'){
//            ap = 2*ap + 1;
//         }else if(str.charAt(i)=='b'){
//           apbp = 2*(apbp)+ap;
//         }else{
//           apbpcp = 2*(apbpcp)+apbp;
//         }
//     }

//     return apbpcp;





// }
// }
 





// import java.util.*;
// public class Dp{

//     public static void main(String[]args){
//         Scanner scn = new Scanner(System.in);
//         int x = scn.nextInt();
//         int []arr = new int[x+1];
//         int ans = friendpairing(arr);
//         System.out.println(ans);


//     }
//     public static int friendpairing(int[]dp){
//         dp[0]= 1;
//         dp[1] = 1;
//         for(int i = 2 ; i<dp.length ; i++){
//            dp[i]= dp[i-1] + (dp[i-2]*(i-1));
//         }
//         return dp[dp.length-1];
//     }
// }







// import java.io.*;
// import java.util.*;

// public class Dp {

//     public static void main(String[] args) throws Exception {
        
        
        
//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
        
        
//         int nm1 = 1; 
//         int nm2 = 1 ; 
//         for(int i = 1; i<n ; i++){
//            int other = nm1 +nm2;
//             nm1 = nm2;
//             nm2 = other;
//         }
//         System.out.println(nm2);
//     }
// }











// import java.util.*;

// public class Dp {
//     public static void main(String[] args) {

//         Scanner scn = new Scanner(System.in);
//         int n = scn.nextInt();
//         int[] prices = new int[n];
//         for (int i = 0; i < n; i++) {
//             prices[i] = scn.nextInt();
//         }
//         int ans = buyandsellonetranc(prices);
//         System.out.println(ans);

//     }

//     public static int buyandsellonetranc(int[] prices) {
//         int minimumbuy = prices[0];
//         int maxprofit = 0;

//         for (int i = 0; i < prices.length; i++) {
//             if (prices[i] < minimumbuy) {
//                 minimumbuy = prices[i];
//             }
//             int profit = prices[i] - minimumbuy;
//             if (profit > maxprofit) {
//                 maxprofit = profit;
//             }
//         }
//         return maxprofit;
//     }
// }





import java.util.*;

public class Dp{
    public static void main(String[] args){

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for(int i= 0 ; i < n ; i++){
          prices[i]=scn.nextInt();
        }
        int ans = buyandsellinfinitetrans(prices);
        System.out .println(ans);
    }

public static int buyandsellinfinitetrans(int[] prices ){
    int buy = 0 ;
    int sell = 0;
    int profit = 0; 
    for (int i = 1 ; i < prices.length ; i++){
        int selldayprice = prices[sell];
        int buydayprice = prices[buy];
      if(selldayprice < buydayprice){
          profit = profit + (prices[sell]-prices[buy]);
        sell = buy = i ;
      }else{
          sell = i;
          
        }
    }
    profit = profit + (prices[sell]-prices[buy]);
    return profit ; 
}




}
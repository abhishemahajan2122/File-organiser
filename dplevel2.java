
import java.util.*;

public class dplevel2 {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    // int N = scn.nextInt();
    // mazepath(N);

    // int st = scn.nextInt();
    // int en = scn.nextInt();
    // int dp[]= new int[en+1];
    // int ans = diceboardtabu(st,en ,dp);
    // System.out.println(ans);

    // String s = "213101";
    // int ans = numDecodingstabu(s);
    // System.out.println(ans);

    // goldmine();

   // friendspairing()
   //Dividesubsetsintoksubsets();

  //  String str= scn.nextLine();
  //  longestpalindromic(str);


  // String text1 = scn.nextLine();
  // String text2 = scn.nextLine();
  // longestcommonsubs(text1, text2);

  // String text1 = scn.nextLine();
  // String text2 = scn.nextLine();
  // distinctsubs(text1, text2);

  // String text1 = scn.next();
  // String text2 = scn.next();
  // editdistance(text1, text2);

  // String text1 = scn.next();
  // String text2 = scn.next();
  // boolean ans = isMatch(text1, text2);
  // System.out.println(ans);
    
  // String text1 = scn.next();
  // String text2 = scn.next();
  // boolean ans = isMatch2(text1, text2);
  // System.out.println(ans);
    
  goldmine();

  }












  public static void mazepath(int N) {
    int[][] dir = { { 0, 1 }, { 1, 1 }, { 1, 0 } };
    int[][] dp = new int[N][N];
    int count = mazepathhelpertabu(0, 0, N - 1, N - 1, dp, dir);
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        System.out.println(dp[i][j]);

      }
    }
  }

  public static int mazepathhelper(int sr, int sc, int er, int ec, int[][] dp, int dir[][]) {
    if (sr == er && sc == ec) {
      return dp[sr][sc] = 1;
    }
    int count = 0;
    if (dp[sr][sc] != 0) {
      return dp[sr][sc];
    }
    for (int[] d : dir) {
      int r = sr + d[0];
      int c = sc + d[1];
      if (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
        count += mazepathhelper(r, c, er, ec, dp, dir);

      }
    }
    return dp[sr][sc] = count;
  }

  public static int mazepathhelpertabu(int Sr, int Sc, int Er, int Ec, int[][] dp, int dir[][]) {

    for (int sr = Er; sr >= Sr; sr--) {
      for (int sc = Ec; sc >= Sc; sc--) {
        if (sr == Er && sc == Ec) {
          dp[sr][sc] = 1;
          continue;
        }
        int count = 0;

        for (int[] d : dir) {

          int r = sr + d[0];
          int c = sc + d[1];

          while (r >= 0 && c >= 0 && r < dp.length && c < dp[0].length) {
            count += dp[r][c]; // mazepathhelpertabu(r, c ,er, ec, dp , dir);
            r += d[0];
            c += d[1];

          }

        }
        dp[sr][sc] = count;

      }
    }
    return dp[Sr][Sc];

  }
















  // leetcode 746 : https://leetcode.com/problems/min-cost-climbing-stairs/

  public int minCostClimbingStairs(int[] cost) {
    int dp[] = new int[cost.length + 1];
    int ans = mincost(cost.length, cost, dp);
    return ans;
  }

  public static int mincost(int Sr, int[] cost, int dp[]) {
    for (int sr = 0; sr <= Sr; sr++) {

      if (sr == 0 || sr == 1) {
        dp[sr] = cost[sr];
        continue;

      }

      int ans = 0;
      int mark1 = dp[sr - 1]; // mincost(sr-1,cost,dp);

      int mark2 = dp[sr - 2];

      if (sr == cost.length) {
        ans = Math.min(mark1, mark2);
      } else {

        ans = Math.min(mark1, mark2) + cost[sr];
      }

      dp[sr] = ans;
    }
    return dp[cost.length];
  }

  // yeh question sir ki fist video mai hi milenge end mai
  public static int diceboard(int st, int en, int[] dp) {

    if (st == en) {
      return dp[st] = 1;
    }
    int count = 0;

    if (dp[st] != 0) {
      return dp[st];
    }
    for (int dice = 1; dice <= 6 && dice + st <= en; dice++) {
      count += diceboard(dice + st, en, dp);
    }

    return dp[st] = count;

  }

  public static int diceboardtabu(int St, int En, int[] dp) {
    for (int st = En; st >= St; st--) {

      if (st == En) {
        dp[st] = 1;
        continue;
      }
      int count = 0;

      for (int dice = 1; dice <= 6 && dice + st <= En; dice++) {
        count += dp[dice + st]; // diceboard(dice+st , en , dp);
      }

      dp[st] = count;

    }
    return dp[St];
  }













  // leetcode 91 : https://leetcode.com/problems/decode-ways/

  // memorization

  public int numDecodings(String s) {

    int dp[] = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    int ans = numdecodinghelper(s, 0, dp);
    return ans;

  }

  public static int numdecodinghelper(String s, int idx, int dp[]) {

    if (idx == s.length()) {
      return dp[idx] = 1;
    }

    if (dp[idx] != -1) {

      return dp[idx];

    }

    if (s.charAt(idx) == '0') {
      return dp[idx] = 0; //// main isss question 0 ka use hi samajna mushkil hai
    }
    int count = numdecodinghelper(s, idx + 1, dp);

    if (idx < s.length() - 1) {
      char ch = s.charAt(idx);
      char ch1 = s.charAt(idx + 1);
      int num = (ch - '0') * 10 + (ch1 - '0');
      if (num <= 26) {
        count += numdecodinghelper(s, idx + 2, dp);

      }
    }

    return dp[idx] = count;

  }

  // tabulation with space optimization pehle neecha wala code samajna phir ispar
  // aaana

  public static int numDecodingstabu(String s) {

    int dp[] = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    int ans = numdecodinghelpertabu(s, 0, dp);
    return ans;

  }

  public static int numdecodinghelpertabu(String s, int Idx, int dp[]) {
    int a = 1, b = 0;
    for (int idx = s.length() - 1; idx >= 0; idx--) {

      // if(idx==s.length()){
      // dp[idx]= 1;
      // continue;
      // }

      if (s.charAt(idx) == '0') {
        b = a;
        a = 0;
        // dp[idx]=0;
        continue;
      }
      if (s.charAt(idx) != '0') {

        int count = a; // dp[idx +1]; //numdecodinghelper(s, idx+1, dp);

        if (idx < s.length() - 1) {
          char ch = s.charAt(idx);
          char ch1 = s.charAt(idx + 1);
          int num = (ch - '0') * 10 + (ch1 - '0');
          if (num <= 26) {
            count += b; // dp[idx +2];//numdecodinghelper(s, idx +2, dp);

          }
        }

        // dp[idx]= count;
        b = a;
        a = count;
      }

    }
    return a;
  }

  // tabulation

  public static int numDecodingsmem(String s) {

    int dp[] = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    int ans = numdecodinghelper(s, 0, dp);
    return ans;

  }

  public static int numdecodinghelpermem(String s, int Idx, int dp[]) {

    for (int idx = s.length(); idx >= 0; idx--) {

      if (idx == s.length()) {
        dp[idx] = 1;
        continue;
      }

      if (s.charAt(idx) == '0') {
        dp[idx] = 0;
        continue;
      }
      int count = dp[idx + 1]; // numdecodinghelper(s, idx+1, dp);

      if (idx < s.length() - 1) {
        char ch = s.charAt(idx);
        char ch1 = s.charAt(idx + 1);
        int num = (ch - '0') * 10 + (ch1 - '0');
        if (num <= 26) {
          count += dp[idx + 2];// numdecodinghelper(s, idx +2, dp);

        }
      }

      dp[idx] = count;

    }
    return dp[Idx];

  }










  // leetcode 639 : https://leetcode.com/problems/decode-ways-ii/

  // yeh question aise sidha samaj nhi aayega pehle iske pichle wala karo acche se
  // phir yeh revise karna

  // ismai sirf memorization hi lagai hai
  static int mod = (int) 1e9 + 7;

  public int numDecodings2(String s) {

    long[] dp = new long[s.length() + 1];
    Arrays.fill(dp, -1);
    long ans = numdecodingshelper(s, 0, dp);
    return (int) ans;
  }

  public long numdecodingshelper(String s, int idx, long dp[]) {
    if (idx == s.length()) {
      return dp[idx] = 1;
    }

    if (dp[idx] != -1) {
      return dp[idx];
    }

    if (s.charAt(idx) == '0') {
      return dp[idx] = 0;
    }
    long count = 0;
    if (s.charAt(idx) == '*') {

      count = (count + (9 * numdecodingshelper(s, idx + 1, dp))) % mod;
      if (idx < s.length() - 1) {

        if (s.charAt(idx + 1) >= '0' && s.charAt(idx + 1) <= '6') {
          System.out.println("hey");
          count = (count + (2 * numdecodingshelper(s, idx + 2, dp))) % mod;

        } else if (s.charAt(idx + 1) >= '7' && s.charAt(idx + 1) <= '9') {

          count = (count + (1 * numdecodingshelper(s, idx + 2, dp))) % mod;

        } else {

          count = (count + (15 * numdecodingshelper(s, idx + 2, dp))) % mod;

        }
      }

    } else {
      count = (count + (1 * numdecodingshelper(s, idx + 1, dp))) % mod;

      if (idx < s.length() - 1) {

        if (s.charAt(idx + 1) == '*' && s.charAt(idx) == '1') {

          count = (count + (9 * numdecodingshelper(s, idx + 2, dp))) % mod;

        } else if (s.charAt(idx + 1) == '*' && s.charAt(idx) == '2') {

          count = (count + (6 * numdecodingshelper(s, idx + 2, dp))) % mod;

        } else if (s.charAt(idx + 1) != '*') {
          char ch = s.charAt(idx);
          char ch1 = s.charAt(idx + 1);
          int num = (ch - '0') * 10 + (ch1 - '0');

          if (num <= 26) {

            count = (count + (1 * numdecodingshelper(s, idx + 2, dp))) % mod;

          }
        }
      }
    }
    return dp[idx] = count;

  }











  // goldmine problem :
  // https://practice.geeksforgeeks.org/problems/gold-mine-problem2608/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

  public static void goldmine() {

    int[][] arr = { { 1, 3, 1, 5 },
        { 2, 2, 4, 1 },
        { 5, 0, 2, 3 },
        { 0, 6, 1, 2 } };
    int n = arr.length, m = arr[0].length, maxgold = 0;

    int[][] dir = { { 1, 1 }, { 0, 1 }, { -1, 1 } };

    int dp[][] = new int[n][m];

    for (int[] d : dp) {
      Arrays.fill(d, -1);
    }
    // for (int i = 0; i < n; i++) {
    //   maxgold = Math.max(goldminehelper(arr, dp, dir, i, 0), maxgold);
    //   // System.out.println(maxgold);
    // }

    goldminehelpertabu(arr, dp, dir, n, m);

    for (int i = 0; i < n; i++) {
      System.out.println(" ");
      for (int j = 0; j < m; j++) {
        System.out.print("dp" + dp[i][j] + " ");
      }
    }
    int si =0;
    for(int i =0 ; i <n ; i++){
        if(dp[i][0]>maxgold){
          maxgold = dp[i][0];
          si =i;
        }
     }
  System.out.println(si);
 goldmineback_eng(dp,si, 0, "",dir);
    System.out.println(maxgold);
  }

  // memorization
  public static int goldminehelper(int[][] arr, int dp[][], int dir[][], int sr, int sc) {

    int n = arr.length, m = arr[0].length;
    if (sc == m - 1) {
      return dp[sr][sc] = arr[sr][sc];

    }
    if (dp[sr][sc] != -1) {
      return dp[sr][sc];
    }

    int maxgold = 0;
    for (int d[] : dir) {
      int r = sr + d[0];
      int c = sc + d[1];
      if (r < n && r >= 0 && c < m && c >= 0)
        maxgold = Math.max(goldminehelper(arr, dp, dir, r, c) + arr[sr][sc], maxgold);
    }

    return dp[sr][sc] = maxgold;
  }

  // tabulation
  public static void goldminehelpertabu(int[][] arr, int dp[][], int dir[][], int Sr, int Sc) {
    int n = arr.length, m = arr[0].length;
    for (int sc = Sc - 1; sc >= 0; sc--) {
      for (int sr = Sr - 1; sr >= 0; sr--) {

        if (sc == m - 1) {
          dp[sr][sc] = arr[sr][sc];
          continue;

        }

        int maxgold = 0;
        for (int d[] : dir) {
          int r = sr + d[0];
          int c = sc + d[1];
          if (r < Sr && r >= 0 && c < Sc && c >= 0) {
            //System.out.println(r + " " + c);

            maxgold = Math.max(dp[r][c] + arr[sr][sc], maxgold); // Math.max(goldminehelper(arr, dp , dir , r, c)+
                                                                 // arr[sr][sc], maxgold) ;
          }
        }

        dp[sr][sc] = maxgold;
      }
    }
  }










  //friends pairing : https://practice.geeksforgeeks.org/problems/friends-pairing-problem5425/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

  public static void friendspairing() {
    long[] dp = new long[4];
    Arrays.fill(dp, -1);
    friendspairinghelpertabu(dp, 3);
    for (int i = 0; i < 4; i++) {
      System.out.println(dp[i]);
    }
  }

  // static int mod = (int)1e9+7; //Memorization
  public static long friendspairinghelper(long dp[], int n) {
    if (n == 0) {
      return dp[n] = 1;
    }

    if (dp[n] != -1) {
      return dp[n];
    }

    long count = 0;
    count += friendspairinghelper(dp, n - 1);
    count += n - 2 >= 0 ? (n - 1) * friendspairinghelper(dp, n - 2) : 0;

    return dp[n] = count % mod;

  }

  // tabulation
public static void friendspairinghelpertabu(long dp[],int N ){
  for(int n =0 ; n<=N ; n++){

    if(n==0){
       dp[n]=1;
       continue;
    }
   
    long count =0 ;
    count += dp[n-1];    //friendspairinghelper(dp, n-1);
    count += n-2>=0 ? (n-1)*dp[n-2] : 0;  //friendspairinghelper(dp, n-2) 
   
     dp[n]=count % mod;
    
  }
}
//space optimized
public static long countFriendsPairings(int n) { 
      long a = 1 , b= 1 ; 
    for(int i = 2 ; i<=n ; i++){
      long sum = b+a* (i-1)%mod;
    a= b ;
    b = sum%mod;
}
return b;
  }
 















//count ways Divide a subset into k subsets: https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

public static void Dividesubsetsintoksubsets (){
  int n = 4;
  int k = 3;
  int[][] dp= new int[n+1][k+1];
  int ans = Dividesubsetsintoksubsetshelpertabu(n,k ,dp);
  System.out.println(ans+"ans");
  for(int i = 0 ; i <n+1 ; i++){
    System.out.println(" ");
    for(int j = 0 ; j<k+1 ; j++){
      System.out.print(dp[i][j]+" ");
    }
  }
  
}

public static int Dividesubsetsintoksubsetshelper (int n , int k, int dp[][]){
  if(n==k || k==1){
    return dp[n][k]=1;
  }
  if(dp[n][k]!=0){
    return dp[n][k];
  }
  
  
  int selfgroup = Dividesubsetsintoksubsetshelper (n-1,k-1,dp);
  int combinewithgroupsmade = k * Dividesubsetsintoksubsetshelper (n-1,k,dp);
 
  
  return dp[n][k]=selfgroup + combinewithgroupsmade ;

}



public static int Dividesubsetsintoksubsetshelpertabu (int N , int K, int dp[][]){
 
  for(int n = 1 ; n <= N ; n++){
    for(int k =1 ; k<= K ; k++){

      if(n==k || k==1){
       dp[n][k]=1;
       continue;
      }
      // if(dp[n][k]!=0){
      //   return dp[n][k];
      // }
      
      
      int selfgroup = dp[n-1][k-1];                  //Dividesubsetsintoksubsetshelper (n-1,k-1,dp);
      int combinewithgroupsmade = k *  dp[n-1][k];   //Dividesubsetsintoksubsetshelper (n-1,k,dp);
     
      
       dp[n][k]=selfgroup + combinewithgroupsmade ;
    }
  }
    return dp[N][K];
 

}



























// ab saare strings wale questions hain aur inka hack yeh hai ki inmai ek pointer i shuru mai rakhna hota hai aur ek 
//pointer j last mai. Phir sochna hota hai ki agr si = sj toh kya karenge aur agr si != sj toh kya karenge. Bass yeh do case sochne hote hain
//4 types ki call lag sakti hai aise questions mai 1. both included 2.si included sj not 3. sj included si not 4.both not included
//but 4th type ki jo call hai woh type 2 and type 3 cover kardete hai toh woh lagane ki itni zaroorat nhi hai 










//leetcode 516  :https://leetcode.com/problems/longest-palindromic-subsequence/

public static void longestpalindromic(String str){
  int dp[][] = new int[str.length()][str.length()];
  // int ans = longestpalindromichelper(str, 0, str.length()-1,dp);
  int ans = longestpalindromichelpertabu(str, 0, str.length()-1,dp);
  
  System.out.println(ans);
}



public static  int longestpalindromichelper(String s , int si , int sj, int dp[][] ){
  if (si >= sj) {

    return dp[si][sj] = (si == sj ? 1 : 0);

  }
  if (dp[si][sj] != 0) {
    return dp[si][sj];
  }

  if (s.charAt(si) == s.charAt(sj)) {
    int bothincluded = 2 + longestpalindromichelper(s, si + 1, sj - 1, dp);
    return dp[si][sj] = bothincluded;
  }else{
    int includedsi = longestpalindromichelper(s, si + 1, sj, dp);
    int includedsj = longestpalindromichelper(s, si, sj - 1, dp);
  
    return dp[si][sj] = Math.max(includedsi, includedsj);

  }

}




//tabu
public static  int longestpalindromichelpertabu(String s , int Si , int Sj, int dp[][] ){
  int n = s.length();
  for(int gap = 0 ; gap <n ;gap ++){
    for(int si = 0 , sj = gap ; sj<n ; si++, sj++ ){

      if (si >= sj) {
    
         dp[si][sj] = (si == sj ? 1 : 0);
         continue; 
    
      }
      // if (dp[si][sj] != 0) {
      //   return dp[si][sj];
      // }
    
      if (s.charAt(si) == s.charAt(sj)) {
        int bothincluded = 2+ dp[si+1][sj-1];                       // 2 + longestpalindromichelper(s, si + 1, sj - 1, dp);
        dp[si][sj] = bothincluded;
      }else{
        int includedsi = dp[si+1][sj]; //longestpalindromichelper(s, si + 1, sj, dp);
        int includedsj = dp[si][sj-1]; //longestpalindromichelper(s, si, sj - 1, dp);
      
         dp[si][sj] = Math.max(includedsi, includedsj);

      }
    
    }
    }
    return dp[Si][Sj];
  }








//leetcode 1143 : https://leetcode.com/problems/longest-common-subsequence/


public static void longestcommonsubs(String text1, String text2){
   int n = text1.length(), m= text2.length();
   int dp[][] = new int [n+1][m+1];
   for(int[]d:dp){
    Arrays.fill(d,-1);
    }
  //  int ans = longestcommonsubshelper(text1, text2, n, m, dp);
  int ans = longestcommonsubshelpertabu(text1, text2, n, m, dp);
   System.out.println(ans);

}



public static int longestcommonsubshelper(String text1 , String text2 , int n , int m , int dp[][]){

  if(n==0||m==0){
    return dp[n][m]=0;
  }

   if(dp[n][m]==-1){
    return dp[n][m];
   }

  if(text1.charAt(n-1)== text2.charAt(m-1)){
    return dp[n][m] = longestcommonsubshelper(text1, text2, n-1, m-1, dp) +1;
  }else{
    int nleft = longestcommonsubshelper(text1, text2, n-1, m, dp);
    int mleft = longestcommonsubshelper(text1, text2, n, m-1, dp);
    return dp[n][m]= Math.max(nleft, mleft);
  }

}






public static int longestcommonsubshelpertabu(String text1 , String text2 , int N , int M , int dp[][]){
 for(int n = 0 ; n<=N ; n++){
  for(int m =0 ; m<= M ; m++){

    if(n==0||m==0){
       dp[n][m]=0;
       continue;
    }
  
    //  if(dp[n][m]==-1){
    //   return dp[n][m];
    //  }
  
    if(text1.charAt(n-1)== text2.charAt(m-1)){
       dp[n][m] = dp[n-1][m-1]+1; //longestcommonsubshelper(text1, text2, n-1, m-1, dp) +1;
    }else{
      int nleft =  dp[n-1][m];   //longestcommonsubshelper(text1, text2, n-1, m, dp);
      int mleft = dp[n][m-1];     //longestcommonsubshelper(text1, text2, n, m-1, dp);
      dp[n][m]= Math.max(nleft, mleft);
    }
  }
 }
 return dp[N][M];
}










//leetcode : https://leetcode.com/problems/distinct-subsequences/

public static void distinctsubs(String s, String t) {
  int n = s.length(), m = t.length();
  int dp[][] = new int[n + 1][m + 1];
  for (int[] d : dp)
    Arrays.fill(d, -1);
  // int ans = distinctsubshelp(dp, s, t, n, m);
  int ans = distinctsubshelptabu(dp, s, t, n, m);
  System.out.println(ans);
}

public static int distinctsubshelp(int[][] dp, String s, String t, int n, int m) {
  if (m == 0) {
    return dp[n][m] = 1;
  }
  if (n < m) {
    return dp[n][m] = 0;
  }
  if (dp[n][m] != -1) {
    return dp[n][m];
  }

  int a = distinctsubshelp(dp, s, t, n - 1, m - 1);
  int b = distinctsubshelp(dp, s, t, n - 1, m);
  if (s.charAt(n - 1) == t.charAt(m - 1)) {
    return dp[n][m] = a + b;
  } else {
    return dp[n][m] = b;
  }

}


//tabu

public static int distinctsubshelptabu(int[][] dp, String s, String t, int N, int M) {
for(int n = 0; n<=N ; n++){
  for(int m =0 ; m<=M ; m++){

    if (m == 0) {
       dp[n][m] = 1;
       continue;
    }
    if (n < m) {
       dp[n][m] = 0;
       continue;

    }
    // if (dp[n][m] != -1) {
    //   return dp[n][m];
    // }
  
    int a = dp[n-1][m-1]; // distinctsubshelp(dp, s, t, n - 1, m - 1);
    int b = dp[n-1][m];   //distinctsubshelp(dp, s, t, n - 1, m);
    if (s.charAt(n - 1) == t.charAt(m - 1)) {
      dp[n][m] = a + b;
    } else {
       dp[n][m] = b;
    }
  
  }
  }
  return dp[N][M];
}










//leetcode 72 : https://leetcode.com/problems/edit-distance/

public static void editdistance (String word1 , String word2){
  
  int n = word1.length(), m =word2.length();
  System.out.println(m);
  int dp[][] = new int[n+1][m+1];
  for(int []d:dp)
    Arrays.fill(d,-1);

  //int ans = editdistancehelp(word1, word2, n, m, dp);
    int ans = editdistancehelptabu(word1, word2, n, m, dp);
  for(int i = 0 ; i <=word1.length(); i++){
    System.out.println(" ");
    for(int j = 0 ; j<=m; j++){
      System.out.print(dp[i][j]+" ");
    }
  }
  
  // System.out.println("hello");


}


public static int editdistancehelp(String word1 , String word2, int n , int m , int[][]dp){
  
  if(n==0 && m==0){
    return dp[n][m] = 0;
  }
  if(n==0 || m==0){
    return dp[n][m] = (n==0? m : n);
  }

  if(dp[n][m] != -1)
   return dp[n][m];

  int insert = editdistancehelp(word1, word2,n, m-1, dp);
  int delete = editdistancehelp(word1, word2, n-1, m, dp);
  int replace = editdistancehelp(word1, word2, n-1, m-1, dp);

  if(word1.charAt(n-1)== word2.charAt(m-1)){
     return dp[n][m]= replace;
  }else{
     return dp[n][m]= Math.min(replace, Math.min(insert, delete)) +1 ;
  }

}


public static int editdistancehelptabu(String word1 , String word2, int N , int M , int[][]dp){

  for(int n = 0 ; n<=N ; n++){
    for(int m =0; m<=M ; m++){

      if(n==0 && m==0){
         dp[n][m] = 0;
         continue;
      }
      if(n==0 || m==0){
        dp[n][m] = (n==0? m : n);
        continue;
      }
    
      // if(dp[n][m] != -1)
      //  return dp[n][m];
    
      int insert = dp[n][m-1];       //editdistancehelp(word1, word2,n, m-1, dp);
      int delete = dp[n-1][m];       //editdistancehelp(word1, word2, n-1, m, dp);
      int replace = dp[n-1][m-1];    //editdistancehelp(word1, word2, n-1, m-1, dp);
    
      if(word1.charAt(n-1)== word2.charAt(m-1)){
          dp[n][m]= replace;
      }else{
          dp[n][m]= Math.min(replace, Math.min(insert, delete)) +1 ;
      }
    }
  }
  return dp[N][M];

}













//leetcode 44: https://leetcode.com/problems/wildcard-matching/

//yeh toh sort of just prepocessing hai
public static String removeextrastars(String str) {

  if (str.length() == 0)
    return str;

  StringBuilder sb = new StringBuilder();

  sb.append(str.charAt(0));

  int i = 1;

  while (i < str.length()) {
    while (i < str.length() && sb.charAt(sb.length() - 1) == '*' && str.charAt(i) == '*') // idhar multiple times
                                                                                          // i<str.length() likhne ka
                                                                                          // reason hai
      i++;

    if (i < str.length())
      sb.append(str.charAt(i));

    i++;
  }
  return sb.toString();

}


//memorization
public static int isMatchhelper(String s, String p, int n, int m, int[][] dp) {
  if (n == 0 || m == 0) {
    if (n == 0 && m == 0) {
      return dp[n][m] = 1;

    } else if (m == 1 && p.charAt(m - 1) == '*') {
      return dp[n][m] = 1;

    } else {
      return dp[n][m] = 0;
    }
  }

  char ch1 = s.charAt(n - 1);
  char ch2 = p.charAt(m - 1);

  if (dp[n][m] != -1) {
    return dp[n][m];
  }

  if (ch1 == ch2 || ch2 == '?') {
    return dp[n][m] = isMatchhelper(s, p, n - 1, m - 1, dp);
  } else if (ch2 == '*') {

    int includeone = isMatchhelper(s, p, n - 1, m, dp); // sequence of characters 
    if (includeone == 1) {                             // ho sakta hai yahi se answer aajaye toh toh aagle case mai jaane se pehle return hojayega
      return dp[n][m] = 1;
    }else{

      int empty = isMatchhelper(s, p, n, m - 1, dp); // empty string
  
      return dp[n][m] = empty;
    }

  } else {
    return dp[n][m] = 0;

  }
}



public static boolean isMatch(String s, String p) {
  p = removeextrastars(p);
  int n = s.length(), m = p.length();

  int[][] dp = new int[n + 1][m + 1];
  for (int[] d : dp) {
    Arrays.fill(d, -1);
  }

  int ans = isMatchhelpertabu(s, p, n, m, dp);
  for(int i = 0 ; i <=n; i++){
    System.out.println(" ");
    for(int j = 0 ; j<=m; j++){
      System.out.print(dp[i][j]+" ");
    }
  }

  if (ans == 1) {
    return true;
  } else {
    return false;
  }

}







//tabulation : preprocessing ismai bhi same hi rahegi 

public static int isMatchhelpertabu(String s, String p, int N, int M, int[][] dp) {

for(int n = 0; n<= N ; n++){
  for(int m =0 ; m<=M ; m++){

    if (n == 0 || m == 0) {
      if (n == 0 && m == 0) {
         dp[n][m] = 1;
         continue;
    
      } else if (m == 1 && p.charAt(m - 1) == '*') {
         dp[n][m] = 1;
         continue;
    
      } else {
         dp[n][m] = 0;
         continue;
      }
    }
    
    char ch1 = s.charAt(n - 1);
    char ch2 = p.charAt(m - 1);
    
    
    if (ch1 == ch2 || ch2 == '?') {
       dp[n][m] = dp[n-1][m-1];        //isMatchhelper(s, p, n - 1, m - 1, dp);
    
    } else if (ch2 == '*') {
    
      int includeone =  dp[n-1][m];            //isMatchhelper(s, p, n - 1, m, dp); // sequence of characters
      if (includeone == 1) {
        dp[n][m] = 1;
      }else{
      int empty =  dp[n][m-1];                  //isMatchhelper(s, p, n, m - 1, dp); // empty string
    
        dp[n][m] = empty;
      }
    
    } else {
        dp[n][m] = 0;
    
    }
    
  }
}

return dp[N][M];

}












//leetcode 10 : https://leetcode.com/problems/regular-expression-matching/solutions/191830/java-dp-solution-beats-100-with-explanation/
//bekar ratta ques // fuddu base case
public static String removestars (String p){

  StringBuilder sb = new StringBuilder();
  sb.append(p.charAt(0));

  int i =1 ;

  while(i<p.length()){
    while(i<p.length() && sb.charAt(sb.length()-1)=='*' && p.charAt(i)=='*')
    i++;

    if(i<p.length())
    sb.append(p.charAt(i));

    i++;
  }

  return sb.toString();

}


public static int isMatchhelper2(String s, String p, int n, int m, int[][] dp) {
  if (n == 0 && m == 0)
      return dp[n][m] = 1;
  if (m == 0)
      return dp[n][m] = 0;

  if (dp[n][m] != -1)
      return dp[n][m];

  char ch1 = n > 0 ? s.charAt(n - 1) : '$';
  char ch2 = p.charAt(m - 1);

  if (ch1 != '$' && (ch1 == ch2 || ch2 == '.'))
      return dp[n][m] = isMatchhelper2(s, p, n - 1, m - 1, dp);
  else if (ch2 == '*') {
      boolean res = false;
      if (m > 1 && n > 0 && (p.charAt(m - 2) == '.' || p.charAt(m - 2) == s.charAt(n - 1)))
          res = res || isMatchhelper2(s, p, n - 1, m, dp) == 1;
      res = res || isMatchhelper2(s, p, n, m - 2, dp) == 1;

      return dp[n][m] = res ? 1 : 0;
  } else
      return dp[n][m] = 0;

}
public static boolean isMatch2(String s , String p){

  p = removestars(p);
 
  int n = s.length() , m = p.length();
  int[][]dp = new int[n+1][m+1];
  for(int []d : dp){
    Arrays.fill(d , -1);
  }
 

  int ans = isMatchhelper2(s, p, n, m, dp);

  if(ans == 1){
    return true;
  }else{
    return false;
  }


}











//leetcode 1035 : https://leetcode.com/problems/uncrossed-lines/ //same as longest common subsequence
public int maxUncrossedLines(int[] nums1, int[] nums2) {
     
  int n = nums1.length , m = nums2.length;

  int dp[][] = new int[n+1][m+1];
  for(int[] d : dp)
  Arrays.fill(d,-1);

  return uncrossedLineshelper(nums1, nums2, n, m, dp);


 }

  public int uncrossedLineshelper(int[] nums1, int[] nums2, int n, int m , int dp[][]) {
    if(n==0 || m==0){
        return dp[n][m]=0;

    }
    if(dp[n][m] != -1){
       return dp[n][m];
    }

    int num1 = nums1[n-1];
    int num2 = nums2[m-1];

    if(num1 == num2){
       return dp[n][m] = uncrossedLineshelper(nums1 , nums2, n-1, m-1, dp)+1;
    }else{
       return dp[n][m] = Math.max(uncrossedLineshelper(nums1 , nums2, n-1, m, dp),uncrossedLineshelper(nums1 , nums2, n ,m-1, dp));
    }
 }

 








 //leetcode 1458:https://leetcode.com/problems/max-dot-product-of-two-subsequences/description/

 public int maxDotProduct(int[] nums1, int[] nums2) {
   int n = nums1.length, m = nums2.length;
   int[][] dp = new int[n + 1][m + 1];
   for (int d[] : dp)
     Arrays.fill(d, -(int) 1e9);
   return maxdotproducthelper(nums1, nums2, n, m, dp);

 }

 public int maxdotproducthelper(int[] nums1, int[] nums2, int n, int m, int dp[][]) {
   if (n == 0 || m == 0) {

     return dp[n][m] = -(int) 1e8;
   }
   if (dp[n][m] != -(int) 1e9)
     return dp[n][m];

   int valab = nums1[n - 1] * nums2[m - 1];
   int acceptbothnums = maxdotproducthelper(nums1, nums2, n - 1, m - 1, dp) + valab;
   int acceptn = maxdotproducthelper(nums1, nums2, n - 1, m, dp);
   int acceptm = maxdotproducthelper(nums1, nums2, n, m - 1, dp);

   return dp[n][m] = maximum(valab, acceptbothnums, acceptn, acceptm);

 }

 public static int maximum(int... arr) {
   int max = arr[0];
   for (int a : arr) {
     max = Math.max(max, a);
   }
   return max;
 }













///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//substring




 //leetcode 5 :https://leetcode.com/problems/longest-palindromic-substring/description/

 public String longestPalindrome(String s) {
   int n = s.length();

   boolean dp[][] = new boolean[n][n];

   String ans = longestPalindromehelper(s, dp);

   return ans;
 }

 public String longestPalindromehelper(String s, boolean[][] dp) {
   int count = 0, maxlen = 0, si = 0, n = dp.length;
   for (int gap = 0; gap < n; gap++) {
     for (int i = 0, j = gap; j < n; i++, j++) {
       if (gap == 0) {
         dp[i][j] = true;

       } else if (gap == 1 && s.charAt(i) == s.charAt(j)) {
         dp[i][j] = true;

       } else {
         if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
           dp[i][j] = true;

         }
       }

       if (dp[i][j]) {
         count++;
         if (j - i + 1 > maxlen) {
           maxlen = j - i + 1;
           si = i;
         }
       }

     }
   }
   return s.substring(si, si + maxlen);
 }










//longest common substring :https://practice.geeksforgeeks.org/problems/longest-common-substring1452/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

int longestCommonSubstr(String S1, String S2, int N, int M){
  int dp[][] = new int[N+1][M+1];
  int maxlen = 0;
  for(int n = 0 ; n<= N ; n++){
      for(int m =0 ; m <= M ; m++){
          if(n==0||m==0){
              dp[n][m]= 0;
              continue;
          }
          if(S1.charAt(n-1)==S2.charAt(m-1)){
              dp[n][m] = dp[n-1][m-1]+1;
          }                                    //ismai aur subsequence mai pharak dekho n-1 m , n m-1 wali call nhi aayegi bakki same
          
          maxlen = Math.max(dp[n][m],maxlen);
      }
  }
  return maxlen;
}






//leetcode 583 : https://leetcode.com/problems/delete-operation-for-two-strings/

//same as longest common subsquence
public int minDistance(String word1, String word2) {
  int n = word1.length(), m = word2.length();
  int maxcommon = longestCommonSubstrcom(word1 , word2,n,m);

  return (n+m)-(2*maxcommon);

}
int longestCommonSubstrcom(String S1, String S2, int N, int M){
  int dp[][] = new int[N+1][M+1];
  int maxlen = 0;
  for(int n = 0 ; n<= N ; n++){
      for(int m =0 ; m <= M ; m++){
          if(n==0||m==0){
              dp[n][m]= 0;
              continue;
          }
          if(S1.charAt(n-1)==S2.charAt(m-1)){
              dp[n][m] = dp[n-1][m-1]+1;
          }else{
              dp[n][m] = Math.max(dp[n-1][m],dp[n][m-1]);
          }
          
        
      }
  }
  return dp[N][M];
}










//leetcode 132: https://leetcode.com/problems/palindrome-partitioning-ii/description/

//bahut ghatiya ques poora question starting se i aur j ke perspective se karna
public int minCut(String s) {
  return palindromes(s);
}
public static int palindromes(String s){
  int n = s.length();
  boolean [][]pdp = new boolean[n][n];
  
  for(int gap =0; gap<n; gap++){
      for(int i=0 , j=gap; j < n ; i++, j++){
          if(gap==0){
             pdp[i][j] = true;
          }else if(gap==1 && s.charAt(i)== s.charAt(j)){
             pdp[i][j] = true;
          }else{
              if(s.charAt(i) == s.charAt(j) && pdp[i+1][j-1]== true)
              pdp[i][j]= true;
          }
      }
  }
  int dp[] = new int[n];
  Arrays.fill(dp,-1);
  int ans =mincuthelper(pdp,dp,0,n-1);
  
  return ans;
}

public static int mincuthelper(boolean[][]pdp,int[] dp, int si ,int ei){
  if( pdp[si][ei]== true){
      return dp[si] = 0;
  }
  if(dp[si]!=-1)
  return dp[si];
  
  int mincut = (int)1e8;
  for(int cut = si ; cut<=ei; cut++)
  if(pdp[si][cut])
    mincut = Math.min(mincut,mincuthelper(pdp,dp,cut+1,ei)+1);
  
  return dp[si] = mincut;


}








//https://practice.geeksforgeeks.org/problems/count-subsequences-of-type-ai-bj-ck4425/1
public int fun(String s)
{
    long acount =0 , bcount =0, ccount = 0, emptycount =1, mod = (int)1e9+7;
    for(int i =0 ; i<s.length() ; i++){
       if(s.charAt(i)=='a'){
           acount = (acount + emptycount + acount)%mod;
       }else if(s.charAt(i)=='b'){
           bcount = (bcount + acount + bcount)%mod;
       }else if(s.charAt(i)=='c'){
            ccount = (ccount + bcount + ccount)%mod;
       }
    }
    return (int)ccount;
}










//trick substring type direct dp[n] tabu
//leetcode 139 :https://leetcode.com/problems/word-break/description/
public boolean wordBreak(String s, List<String> wordDict) {
  HashSet<String> hs = new HashSet<>();
  int maxlength = 0, n = s.length();
  for (String ss : wordDict) {
    hs.add(ss);
    maxlength = Math.max(maxlength, ss.length());
  }

  boolean[] dp = new boolean[n + 1];
  dp[0] = true;
  for (int i = 0; i <= n; i++) {
    if (!dp[i])
      continue;

    for (int l = 1; l <= maxlength && i + l <= n; l++) {
      if (hs.contains(s.substring(i, i + l)))
        dp[i + l] = true;
    }
  }
  return dp[n];
}









///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///Back Engineering means printing the subsequence 


//first trying on longest palindromic subsequence

public static String lps_backeng(String s , int si , int ei , int[][]dp){
  if(si >= ei ){
     return si== ei? s.charAt(si)+ "" :"";
  }

  if(s.charAt(si) == s.charAt(ei)){
    return s.charAt(si) + lps_backeng(s, si+1, ei-1 , dp ) + s.charAt(ei);
  }else if(dp[si+1][ei]> dp[si][ei-1]){
    return lps_backeng(s, si+1, ei, dp);
  }else{
     return lps_backeng(s, si, ei-1, dp);
  }
}











//goldmine back_eng
public static void goldmineback_eng(int dp[][], int si, int ei, String psf, int dir[][]) {
  int n = dp.length, m = dp[0].length;

  if (ei == m - 1) {

    System.out.println(psf + "(" + si + "," + ei + ")");
    return;
  }

  int maxgold = 0;
  int idx = -1;
  for (int d = 0; d < dir.length; d++) {
    int r = si + dir[d][0];
    int c = ei + dir[d][1];
    if (r < n && r >= 0 && c < m && c >= 0 && dp[r][c] > maxgold) {
      maxgold = dp[r][c];
      idx = d;

    }
  }

  if (idx != -1) {
    int x = si + dir[idx][0], y = ei + dir[idx][1];
    goldmineback_eng(dp, x, y, psf + "(" + si + ", " + ei + ") ", dir);

  }
}



















////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//leetcode 300 : https://leetcode.com/problems/longest-increasing-subsequence/description/
// longest increasing subsequence

public int lengthOfLIS(int[] nums) {
  int n = nums.length,ans = 0;   
  int dp[] = new int[n];
   
   for(int i =0 ; i< n ; i++){
       ans = Math.max(ans, lishelper(nums,i,dp));
   }
   return ans;

  }
  public static int lishelper(int[]arr,int ei,int []dp){

      if(dp[ei]!=0)
      return dp[ei];
      
      int maxlength =1;
      for(int i = ei-1; i>=0; i--){
          if(arr[i]<arr[ei]){
            int len = lishelper(arr,i, dp);
             maxlength = Math.max(maxlength, len+1);
          }
      }
      
  
      return dp[ei] = maxlength;
  }





  //tabulation lis left to right (normal one): faith is element element starting se apne tak sabse increasing btaega
  public int lengthOfLIS(int[] arr) {
    int n = arr.length, ans = 0;
    int dp[] = new int[n];
    for (int i = 0; i < n; i++) {
      dp[i] = 1;
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] < arr[i]) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
      ans = Math.max(ans, dp[i]);
    }
    return ans;
  }


//lis right to left : left se dekhne par might seem decreasing : faith is element end se apne tak sabse increasing btaega
public static void lisrll(int []arr, int dp[]){
  int n = arr.length;
  for(int i =n-1 ; i>=0 ; i--){
      dp[i]=1;
      for(int j = i+1 ; j<n ;j++){
          if(arr[j]<arr[i]){
              dp[i] = Math.max(dp[j]+1,dp[i]);
          }
      }
  }
}



//lds left to right :  faith is element starting se apne tak sabse decreasing btaega
public int lengthOfLIS(int[] arr) {
  int n = arr.length, ans = 0;
  int dp[] = new int[n];
  for (int i = 0; i < n; i++) {
    dp[i] = 1;
    for (int j = i - 1; j >= 0; j--) {
      if (arr[j] > arr[i]) {
        dp[i] = Math.max(dp[j] + 1, dp[i]);
      }
    }
    ans = Math.max(ans, dp[i]);
  }
  return ans;
}






//lis right to left : left se dekhne par might seem increasing: faith is element end se apne tak sabse decreasing btaega
public static void lisrll(int []arr, int dp[]){
  int n = arr.length;
  for(int i =n-1 ; i>=0 ; i--){
      dp[i]=1;
      for(int j = i+1 ; j<n ;j++){
          if(arr[j]>arr[i]){
              dp[i] = Math.max(dp[j]+1,dp[i]);
          }
      }
  }
}




//leetcode 673 : https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
public int findNumberOfLIS(int[] arr) {
        
  int n = arr.length, maxlength = 0,maxcount =0;;
  int count[] = new int[n];
  int dp[] = new int[n]; //yeh longest length store kar rahi hai as we did in longest lis
  for(int i =0 ; i < n ; i++){
      dp[i]= 1;
      count[i] =1;
      for(int j = i-1 ; j>=0; j--){
          if(arr[j]<arr[i]){
              if(dp[j]+1 > dp[i]){
                  dp[i] = dp[j]+1;
                  count[i] = count[j];
              }else if(dp[j]+1 == dp[i]){
                   count[i] += count[j];
              }
          }

      }
      if(maxlength < dp[i]){
          maxlength = dp[i];
          maxcount = count[i];
      }else if(maxlength == dp[i]){
          maxcount += count[i];

      }
  }
  return maxcount;
 }





 // maximum bridges gfg : 
 public static int maxbridges(int arr[][]){
  int n = arr.length , m = arr[0].length, maxlength =0;

  Arrays.sort(arr,(a,b) -> {
    return a[1]-b[1];
  });

  int dp[] = new int[n];

  for(int i =0 ; i < n ; i++){
    dp[i]=1;
    for(int j = i-1 ; j>=0 ; j-- ){
      if(arr[j][0] < arr[i][0] && arr[j][1] < arr[i][1] ){
        dp[i] = Math.max(dp[j]+1, dp[i]);

      }
    }
    maxlength = Math.max(maxlength, dp[i]);
  }
  return maxlength;
 }



application of bridges
 //leertcode 354: https://leetcode.com/problems/russian-doll-envelopes/description/ 





 //https://practice.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1
 public int LongestBitonicSequence(int[] nums)
 {
    int n = nums.length, maxlength =0;
    int lislr[] = new int[n]; 
    int lisrl[] = new int[n];
    lislrr(nums,lislr);
    lisrll(nums,lisrl);
    for(int i = 0 ; i< n ; i++ ){
        maxlength = Math.max(lislr[i]+lisrl[i]-1,maxlength);
    }
    return maxlength;
 }
 
 public static void lislrr(int []arr, int dp[]){
     int n = arr.length;
     for(int i =0 ; i<n ; i++){
         dp[i]=1;
         for(int j = i-1 ; j>=0 ;j--){
             if(arr[j]<arr[i]){
                 dp[i] = Math.max(dp[j]+1,dp[i]);
             }
         }
     }
 }
 public static void lisrll(int []arr, int dp[]){
     int n = arr.length;
     for(int i =n-1 ; i>=0 ; i--){
         dp[i]=1;
         for(int j = i+1 ; j<n ;j++){
             if(arr[j]<arr[i]){
                 dp[i] = Math.max(dp[j]+1,dp[i]);
             }
         }
     }
 }

 




 //https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence4749/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article
 //kuch nhi hai bass length ki jagah sum store karenge issbaar
 public int maxSumIS(int arr[], int n)  
 {  
    return sumoflis(arr);
 }  
 public int sumoflis(int[] arr) {
   int n = arr.length, ans = 0;
   int dp[] = new int[n];
   for (int i = 0; i < n; i++) {
     dp[i] = arr[i];
     for (int j = i - 1; j >= 0; j--) {
       if (arr[j] < arr[i]) {
         dp[i] = Math.max(dp[j] + arr[i], dp[i]);
       }
     }
     ans = Math.max(ans, dp[i]);
   }
   return ans;
 }
}




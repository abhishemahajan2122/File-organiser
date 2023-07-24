import java.util.*;

public class array2 {
    public  static void main(String args[]) {
      Scanner scn = new Scanner(System.in);

      int x = scn.nextInt();
    
      int[] arr = new int[x];
      
      for(int i = 0; i < x; i++){
        //System.out.println("hello ");
        arr[i] = scn.nextInt();
      }
      //  int n = scn.nextInt();
       
      //  if(n<0){
      //      int m = arr.length-(-n);
      //    rotateknums(m,arr);
      //  }else{
      //    rotateknums(n,arr);
      //  }
       
      // segregatenp(arr);
      //System.out.println(arr.length);
      //  segregate012(arr);
      //  for(int i = 0; i < arr.length ; i++){
      //   System.out.println("ans "+ arr[i]);
      //  }

      // maxsumconfig(arr);

      maxarea(arr);

    }

// public static int[] rotateknums(int n, int[]arr ){

//    reverse(arr,0,arr.length-1);

//    if(n>=0){
//     int i = arr.length - n -1;
//      reverse(arr,0,i);
//      reverse(arr,i+1,arr.length-1);

//    }else{
//     int i = n-1;
//      reverse(arr,0,i);
//      reverse(arr,i+1,arr.length-1);
//    }

//    return arr;

// }

// public static void reverse(int arr[],int st, int end){
//     while(st<=end){
//       int var = arr[st];
//       arr[st] = arr[end];
//       arr[end] = var; 
//       st++;
//       end--;
//     }
// }

public static void swap(int[] arr, int st, int end){
  int temp = arr[st];
  arr[st] = arr[end];
  arr[end] = temp;
}

// public static void segregatenp(int[] arr){
//   int ptr = -1;
//   int itr = 0;
//   while(itr < arr.length){
//       if(arr[itr] >= 0)
//         swap(arr,++ptr,itr);
    
//          itr++;
       
//   }
  
// }

// public static void segregate012(int[] arr){
//   int itr = 0, ptr1 = -1, ptr2 = arr.length-1;
//   while(itr <= ptr2){
//      if(arr[itr] == 0){
//        swap(arr,++ptr1,itr++);
//      }else if(arr[itr] == 1){
//        itr = itr + 1;
      
//      }else{
//       // ptr2 = ptr2 - 1;
//       swap(arr,ptr2--,itr);

//      }
//   }
// }








// gfg : https://practice.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
// public static void maxsumconfig(int arr[]){
//   int orgsum = 0 ;
//   int maxsum = 0;
//   int n = arr.length;
//   int arrsum =0; 

//   for(int i = 0 ; i<n ; i++){
//     arrsum = arrsum + arr[i];
//     orgsum = orgsum + (arr[i]*i);

//   }
//   maxsum = orgsum;

//   for(int i =1 ; i<n ; i++){
//      orgsum = orgsum - arrsum + (arr[i-1]*n);
//      maxsum = Math.max(maxsum, orgsum);
//     }
//     System.out.println(maxsum);
// }







// //leetcode 11 : https://leetcode.com/problems/container-with-most-water/
// public static void maxarea(int arr[]){
//   int i = 0;
//   int j = arr.length-1;
//   int maxarea = 0;
//   while(i<j){
//     if(arr[i]<arr[j]){
//       maxarea = Math.max(maxarea ,(j-i)*Math.min(arr[i],arr[j]) );
//       i++;
//     }else{
//       maxarea = Math.max(maxarea ,(j-i)*Math.min(arr[i],arr[j]) );
//       j--;
//     }
//   }
//    System.out.println(maxarea);

// }







leetcode 3:https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//simple
public int lengthOfLongestSubstring(String s) {
  int ans =  lenoflongsubs(s);
  return ans;
}
public int lenoflongsubs(String s){
   int si =0 , ei = 0 , n = s.length() , len = 0, count =0;
   int freq [] = new int [128];

   while(ei<n){
        if(freq[s.charAt(ei)]== 1)
            count ++;
            freq[s.charAt(ei)]++;
            ei++;
        
       
       while (count>0){
           if(freq[s.charAt(si)]==2)
               count--;
               freq[s.charAt(si)]--;
               si++;
           
       }
   
      len = Math.max(len, ei-si);
   }
   return len;
}


//updated versiom
public int lengthOfLongestSubstring(String s) {
  int ans =  lenoflongsubs(s);
  return ans;
}
public int lenoflongsubs(String s){
   int si =0 , ei = 0 , n = s.length() , len = 0, count =0, gei = 0 , gsi = 0;
   int freq [] = new int [128];

   while(ei<n){
        if(freq[s.charAt(ei++)]++ >0 )
            count ++;
            
        
       
       while (count>0){
           if(freq[s.charAt(si++)]-- >1)
               count--;
               
           
       }
   
    if(ei-si>len){
        len= ei-si;
        gei = ei;
        gsi = gsi;
    }
   }
   System.out.println(s.substring(gsi,gei));//yeh substring wala ans bhi print kardega

   return len;
}








leetcode 159:https://leetcode.ca/all/159.html
public static lengthOfLongestSubstringwithatmost2distinctchar(String s){
  if(s.length()<2){
    return s.length();
  }
  int ei = 0 ,si =0 , n = s.length(), len = 0 ,count = 0;

  int freq[]= new int[128];

  while(ei<n){
     if(freq[s.charAt(ei++)]++==0)
      count++;

      while(count >2){
        if(freq[s.charAt(si++)]--==1){
          count --;
        }
      }
      
      len = Math.max(len, ei-si);
  }
  return len;
}








leetcode 76: https://leetcode.com/problems/minimum-window-substring/
public String minWindow(String s, String t) {
  int st = s.length(), nt = t.length();
  if(nt > st)
  return "";
  int freq [] = new int[128];
  for(int i = 0 ; i<nt ; i++){
      freq[t.charAt(i)]++;
  }
  
  int ei = 0, si= 0 , count= nt , len = (int)1e9 , gsi =0 ; 

  while(ei < st){
      if(freq[s.charAt(ei++)]-- >0)
      count--;
      
     while(count == 0){
         
         if(ei-si<len){
             len = ei- si;
             gsi = si;
         }
         
         if(freq[s.charAt(si++)]++==0)
         count++;
     }
  }
  return len==(int)1e9? "":s.substring(gsi,gsi+len);
 
  

}





//https://practice.geeksforgeeks.org/problems/smallest-distant-window3132/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
public int find_substring(String s){
  int n = s.length();
  int ei =0, si =0 , count =0 , len = (int)1e9;
  int freq[]= new int [128];
  for(int i = 0 ; i <s.length(); i++){
    if(freq[s.charAt(i)]==0){
      freq[s.charAt(i)] = 1;
      count++;
    }
  }
 
  while(ei<n){
    if(freq[s.charAt(ei++)]-- == 1)
    count--;
   
    while(count == 0){
      len = Math.min(len, ei-si );

      if(freq[s.charAt(si++)]++ == 0)
      count++;


    }


  }

return len;






}






leetcode 340 : https://www.lintcode.com/problem/386/
public static lengthOfLongestSubstringwithatmostkdistinctchar(String s){
  if(s.length()<=k){
    return s.length();
  }
  int ei = 0 ,si =0 , n = s.length(), len = 0 ,count = 0;

  int freq[]= new int[128];

  while(ei<n){
     if(freq[s.charAt(ei++)]++==0)
      count++;

      while(count >k){
        if(freq[s.charAt(si++)]--==1){
          count --;
        }
      }
      
      len = Math.max(len, ei-si);
  }
  return len;
}








leetcode 1456 : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
public static int maxVowels(String s, int k){

  HashMap <Character,Integer> map = new HashMap<>();
  map.put ('a',1);
  map.put ('e',1);
  map.put ('i',1);
  map.put ('o',1);
  map.put ('u',1);

  int ei =0 , si =0 , maxvowels = 0 , vowelcount=0 ,n = s.length() ; 

  while(ei<n){
    if(map.containsKey(s.charAt(ei++)))
    vowelcount++;

    while(ei-si > k){
      if(map.containsKey(s.charAt(si++)))
      vowelcount--;
    }

    maxvowels = Math.max(maxvowels , vowelcount);

  }
  return maxvowels;

}







leetcode 992 : https://leetcode.com/problems/subarrays-with-k-different-integers/
public int subarrayswithkdistinct(int num[], int k ){
  int ans1 = subarrayswithkdistincthelper(nums, k);
  int ans2 = subarrayswithkdistincthelper(nums, k-1);
  int finalans = ans1 - ans2;
  return finalans;
}

//using hashmap 
public int subarrayswithkdistincthelper(int nums[], int k){
  HashMap<Integer, Integer> hm =new HashMap<>();
  int ei =0 , si =0 , maxcount =0 , countdistinct =0 , n = nums.length;
  
  while (ei<n){
    hm.put(nums[ei],hm.getOrDefault(nums[ei],0)+1);
    ei++;
    while(hm.size()>k){
      
      hm.put(nums[si],hm.get(nums[si])-1);
      if(hm.get(nums[si])==0){
        hm.remove(nums[si]);
      }
      si++;
    }
    maxcount += ei-si;
  }
  return maxcount;
}

//using array 
public int subarraywithkdistincthelper(int nums[],int k){
  
  int arr[]= new int [200001];
  int ei = 0 , si =0 , countdistinct =0, maxcount = 0 , n = nums.length; 
  
  while (ei < n){
    
    if(arr[nums[ei++]]++ == 0)
    countdistinct ++;
    
    while(countdistinct > k){
      if(arr[nums[si++]]-- == 1)
      countdistinct--;
      
      
    }
    
    maxcount += ei - si ;
    
  }
  return maxcount;
}








leetcode 1248 : https://leetcode.com/problems/count-number-of-nice-subarrays/

public static int numberofsubarrays(int[]nums, int k){
  int ans1= countnicesubarrayshelper(nums, k);
  int ans2 = countnicesubarrayshelper(nums, k-1);
  return ans1 - ans2;
}

public static int countnicesubarrayshelper(int[]nums, int k){
  int si=0 , ei =0 , count =0, oddnums =0; 

  while(ei<n){
    if((num[ei++] & 1) !=0)
    oddnums++;

    while(oddnums>k){
      if((nums[si++] & 1) != 0)
      oddnums--;
    }

    count += ei-si;


  }
  return count;
}









leetcode 904: https://leetcode.com/problems/fruit-into-baskets/

public static int fruitbasket(int[]fruits){
  int []freq = new int[100000+1];
  int ei =0 , si=0, n = fruits.length , countdistinct =0 , len =0 ;
  
  while(ei<n){
    if(freq[fruits[ei++]]++ == 0)
    countdistinct++;

    while(countdistinct>2){
      if(freq[fruits[si++]]-- ==1)
      countdistinct--;
    }

    len= Math.max(len, ei-si);

  }
  return len;
}







leetcode 930 : https://leetcode.com/problems/binary-subarrays-with-sum/
//at most ka logic sum par and ek baat dekkh le kaffi useful hai

public static int subarraysum(int[]nums , goal){
  return atmostsubarrasumhelp(nums, goal) - (goal!=0?atmostsubarrasumhelp(nums, goal-1):0);

}

public static int atmostsubarrasumhelp (int nums[], int goal){

  int ei =0 , si =0 , n = nums.length , sum =0, count =0;
  
  while(ei<n){
    sum += nums[ei++];

    while(sum>goal)
     sum -= nums[si++];

    count += ei-si;

  }
  return count;
}






leetcode 485:https://leetcode.com/problems/max-consecutive-ones/description/
public int findMaxConsecutiveOnes(int[] nums) {

  int ei =0, si =0 , n =nums.length , count =0 , len =0;
  while(ei<n){
     if(nums[ei++] == 0)
     count ++;
      
    while(count >0){
      if(nums[si++] == 0)
      count--;
    }
    
    len = Math.max(len, ei-si);
    
  }
  return len;
}






leetcode 487:https://leetcode.com/problems/max-consecutive-ones-ii/
public static int solution(int[] nums, int k){
  int ei =0, si =0 , n =nums.length , count =0 , len =0;
while(ei<n){
   if(nums[ei++] == 0)
   count ++;
    
  while(count >k){
    if(nums[si++] == 0)
    count--;
  }
  
  len = Math.max(len, ei-si);
  
}
return len;
}





//divisible wale = prefix sum wale hain yeh, see from notebook special condition 

//tough questions


leetcode 974:https://leetcode.com/problems/subarray-sums-divisible-by-k/description/
//using arrays
public int subarraysDivByK(int[] nums, int k) {
  int ei =0 , n = nums.length, sum =0 , ans =0 ;
  int rem [] = new int[k];
  rem[0] = 1;//handling special condition

  while(ei<n){
      sum  += nums[ei++];
     int r = ((sum % k) + k)%k;
     
     ans += rem[r];

     rem[r]++;

  }
  return ans;
}

//using hashmap
public int subarraysDivByK(int[] nums, int k) {

  int ei = 0, n = nums.length, sum = 0, ans = 0;

  HashMap<Integer, Integer> rem = new HashMap<Integer, Integer>();

  rem.put(0, 1);
  while (ei < n) {
    sum += nums[ei++];
    int r = ((sum % k) + k) % k;

    ans += rem.getOrDefault(r, 0);

    rem.put(r, rem.getOrDefault(r, 0) + 1);

  }
  return ans;

}








gfg: https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

//using arrays
int longSubarrWthSumDivByK(int a[], int n, int k)
    {
      int rem[] = new int[1000001];
      int ei= 0,sum =0, len=0;
      Arrays.fill(rem,-2);
      rem[0]=-1;
      while(ei<n){
         sum += a[ei];
         int r = ((sum%k)+k)%k;
         
         if(rem[r]==-2){
             rem[r]=ei;
         }
         
         len= Math.max(len, ei-rem[r]);
         ei++;
      }
       
       return len;
    }


//using hashmaps
int longSubarrWthSumDivByK(int a[], int n, int k)
{
  HashMap<Integer,Integer> rem = new HashMap<>();
  int ei= 0,sum =0, len=0;

  rem.put(0,-1);
  while(ei<n){
     sum += a[ei];
     int r = ((sum%k)+k)%k;
     
     rem.putIfAbsent(r,ei);
    //  if(rem.getOrDefault(r,-2)==-2){
    //      rem.put(r,ei);
    //  }
     
     len= Math.max(len, ei-rem.get(r));
     ei++;
  }
   
   return len;
}








gfg : https://practice.geeksforgeeks.org/problems/count-subarrays-with-equal-number-of-1s-and-0s-1587115620/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
static int countSubarrWithEqualZeroAndOne(int arr[], int n) {
  HashMap<Integer, Integer> a = new HashMap<>();
  a.put(0, 1);
  for (int i = 0; i < n; i++) {
    if (arr[i] == 0)
      arr[i] = -1;

  }

  int ei = 0, sum = 0, ans = 0;
  while (ei < n) {
    sum += arr[ei++];

    ans += a.getOrDefault(sum, 0);
    a.put(sum, a.getOrDefault(sum, 0) + 1);
  }
  return ans;
}








leetcode 525: https://leetcode.com/problems/contiguous-array/
public int findMaxLength(int[] nums) {
  HashMap<Integer, Integer> hm = new HashMap<>();

  hm.put(0, -1);
  int ei = 0, n = nums.length, len = 0, sum = 0;
  while (ei < n) {
    int val = nums[ei];
    if (val == 0)
      sum += -1;

    sum += val;

    hm.putIfAbsent(sum, ei);

    len = Math.max(len, ei - hm.get(sum));
    ei++;
  }
  return len;
}







//tough one
leetcode 239: https://leetcode.com/problems/sliding-window-maximum/
//bekar sol ONK
public int[] maxSlidingWindow(int[] nums, int k) {
  int ei =0 , si =0,i=0, n =nums.length, count =0, maxele = Integer.MIN_VALUE; 
  int ans [] = new int[n-k+1];
  while(ei<n){
     int val = nums[ei++];
      count ++;
      
      while(count>k){

          si++;
          int sec = ei-2;
          maxele = Integer.MIN_VALUE;

          for(int j =si ; j<= sec; j++){

          maxele= Math.max(maxele,nums[j]);
          }
          
          count--;
      }

      maxele = Math.max(maxele,val);
     
      if(count == k){
          ans[i]= maxele;
          i++;
      }

      
  }
  return ans;
}

//ONlogN
public int[] maxSlidingWindow(int[] nums, int k) {
  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
    return nums[b] - nums[a];
  });

  int idx = 0, n = nums.length;
  int ans[] = new int[n - k + 1];

  for (int i = 0; i < nums.length; i++) {
    while (pq.size() > 0 && pq.peek() <= i - k)
      pq.remove();

    pq.add(i);

    if (i >= k - 1) {
      ans[idx++] = nums[pq.peek()];
    }
  }
  return ans;
}

//ON
public int[] maxSlidingWindow(int[] nums, int k) {
  LinkedList<Integer> ll = new LinkedList<>();

  int idx = 0, n = nums.length;
  int ans[] = new int[n - k + 1];

  for (int i = 0; i < n; i++) {
    while (ll.size() > 0 && ll.peekFirst() <= i - k)
      ll.removeFirst();

    while (ll.size() > 0 && nums[i] >= nums[ll.peekLast()]) //ismai equal to kyu aayega socho as hum daal indexes rahe hain so lastedt index kisi future answer ka part ho sakta hai so equalto aayega
      ll.removeLast();

    ll.add(i);

    if (i >= k - 1) {
      ans[idx++] = nums[ll.peekFirst()];
    }

  }
  return ans;

}









///kadane algo



//kadane algo  - 0 if all negative one 


//finding subarray too



//kadane also - generic one works for all negative numbers too


//finding subarray







leetcode 1191: https://leetcode.com/problems/k-concatenation-maximum-sum/description/
public int kConcatenationMaxSum(int[] arr, int k) {
  long prevsum = 0;

  for (int i = 1; i <= 3; i++) {
    long sum = kadanealgo(arr, i);
    System.out.println(sum);
    if (k == i) {       // if k==1||k==2 ||k==3 toh toh yahi se return hohjayega 
      return (int) sum;
    }
    if (i == 3)           // tricky part just here idhar k>3 wale sab return karega
      return (int) ((prevsum + (k - 2) * (sum - prevsum)) % mod);
    prevsum = sum;
  }

  return 0;
}

static int mod = (int) 1e9 + 7;

public static int kadanealgo(int arr[], int k) {
  long csum = 0, gsum = 0;
  int n = arr.length;
  for (int i = 0; i < arr.length * k; i++) {
    csum = csum + arr[i % n];
    if (csum > gsum) {
      gsum = csum;
    }
    if (csum <= 0)
      csum = 0;

  }
  return (int) gsum % mod;

}

}



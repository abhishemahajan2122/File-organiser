package trees;

public class find {





   //leetcode 863: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        distancekfrom(root,target, k ,ans);
       
        return ans;
     }
 
     public static int distancekfrom (TreeNode root ,TreeNode Target , int k , ArrayList<Integer>ans ){
          if(root == null){
             return -1;
         }
         if(root == Target){
             kdown(root,null , k, ans);
             return 1;
         }
 
         int lcall = distancekfrom(root.left , Target, k , ans);
         if(lcall !=-1 ){
             kdown(root,root.left,k-lcall, ans);
             return lcall +1;
         }
 
         int rcall = distancekfrom(root.right , Target, k , ans);
         if(rcall !=-1 ){
             kdown(root,root.right,k-rcall, ans);
             return rcall +1;
         }
 
 
         return -1;
 
 
     }
 
     public static void kdown(TreeNode root , TreeNode block , int k , ArrayList<Integer> ans){
         if(root == null || k < 0 || root == block){
             return ;
         }
 
         if(k == 0){
             ans.add(root.val);
         }
 
         kdown(root.left , block, k-1, ans);
         kdown(root.right , block, k-1, ans);
 
     }








     //burning tree

     public static void burtree(TreeNode root, TreeNode target ){

        ArrayList<ArrayList<Integer> ans = new ArrayList<>();
        burningtree(root, target , ans );
        System.out.println(ans);

     }

     public static int buringtree(TreeNode root , TreeNode target , ArrayList<ArrayList<Integer> ans){
        
        if(root == null ){
            return -1;
        }

        if(root == target){
          burnkarkeaa(root, 0,null,  ans);
          return 1;
        }

        int lt = burningtree(root.left, target, ans);
        if(lt != -1){
            burnkarkeaa(root, lt, root.left,  ans);
            return lt+1;

        }

        int rt = burningtree(root.right , target, ans);
        if(rt != -1){
            burnkarkeaa(root, rt, root.right,  ans);
            return rt+1;

        }

        return -1;

     }

     public static void burnkarkeaa(TreeNode root, int time, TreeNode block ,ArrayList<ArrayList<Integer>> ans){

         if(root == null || root == block){
            return ;
         }

         if(ans.size()== time)               //very important see notes 
           ans.add(new ArrayList<>());
         ans.get(time).add(root.val);


         burnkarkeaa(root.left , time+1, block ,ans);
         burnkarkeaa(root.right, time+1, block, ans);


     }
}

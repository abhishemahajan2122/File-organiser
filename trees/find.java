package trees;

import java.util.ArrayList;

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


    


     //burning tree with water

     public static void burntreewithwater(TreeNode root , TreeNode target){
        ArrayList<ArrayList<Integer> = new ArrrayList<>();

        burningtree(root, target , ans , waterset);
        System.out.println(ans);


     }


     public static int burnnigtree(TreeNode root , TreeNode target , ArrayList<ArrayList<Integer>ans, HashSet<Integer> waterset ){
        
        if(root == null ){
            return -1;
        }


        if(root == target){
            if(!waterset.contains(root.value)){
                burnkarkeaa(root,null , 0 , ans, waterset);
                return 1;
            }
            return -2; // if target par hi water hai

        }


        int lt = burningtree(root.left, target, ans , waterset);

        if(lt > 0){
            if(!waterset.contains(root.value)){
                burnkarkeaa(root, root.left , lt , ans, waterset);
                return lt+1;
            }
            return -2;

        }
        
        if(lt == -2){
            return -2;
        }



        int rt = burningtree(root.right, target, ans , waterset);
        
        if(rt > 0){
            if(!waterset.contains(root.value)){
                burnkarkeaa(root, root.right , rt, ans, waterset);
                return lt+1;
            }
            return -2;


        }

       return -1;


     }


     public static void burnkarkeaa(TreeNode root , TreeNode block , int time , ArrayList<ArrayList<Integer> ans, HashSet<Integer>waterset){
       
        if(root == null || root == block || waterset.contains(root.value)){
            return ;
        }

        if(time == ans.size())
         ans.add(ArrayList<>());
         ans.get(time).add(root.value);


         burnkarkeaa(root.left, block, time+1, ans, waterset);
         burnkarkeaa(root.right, block, time+1, ans, waterset);

     }
    



     //lca


    // without optimization
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        ArrayList<TreeNode> ans1 = new ArrayList<>();
        ArrayList<TreeNode> ans2 = new ArrayList<>();

        Nodetoroot(root, p , ans1);
        Nodetoroot(root, q , ans2);
        int i = ans1.size()-1, j = ans2.size()-1;

        while(i>=0 && j >=0 && ans1.get(i) == ans2.get(j)){
            i--;
            j--;
        }
        
        return ans1.get(i+1);
        
    }
    public static boolean Nodetoroot(TreeNode root, TreeNode target, ArrayList<TreeNode> ans){
        if(root ==null ){
            return false;
        }

        if(root == target){
            ans.add(target);
            return true;
        }

        boolean res =  Nodetoroot(root.left, target, ans) || Nodetoroot(root.right, target,ans);
        
        if(res)
        ans.add(root);

        return res;

    }




    //with optimization
    static TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        boolean check = lca(root,p, q);
        return ans;
    }

    public static boolean lca (TreeNode root , TreeNode p , TreeNode q){
        if(root == null ){
            return false;
        }

        boolean selfpresent = (root == p || root == q);

        boolean lt= lca(root.left, p , q);

        boolean rt= lca(root.right, p , q);

        if((selfpresent && lt) || (selfpresent && rt) || (lt && rt) ){
          ans = root;
          return true;
        }

        return selfpresent || lt || rt;
    } 


}

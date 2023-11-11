package trees;

public class traversalset  {

    public static class TreeNode {
        int val = 0 ;
        TreeNoede left = null;
        TreeNode right = null;

        TreeNode(int val){
            this .val = val;
        }
    }




    //Morris travelsal Inorder

    public static TreeNode rightmost(TreeNode root , TreeNode curr){
        
         
        while(root.right != null && root.right != curr  ){
            root = root.right;
        }
       
        return root;
    }


    public static ArrayList<Integer> mosrrisinorder(TreeNode root){
        TreeNode curr = root;

        while(curr != null){
            TreeNode left = curr.left;

            if(left == null){
                ans.add(curr.val);
                curr = curr.right;

            }else{
                TreeNode rgtmost = rightmost(left , curr);
                if(rgtmost.right == null) {    //thread creation block
                    rgtmost.right = curr;      //thread creation
                    curr = curr.left;

                }else{
                    rgtmost.right = null;           //thread deletion
                    ans.add(curr.val);        
                    curr = curr.right;

                }
            }
        }
    }    







    //MORRIS TRAVERSAL PREORDER

    public static getrightmost(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr)
        root = root.right;

        return root;
    }

    public static ArrayList<Integer> morrispreorder(TreeNode root){
       ArrayList<Integer> ans = new ArrayList<>();  
     
        TreeNode curr = root;
        whille(curr != null){
                 
            if(curr.left == null){
                curr= curr.right;

            }else{

                TreeNode rgtmost = getrightmost(curr.left , curr);
                if(rgtmost.right == null){  // thread creation
                   
                    rgtmost.right = curr;
                    ans.add(curr.val);
                    curr = curr.left;
                }else{
                    rgtmost.right = null ;
                    curr = curr.right;
                }

            }
        }
        return ans;
    }




    // same question using stack  : validate BST

    public static void insertallleft(TreeNode root, LinkedList<TreeNode> stack){
        TreeNode curr = root;
     while(curr != null){
         stack.addFirst(curr);
         curr = curr.left ;
     }
   }
   public boolean isValidBST(TreeNode root) {
     long prev = -(long)1e13;
     LinkedList<TreeNode> stack = new LinkedList<>();
     insertallleft(root, stack);
     while(stack.size()!= 0){
        TreeNode curr = stack.removeFirst();
        if(prev >= curr.val){
          return false;
        }
        prev = curr.val;
        if(curr.right != null){
        //  stack.addFirst(curr.right);
          insertallleft(curr.right, stack);
        }
     
     }

    return true;

   }






   // leetcode 173 : BST Iterator
   //    easy hai 
   //    same concept as last with stack 



   //same question now with morris traversal
   class BSTIterator {

    private TreeNode curr = null;


    private TreeNode getrightmost(TreeNode root, TreeNode curr){
        while(root.right != null && root.right != curr){
            root = root.right;

        }
        return root;
    }

    public BSTIterator(TreeNode root) {
       curr = root;
    }
    
     public int next() {
         int rv = -1;

         while(curr != null){
            TreeNode left = curr.left;
            if(left == null){
                rv = curr.val;
                curr = curr.right;
                break;

            }else{
                TreeNode rgtmost = getrightmost(left, curr);
                if(rgtmost.right == null){
                    rgtmost.right = curr;
                    curr = curr.left;
                }else{
                    rgtmost.right = null;
                    rv = curr.val;
                    curr = curr.right;
                    break;

                }
            }        
 
         }
         return rv;
            
        }
    
    public boolean hasNext() {
        if(curr == null){
            return false;
        }
        return true;
        
    }
}


   


   //leetcode 230 : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
   public static TreeNode rightmost(TreeNode root, TreeNode curr) {

       while (root.right != null && root.right != curr) {
           root = root.right;
       }

       return root;
   }

   public int kthSmallest(TreeNode root, int k) {
       int rv = -1;
       TreeNode curr = root;

       while (curr != null) {
           TreeNode left = curr.left;

           if (left == null) {
               if (k == 1)
                   rv = curr.val;
               k--;
               curr = curr.right;

           } else {
               TreeNode rgtmost = rightmost(left, curr);
               if (rgtmost.right == null) { // thread creation block
                   rgtmost.right = curr; // thread creation
                   curr = curr.left;

               } else {
                   rgtmost = null;
                   if (k == 1)
                       rv = curr.val; // thread deletion
                   k--;
                   curr = curr.right;

               }
           }
       }
       return rv;
   }






   //GFG : https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1?utm_source=geeksforgeeks&utm_medium=ml_article_practice_tab&utm_campaign=article_practice_tab
   public static Node rightmost(Node root, Node curr) {

       while (root.right != null && root.right != curr) {
           root = root.right;
       }

       return root;
   }

   public static int kthLargest(Node root, int k) {
       ArrayList<Integer> ans = new ArrayList<>();

       Node curr = root;

       while (curr != null) {
           Node left = curr.left;

           if (left == null) {

               ans.add(curr.data);

               curr = curr.right;

           } else {
               Node rgtmost = rightmost(left, curr);
               if (rgtmost.right == null) { // thread creation block
                   rgtmost.right = curr; // thread creation
                   curr = curr.left;

               } else {
                   rgtmost.right = null;

                   ans.add(curr.data); // thread deletion

                   curr = curr.right;

               }
           }
       }
       // System.out.println(ans);
       for (int i = ans.size() - 1; i >= 0; i--) {
           if (k == 1)
               return ans.get(i);
           k--;
       }
       return -1;

   }






}

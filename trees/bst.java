public class bst {
    


public static int size (TreeNode root){
    if(root == null) ? 0: size(root.left)+ size(root.right) +1;
}


public static int height (TreeNode root){
    if(root == null) ? -1 : Math.max(height(root.left), height(root.right))+1;
}



public static int maximum(TreeNode root){
    TreeNode curr = root;
    while(curr != null)
     curr = curr.right;

     return curr.value;

}


public static boolean find(TreeNode root,int data){
    TreeNode curr = root;

    while(curr != null){
        if(curr.val == data){
            return true;
        }else if(curr.val > data){
            curr = curr.left;
        }else{
            curr = curr.right;
        }
    }
    return false;
}



public static ArrayList nodetoroot(TreeNode root, int data){
    TreeNode curr = root;
    ArrayList<Integer> ans = new ArrayList<>();

    while(curr != null){
        ans.add(root.val);
        if(curr.val == data){
          break;
        }else if(curr.val > data){
            curr = curr.left;
        }else{
            curr = curr.right;
        }
    }
    return ans;


}




public static TreeNode lca(TreeNode root, int p , int q){
    TreeNode curr = root , lca = null;

    while(curr != null){
        if(curr.val > p && curr.val > q){
            curr = curr.left;

        }else if(curr.val < p && curr.val < q){
            curr = curr.right;

        }else{
            lca = curr;
        }
    }

    return (lca != null && find(lca , p ) && find(lca ,q))?lca :null ;

}

}
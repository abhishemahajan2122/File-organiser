public class dsuques {
    
 

    //leetcode 684 : https://leetcode.com/problems/redundant-connection/description/ 
    static int par[];

    public static int findpar(int i) {
        return par[i] == i ? i : (par[i] = findpar(par[i]));
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        for (int[] edge : edges) {
            int p1 = findpar(edge[0]);
            int p2 = findpar(edge[1]);

            if (p1 != p2) {
                par[p1] = p2;
            } else {
                return edge;
            }

        }
        return new int[0];
    }






    //leetcode 1061 : https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

    public int findpar(int u ){
        return par[u] == u? u: (par[u]= findpar(par[u]));
    }

    static int par[];
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int n = s1.length(), m = baseStr.length(); 
        par = new int[26];
        for(int i =0 ; i<26 ; i++){
            par[i] = i;
        }

        for(int i=0 ; i<n ;i++){
            char ch1 = s1.charAt(i), ch2 = s2.charAt(i);

            int p1 = findpar(ch1-'a');
            int p2 = findpar(ch2-'a');

            par[p1] = Math.min(p1,p2);
            par[p2] = Math.min(p1,p2);

        }

        String ans ="";
        for(int i=0 ; i< m ; i++){
           char ch3 = baseStr.charAt(i);
            int p3 = findpar(ch3-'a');
            ans = ans + (char)(p3+'a');
        }
        return ans;


    }

 




    //leetcode 839 : https://leetcode.com/problems/similar-string-groups/description/
    static int par[];

    public static int findpar(int u) {
        return par[u] == u ? u : (par[u] = findpar(par[u]));
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        par = new int[n];
        for (int i = 0; i < n; i++) {
            par[i] = i;
        }
        int size = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (issimilar(strs[i], strs[j])) {

                    int p1 = findpar(i);
                    int p2 = findpar(j);
                    if (p1 != p2) {

                        par[p1] = p2;
                        size--;
                    }
                }
            }
        }
        return size;

    }

    public static boolean issimilar(String s1, String s2) {
        int n = s1.length(), distinct = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i) && ++distinct > 2)
                return false;
        }
        return true;
    }








//leetcode 695 : https://leetcode.com/problems/max-area-of-island/description/

static int par[], size[];

    public static int findpar(int u){
        return par[u]==u? u : (par[u]= findpar(par[u]));
    }


    public int maxAreaOfIsland(int[][] grid) {

    int dir[][] = {{0,1},{0,-1}, {1,0},{-1,0}};
    int n = grid .length, m = grid[0].length , maxarea = 0;
    par = new int[n*m];
    size = new int[n*m];
    for(int i = 0; i<n*m  ; i++){
        par[i] = i;
        size[i] =1;
    }


    for(int i =0 ; i<n ;i++){
        for(int j = 0 ; j< m ; j++){
           if(grid[i][j]== 1){


               for(int d = 0 ; d< dir.length ; d++){
                   int r = i + dir[d][0];
                   int c = j + dir[d][1];

                   if(r>=0 && r<n && c>=0 && c< m && grid[r][c]== 1){
                
                      int p1 = findpar(i*m+j);
                      int p2 = findpar(r*m +c);
                      if(p1!=p2){
                          par[p2]= p1;
                          size[p1] += size[p2];
                      }
                   }
               }
              maxarea = Math.max(maxarea, size[par[i*m+j]]);

           }
        }
    }
    return maxarea;
        
    }










// number of islands 2 : https://www.lintcode.com/problem/434/description?fromId=207&_from=collection

static int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
static int par[];

public static int findpar(int u) {
    return par[u] == u ? u : (par[u] = findpar(par[u]));
}

public List<Integer> numIslands2(int n, int m, Point[] operators) {
    ArrayList<Integer> ans = new ArrayList<>();
    int s = operators.length, count = 0;
    int grid[][] = new int[n][m];
    par = new int[n * m];
    for (int i = 0; i < par.length; i++) {
        par[i] = i;
    }

    for (int i = 0; i < s; i++) {

        Point p = operators[i];

        int x = p.x;
        int y = p.y;

        if (grid[x][y] != 1) {
            grid[x][y] = 1;
            count++;

            for (int d = 0; d < dir.length; d++) {
                int r = x + dir[d][0];
                int c = y + dir[d][1];

                if (r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == 1) {
                    int p1 = findpar(x * m + y);
                    int p2 = findpar(r * m + c);

                    if (p1 != p2) {
                        par[p2] = p1;
                        count--;
                    }
                }
            }

        }

        ans.add(count);

    }

    return ans;

}








//can be optimised for space by not making grid

static int dir[][] = {{0,1},{1,0}, {-1,0},{0,-1}};
static int par[];
public static int findpar(int u ){
    return par[u] == u ? u : (par[u] = findpar(par[u]));
}
public List<Integer> numIslands2(int n, int m, Point[] operators) {
    ArrayList<Integer> ans = new ArrayList<>();
    int s = operators.length, count =0;
    
    par = new int[n*m];
    for(int i =0 ; i< par.length ; i++){
        par[i] = -1;
    }

    for(int i = 0 ; i< s; i++){
        
       Point p = operators[i];
     
        int x = p.x;
        int y = p.y;
        

        if(par[x*m+y]== -1){
            par[x*m+y] = (x*m+y);
            count ++;


           for(int d =0 ; d< dir.length ; d++){
              int r = x + dir[d][0];
              int c = y + dir[d][1];

              if(r <n && r>=0 && c<m && c>=0 && par[r*m+c]!= -1){
                  int p1 = findpar(x*m+y);
                  int p2 = findpar(r*m+c);

                  if(p1!=p2){
                      par[p2] = p1;
                      count --;
                  }
              }             
        } 

    }

   ans.add(count);    
       
    }

    return ans;
  
}

}

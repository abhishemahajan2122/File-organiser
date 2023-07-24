import java.util.*;

public class level2dfsques {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    }











    // leetcode 200 : https://leetcode.com/problems/number-of-islands/description/
    public int numIslands(char[][] grid) {
        int dir[][] = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        int n = grid.length, m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        int islands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    islands++;
                    dfs(i, j, grid, dir, visited);

                }

            }
        }
        return islands;
    }

    public static void dfs(int sr, int sc, char grid[][], int dir[][], boolean visited[][]) {
        int n = grid.length, m = grid[0].length;

        visited[sr][sc] = true;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == '1' && !visited[r][c])
                dfs(r, c, grid, dir, visited);
        }
        return;
    }





    //leetcode 695 : https://leetcode.com/problems/max-area-of-island/description/
    public int maxAreaOfIsland(int[][] grid) {
        int dir[][] = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
        int n = grid.length, m = grid[0].length;
   
        int maxarea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ( grid[i][j] == 1) {                    
                int myarea =  dfs(i, j, grid, dir);
                maxarea = Math.max(myarea, maxarea);
              }

            }
        }
        return maxarea;
    }
    public static int dfs(int sr, int sc, int grid[][], int dir[][]) {
        int n = grid.length, m = grid[0].length;
        grid[sr][sc] =0;
        int area =0 ;
        for (int d = 0; d < dir.length; d++) {
            int r = sr + dir[d][0];
            int c = sc + dir[d][1];
            if (r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == 1 )
              area +=  dfs(r, c, grid, dir);
        }
        return area+1;
    }








   // leetcode463: https://leetcode.com/problems/island-perimeter/description/
   public int islandPerimeter(int[][] grid) {
    int n = grid.length,m = grid[0].length, once =0 , nbr =0;
    int dir[][] = { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
  for(int i =0 ; i <n ; i++){
      for(int j =0 ; j<m; j++){
          if(grid[i][j]==1){
          once ++;
              for(int d =0 ; d< dir.length; d++){
                  int r= i+dir[d][0];
                  int c = j+dir[d][1];
                 if (r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == 1 )
                 nbr++;
                 
              }
          }
      }
  }

  return 4*once - nbr;
}




//leetcode 130: https://leetcode.com/problems/surrounded-regions/description/

//special thing about question pehle boudary se dfs lagega as backtracking sabh cover karna is not possible
public void solve(char[][] grid) {
    int n = grid.length, m = grid[0].length;
    int dir [][] = {{1,0},{-1,0},{0,1},{0,-1}};
    for(int i = 0 ; i<n ; i++){
        for(int j = 0 ; j<m ; j++){
            if(i==0 || j==0 || i==n-1 || j==m-1){
                if(grid [i][j]=='O'){
                    dfs(grid ,  i ,  j , dir);
                }
            }
        }
    }

    for(int i = 0 ; i<n ; i++){
        for(int j =0; j<m ; j++){
          if(grid [i][j]=='$'){
              grid [i][j] = 'O';

          }else if(grid[i][j] == 'O'){
               grid[i][j] = 'X';
          }

        }
    }
}
public static void dfs(char grid[][], int sr , int sc ,int dir[][]){
    int n = grid.length, m = grid[0].length;
    grid [sr][sc] = '$';
    for(int d =0 ; d< dir.length ; d++){
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];
        if (r < n && r >= 0 && c < m && c >= 0 && grid[r][c] == 'O' )
        dfs(grid , r, c ,dir);
    }
    return;
}









//https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1

int countDistinctIslands(int[][] grid) {
    int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    HashSet<String> hs = new HashSet<>();
    int n = grid.length, m = grid[0].length;
    for(int i = 0 ; i<n ; i++){
        for(int j =0 ; j<m ; j++){
            if(grid[i][j]==1){
                String ans = dfs(grid ,i,j ,dir);
                //System.out.println(ans);
                hs.add(ans);
               
            }
        }
    }
    return hs.size();
}

 static String dfs(int[][]grid, int sr, int sc ,int dir[][]){
    int n = grid.length, m = grid[0].length;
    
    String check ="";
    grid[sr][sc] = 0;
    for(int d = 0 ; d< dir.length ; d++){
        int r = sr + dir[d][0];
        int c = sc + dir[d][1];
        
        if(r < n && r >=0 && c <m && c>=0 && grid[r][c]==1){
            if(d==0){
            check = check+"u";
            }else if(d==1){
            check = check+"r";   
          }else if(d==2){
            check = check+"d";   
          }else {
            check = check+"l";   
          }
           check = check + dfs(grid, r, c , dir);
           
        }
    }
    
    return check+"b";

}




//jouney to the moon   : ismai long wagera ka dhyan rakhne imp hai
public static int dfs(ArrayList<Integer> graph[], int src , boolean visited[]){
    int size = 1;
    visited[src] = true;
    for(int e : graph[src]){
        if(visited [e] == false){
           size += dfs(graph,e, visited);
        }
    }
    return size;
}




public static long journeyToMoon(int n, List<List<Integer>> edges) {

ArrayList<Integer> graph[] = new ArrayList[n];
for(int i =0 ; i <n ; i++){
    graph[i] = new ArrayList<>();
}
for(int i = 0 ; i < edges.size() ; i++){
    graph[edges.get(i).get(0)].add(edges.get(i).get(1));
    graph[edges.get(i).get(1)].add(edges.get(i).get(0));
    
}
long sum = 0, ans =0 ;
boolean visited[] = new boolean[n];
for(int i =0 ; i<n ; i++){
    if(!visited [i]){
    int size2 = dfs(graph,i, visited);
    ans += size2 * sum;
    sum += size2;
    }
}
return ans;
}













//leetcode 1905 : https://leetcode.com/problems/count-sub-islands/description/

static int dir[][] ={{0,1},{1,0},{0,-1},{-1,0}};
public int countSubIslands(int[][] grid1, int[][] grid2) {
    int n = grid2.length, m = grid2[0].length, count =0;
   for(int i =0 ; i< n ; i++){
       for(int j =0 ; j< m ; j++){
           if(grid2[i][j]==1){
               boolean check = helper(grid1, grid2, i, j);
               if(check == true){
                   count++;
               }

           }
       }
   }
   return count;
}


public static boolean helper(int [][]grid1, int [][]grid2 , int i , int j ){
   int n = grid2.length, m = grid2[0].length;
  grid2[i][j] = 0;

  boolean res = true;
  for(int d=0 ; d< dir.length ; d++){
      int r = i + dir[d][0];
      int c = j + dir[d][1];
      if(r>=0 && r<n && c<m && c>=0 && grid2[r][c]==1){
        
        res = helper(grid1, grid2, r, c) && res ;
      }
  }

  if(grid1[i][j]!=1){
      return false;
  }
   
   return res ;


}
}

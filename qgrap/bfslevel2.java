import java.util.*;

public class bfslevel2 {
    

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

    }




    //leetcode 785 : https://leetcode.com/problems/is-graph-bipartite/description/
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int visited[] = new int[n];
        boolean bipar = true;
        Arrays.fill(visited, -1);
        for (int i = 0; i < n; i++) {
            if (visited[i] == -1)
                bipar = bipartite(graph, i, visited);
            if (bipar == false) {
                return false;
            }
        }
        return true;
    }

    public static boolean bipartite(int graph[][], int src, int visited[]) {
        LinkedList<Integer> que = new LinkedList<>();

        que.add(src);
        // no color : -1 red : 0 green : 1
        int color = 0;
        // boolean iscyclic = false, isbipartite = true;

        while (que.size() != 0) {

            int size = que.size();

            while (size-- > 0) {
                int vtx = que.removeFirst();
                if (visited[vtx] != -1) {
                    // iscyclic = true;
                    if (visited[vtx] != color) {
                        return false;
                        // continue;

                    }
                }
                visited[vtx] = color;
                for (int v : graph[vtx]) {
                    if (visited[v] == -1) { // conflict
                        que.addLast(v);
                    }
                }
            }

            color = (color + 1) % 2;
        }
        return true;

    }




    //leetcode 994 : https://leetcode.com/problems/rotting-oranges/description/
    public static int orangesRotting(int[][] grid) {
        int oranges = 0;
        int n = grid.length, m = grid[0].length;
        int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        LinkedList<Integer> que = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2)
                    que.add(i * m + j);
                if (grid[i][j] == 1)
                    oranges++;
            }
        }

        if (oranges == 0) // aggr sahi oranges hai hi nhi toh pehle hi return kardo 0 imp case
            return 0;
        int time = 0;
        while (que.size() != 0) {
            int size = que.size();

            while (size-- > 0) {
                int idx = que.removeFirst();

                int r = idx / m, c = idx % m;

                for (int d = 0; d < dir.length; d++) {
                    int x = r + dir[d][0];
                    int y = c + dir[d][1];
                    if (x < n && x >= 0 && y < m && y >= 0 && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        oranges--;
                        que.addLast(x * m + y);
                        if (oranges == 0)
                            return time + 1;  // time +1 return hoga kyu ki time 0 se shuru ho raha hai dry run karke aur samaj aaayega

                    }
                }

            }
            time++;

        }
        return -1;
    }




    //leetcode 542 : https://leetcode.com/problems/01-matrix/description/

    // main part in this question is that start by filling 0s in que
    public int[][] updateMatrix(int[][] grid) {
        // if (grid.length == 0 || grid[0].length == 0)
        // return grid;
        int n = grid.length, m = grid[0].length;

        boolean visited[][] = new boolean[n][m];
        LinkedList<Integer> que = new LinkedList<>();

        int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    que.addLast(i * m + j);
                    visited[i][j] = true;
                }
            }
        }

        while (que.size() != 0) {
            int size = que.size();
            while (size-- > 0) {

                int idx = que.removeFirst();
                int sr = idx / m, sc = idx % m;

                for (int d = 0; d < dir.length; d++) {
                    int r = sr + dir[d][0];
                    int c = sc + dir[d][1];
                    if (r < n && r >= 0 && c < m && c >= 0 && !visited[r][c]) {

                        grid[r][c] = grid[sr][sc] + 1;
                        visited[r][c] = true;
                        que.addLast(r * m + c);

                    }
                }
            }
        }

        return grid;
    }

}

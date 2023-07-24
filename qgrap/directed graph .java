import java.util.*;
import java.util.concurrent.CyclicBarrier;
public class directed graph  {
    public static class Edge{
        int v , w;
    
      Edge(int v , int w){
        this.v = v;
        this.w = w;
      }
    }


    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int vers = scn.nextInt();
        int Edges = scn.nextInt();
    
        constructgraph(vers,Edges);
      
    
    
    }
    
    public static void addEdge(ArrayList<Edge> graph[],int u, int v, int w){
      graph[u].add(new Edge(v,w));
      graph[v].add(new Edge(u,w));
    }
    
    public static void constructgraph(int vers , int edges){
    
        ArrayList<Edge> graph[]= new ArrayList[vers];
    
        for(int i =0 ; i<vers ; i++ ){
            graph[i] = new ArrayList<>();
        }
        addEdge(graph, 0, 1, 10);
        addEdge(graph, 0, 3, 10);
        addEdge(graph, 1, 2, 10);
        addEdge(graph, 2, 3, 40);
    
        addEdge(graph, 2, 7, 2);
        addEdge(graph, 2, 8, 4);
        addEdge(graph, 7, 8, 3);
    
       addEdge(graph, 3, 4, 2);
        addEdge(graph, 4, 5, 2);
        addEdge(graph, 4, 6, 8);
       addEdge(graph, 5, 6, 3);
    
       // addEdge(graph, 0, 6, 3);
    
        //removeEdge(graph, 3, 4);
        //removeVer(graph,2);
        display(graph);
    


        
    }






  //topological sort 

  //using dfs but this type fails in cases of cycle as it gives answer even when cycle is there

  public static void topodfs(ArrayList<Edge>graph[], int src ,ArrayList<Integer>ans, visited boolean){
    visited[src] = true;
    for(Edge e : graph[src]){
      if(!visited[e.v])
      topodfs(graph, e.v , ans ,boolean);
    }
    ans.add(src);
  }

  public static topoorderdfs(ArrayList<Edge>graph){
    int n = graph.length;
    boolean visited[] = new boolean [n];
    ArrayList<Integer> ans= new ArrayList<>();
    for(int i =0 ; i < n ; i++){
      if(!visited)
      topodfs(graph , i , ans, visited);
    }
    System.out.println(ans);
  }






  //topological sort - using kahns algo it works perfectly doesn't give answers when cycle is there which is perfect

  public static ArrayList<Integer> kahnsalgo (ArrayList<Edge> graph[], int src ){
    int n = graph.length;
    int indegree[] = new indegree[n];
    for(ArrayList<Edge> edgelist : graph){
        for(Edge e : edgelist){
            indegree[e.v]++;
        }
    }
    LinkedList<Integer> que = new LinkedList<>();
    ArrayList<Integer> ans = new ArrayList<>();

    for(int i= 0 ; i< n ; i++){
       if(indegree[i]==0){
        que.addLast(i);
       }
    }
    int level =0 ; 
    while(que.size() != 0){
        int size = que.size();
        while(size-- > 0){
            int vtx = que.removeFirst();
            
            ans.add(vtx);
            for(Edge e : graph[vtx]){
                if(--indegree[e.v]==0)  // sirf yaha pharak aaya hai normal bfs se but ismai hum marking wagera nhi kar rahe as need nhi hai
                que.addLast(e.v);
               
                }
            }
            level ++;
            
        }

        if(ans.size()!= n){
            System.out.println(topo order not possible due to Cyclic);
            ans.clear();
        }
        return ans ;
    }




    // parallel courses arraylist  mai nikalne ke liye
    public static ArrayList<ArrayList> kahnsalgo (ArrayList<Edge> graph[], int src ){
        int n = graph.length;
        int indegree[] = new indegree[n];
        for(ArrayList<Edge> edgelist : graph){
            for(Edge e : edgelist){
                indegree[e.v]++;
            }
        }
        LinkedList<Integer> que = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
    
        for(int i= 0 ; i< n ; i++){
           if(indegree[i]==0){
            que.addLast(i);
           }
        }
        int level =0 ; 
        while(que.size() != 0){
            int size = que.size();
            ArrayList<ArrayList> arr = new ArrayList<>();
            while(size-- > 0){

                int vtx = que.removeFirst();
                
                arr.add(vtx);
                for(Edge e : graph[vtx]){
                    if(--indegree[e.v]==0)
                    que.addLast(e.v);
                   
                    }
                }
                level ++;
                ans.add(arr);
                
            }
    
            if(ans.size()!= n){
                System.out.println(topo order not possible due to Cyclic);
                ans.clear();
            }
            return ans ;
        }
    

        //leetcode 207
        public boolean canFinish(int n, int[][] prereq) {

            ArrayList<Integer> graph[] = new ArrayList[n];
            int indegrees[] = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();

            }
            for (int i = 0; i < prereq.length; i++) {
                graph[prereq[i][0]].add(prereq[i][1]);
                indegrees[prereq[i][1]]++;
            }

            LinkedList<Integer> que = new LinkedList<>();

            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    que.addLast(i);
                }
            }

            int level = 0, ver = 0;
            while (que.size() != 0) {
                int size = que.size();
                while (size-- > 0) {
                    int vtx = que.removeFirst();

                    ver++;
                    for (int e : graph[vtx]) {
                        if (--indegrees[e] == 0)
                            que.addLast(e);

                    }
                }
                level++;

            }

            if (ver != n) {
                return false;
            }
            return true;


        }





        //leetcode 210
        public int[] findOrder(int n, int[][] prereq) {

            ArrayList<Integer> graph[] = new ArrayList[n];
            int indegrees[] = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();

            }
            for (int i = 0; i < prereq.length; i++) {
                graph[prereq[i][1]].add(prereq[i][0]);
                indegrees[prereq[i][0]]++;
            }

            LinkedList<Integer> que = new LinkedList<>();
            int ans[] = new int[n];

            for (int i = 0; i < indegrees.length; i++) {
                if (indegrees[i] == 0) {
                    que.addLast(i);
                }
            }

            int level = 0, ver = 0;
            while (que.size() != 0) {
                int size = que.size();
                while (size-- > 0) {
                    int vtx = que.removeFirst();
                    ans[ver] = vtx;
                    ver++;
                    for (int e : graph[vtx]) {
                        if (--indegrees[e] == 0)
                            que.addLast(e);

                    }
                }
                level++;

            }

            if (ver != n) {

                return new int[0];
            }
            return ans;

        }










         //kahn's algo can be used this way to find longest once graph is made
        //leetcode 329 : https://leetcode.com/problems/longest-increasing-path-in-a-matrix/description/
        public int longestIncreasingPath(int[][] matrix) {
            int n = matrix.length ,m = matrix[0].length;
            int dir[][] = {{0,1},{1,0},{-1,0},{0,-1}};
            int indegree[][] =new int[n][m];
            for(int i =0 ; i< n ;i++){
                for(int j =0 ; j <m ; j++){
                    
                    for(int d =0 ; d< dir.length; d++){
                        int r = i + dir[d][0];
                        int c = j + dir[d][1];
                        if(r>=0 && r<n && c>=0 && c<m && matrix[i][j]>matrix[r][c])
                        indegree[i][j]++;
                    }
                }
            }
    
    
            LinkedList<Integer> que = new LinkedList<>();
            for(int i =0 ; i <n ;i++){
                for(int j=0 ; j<m ;j++){
                    if(indegree[i][j]==0)
                    que.addLast(i*m+j);
                }
            }
    
            int level =0;
            while(que.size()!=0){
            int size = que.size();
            while(size-->0){
                int vtx = que.removeFirst();
                int x = vtx/m , y = vtx%m;
                for(int d =0 ; d< dir.length; d++){
                   int r = x+ dir[d][0];
                   int c = y + dir[d][1];    
                   if(r>=0 && r<n && c>=0 && c<m && matrix[r][c]>matrix[x][y]){
                    if(--indegree[r][c]==0){
                        que.addLast(r*m+c);
                    }
                   }
            }
            }
            level++;
            }
            return level;
        }











        // topo dfs working with cycle for directed graph
        //leetcode 210 : https://leetcode.com/problems/course-schedule-ii/submissions/985646770/
        //visited[i]=1 signifies visited in currect set , visited[i] = 2 means visited earlier too but not in this set
        public int[] findOrder(int n, int[][] prereq) {

            ArrayList<Integer> graph[] = new ArrayList[n];
            int visited[] = new int[n]; // visited int ki hai main change
            ArrayList<Integer> ans = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();

            }
            for (int i = 0; i < prereq.length; i++) {
                graph[prereq[i][0]].add(prereq[i][1]);

            }
            boolean cyclic = false;
            int result[] = new int[n];
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0) {
                    cyclic = cyclic || topodfs(graph, i, ans, visited);
                }
            }
            if (cyclic == true) {
                return new int[0];
            } else {

                for (int i = 0; i < ans.size(); i++) {
                    result[i] = ans.get(i);
                }
            }
            return result;
        }

        public static boolean topodfs(ArrayList<Integer> graph[], int src, ArrayList<Integer> ans, int[] visited) {
            visited[src] = 1;
            boolean iscycle = false;
            for (int e : graph[src]) {
                if (visited[e] == 0) {
                    iscycle = iscycle || topodfs(graph, e, ans, visited);
                } else if (visited[e] == 1)
                    return true;
            }
            ans.add(src);

            visited[src] = 2;
            return iscycle;
        }
  }



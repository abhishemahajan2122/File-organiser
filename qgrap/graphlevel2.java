import java.util.*;

public class graphlevel2 {
    

public static class Edge{
    int v , w;

  Edge(int v , int w){
    this.v = v;
    this.w = w;
  }
}

public static class pair{
  int wgt;
  String psf;

  pair(int wgt, String psf){
    this.wgt = wgt;
    this.psf = psf;
  }
}

public static class pairl{
  int len;
  String psf;

  pairl(int len, String psf){
    this.len = len;
    this.psf = psf;
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

    //boolean [] visited = new boolean[vers];
    int visited[] = new int[vers];
    // System.out.println(haspath(graph, 0 , 6, visited));
    //allpath(graph, 0, 6, visited, "");
   // preorder(graph, 0, "", 0,visited);
   //postorder(graph, 0, "", 0,visited);
  //  pair ans =  heavypath(graph, 0, 6, visited);
  //  System.out.println(ans.wgt +" " +ans.psf);

  // pairl ans =  longpath(graph, 0, 6, visited);
  // System.out.println(ans.len +" " +ans.psf);
  // ArrayList<String> ans = new ArrayList<>();
  // hamilton(graph, 0, 0, visited, 0, "", ans);
  // System.out.println(ans);
  //System.out.println(gcc(graph));

  //bfswithcycle(graph, 0, visited);
  // bfs(graph, 0, visited);
  Arrays.fill(visited, -1);
  bipartite(graph, 0, visited);



}






//remove edge ver
//O(2E)
public static void display(ArrayList<Edge> graph[]){ 
    for(int i =0 ; i<graph.length ; i++){
      System.out.print(i+" "+"->");
        for(Edge e : graph[i])
        System.out.print(" "+"{"+e.v+","+ e.w+"}"+" ");
        System.out.println("");
    }
}

public static int findEdge(ArrayList<Edge>graph[], int u , int v){
  for(int i =0 ; i < graph[u].size(); i++){
     Edge e = graph[u].get(i);
     if(e.v == v )
     return i;
  }
  return -1;
}

public static void removeEdge(ArrayList<Edge>graph[], int u, int v){

  int idx1 = findEdge(graph, u, v);
  graph[u].remove(idx1);

  int idx2 = findEdge(graph, v, u);
  graph[v].remove(idx2);
}

//O(E*E)
public static void removeVer(ArrayList<Edge>graph[], int u){
  for(int i = graph[u].size() -1 ; i>=0; i-- ){
    Edge e = graph[u].get(i);
    removeEdge(graph,u,e.v );
  }
}



//has path
public static boolean haspath(ArrayList<Edge>graph[],int src , int des, boolean visited[] ){
  if(src == des){
    return true;
  }
  boolean res = false;
  visited[src]= true;
  for(Edge e : graph[src]){
    if(visited[e.v] != true){
     res = res || haspath(graph, e.v, des, visited);
    }
  }
  return res;
}


//all path
public static int allpath(ArrayList<Edge>graph[],int src , int des, boolean visited[],String psf){
  if(src  == des){
    System.out.println(psf+src);
    return 1;

  }
  
  visited[src]=true;
  int count =0;
  for(Edge e : graph[src]){
    if(visited[e.v]!= true)
     count += allpath(graph, e.v, des, visited, psf+src);
  }
  visited[src] = false;
  return count;
}







//preorder
public static void preorder(ArrayList<Edge>graph[],int src , String psf , int wgt , boolean visited[]){
  System.out.println(src+ " -> "+ psf+src +" @ "+wgt);

  visited[src] = true;
  for(Edge e : graph[src]){
    if(visited[e.v]!=true)
    preorder(graph, e.v, psf +src, wgt+e.w, visited);
  }

  visited[src]= false;
}








//postorder
public static void postorder(ArrayList<Edge>graph[],int src , String psf , int wgt , boolean visited[]){
  
  visited[src] = true;
  for(Edge e : graph[src]){
    if(visited[e.v]!=true)
    postorder(graph, e.v, psf +src, wgt+e.w, visited);
  }
  
  System.out.println(src+ " -> "+ psf+src +" @ "+wgt);
  visited[src]= false;
}





//heavy path
public static pair heavypath(ArrayList<Edge>graph[],int src, int des,boolean []visited ){
  if(src == des){
    return new pair(0, src+"");

  }
  visited[src] =true;
  pair myans = new pair(-1 , "");
  for(Edge e : graph[src]){
    if(visited [e.v]!= true){
      pair can = heavypath(graph, e.v, des , visited);
      if(can.wgt != -1 && can.wgt + e.w > myans.wgt){
        myans.wgt = can.wgt+e.w;
        myans.psf = src + can.psf;
      }

    }
  }
  visited[src] = false;
  return myans;
}







//long path
public static pairl longpath(ArrayList<Edge>graph[],int src, int des,boolean []visited ){
  if(src == des){
    return new pairl(1, src+"");

  }
  visited[src] =true;
  pairl myans = new pairl(-1 , "");
  for(Edge e : graph[src]){
    if(visited [e.v]!= true){
      pairl can = longpath(graph, e.v, des , visited);
      if(can.len != -1 && can.len + 1 > myans.len){
        myans.len = can.len+1;
        myans.psf = src + can.psf;
      }

    }
  }
  visited[src] = false;
  return myans;
}







//hamiltonpathcycle
//base condition for hamilton path is that Edges = vers -1
public static void hamilton(ArrayList<Edge>graph[],int src, int orgsrc, boolean[]visited, int edgecount, String psf, ArrayList<String> ans ){
  if(edgecount== graph.length-1){
    psf = psf +src;
    int idx = findEdge(graph, src, orgsrc);
    if(idx != -1)
    psf = psf+"*";
    ans.add(psf);
   return;

  }

  visited[src] = true;
  for(Edge e : graph[src]){
    if(!visited[e.v])
    hamilton(graph, e.v, orgsrc, visited,edgecount+1, psf+src, ans);
  }
  visited[src] = false;
}






//gcc
public static void dfs(ArrayList<Edge>graph[], int src, boolean []visited){
  visited[src] = true;
  for(Edge e : graph[src])
  if(!visited[e.v])
  dfs(graph, e.v, visited);

}
public static int gcc(ArrayList<Edge> graph[]){
  boolean []visited = new boolean[graph.length];
  int comps =0;
  for(int i = 0 ; i<graph.length; i++){
    if(!visited[i]){
      dfs(graph,i, visited);
      comps++;

    }
  }
  return comps;
}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


//BFS

//BFS always finds minimum path

//BFS for detecting cycles // can't find in directed graph

public static void bfswithcycle(ArrayList<Edge> graph[], int src, boolean visited[]) {
  LinkedList<Integer> que = new LinkedList<>();

  que.add(src);
  int level = 0;
  while (que.size() != 0) {
    int size = que.size();
    System.out.print("level" + level + "-->");

    while (size-- > 0) {
      int vtx = que.removeFirst();

      if (visited[vtx] == true) {
        System.out.println("cycle");
        continue;
      }
      visited[vtx] = true;

      System.out.print(vtx + ",");

      for (Edge e : graph[vtx]) {
        if (!visited[e.v]) {
          que.add(e.v);
        }
      }
    }
    level++;
    System.out.println();
  }

}






//BFS for other purpose (optimised one )

public static void bfs(ArrayList<Edge>graph[], int src , boolean visited[]){
  LinkedList<Integer> que = new LinkedList<>();

  que.add(src);
   visited[src] = true;       // here also different
   int level =0;
  while (que.size() != 0) {
    int size = que.size();
    System.out.print("level" + level + "-->");

    while (size-- > 0) {
      int vtx = que.removeFirst();

      System.out.print(vtx + ",");

      for (Edge e : graph[vtx]) {
        if (!visited[e.v]) {

          visited[e.v]= true;   //here different from previous one as we while adding marking true but in cycle one we add first only .
          que.add(e.v);
        }
      }
    }
    level++;
    System.out.println();
  }
  
}








//is bipartite
public static void bipartite(ArrayList<Edge> graph[], int src, int visited[]) {
  LinkedList<Integer> que = new LinkedList<>();

  que.add(src);
  //no color : -1   red : 0    green : 1
  int color = 0;
  boolean iscyclic = false, isbipartite = true;

  while (que.size() != 0) {

    int size = que.size();

    while (size-- > 0) {     
      int vtx = que.removeFirst();
      if (visited[vtx] != -1) {
        iscyclic = true;
        if (visited[vtx] != color) {
          isbipartite = false;
          continue;

        }
      }
      visited[vtx] = color;
      for (Edge e : graph[vtx]) {
        if (visited[e.v] == -1) {   // conflict
          que.addLast(e.v);
        }
      }
    }

    color = (color + 1) % 2;
  }
  if (!iscyclic)
    System.out.println("Bipartite graph with no cycle");
  else {
    if (isbipartite) {
      System.out.println("Bipartite graph with even length cycle");
    } else {
      System.out.println("non-Bipartite graph with odd length cycle");
    }
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
}

}
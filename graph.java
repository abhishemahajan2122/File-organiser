import java.util.*;

public class graph {

  public static class Edge {
    int src, nbr, wgt;

    Edge(int src, int nbr, int wgt) {
      this.src = src;
      this.nbr = nbr;
      this.wgt = wgt;
    }
  }

  public static class bfspair {
    int vtx;
    String psf;

    bfspair(int vtx, String psf) {
      this.vtx = vtx;
      this.psf = psf;
    }

  }

  public static class pairbip {
    int vtx;
    int lev;

    pairbip(int vtx, int lev) {
      this.vtx = vtx;
      this.lev = lev;
    }
  }


  public static class pairsoi{
    int val ; 
    int time; 

    pairsoi(int val, int time){
      this.val = val;
      this.time = time;
    }
  }


  public static class itdfs{
    int vtx; 
    String psf;
    
    itdfs(int vtx, String psf){
      this.vtx = vtx;
      this.psf = psf;
    }
  }

  public static class dijpair implements Comparable<dijpair>{
    int vtx; 
    String psf;
    int wgtsf;
    dijpair(int vtx , String psf, int wgtsf){
      this.vtx = vtx;
      this.psf = psf;
      this.wgtsf = wgtsf;
    }
   public int compareTo(dijpair o){
    return this.wgtsf - o.wgtsf;
   }
  }




  public static class primpair implements Comparable<primpair>{
    int src;
    int par;
    int edgewt;

    primpair(int src, int par , int edgewt){
      this.src= src;
      this.par = par;
      this.edgewt = edgewt;
    }
    public int compareTo(primpair o){
      return this.edgewt - o.edgewt;
    }
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int vers = scn.nextInt();
    int edges = scn.nextInt();
    ArrayList<Edge> graph[] = new ArrayList[vers];

    for (int i = 0; i < vers; i++) {
      graph[i] = new ArrayList<>();
    }
    for (int i = 0; i < edges; i++) {
      int src = scn.nextInt();
      int ver = scn.nextInt();
      int wgt = scn.nextInt();

      graph[src].add(new Edge(src, ver, wgt));
      graph[ver].add(new Edge(ver, src, wgt));

    }

    // display(graph);

    // int src = scn.nextInt();
    // int des = scn.nextInt();
    // boolean []visited = new boolean[vers];
    // System.out.println(haspath(graph , src, des, visited));

    // int src = scn.nextInt();
    // int dest = scn.nextInt();
    // boolean [] visited = new boolean[vers];
    // String str = "";
    // printpath(graph, src, dest, visited, str);

    // System.out.println(gcc(graph));

    // int ans = perfectfriends(graph);
    // System.out.println(ans);

    // int src = scn.nextInt();
    // bfs(graph, src);

    // System.out.println(iscyclic(graph));

    // System.out.println(isbip(graph));


    // int vtx =scn.nextInt();
    // int timelimit =scn.nextInt();
    // System.out.println(spreadofinfection(graph, vtx, timelimit , 0));

    
    // orderofcompilation(graph);
    
    // int vtx = scn.nextInt();
    // iterativedfs(graph, vtx);


    // int vtx = scn.nextInt();
    // dijkshtra(graph, vtx);


    // prims(graph);



    int ver = scn.nextInt();
    hamiltonpathcycle(graph,ver); 
  }

  public static void display(ArrayList<Edge> graph[]) {
    for (int i = 0; i < graph.length; i++) {
      System.out.print(i + " " + "-->" + " ");
      for (Edge e : graph[i]) {

        System.out.print(e.src + " " + e.nbr + " " + e.wgt + ",");
      }
      System.out.println("");
    }
  }

  public static boolean haspath(ArrayList<Edge> graph[], int ver, int des, boolean[] visited) {
    if (ver == des) {
      return true;
    }
    visited[ver] = true;
    for (Edge e : graph[ver]) {

      if (visited[e.nbr] == false) {
        boolean kalrav = haspath(graph, e.nbr, des, visited);
        if (kalrav == true) {
          return true;
        }
      }
    }
    return false;

  }




  public static void printpath(ArrayList<Edge> graph[], int ver, int des, boolean[] visited, String str) {
    if (ver == des) {
      System.out.println(str + ver);
      return;
    }
    visited[ver] = true;
    for (Edge e : graph[ver]) {
      if (visited[e.nbr] == false) {
        printpath(graph, e.nbr, des, visited, str + ver);

      }
    }
    visited[ver] = false;
  }




  public static ArrayList gcc(ArrayList<Edge> graph[]) {
    boolean[] visited = new boolean[graph.length];
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == false) {

        ArrayList<Integer> arr = new ArrayList<>();
        gcchelper(graph, i, visited, arr);
        ans.add(arr);
      }
    }
    return ans;
  }

  public static void gcchelper(ArrayList<Edge> graph[], int ver, boolean[] visited, ArrayList arr) {

    visited[ver] = true;
    arr.add(ver);

    for (Edge e : graph[ver]) {
      if (visited[e.nbr] == false) {
        gcchelper(graph, e.nbr, visited, arr);
      }
    }

  }







  public static int perfectfriends(ArrayList<Edge> graph[]) {

    ArrayList<ArrayList<Edge>> ans = gcc(graph);
    int res = 0;
    for (int i = 0; i < ans.size(); i++) {
      for (int j = i + 1; j < ans.size(); j++) {
        res = res + ans.get(i).size() * ans.get(j).size();
      }
    }
    return res;
  }

  public static void bfs(ArrayList<Edge> graph[], int src) {
    Queue<bfspair> ok = new ArrayDeque<>();
    boolean[] visited = new boolean[graph.length];
    ok.add(new bfspair(src, src + ""));
    while (ok.size() > 0) {
      bfspair sel = ok.remove();
      if (visited[sel.vtx] == false) {
        System.out.println(sel.vtx + "@" + sel.psf);
        visited[sel.vtx] = true;

        for (Edge e : graph[sel.vtx]) {
          if (visited[e.nbr] == false) {
            ok.add(new bfspair(e.nbr, sel.psf + e.nbr + ""));
          }
        }
      }
    }

  }







  public static boolean iscyclic(ArrayList<Edge> graph[]) {
    boolean[] visited = new boolean[graph.length];

    for (int i = 0; i < graph.length; i++) {
      if (visited[i] == false) {// for connected graph and disconnected graph
        if (iscyclichelper(graph, i, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean iscyclichelper(ArrayList<Edge> graph[], int src, boolean[] visited) {
    Queue<Integer> ok = new ArrayDeque<>();
    ok.add(src);

    while (ok.size() > 0) {
      Integer sel = ok.remove();
      if (visited[sel] == true) {
        return true;

      } else {

        visited[sel] = true;
        for (Edge e : graph[sel]) {
          if (visited[e.nbr] == false) {
            ok.add(e.nbr);
          }
        }

      }
    }
    return false;

  }






  public static  boolean isbip(ArrayList<Edge> graph []){
    int[] visited = new int[graph.length];
    for(int i= 0 ; i< graph.length ; i++){
        if(visited[i]==0){
            if(isbipartite(graph,i , visited)== false){
                return false;
            }
        }
    }
    return true;
}
  public static boolean isbipartite(ArrayList<Edge> graph[], int src ,int []visited) {
    Queue<pairbip> ok = new ArrayDeque<>();
    //int[] visited = new int[graph.length];
    ok.add(new pairbip(src, 1));
    while (ok.size() > 0) {
      pairbip sel = ok.remove();

      if (visited[sel.vtx] == 0) {
        visited[sel.vtx] = sel.lev;

        for (Edge e : graph[sel.vtx]) {
          if (visited[e.nbr] == 0) {
            ok.add(new pairbip(e.nbr, sel.lev + 1));

          }

        }
      } else {
        if (visited[sel.vtx] % 2 != sel.lev % 2) {
          return false;
        }
      }

    }
    return true;

  }








public static int spreadofinfection (ArrayList<Edge> graph[], int src , int timelimit, int count){
  
  int mark[] = new int[graph.length];
   
  Queue<pairsoi> ok = new ArrayDeque<>();

  ok.add(new pairsoi(src, 1));

 while(ok.size()>0){
  pairsoi sel = ok.remove();
  
  if(mark[sel.val]==0){
    mark[sel.val] = sel.time; 
    if(sel.time > timelimit){
      break;

    }
    count ++;

    for(Edge e : graph[sel.val]){
      if(mark[e.nbr]==0){
        ok.add(new pairsoi(e.nbr, sel.time+1));
      }
    }

  }
  
}  
for(int i = 0 ; i< graph.length ; i++){
  System.out.println(mark[i]);
}
return count;

}








  
public static void orderofcompilation(ArrayList<Edge> graph []){
  Stack <Integer> stack = new Stack<>();
  boolean visited [] = new boolean[graph.length];
  for(int i = 0 ; i< graph.length ; i++){
    if(visited[i]==false)
    orderofcompilationhelper(graph , stack , i , visited);
  }
 
   while(stack.size()>0){
     System.out.println(stack.pop());
  
   }

}

public static void orderofcompilationhelper(ArrayList<Edge> graph [], Stack stack, int src, boolean visited []){
  visited[src]= true;
  for(Edge e : graph[src]){
    if(visited[e.nbr]==false){
      orderofcompilationhelper(graph, stack, e.nbr, visited);
    }
  }
 
  stack.push(src);
  return;
}





public static void iterativedfs(ArrayList<Edge> graph[], int src) {
  boolean visited[] = new boolean[graph.length];

  // if(visited[i]==false)
  iterativedfshelper(graph, src, visited);

  return;
}

public static void iterativedfshelper(ArrayList<Edge> graph[], int src, boolean visited[]) {
  Stack<itdfs> stack = new Stack<>();
  stack.push(new itdfs(src, src + ""));
  while (stack.size() > 0) {
    itdfs rem = stack.pop();
    if(visited[rem.vtx]==false){
      System.out.println(rem.vtx + "@" + rem.psf);
      visited[rem.vtx] = true;

    for (Edge e : graph[rem.vtx]) {
      if (visited[e.nbr] == false) {
        stack.push(new itdfs(e.nbr, rem.psf + e.nbr + ""));
      }
    }
  }
}
  return;

}





public static void dijkshtra(ArrayList<Edge> []graph, int src){
 boolean [] visited = new boolean [graph.length];
 dijkshtrahelper(graph, visited, src);

return;
}

public static void dijkshtrahelper(ArrayList<Edge>graph[],boolean[]visited, int src){
  PriorityQueue<dijpair>ok = new PriorityQueue<>();

  ok.add(new dijpair(src,src+"",0));

  while(ok.size()>0){
    dijpair sel = ok.remove();
    if(visited[sel.vtx]==false){
      visited[sel.vtx]=true;
      
      System.out.println(sel.vtx + " "+ "via"+ " "+sel.psf +" "+"@" +" "+sel.wgtsf);
    
      for(Edge e: graph[sel.vtx]){
        if(visited[e.nbr]==false){
          ok.add(new dijpair(e.nbr, sel.psf+e.nbr+"" , sel.wgtsf+e.wgt));
        } 
      } 

    }
  }
  return;
}







public static void prims(ArrayList<Edge> graph[]) {
  boolean visited [] = new boolean[graph.length];

  primshelper(graph, 0 , visited);

  return;

}

public static void primshelper (ArrayList<Edge>graph [], int vtx , boolean visited[]){
  PriorityQueue <primpair> ok = new PriorityQueue<>();
  ok.add(new primpair(vtx,-1, 0));
  while(ok.size()>0){
   primpair sel =  ok.remove();
     
   if(visited[sel.src]==false){
    visited[sel.src]= true;
     
    if(sel.par != -1){
      System.out.println(sel.src +"-"+ sel.par+"@" + sel.edgewt);
    }


    for(Edge e : graph[sel.src]){

      if(visited[e.nbr]==false){
        ok.add(new primpair(e.nbr,e.src, e.wgt));

      }
    }
  }
   
  }
  return;
}








 static int orgsrc = 0;
public static void hamiltonpathcycle(ArrayList<Edge> graph [], int src){
 boolean visited[] = new boolean[graph.length];
 hamiltonpathcyclehelper(graph , src,0 , "0",visited);
}
public static void hamiltonpathcyclehelper(ArrayList<Edge> graph[], int vtx, int count , String psf, boolean visited []){
  
  visited[vtx] = true;
if(count == graph.length-1){
  for(Edge e : graph[orgsrc]){
    if(e.nbr== vtx){
      System.out.println(psf+"*");
      visited[vtx] = false;
      return;
  
    }
  }
  visited[vtx] = false;
  System.out.println(psf+".");
  return;
}

for(Edge e : graph[vtx]){
  if(visited[e.nbr]==false){
    hamiltonpathcyclehelper(graph , e.nbr, count+1, psf +e.nbr +"" ,visited);
    
  }
}

  visited[vtx] = false;
  return; 


}






}



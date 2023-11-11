import java.util.*;
public class unionfind {
 
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
        int Edges[][] = {{3,4,10}{2,5,10}};
        
        unionfind(vers,Edges);
        display(graph);
      
    
    
    }
    
    public static void addEdge(ArrayList<Edge> graph[],int u, int v, int w){
      graph[u].add(new Edge(v,w));
      graph[v].add(new Edge(u,w));
    }
    
    

    public static void display(ArrayList<Edge> graph[]){ 
        for(int i =0 ; i<graph.length ; i++){
          System.out.print(i+" "+"->");
            for(Edge e : graph[i])
            System.out.print(" "+"{"+e.v+","+ e.w+"}"+" ");
            System.out.println("");
        }
    }




    //union find

    static int[]par,size;

    public static int findpar(int i){
       return (par[i] == i)? i: ( par[i] =findpar(par[i])); // it is doing path compression here too
    }

    public static void merge(int p1 , int p2){
        if(size[p1]< size[p2]){
          par[p1] = p2;
          size[p2] += size[p1];
        }else{
          par[p2] = p1;
          size[p1] += size[p2];
        }
    }


    public static void unionfind(int [][]edges, int n){

        ArrayList<edge> graph [] = new ArrayList[];
        for(int i =0 ;i <n ; i++){
            graph[i] = new ArrayList<>();
        }
        par = new int[n];
        size = new int[n];

        for(int i =0 ; i < n ; i++){
            par[i] = i;
            size[i] = 1;
        }

        for(int [] e: edges){
            int u = e[0] , v =e[1] , w = e[2];
            int p1 = findpar(u);
            int p2 = findpar(v);

            if(p1 ! = p2){
                merge(p1,p2); // ismai yaad rakhna hum u aur v nhi pass karenge p1 p2 parent pass karenge as parent change hoteh hai
                addEdge(graph, u, v, w);
            }
        }


    }




    //MST kushkal algorithem
    //https://www.codingninjas.com/studio/problems/water-supply-in-a-village_1380956?leftPanelTab=

    static int []par ;

    public static int findpar(int u){
      return(par[u]==u)?  u :(par[u] = findpar(par[u]));
    }

    public static int supplyWater(int n, int k, int[] wells, int[][] pipes) {
       
      ArrayList<int[]> allpipes = new ArrayList<>();
      for(int i =0 ; i< k ; i ++){
          allpipes.add(pipes[i]);
      }
      for(int i = 0 ; i < wells.length; i++){

          allpipes.add(new int[]{0 , i+1, wells[i]});
      }

      Collections.sort(allpipes,(a,b)->{
          return a[2]-b[2];
      });

      par = new int[n+1];

      for(int i = 0; i <=  n; i++){
          par[i] = i ;
      }
      int ans = 0;
      for(int e[] : allpipes){
        int u = e[0], v =e[1] , w = e[2];
        int p1 = findpar(u), p2 = findpar(v);
        if(p1!=p2){
            par[p1] = p2;
            ans+=w;
        }

      }
      return ans;

    }



  }
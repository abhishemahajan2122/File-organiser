package practice;

import java.util.*;

 
public class graph{


public static class Edge{
  int src, nbr, wgt;

  Edge(int src,int nbr,int wgt){
    this.src = src;
    this.nbr = nbr;
    this.wgt = wgt;
  }

}
  public static void main(String[]args){

   Scanner scn = new Scanner(System.in);
   int vers = scn.nextInt();
   int edges = scn.nextInt();

     ArrayList<Edge> graph[] = new ArrayList[vers];

     for(int i = 0 ; i < vers ; i++){
          graph[i] = new ArrayList<>();
     }
     
     for(int i = 0 ; i< edges; i++){
      int src = scn.nextInt();
      int nbr = scn.nextInt();
      int wgt = scn.nextInt();

      graph[src].add(new Edge(src,nbr,wgt));
      graph[nbr].add((new Edge(nbr,src,wgt)));
      
    
      
    }
    display(graph);
     
     
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
  }
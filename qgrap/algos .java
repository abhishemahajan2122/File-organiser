
import java.util.*;

public class algo{

    
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    
    
    
    
        //kushkal questions
    
        //https://www.hackerearth.com/practice/algorithms/graphs/minimum-spanning-tree/practice-problems/algorithm/mr-president/
        static int par[];
        public static int mrpresident(){
            Scanner scn = new Scanner(System.in);
            int cities = scn.nextInt();
            int totalroads = scn.nextInt();
            int totalcost = scn.nextLong();
    
            ArrayList<int[]> edges = new ArrayList<>();
    
            for(int i =0 ; i< totalroads ; i++ ){
                int u = scn.nextInt() , v = scn.nextInt(), w = scn.nextInt();
                edges.add(new int[]{u,v,w});
    
            }
    
            Collections.sort(edges,(a,b)->{
                return a[2] - b[2];
            });
    
        int totalweight = 0, components = cities , conversions=0;


        ArrayList<Integer> weights = new ArrayList<>();
        par = new par[cities+1];

        for(int i = 0 ; i < par.length ; i++){
            par[i] = i;
        }

        for(int []e  : edges){
            int u = e[0], v= e[1], w = e[2];

            int p1 = findpar(u);
            int p2 = findpar(v);

            if(p1!=p2){
              par[p1] = p2;
              compnents--;
              weights.add(w);
            }
        }

        if(components != 1){
            return -1;
        }

        for(int i = weights.length -1; i>=0 ; i--){

           if(totalweight > totalcost){
               totalweight = totalweight - weights[i] +1;
               conversions++;

           }
        }
        if(totalweight > totalcost){
            return -1;
        }
        return totalweight;
}
}



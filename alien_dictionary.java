import java.util.ArrayList;

public class alien_dictionary {
    private List<Integer> topoSort(int V, List<List<Integer>> adj){
        int[] indegree = new int[V];

        for(int i=0; i<V; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Arraylist<Integer> topo = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);

            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        return topo;
    }


   public String findOrder(String[] dict, int N, int K){
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0; i<K; i++){
        adj.add(new ArrayList<>());
       }

       for(int i=0; i<N-1; i++){
        String s1 = dict[i];
        String s2 = dict[i+1];
        int len = Math.min(s1.length(), s2.length());
           for(int ptr = 0; ptr < len; ptr++){
            if(s1.charAt(ptr) != s2.charAt(ptr)){
                adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                break;
            }
          }
       }

       ArrayList<Integer> topo = topoSort(K,adj);
       String ans = "";
       for(int i=0; i<topo.size(); i++){
        ans = ans + (char)(topo.get(i) + 'a');
       }

       return ans;
   } 
}

class Solution {
    public int[] findOrder(int N, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0; i<prerequisites.length; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        //check cycle using topoSort
        int[] indegree = new int[N];
        
        for(int i=0; i<N; i++){
            for(int it : adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] topo = new int[N];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.poll();
            topo[i++] = node;
            
            for(int it : adj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        
        if(i == N) return topo;
        int[] arr = {};
        return arr;
    }
}
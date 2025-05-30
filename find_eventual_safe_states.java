class Solution {
    //using cycyle detection method -- dfs
    public boolean dfsCheck(int node, int[][] graph, int[] vis, int[] pathVis){
        vis[node] = 1;
        pathVis[node] = 1;

        for(int it : graph[node]){
            if(vis[it] == 0){
                if(dfsCheck(it,graph, vis, pathVis)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i=0; i<V; i++){
            if(vis[i] == 0){
                dfsCheck(i,graph,vis,pathVis);
            }
        }

        for(int i=0; i<V; i++){
            if(pathVis[i] == 0)
            ans.add(i);
        }
        return ans;
    }

*************************************************** TOPOSORT SOLUTION *****************************************************************
    //topo sort
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        int V = graph.length;
        int[] indegree = new int[V];

        for(int i=0; i<V; i++){
            adjRev.add(new ArrayList<>());
        }

        for(int i=0; i<V; i++){
            for(int it : graph[i]){
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }

        ArrayList<Integer> safenodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.remove();
            safenodes.add(node);

            for(int it : adjRev.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }

        Collections.sort(safenodes);
        return safenodes;
    }
}

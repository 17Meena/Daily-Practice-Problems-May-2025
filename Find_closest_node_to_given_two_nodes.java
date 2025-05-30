class Solution {
    private void bfs(int[] edges, int node, int[] dist, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 1;
        dist[node] = 0;

        while(!q.isEmpty()){
            int currNode = q.remove();

            int neighbour = edges[currNode];
            if(neighbour != -1 && vis[neighbour] == 0){
                q.add(neighbour);
                vis[neighbour] = 1;
                dist[neighbour] = dist[currNode]+1;
            }
        }
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;

        int[] dist1 = new int[n]; //dist of all nodes from node1
        int[] dist2 = new int[n]; //dist of all nodes from node2

        int[] vis1 = new int[n]; //for bfs of node1
        int[] vis2 = new int[n]; //for bfs of node2

         Arrays.fill(dist1,Integer.MAX_VALUE);
         Arrays.fill(dist2,Integer.MAX_VALUE);

        bfs(edges,node1,dist1,vis1);
        bfs(edges,node2,dist2,vis2);

        int minDistTillNow = Integer.MAX_VALUE;
        int minDistNode = -1;

        for(int i=0; i<n; i++){
            int maxD = Math.max(dist1[i],dist2[i]);

                if(maxD < minDistTillNow){
                    minDistTillNow = maxD;
                    minDistNode = i;
                }
            
        }

        return minDistNode;

    }
}
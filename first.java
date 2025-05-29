class Pair{
    int node;
    int factor;

    public Pair(int n, int f){
        this.node = n;
        this.factor = f;
    }
}

class Solution {
    static final int mod = (int)1e9+7;
    public int[] baseUnitConversions(int[][] conversions) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

       int n = 0;
       for (int[] conversion : conversions) {
            n = Math.max(n, Math.max(conversion[0], conversion[1]));
        }
        n++;
       for(int i=0; i<n; i++){
        adj.add(new ArrayList<>());
       }

       for(int[] arr : conversions){
        adj.get(arr[0]).add(new Pair(arr[1],arr[2]));
       }

       int[] ans = new int[n];
       ans[0] = 1;
       Queue<Integer> q = new LinkedList<>();
       q.add(0);

       while(!q.isEmpty()){
        int node = q.remove();

        for(Pair p : adj.get(node)){
           int v = p.node;
           int c = p.factor ;
           if(ans[v] == 0){
            ans[v] = (int)((1L * ans[node] * c) % mod);
            q.add(v);
           }

        }
       }

       return ans;

    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int[] e : edges){
            int u= e[0], v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int res = 0;
        for (int i=0; i<n; i++){
            if (!vis[i]){
                int[] ans = bfs(adj, i, vis);
                int nodes=ans[0], edge=ans[1];
                if (edge == nodes * (nodes-1)/2) res++;
            }
        }

        return res;
    }

    public int[] bfs(List<List<Integer>> adj, int node, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        vis[node] = true;
        int[] res = new int[2]; //{nodes, edges}

        while(!q.isEmpty()){
            int curr = q.poll();
            res[0]++; //nodes++

            for (int neighbor : adj.get(curr)){
                res[1]++; //edges++
                if (!vis[neighbor]){
                    q.offer(neighbor);
                    vis[neighbor] = true; 
                }
            }
            
        }

        res[1] /= 2;

        return res;
    }
}
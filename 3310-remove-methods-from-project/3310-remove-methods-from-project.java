class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i=0; i<n; i++) adj.add(new ArrayList<>());
        for (int[] edge : invocations){
            int u=edge[0], v=edge[1];
            adj.get(u).add(v);
        }

        List<Integer> res = new ArrayList<>();
        // bfs from k to mark all damaged nodes
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[n];
        q.offer(k);
        vis[k] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for (int neighbor : adj.get(node)){
                if (!vis[neighbor]){
                    q.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        for (int[] edge : invocations){
            int u=edge[0], v=edge[1];
            if (!vis[u] && vis[v]){
                for (int i=0; i<n; i++) res.add(i);
                return res;
            }
        }

        for (int i=0; i<n; i++){
            if (!vis[i]) res.add(i);
        }
        return res;
    }
}
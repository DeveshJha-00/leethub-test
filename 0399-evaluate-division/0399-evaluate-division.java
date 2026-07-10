class Pair{
    String node;
    double wt;
    Pair(String node, double wt){
        this.node = node;
        this.wt = wt;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        Map<String, List<Pair>> graph = new HashMap<>();

        for (int i=0; i<n; i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double wt = values[i];

            graph.putIfAbsent(u, new ArrayList<Pair>());
            graph.putIfAbsent(v, new ArrayList<Pair>());

            graph.get(u).add(new Pair(v, wt));
            graph.get(v).add(new Pair(u, 1.0/wt));
        }

        double[] res = new double[queries.size()];
        for (int i=0; i<queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)){
                res[i] = -1.0;
                continue;
            }
            Set<String> vis = new HashSet<>();
            res[i] = dfs(src, dest, graph, vis, 1.0);
        }

        return res;
    }

    double dfs(String src, String dest, Map<String, List<Pair>> graph, Set<String> vis, double prod){
        if (src.equals(dest)) return prod;

        vis.add(src);
        for (Pair p : graph.get(src)){
            String neighbor = p.node;
            double wt = p.wt;
            if (!vis.contains(neighbor)){
                double ans = dfs(neighbor, dest, graph, vis, prod*wt);
                if (ans != -1.0) return ans; 
            }
        }

        return -1.0;
    }
}
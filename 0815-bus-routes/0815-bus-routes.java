class Solution {
    public int numBusesToDestination(int[][] routes, int src, int target) {
        if (src == target) return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>(); // stop to bus map
        for (int i=0; i<routes.length; i++){
            for (int stop : routes[i]){
                adj.putIfAbsent(stop, new ArrayList<>());
                adj.get(stop).add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[501]; 
        for (int stop : adj.getOrDefault(src, Collections.emptyList())){
            q.offer(stop);
            vis[stop] = true;
        }

        int busCount = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-- > 0){
                int stop = q.poll();

                for (int neighbor : routes[stop]){
                    if (neighbor == target) return busCount;

                    for (int nextStop : adj.getOrDefault(neighbor, Collections.emptyList())){
                        if (!vis[nextStop]){
                            vis[nextStop] = true;
                            q.offer(nextStop);
                        }
                    }

                }
            }

            busCount++;
        }

        return -1;

    }
}
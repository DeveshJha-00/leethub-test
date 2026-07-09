class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        List<int[]> events = new ArrayList<>();
        int n = trips.length; 
        for (int i=0; i<n; i++){
            int from = trips[i][1];
            int to = trips[i][2];
            int val = trips[i][0];
            events.add(new int[]{from, +val});
            events.add(new int[]{to, -val});
        }

        Collections.sort(events, (a,b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        int curr = 0;
        for (int[] e : events){
            curr += e[1];
            if (curr > capacity) return false;
        }

        return true;
    }
}
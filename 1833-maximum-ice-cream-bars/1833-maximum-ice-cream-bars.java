class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int cnt = 0;
        Arrays.sort(costs);
        
        for (int cost : costs){
            if (cost > coins) break;
            cnt++;
            coins -= cost;
        }

        return cnt;
    }
}
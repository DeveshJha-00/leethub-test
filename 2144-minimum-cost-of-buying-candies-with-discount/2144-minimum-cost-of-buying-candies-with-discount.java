class Solution {
    public int minimumCost(int[] cost) {
        int n = cost.length;
        Arrays.sort(cost);
        int price = 0;
        int ctr = 1;
        for (int i=n-1; i>=0; i--){
            if (ctr%3 != 0) price += cost[i];
            ctr++;
        }
        return price;
    }
}

/*
[6,5,7,9,2,2]
[2,2,5,6,7,9]
9 
*/
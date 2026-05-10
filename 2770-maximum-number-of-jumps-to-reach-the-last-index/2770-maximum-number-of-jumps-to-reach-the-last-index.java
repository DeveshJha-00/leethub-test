// MEMOIZATION : 

// class Solution {
//     public int maximumJumps(int[] nums, int target) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, Integer.MIN_VALUE);

//         int ans = solve(nums, target, 0, dp);
//         if (ans < 0) return -1;
//         return ans;
//     }

//     private int solve(int[] nums, int target, int i, int[] dp){
//         int n = nums.length;
//         if (i == n-1){
//             return dp[i] = 0;
//         }

//         if (dp[i] != Integer.MIN_VALUE){
//             return dp[i];
//         }

//         int res = Integer.MIN_VALUE;
//         for (int j=i+1; j<n; j++){
//             if (Math.abs(nums[j] - nums[i]) <= target){
//                 int temp = 1 + solve(nums, target, j, dp);
//                 res = Math.max(res, temp);
//             }
//         }

//         return dp[i] = res;
//     }
// }

// TABULATION : 

class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        dp[n-1] = 0;
        for (int i=n-2; i>=0; i--){
            for (int j=i+1; j<n; j++){
                if (Math.abs(nums[i] - nums[j]) <= target && dp[j] != Integer.MIN_VALUE){
                    int temp = 1 + dp[j];
                    dp[i] = Math.max(dp[i], temp);
                }
            }
        }

        return dp[0] < 0 ? -1 : dp[0];
    }
}

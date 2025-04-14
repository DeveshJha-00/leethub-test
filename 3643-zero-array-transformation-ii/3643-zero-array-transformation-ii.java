class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        //BRUTE FORCE
        // for (int i=0; i<queries.length; i++){
        //     int[] query = queries[i];
        //     int start = query[0];
        //     int end = query[1];
        //     int val = query[2];
        //     for (int j=start; j<=end; j++){
        //         nums[j] = Math.max(0, nums[j] - Math.min(nums[j], val));
        //     }
        //     boolean isZero = true;
        //     for (int num : nums) {
        //         if (num != 0) {
        //             isZero = false;
        //             break;
        //         }
        //     }
        //     if (isZero) return i+1;
        // }
        // return -1;

        //BETTER BUT STILL SAME TC, CZ LINEAR, NEED BINARY SEARCH OVER QUERIES ARR
        // int n=nums.length, q=queries.length;
        // if (allZerosAlready(nums)) return 0;
        // for(int i=0; i<q; i++){
        //     if (checkWithDifferenceArray(nums, queries, i)) return i+1;
        // }
        // return -1;

        //JUST  REPLACE WITH BINARY SEARCH OVER QUERIES ARR INSTEAD OF LINEAR
        int n=nums.length, q=queries.length;
        if (allZerosAlready(nums)) return 0;
        int l=0, r=q-1, res=-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (checkWithDifferenceArray(nums, queries, mid)) {
                res = mid+1; //possible ans
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;

    }

    public boolean checkWithDifferenceArray(int[] nums, int[][] queries, int k){
        int n=nums.length;
        int[] diff = new int[n];
        for (int i=0; i<=k; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            int val= queries[i][2];
            diff[start] += val;
            if (end+1<n) diff[end+1] -= val;
        }
        int cumSum=0;
        for (int i=0; i<n; i++){
            cumSum += diff[i];
            diff[i] = cumSum;
            if (nums[i]-diff[i] > 0) return false; 
        }
        return true;
    }

    public boolean allZerosAlready(int[] nums){
        boolean ans = true;
        for (int ele:nums){
            if (ele!=0){
                ans=false;
                break;
            }
        }
        return ans;
    }

}
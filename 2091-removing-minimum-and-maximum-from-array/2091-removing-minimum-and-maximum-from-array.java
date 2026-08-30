class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int minEl=Integer.MAX_VALUE, maxEl=Integer.MIN_VALUE;
        int minPos=-1, maxPos=-1;

        for (int i=0; i<n; i++){
            int num = nums[i];

            if (num < minEl){
                minEl = num;
                minPos = i;
            }
            if (num > maxEl){
                maxEl = num;
                maxPos = i;
            }
        }


        int bothFront = Math.max(minPos, maxPos) + 1;
        int bothBack = n - Math.min(minPos, maxPos);

        int frontMinBackMax = minPos + 1 + n - maxPos;
        int frontMaxBackMin = maxPos + 1 + n - minPos;

        return Math.min(
            Math.min(bothFront, bothBack),
            Math.min(frontMinBackMax, frontMaxBackMin)
        );
    }
}
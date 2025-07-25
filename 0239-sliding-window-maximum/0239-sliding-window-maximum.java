class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int resultIdx=0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i=0; i<n; i++){
             // Remove elements from the front of the deque that are out of the current window
            if (!dq.isEmpty() && dq.peekFirst() <= i-k){
                dq.pollFirst();
            }
            // Maintain a monotonically decreasing order in the deque
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            // Add the current element's index to the back of the deque
            dq.offer(i);
            // Add the maximum of the current window to the result 
            if (i >= k-1) {
                res[resultIdx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res,-1);
        Stack<Integer> st = new Stack<>();
        
        for (int i=0; i<2*n; i++){
            int current = nums[i % n];
            while (!st.isEmpty() && current > nums[st.peek()]) {
                res[st.pop()] = current;
            }
            // We only push indices from the first pass
            if (i < n) {
                st.push(i);
            }
        }
        return res;
    }
}
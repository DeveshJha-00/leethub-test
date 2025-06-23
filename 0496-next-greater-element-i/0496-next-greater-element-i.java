class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        for(int num : nums2){
            while ( !st.isEmpty() && num>st.peek() ) {
                map.put(st.pop(), num);
            }
            st.push(num);
        }
        int n=nums1.length;
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            res[i] = map.getOrDefault(nums1[i],-1);
        }
        return res;
    }
}
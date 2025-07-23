class Solution {

    public long subArrayRanges(int[] nums) {
        return maxSubarraySum(nums) - minSubarraySum(nums);
    }


    public long minSubarraySum(int[] arr) {
        int n = arr.length;
        int[] pse = prevSmallerOrEqualEle(arr);
        int[] nse = nextSmallerEle(arr);
        long total=0;
        for (int i=0; i<n; i++){
            total += (long) (i-pse[i])*(nse[i]-i) * arr[i];
        }
        return total;
    }
    public long maxSubarraySum(int[] arr) {
        int n = arr.length;
        int[] pge = prevGreaterOrEqualEle(arr);
        int[] nge = nextGreaterEle(arr);
        long total=0;
        for (int i=0; i<n; i++){
            total += (long) (i-pge[i])*(nge[i]-i) * arr[i];
        }
        return total;
    }


    public int[] prevSmallerOrEqualEle(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
    public int[] nextSmallerEle(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek(); 
            st.push(i);
        }
        return nse;
    }


    public int[] prevGreaterOrEqualEle(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++){
            while (!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            pge[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pge;
    }
    public int[] nextGreaterEle(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            nge[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nge;
    }
    
}
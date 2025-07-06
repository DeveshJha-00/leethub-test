class Solution {

    // public int[] prevSmallerOrEqualEle(int[] arr){
    //     int n = arr.length;
    //     int[] pse = new int[n];
    //     Stack<Integer> st = new Stack<>();
    //     for (int i=0; i<n; i++) {
    //         while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
    //             st.pop();
    //         }
    //         pse[i] = st.isEmpty() ? -1 : st.peek();
    //         st.push(i);
    //     }
    //     return pse;
    // }

    // public int[] nextSmallerEle(int[] arr){
    //     int n = arr.length;
    //     int[] nse = new int[n];
    //     Stack<Integer> st = new Stack<>();
    //     for(int i=n-1; i>=0; i--){
    //         while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
    //             st.pop();
    //         }
    //         nse[i] = st.isEmpty() ? n : st.peek(); 
    //         st.push(i);
    //     }
    //     return nse;
    // }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i=0; i<n; i++) { //MAKING PSE(LEFT)
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){ //MAKING RIGHT
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek(); 
            st.push(i);
        }

        // int[] nse = nextSmallerEle(arr);
        // int[] pse = prevSmallerOrEqualEle(arr);
        long total=0;
        int mod=(int)(1e9+7);
        for (int i=0; i<n; i++){
            // int left = i-pse[i];
            // int right = nse[i]-i;
            // total += (long) ( ( ((right*left)%mod) * arr[i] )% mod);
            total += (long) (i-pse[i])*(nse[i]-i)%mod * arr[i] % mod;
            total %= mod;
        }
        return (int)total;
    }
}
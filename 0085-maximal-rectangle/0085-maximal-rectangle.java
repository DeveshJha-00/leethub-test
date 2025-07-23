class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n=matrix.length, m=matrix[0].length;
        int maxArea=0; 
        int[][] prefSum = new int[n][m];
        for (int j=0; j<m; j++){
            int sum=0;
            for (int i=0; i<n; i++){
                sum += matrix[i][j]-'0';
                if (matrix[i][j]=='0') sum=0;
                prefSum[i][j] = sum;
            }
        }
        
        for (int i=0; i<n; i++){
            maxArea = Math.max(maxArea, largestRectangleArea(prefSum[i]));
        }
        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length, maxArea=0;
        int[] pse = prevSmallerEle(heights);
        int[] nse = nextSmallerEle(heights);
        for (int i=0; i<n; i++){
            // int width = (i-pse[i]) + (nse[i]-i) -1 ;
            int width = nse[i] - pse[i] - 1;
            int currArea = width*heights[i];
            maxArea=Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    public int[] prevSmallerEle(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
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
        for (int i=n-1; i>=0; i--){
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}
class Solution {
    public int trap(int[] h) {

        // int n=height.length, total=0;
        // int[] prefixMax = new int[n];
        // int[] suffixMax = new int[n];
        // prefixMax[0]=height[0];
        // for (int i=1; i<n; i++) prefixMax[i]=Math.max(height[i],prefixMax[i-1]);

        // suffixMax[n-1]=height[n-1];
        // for (int i=n-2; i>=0; i--) suffixMax[i]=Math.max(height[i], suffixMax[i+1]);

        // for (int i=0; i<n;i++){
        //     int leftMax=prefixMax[i];
        //     int rightMax=suffixMax[i];
        //     if (height[i]<leftMax && height[i]<rightMax){
        //         total += Math.min(leftMax,rightMax)-height[i];
        //     }
        // }

        // return total;

        int total=0, left=0, right=h.length-1;
        int leftMax=h[left];
        int rightMax=h[right];

        while (left < right){
            if (leftMax < rightMax){
                total += (leftMax - h[left]);
                left++;
                leftMax = Math.max(leftMax, h[left]);
            } else {
                total += (rightMax - h[right]);
                right--;
                rightMax = Math.max(rightMax, h[right]);
            }
        }
        return total;

    }
}
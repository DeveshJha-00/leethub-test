class Solution {
    public int[] runningSum(int[] arr) {
        int sum=arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=sum;
            sum+=arr[i+1];
        }
        arr[arr.length-1]=sum;
        return arr;
    }
}
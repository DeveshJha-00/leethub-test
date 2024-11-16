class Solution {

    public int countSubarrays(int[] arr, int mid){
        int sum=0, subArrCount=1;
        for (int ele : arr){
            if ((sum+ele) <= mid){
                sum += ele;
            }else{
                sum = ele;
                subArrCount++;
            }
        }
        return subArrCount;
    }

    public int splitArray(int[] nums, int k){
        int minPossibleMax = Integer.MIN_VALUE;
        int maxPossibleMax = 0;
        for (int ele : nums){
            minPossibleMax = Math.max(minPossibleMax, ele);
            maxPossibleMax += ele;
        }
        int low=minPossibleMax, high=maxPossibleMax;
        while (low<=high){
            int mid = low + (high-low)/2;
            int noOfSubarrays = countSubarrays(nums,mid);
            if (noOfSubarrays > k) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}


// class Solution {
//     public int splitArray(int[] nums, int k) {
//         int start =Integer.MIN_VALUE;;
//         int end = 0;
//         for(int i=0;i<nums.length;i++){
//             start = Math.max(start,nums[i]);
//             end = end+nums[i];
//         }
//         while(start<=end){
//             int mid = start+((end-start)/2);
//             int numsplits = func(nums,mid);
//             if(numsplits > k){
//                 start = mid+1;
//             }else{
//                 end = mid-1;
//             }
//         }
//         return start;
//     }
//     int func(int[] arr, int splits){
//         int numsplits =1;
//         int sumsplit=0;
//         for(int i=0;i<arr.length;i++){
//             if(sumsplit+arr[i]<=splits){
//                 sumsplit +=arr[i];
//             }
//             else{
//                 numsplits ++;
//                 sumsplit = arr[i];
//             }
//         }
//         return numsplits;
//     }
// }
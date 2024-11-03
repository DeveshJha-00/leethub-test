class Solution {
    public int firstOccurence(int[] arr, int target){
        int initialIndex=-1;
        int left=0,right=arr.length-1,mid;
        while(left<=right){
            mid=(left+right)/2;
            if (arr[mid] > target) right=mid-1;
            else if (arr[mid] < target) left=mid+1;
            else{
                initialIndex=mid;
                right=mid-1;
            }
        }
        return initialIndex;
    }
    public int lastOccurence(int[] arr, int target){
        int finalIndex=-1;
        int left=0,right=arr.length-1,mid;
        while(left<=right){
            mid=(left+right)/2;
            if (arr[mid] > target) right=mid-1;
            else if (arr[mid] < target) left=mid+1;
            else{
                finalIndex=mid;
                left=mid+1;
            }
        }
        return finalIndex;
    }


    public int[] searchRange(int[] nums, int target) {
        int initialIndex = firstOccurence(nums, target);
        int finalIndex = lastOccurence(nums, target);
        return new int[]{initialIndex,finalIndex};
    }

}
class Solution {

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j=-1;
        //place j at the first 0
        for (int i=0;i<n;i++){
            if (nums[i]==0){
                j=i;
                break;
            }
        }
        //if no 0, return
        if (j==-1) return; 

        for (int i=j+1;i<n;i++){
            if (nums[i]!=0){
                swap(nums,i,j);
                j++;
            }
        }

    }

}
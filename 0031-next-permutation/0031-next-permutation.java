class Solution {

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void reverse(int[] arr, int a, int b){
        while(a<b){
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
            a++;
            b--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        //find breakpoint
        int bp=-1;
        for (int i=n-2; i>=0; i--){
            if (nums[i] < nums[i+1]){
                bp=i;
                break;
            }
        }

        if (bp==-1){
            reverse(nums,0,n-1);
            return;
        }
        
        //swap the element(ele) at bp with the smallest number greater than ele
        for (int i=n-1; i>bp; i--){
            if (nums[i] > nums[bp]){
                swap(nums,i,bp);
                break;
            }
        }
        reverse(nums, bp+1, n-1);
    }
}
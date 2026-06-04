class Solution {
    public int minimumSwaps(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int swaps = 0;

        while (left < right) {

            while (left < right && nums[left] != 0)
                left++;

            while (left < right && nums[right] == 0)
                right--;

            if (left < right) {
                swap(nums, left, right);
                swaps++;
                left++;
                right--;
            }
        }

        return swaps;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
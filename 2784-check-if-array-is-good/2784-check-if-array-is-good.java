// class Solution {
//     public boolean isGood(int[] nums) {
//         int maxEle = Integer.MIN_VALUE;
//         for (int num : nums) maxEle=Math.max(maxEle, num);

//         if (maxEle + 1 != nums.length) return false;

//         int[] freq = new int[maxEle + 1];
//         for (int i=0; i<nums.length; i++){
//             freq[nums[i]]++;
            
//             if (nums[i] != maxEle && freq[nums[i]] > 1) return false;
//             if (nums[i] == maxEle && freq[nums[i]] > 2) return false;
//         }

//         return true;
//     }
// }

class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;

        int maxEl = n - 1;
        int maxElCount = 0;

        for (int num : nums) {
            int val = Math.abs(num);

            if (val > maxEl) return false;

            if (val == maxEl) maxElCount++;

            if (nums[val] < 0) {
                if (val != maxEl || maxElCount > 2) return false;
            } else {
                nums[val] *= -1;
            }
        }

        return true;
    }
}

// // class Solution {
// //     public boolean isGood(int[] nums) {
// //         int n = nums.length;
// //         Arrays.sort(nums);

// //         for (int i = 0; i <= n - 2; i++) {
// //             if (nums[i] != i + 1)
// //                 return false;
// //         }

// //         return nums[n - 1] == n - 1;
// //     }
// // }
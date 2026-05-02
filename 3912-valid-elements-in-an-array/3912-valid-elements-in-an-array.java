class Solution {
    public List<Integer> findValidElements(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i=0; i<nums.length; i++){
            boolean rightCheck = true, leftCheck = true;
            for (int j=i+1; j<nums.length; j++){
                if (nums[j] >= nums[i]) rightCheck=false;
            }
            for (int j=0; j<i; j++){
                if (nums[j] >= nums[i]) leftCheck=false;
            }

            if (rightCheck || leftCheck) res.add(nums[i]);
        }

        return res;
    }
}
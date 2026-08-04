class Solution {
    public List<Integer> findMissingElements(int[] nums) {

        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int prev = nums[0];

        for (int i=1; i<nums.length; i++){
            while(nums[i] != prev + 1){
                prev++;
                res.add(prev);
            }
            prev = nums[i];
        }

        return res;
    }
}
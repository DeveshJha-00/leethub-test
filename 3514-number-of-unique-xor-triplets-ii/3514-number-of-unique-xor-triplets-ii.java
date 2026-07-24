class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        Set<Integer> pairXors = new HashSet<>();
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                pairXors.add(nums[i] ^ nums[j]);
            }
        }

        Set<Integer> res = new HashSet<>();
        for (int pairXor : pairXors){
            for (int num : nums) res.add(pairXor ^ num);
        }

        return res.size();
    }
}
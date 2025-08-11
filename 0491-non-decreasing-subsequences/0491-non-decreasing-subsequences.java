class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        solve(res, temp, nums, 0);
        return res;
    }

    public void solve(List<List<Integer>> res, List<Integer> temp, int[] nums, int idx){
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
            // return;  //DONT RETURN HERE SINCE ONLY LISTS OF LENGTH 2 WILL BE ADDED
        }
        if (idx==nums.length){
            return;
        }

        Set<Integer> st = new HashSet<>();
        for (int i=idx; i<nums.length; i++){
            if ((temp.isEmpty() || nums[i]>=temp.get(temp.size()-1)) && !st.contains(nums[i])){
                temp.add(nums[i]);
                solve(res, temp, nums, i+1);
                temp.remove(temp.size()-1);
                st.add(nums[i]);
            }
        }
    }

}
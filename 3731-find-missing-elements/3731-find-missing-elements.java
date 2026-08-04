class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int mini=Integer.MAX_VALUE, maxi=Integer.MIN_VALUE;
        for (int num : nums){
            set.add(num);
            mini = Math.min(mini, num);
            maxi = Math.max(maxi, num);
        }

        List<Integer> res = new ArrayList<>();
        for (int i=mini; i<=maxi; i++){
            if (!set.contains(i)) res.add(i);
        }

        return res;
    }
}
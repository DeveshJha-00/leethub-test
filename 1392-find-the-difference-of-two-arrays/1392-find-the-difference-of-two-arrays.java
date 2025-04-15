class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int ele:nums1) set1.add(ele);
        for (int ele:nums2) set2.add(ele);

        Set<Integer> onlyInNums1 = new HashSet<>(set1);
        Set<Integer> onlyInNums2 = new HashSet<>(set2);
        onlyInNums1.removeAll(set2);  
        onlyInNums2.removeAll(set1);
        ans.add(new ArrayList<>(onlyInNums1));
        ans.add(new ArrayList<>(onlyInNums2));

        return ans;
    }
}
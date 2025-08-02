class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // int n = nums.length;
        // Set<List<Integer>> set = new HashSet<>();
        // for (int i=0; i<n-2; i++){
        //     for (int j=i+1; j<n-1; j++){
        //         for (int k = j+1; k<n; k++){
        //             if (nums[i]+nums[j]+nums[k]==0){
        //                 List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
        //                 Collections.sort(triplet); 
        //                 set.add(triplet);
        //             }
        //         }
        //     }
        // }
        // return new ArrayList<>(set);

        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<n-2; i++){
            if (i>0 && nums[i]==nums[i-1]) continue;
            int l=i+1; 
            int r=n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if (sum==0){
                    List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
                    ans.add(triplet);
                    while(l<n-1 && nums[l]==nums[l+1]) l++;
                    while(r>i+1 && nums[r]==nums[r-1]) r--;
                    l++; r--;
                }else if (sum > 0){
                    r--;
                }else{
                   l++;
                }
            }
        }
        return ans;
    }
}
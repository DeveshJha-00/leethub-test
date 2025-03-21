class Solution {
    public int duplicateNumbersXOR(int[] nums) {

        HashSet<Integer> set = new HashSet<>();
        int xor=0;
        for (int ele:nums){
            if (set.contains(ele)){
                xor ^= ele;
            }
            else set.add(ele);
        }
        return xor;
        
    }
}
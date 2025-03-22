class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for (int ele:nums) xor ^= ele;
        int rightmostSetBit = xor & -(xor);
        int num1=0, num2=0;
        for (int ele:nums){
            if ((ele & rightmostSetBit) != 0) num1 ^= ele;
            else num2 ^= ele;
        }
        return new int[] {num1, num2};
    }
}
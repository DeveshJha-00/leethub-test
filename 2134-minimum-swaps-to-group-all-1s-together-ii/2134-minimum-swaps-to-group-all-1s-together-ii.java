class Solution {
    public int minSwaps(int[] arr) {
        int totalOnes = 0;
        for (int ele : arr){
            if (ele == 1) totalOnes++;  
        }
        if (totalOnes == 0) return 0;

        int[] nums = new int[arr.length*2];
        for (int i=0; i<arr.length; i++){
            nums[i] = arr[i];
            nums[i + arr.length] = arr[i];
        }
        int l=0, r=0, minZeros=Integer.MAX_VALUE, currZeros=0;
        while(r < nums.length){
            if (nums[r] == 0) currZeros++;

            if ((r-l+1) < totalOnes){
                r++;
            }else if ((r-l+1) == totalOnes){
                minZeros = Math.min(minZeros, currZeros);

                if (nums[l] == 0) currZeros--;
                l++;
                r++;
            }
        }

        return minZeros;
    }
}
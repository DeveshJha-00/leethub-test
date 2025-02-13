class Solution {

    public int sumOfDigits(int n){
        int sum=0, temp=n;
        while(temp!=0){
            sum += temp%10;
            temp /= 10;
        }
        return sum;
    }

    public int maximumSum(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int currSum=0, maxSum=-1;

        for(int i=0; i<nums.length; i++){
            int sum = sumOfDigits(nums[i]);

            if (map.containsKey(sum)){
                int prevNo = nums[map.get(sum)];
                int currNo = nums[i];
                currSum = prevNo + currNo;
                maxSum = Math.max(currSum, maxSum);
                int maxNoIdx = (prevNo > currNo) ? map.get(sum) : i;
                map.put(sum,maxNoIdx);
            }
            else{
                map.put(sum, i);
            }
        }
        return maxSum;
    }
}
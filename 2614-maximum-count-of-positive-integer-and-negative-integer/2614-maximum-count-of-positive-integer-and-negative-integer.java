class Solution {
    public int maximumCount(int[] nums) {

        // int pos=0, neg=0;
        // for (int ele:nums){
        //     if (ele>0) pos++;
        //     else if (ele<0) neg++;
        // }
        // return Math.max(pos,neg);

        int pos=0, neg=0, negLast=0, posFirst=0, posLast=0;
        int  n=nums.length, l=0, r=n-1;

        if (nums[0]==0 && nums[n-1]==0) return 0;

        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid] < 0){
                negLast=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        l=0;
        r=n-1;
        while (l<=r){
            int mid = l + (r-l)/2;
            if (nums[mid] > 0){
                posFirst=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }

        if (nums[n-1] > 0) posLast=n-1;

        pos = posLast-posFirst+1;
        neg = 1+negLast;
        return Math.max(pos,neg);

    }


}
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int maxi=Integer.MIN_VALUE, secondMaxi=Integer.MIN_VALUE, thirdMaxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE, secondMini=Integer.MAX_VALUE;

        for (int num : nums){
            if (num > maxi){
                thirdMaxi = secondMaxi;
                secondMaxi = maxi;
                maxi = num;
            }else if (num > secondMaxi){
                thirdMaxi = secondMaxi;
                secondMaxi = num;
            }else if (num > thirdMaxi){
                thirdMaxi = num;
            }
            if (num < mini){
                secondMini = mini;
                mini = num;
            }else if (num < secondMini){
                secondMini = num;
            }
        }

        return (int)Math.max(maxi*secondMaxi*thirdMaxi, maxi*mini*secondMini);
    }
}

/*
thirdMaxi = 1
secondMaxi = 3;
maxi = 4;

num = -7;
mini = -10;
secondMini = -5;
*/
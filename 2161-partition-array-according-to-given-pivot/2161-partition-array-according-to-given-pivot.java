class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> larger = new ArrayList<>();
        int sameCnt = 0;
        for (int ele : nums){
            if (ele == pivot) sameCnt++;
            else if (ele > pivot) larger.add(ele);
            else smaller.add(ele);
        }

        int ptr = 0;
        while(ptr < nums.length){
            for (int ele : smaller){
                nums[ptr++]=ele;
            }
            for (int i=0; i<sameCnt; i++){
                nums[ptr++] = pivot;
            }
            for (int ele : larger){
                nums[ptr++] = ele;
            }
        }

        return nums;
    }
}
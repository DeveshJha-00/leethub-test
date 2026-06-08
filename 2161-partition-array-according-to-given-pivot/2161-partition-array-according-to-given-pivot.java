class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int cntLess = 0;
        int cntSame = 0;
        for (int ele : nums){
            if (ele == pivot) cntSame++;
            else if (ele < pivot) cntLess++;
        }

        int i=0, j=cntLess, k=cntLess+cntSame;

        int[] res = new int[nums.length];
        for (int ele : nums){
            if (ele < pivot) res[i++] = ele;
            else if (ele == pivot) res[j++] = ele;
            else res[k++] = ele;
        }

        return res;
    }
}
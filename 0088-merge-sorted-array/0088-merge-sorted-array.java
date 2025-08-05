class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n==0) return;
        if (m==0){
            for (int i=0; i<nums2.length; i++){
                nums1[i]=nums2[i]; 
            }
            return;
        }
        int ptr1=m-1, ptr2=n-1, ptr=m+n-1;
        while(ptr2>=0){
            if (ptr1<0 || nums1[ptr1] <= nums2[ptr2]){
                nums1[ptr] = nums2[ptr2--];
            }else{
                nums1[ptr] = nums1[ptr1--];
            }
            ptr--;
        }
    }
}
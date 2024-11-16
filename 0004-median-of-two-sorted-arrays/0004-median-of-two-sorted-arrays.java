class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // int n1 = nums1.length, n2 = nums2.length;
        // int i=0, j=0;
        // int n = n1+n2;

        // int idxTracker=0;
        // int idx2 = n/2;
        // int idx1 = idx2-1;
        // int idx1el = -1;
        // int idx2el = -1;

        // while (i<n1 && j<n2){
        //     if (nums1[i] < nums2[j]){
        //         if (idxTracker == idx1) idx1el = nums1[i];
        //         if (idxTracker == idx2) idx2el = nums1[i];
        //         i++;
        //         idxTracker++;
        //     }else{
        //         if (idxTracker == idx1) idx1el = nums2[j];
        //         if (idxTracker == idx2) idx2el = nums2[j];
        //         j++;
        //         idxTracker++;
        //     }
        // }

        // while (i<n1){
        //     if (idxTracker == idx1) idx1el = nums1[i];
        //     if (idxTracker == idx2) idx2el = nums1[i];
        //     i++;
        //     idxTracker++;
        // }
        // while (j<n2){
        //     if (idxTracker == idx1) idx1el = nums2[j];
        //     if (idxTracker == idx2) idx2el = nums2[j];
        //     j++;
        //     idxTracker++; 
        // }

        // if (n%2==1){
        //     return idx2el;
        // }else{
        //     return ((double)idx1el + (double) idx2el) / 2.0;
        // }

        int n1 = a.length, n2 = b.length;
        if (n1 > n2) return findMedianSortedArrays(b, a);
        int n = n1 + n2; 
        int left = (n1 + n2 + 1) / 2; 

        int low = 0, high = n1;

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            }
            else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return -1;
    }
}
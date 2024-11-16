class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int i=0, j=0;
        int n = n1+n2;

        int idxTracker=0;
        int idx2 = n/2;
        int idx1 = idx2-1;
        int idx1el = -1;
        int idx2el = -1;

        while (i<n1 && j<n2){
            if (nums1[i] < nums2[j]){
                if (idxTracker == idx1) idx1el = nums1[i];
                if (idxTracker == idx2) idx2el = nums1[i];
                i++;
                idxTracker++;
            }else{
                if (idxTracker == idx1) idx1el = nums2[j];
                if (idxTracker == idx2) idx2el = nums2[j];
                j++;
                idxTracker++;
            }
        }

        while (i<n1){
            if (idxTracker == idx1) idx1el = nums1[i];
            if (idxTracker == idx2) idx2el = nums1[i];
            i++;
            idxTracker++;
        }
        while (j<n2){
            if (idxTracker == idx1) idx1el = nums2[j];
            if (idxTracker == idx2) idx2el = nums2[j];
            j++;
            idxTracker++; 
        }

        if (n%2==1){
            return idx2el;
        }else{
            return ((double)idx1el + (double) idx2el) / 2.0;
        }

    }
}
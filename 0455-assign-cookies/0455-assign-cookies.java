class Solution {
    public int findContentChildren(int[] greed, int[] cookieSize) {
        if (cookieSize.length==0) return 0;
        Arrays.sort(greed); Arrays.sort(cookieSize);
        int l=0, r=0;
        while(l<greed.length && r<cookieSize.length){
            if (greed[l] <= cookieSize[r]) l++;
            r++;
        }
        return l;
    }
}
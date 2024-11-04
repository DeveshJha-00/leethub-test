class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] arr, int si, int ei){

        if (si>=ei) return;
        int mid = si + (ei-si)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);

        merge(arr,si,mid,ei);

    }

    public void merge(int[] arr, int si, int mid, int ei){
        int[] mergedArr = new int[ei-si+1];
        int p1=si, p2=mid+1;
        int ptr=0;

        while(p1<=mid && p2<=ei){
            if (arr[p1] <= arr[p2]){
                mergedArr[ptr++]=arr[p1++];
            }else{
                mergedArr[ptr++]=arr[p2++];
            }
        }

        while(p1<=mid) mergedArr[ptr++]=arr[p1++];
        while (p2<=ei) mergedArr[ptr++]=arr[p2++];

        for (int i=0,j=si; i<mergedArr.length;i++,j++){
            arr[j] = mergedArr[i];
        }
    }

}
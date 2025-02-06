class Solution { 
    //DRIVER FN
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }

    public void mergeSort(int[] arr, int low, int high){
        if (low>=high) return;
        int mid = low + (high-low)/2;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);

        merge(arr,low,mid,high);

    }

    public void merge(int[] arr, int low, int mid, int high){
        int[] mergedArr = new int[high-low+1];
        int p1=low, p2=mid+1;
        int ptr=0;

        while(p1<=mid && p2<=high){
            if (arr[p1] <= arr[p2]){
                mergedArr[ptr++]=arr[p1++];
            }else{
                mergedArr[ptr++]=arr[p2++];
            }
        }

        while(p1<=mid) mergedArr[ptr++]=arr[p1++];
        while(p2<=high) mergedArr[ptr++]=arr[p2++];

        for (int i=0,j=low; i<mergedArr.length; i++,j++){
            arr[j] = mergedArr[i];
        }
    }

}
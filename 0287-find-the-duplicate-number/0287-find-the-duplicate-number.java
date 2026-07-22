class Solution {
    public int findDuplicate(int[] arr) {
        int n = arr.length;

        int i = 0;
        while (i < n){
            if (arr[i] != arr[arr[i] - 1]){
                swap(arr, i, arr[i]-1);
            }else{
                i++;
            }
        }

        for (int j=0; j<n; j++){
            if (j+1 != arr[j]) return arr[j];
        }

        return -1;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
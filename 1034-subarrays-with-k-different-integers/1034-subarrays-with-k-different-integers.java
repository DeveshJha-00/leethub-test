class Solution {

    // function to find subarrays With Less Than Or Equal To K Distinct
    public int func(int[] arr, int k){

        if (k<=0) return 0;
        int l=0, r=0, ct=0, n=arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();

        while (r<n){
            map.put(arr[r], map.getOrDefault(arr[r],0)+1);
            while (map.size() > k){
                map.put(arr[l], map.get(arr[l])-1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }
            ct += r-l+1;
            r++;
        }

        return ct;
    }


    public int subarraysWithKDistinct(int[] arr, int k) {

        return func(arr,k) - func(arr,k-1);
    }
}
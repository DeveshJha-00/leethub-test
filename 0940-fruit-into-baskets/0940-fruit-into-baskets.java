class Solution {
    public int totalFruit(int[] arr) {
        int l=0, r=0, n=arr.length, maxLen=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        
        // while (r<n){
        //     map.put(arr[r], map.getOrDefault(arr[r],0) + 1);
        //     while (map.size()>2){
        //         int val = map.get(arr[l]);
        //         map.put(arr[l], val-1);
        //         if (map.get(arr[l]) == 0) map.remove(arr[l]);
        //         l++;
        //     }
        //     maxLen = Math.max(maxLen, r-l+1);
        //     r++;
        // }

        while (r<n){
            map.put(arr[r], map.getOrDefault(arr[r],0) + 1);
            if (map.size() > 2){
                int val = map.get(arr[l]);
                map.put(arr[l], val-1);
                if (map.get(arr[l]) == 0) map.remove(arr[l]);
                l++;
            }
            if (map.size() <= 2) maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}
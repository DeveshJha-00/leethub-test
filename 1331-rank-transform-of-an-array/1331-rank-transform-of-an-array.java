class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;

        int[] copy = arr.clone();
        Arrays.sort(copy); 

        int[] res = new int[n];
        Map<Integer, Integer> map = new TreeMap<>();
        int rank = 1;

        for (int i=0; i<n; i++){
            if (i > 0 && copy[i] > copy[i-1]) rank++;
            map.put(copy[i], rank);
        }

        for (int i=0; i<n; i++){
            res[i] = map.get(arr[i]);
        }

        return res;
    }
}
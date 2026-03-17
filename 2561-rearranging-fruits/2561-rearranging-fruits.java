class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int minEl = Integer.MAX_VALUE;

        for (int x : basket1) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            minEl = Math.min(minEl, x);
        }

        for (int x : basket2) {
            map.put(x, map.getOrDefault(x, 0) - 1);
            minEl = Math.min(minEl, x);
        }

        List<Integer> finalList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cost = entry.getKey();
            int count = entry.getValue();

            if (count == 0) continue;
            if (count%2 != 0) return -1;

            for (int c=1; c <= Math.abs(count)/2; c++) {
                finalList.add(cost);
            }
        }

        Collections.sort(finalList);
        long result = 0;

        for (int i = 0; i < finalList.size() / 2; i++) {
            result += Math.min(finalList.get(i), minEl * 2);
        }

        return result;

    }
}
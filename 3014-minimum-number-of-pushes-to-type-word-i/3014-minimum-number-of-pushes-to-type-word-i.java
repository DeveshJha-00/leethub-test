class Solution {
    public int minimumPushes(String word) {
        if (word.length() <= 8) {
            return word.length();
        }

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        int key = 2;
        for (char ch : word.toCharArray()){
            if (key > 9) key=2;

            map.put(key, map.getOrDefault(key, 0) + 1);
            count += map.get(key);
            key++;
        }

        return count;
    }
}
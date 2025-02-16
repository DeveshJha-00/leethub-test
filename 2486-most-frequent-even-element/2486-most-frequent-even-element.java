class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0, minVal = -1;

        for (int num : nums) {
            if (num % 2 == 0) { // Only consider even numbers
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
                int freq = freqMap.get(num);

                // Update max frequency or select the smaller number in case of a tie
                if (freq > maxFreq || (freq == maxFreq && num < minVal)) {
                    maxFreq = freq;
                    minVal = num;
                }
            }
        }

        return minVal;
    
    }
}
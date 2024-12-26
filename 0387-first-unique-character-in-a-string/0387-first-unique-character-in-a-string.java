class Solution {
    public int firstUniqChar(String s) {
        // Queue<Integer> queue = new LinkedList<>();
        // int n = s.length();
        // int[] freq = new int[26];

        // for (int i=0; i<n; i++){
        //     char ch = s.charAt(i);
        //     freq[ch-'a']++;
        //     queue.offer(i);
        // }

        // while (!queue.isEmpty()) {
        //     int index = queue.peek();
        //     char c = s.charAt(index);
        //     if (freq[c - 'a'] == 1) {
        //         return index; 
        //     }
        //     queue.poll(); 
        // }
        // return -1;

        //BETTER -->
        int[] count = new int[26];
        for(int i = 0;i<s.length();i++){
            count[s.charAt(i)-'a']++;
        }
        for(int i = 0;i<s.length();i++){
            if(count[s.charAt(i)-'a'] == 1){
                return i;
            }
        }
        return -1;

    }
}
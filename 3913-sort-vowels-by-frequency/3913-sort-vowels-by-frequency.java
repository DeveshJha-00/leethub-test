class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        int[] freq = new int[5];
        int[] first = new int[5];
        Arrays.fill(first, -1);

        List<Integer> pos = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char ch = arr[i];
            int idx = getIndex(ch);

            if (idx != -1) {
                pos.add(i);
                freq[idx]++;

                if (first[idx] == -1) first[idx] = i;
            }
        }

        Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
        Arrays.sort(vowels, (x, y) -> {
            int i1 = getIndex(x);
            int i2 = getIndex(y);

            if (freq[i1] != freq[i2]) return freq[i2] - freq[i1];

            return first[i1] - first[i2];
        });

        StringBuilder sb = new StringBuilder();

        for (char ch : vowels) {
            int idx = getIndex(ch);
            for (int i = 0; i < freq[idx]; i++) {
                sb.append(ch);
            }
        }

        int k = 0;
        for (int index : pos) {
            arr[index] = sb.charAt(k++);
        }

        return new String(arr);
    }

    private int getIndex(char ch) {
        if (ch == 'a') return 0;
        if (ch == 'e') return 1;
        if (ch == 'i') return 2;
        if (ch == 'o') return 3;
        if (ch == 'u') return 4;
        return -1;
    }
}
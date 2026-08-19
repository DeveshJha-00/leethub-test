class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        int res = 2 * n;

        for (int[] seats : reservedSeats) {
            int row = seats[0], seat = seats[1];
            map.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        }

        for (HashSet<Integer> seats : map.values()) {
            boolean left = !seats.contains(2) && !seats.contains(3)
                    && !seats.contains(4) && !seats.contains(5);

            boolean right = !seats.contains(6) && !seats.contains(7)
                    && !seats.contains(8) && !seats.contains(9);

            boolean middle = !seats.contains(4) && !seats.contains(5)
                    && !seats.contains(6) && !seats.contains(7);

            if (left && right) continue;
            else if (left || right || middle) res--;
            else res -= 2;
        }

        return res;
    }
}
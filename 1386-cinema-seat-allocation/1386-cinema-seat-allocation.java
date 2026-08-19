class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, HashSet<Integer>> map = new TreeMap<>();
        int res = 0;

        for (int[] seats : reservedSeats){
            int row=seats[0], seat=seats[1];

            map.computeIfAbsent(row, k -> new HashSet<>()).add(seat);
        }

        for (Map.Entry<Integer, HashSet<Integer>> e : map.entrySet()){
            HashSet<Integer> seats = e.getValue();
            if (!seats.contains(2) && !seats.contains(3) && !seats.contains(4) && !seats.contains(5)){
                res++;
                seats.add(2); seats.add(3); seats.add(4); seats.add(5);
            }

            if (!seats.contains(6) && !seats.contains(7) && !seats.contains(8) && !seats.contains(9)){
                res++;
                seats.add(6); seats.add(7); seats.add(8); seats.add(9);
            }

            if (!seats.contains(4) && !seats.contains(5) && !seats.contains(6) && !seats.contains(7)){
                res++;
                // seats.add(4); seats.add(5); seats.add(6); seats.add(7);
            }
        }

        res += (n - map.size()) * 2;


        return res;
    }
}
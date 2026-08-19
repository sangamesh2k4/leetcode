class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reserved = new HashMap<>();

        for (int[] seat : reservedSeats) {
            reserved
                .computeIfAbsent(seat[0], x -> new HashSet<>())
                .add(seat[1]);
        }
        int ans = 2 * n;
        for (Map.Entry<Integer, Set<Integer>> entry : reserved.entrySet()) {
            Set<Integer> set = entry.getValue();
            boolean left =
                !set.contains(2) &&
                !set.contains(3) &&
                !set.contains(4) &&
                !set.contains(5);
            boolean right =
                !set.contains(6) &&
                !set.contains(7) &&
                !set.contains(8) &&
                !set.contains(9);
            boolean middle =
                !set.contains(4) &&
                !set.contains(5) &&
                !set.contains(6) &&
                !set.contains(7);
            if (left && right) {
            } 
            else if (left || right || middle) {
                ans--;
            } 
            else {
                ans -= 2;
            }
        }
        return ans;
    }
}
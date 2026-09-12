class Solution {
    private int compare(int[] a, int[] b) {
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
            if (a[i] == Integer.MAX_VALUE) {
                return 0;
            }
        }
        return 0;
    }
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];
        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int lo = i + 1;
            int hi = n - 1;
            int ans = n;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (arr[mid][0] > arr[i][1]) {
                    ans = mid;
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            next[i] = ans;
        }
        long[][] dp = new long[n + 1][5];

        int[][][] choice = new int[n + 1][5][4];

        for (int i = 0; i <= n; i++) {
            for (int k = 0; k <= 4; k++) {
                Arrays.fill(choice[i][k], Integer.MAX_VALUE);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int k = 1; k <= 4; k++) {
                long skipScore = dp[i + 1][k];
                int[] skipChoice = choice[i + 1][k];
                long takeScore = arr[i][2] + dp[next[i]][k - 1];
                int[] takeChoice = new int[4];
                Arrays.fill(takeChoice, Integer.MAX_VALUE);
                takeChoice[0] = arr[i][3];
                for (int x = 0; x < 3; x++) {
                    takeChoice[x + 1] = choice[next[i]][k - 1][x];
                }
                Arrays.sort(takeChoice);
                if (takeScore > skipScore) {
                    dp[i][k] = takeScore;
                    choice[i][k] = takeChoice;
                } else if (skipScore > takeScore) {
                    dp[i][k] = skipScore;
                    choice[i][k] = skipChoice;
                } else {
                    dp[i][k] = skipScore;
                    if (compare(takeChoice, skipChoice) < 0) {
                        choice[i][k] = takeChoice;
                    } else {
                        choice[i][k] = skipChoice;
                    }
                }
            }
        }
        int count = 0;
        while (count < 4 &&
               choice[0][4][count] != Integer.MAX_VALUE) {
            count++;
        }
        int[] ans = new int[count];
        for (int i = 0; i < count; i++) {
            ans[i] = choice[0][4][i];
        }
        return ans;
    }
}
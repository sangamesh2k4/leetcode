class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] dp = new int[n + 1];

        // dp[i] = longest suffix of word2 that can be
        // matched in word1[i...n-1]
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];

            if (dp[i + 1] < m &&
                word1.charAt(i) == word2.charAt(m - dp[i + 1] - 1)) {
                dp[i]++;
            }
        }

        int[] ans = new int[m];

        int j = 0;
        boolean usedMismatch = false;

        for (int i = 0; i < n && j < m; i++) {

            // Exact match
            if (word1.charAt(i) == word2.charAt(j)) {
                ans[j++] = i;
            }

            // Use our one allowed mismatch
            else if (!usedMismatch &&
                     dp[i + 1] >= m - j - 1) {

                ans[j++] = i;
                usedMismatch = true;
            }
        }

        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}
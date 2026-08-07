import java.util.*;

/**
 * LeetCode 3348. Smallest Divisible Digit Product II
 * Time:  O(len(num) + log t)   Space: O(len(num))
 */
class Solution {
    private static final int[][] DIGIT_FACTORS = {
        {0,0,0,0}, {0,0,0,0}, {1,0,0,0}, {0,1,0,0}, {2,0,0,0},
        {0,0,1,0}, {1,1,0,0}, {0,0,0,1}, {3,0,0,0}, {0,2,0,0}
    };

    public String smallestNumber(String num, long t) {
        int[] need = new int[4];
        int[] primes = {2, 3, 5, 7};
        for (int i = 0; i < 4; i++) {
            while (t % primes[i] == 0) { t /= primes[i]; need[i]++; }
        }
        if (t != 1) return "-1";

        int[] minDigits = minimalDigitCounts(need);
        int requiredLen = sum(minDigits);
        if (requiredLen > num.length()) return buildAscending(minDigits);

        int[] total = new int[4];
        for (char c : num.toCharArray()) add(total, DIGIT_FACTORS[c - '0']);

        int firstZero = num.indexOf('0');
        if (firstZero == -1) {
            if (covers(total, need)) return num;
            firstZero = num.length();
        }

        int[] suffixFactors = total.clone();
        for (int i = num.length() - 1; i >= 0; i--) {
            int d = num.charAt(i) - '0';
            subtract(suffixFactors, DIGIT_FACTORS[d]);
            if (i > firstZero) continue;

            int spaceAfter = num.length() - 1 - i;
            for (int bigger = d + 1; bigger <= 9; bigger++) {
                int[] remaining = need.clone();
                subtractClamped(remaining, suffixFactors);
                subtractClamped(remaining, DIGIT_FACTORS[bigger]);
                int[] fill = minimalDigitCounts(remaining);
                int fillLen = sum(fill);
                if (fillLen <= spaceAfter) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + bigger));
                    for (int k = 0; k < spaceAfter - fillLen; k++) sb.append('1');
                    sb.append(buildAscending(fill));
                    return sb.toString();
                }
            }
        }

        int[] fill = minimalDigitCounts(need);
        int fillLen = sum(fill);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < num.length() + 1 - fillLen; k++) sb.append('1');
        sb.append(buildAscending(fill));
        return sb.toString();
    }

    private int[] minimalDigitCounts(int[] need) {
        int e2 = Math.max(need[0], 0), e3 = Math.max(need[1], 0);
        int e5 = Math.max(need[2], 0), e7 = Math.max(need[3], 0);
        int c8 = e2 / 3; e2 %= 3;
        int c9 = e3 / 2; e3 %= 2;
        int c4 = e2 / 2; int c2 = e2 % 2;
        int c3 = e3, c6 = 0;
        if (c2 == 1 && c3 == 1) { c2 = 0; c3 = 0; c6 = 1; }
        if (c3 == 1 && c4 == 1) { c2 = 1; c6 = 1; c3 = 0; c4 = 0; }
        return new int[] { c2, c3, c4, e5, c6, e7, c8, c9 };
    }

    private String buildAscending(int[] counts) {
        StringBuilder sb = new StringBuilder();
        for (int digit = 2; digit <= 9; digit++)
            for (int k = 0; k < counts[digit - 2]; k++) sb.append((char) ('0' + digit));
        return sb.toString();
    }

    private void add(int[] a, int[] b) { for (int i = 0; i < a.length; i++) a[i] += b[i]; }
    private void subtract(int[] a, int[] b) { for (int i = 0; i < a.length; i++) a[i] -= b[i]; }
    private void subtractClamped(int[] a, int[] b) { for (int i = 0; i < a.length; i++) a[i] = Math.max(0, a[i] - b[i]); }
    private boolean covers(int[] have, int[] need) { for (int i = 0; i < have.length; i++) if (have[i] < need[i]) return false; return true; }
    private int sum(int[] a) { int s = 0; for (int v : a) s += v; return s; }
}
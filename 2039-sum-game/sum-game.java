class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int qLeft = 0, qRight = 0;
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                qLeft++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qRight++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }
        int diff = leftSum - rightSum;
        int qDiff = qLeft - qRight;
        return 2 * diff != -9 * qDiff;
    }
}
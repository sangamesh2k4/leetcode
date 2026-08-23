class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftSum = 0, rightSum = 0;
        int qLeft = 0, qRight = 0;
        
        // First half
        for (int i = 0; i < n / 2; i++) {
            if (num.charAt(i) == '?') {
                qLeft++;
            } else {
                leftSum += num.charAt(i) - '0';
            }
        }
        
        // Second half
        for (int i = n / 2; i < n; i++) {
            if (num.charAt(i) == '?') {
                qRight++;
            } else {
                rightSum += num.charAt(i) - '0';
            }
        }
        
        int diff = leftSum - rightSum;
        int qDiff = qLeft - qRight;
        
        // Alice wins if Bob cannot force diff to be 0
        // Bob wins if 2 * diff == -9 * qDiff
        return 2 * diff != -9 * qDiff;
    }
}

import java.util.*;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0]) {
                    return Integer.compare(a[0], b[0]);
                }
                return Integer.compare(a[1], b[1]);
            }
        );
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> {if (a[0] != b[0]) {
                    return Long.compare(a[0], b[0]);
                }
                if (a[1] != b[1]) {
                    return Long.compare(a[1], b[1]);
                }
                return Long.compare(a[2], b[2]);
            }
        );
        for (int i = 0; i < servers.length; i++) {
            available.offer(new int[]{servers[i], i});
        }
        int[] ans = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= i) {
                long[] server = busy.poll();
                available.offer(new int[]{(int) server[1],(int) server[2]});
            }
            if (!available.isEmpty()) {
                int[] server = available.poll();
                ans[i] = server[1];
                busy.offer(new long[]{(long) i + tasks[i],server[0],server[1]});
            } else {
                long[] server = busy.poll();
                ans[i] = (int) server[2];
                busy.offer(new long[]{server[0] + tasks[i],server[1],server[2]});
            }
        }
        return ans;
    }
}
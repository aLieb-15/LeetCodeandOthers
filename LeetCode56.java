import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode56 {
    public static void main(String[] args) {
        int[][] in = { { 2, 6 }, { 1, 3 }, { 8, 10 }, { 15, 18 } };
        merge(in);
    }

    public static int[][] merge(int[][] intervals) {
        int len = intervals.length;
        if (len == 1) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        boolean[] used = new boolean[len];
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            int far = intervals[i][1];
            for (int j = i + 1; j < len; j++) {
                if (used[j]) {
                    continue;
                }
                int jl = intervals[j][0];
                if (far < jl) {
                    used[i] = true;
                    break;
                } else {
                    far = Math.max(far, intervals[j][1]);
                    used[j] = true;
                }
            }
            int[] tmp = new int[2];
            tmp[0] = intervals[i][0];
            tmp[1] = far;
            res.add(tmp);
        }
        int[][] ans = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        return ans;
    }
}

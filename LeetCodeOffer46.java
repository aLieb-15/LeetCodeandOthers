import java.util.ArrayList;
import java.util.List;

import javafx.stage.StageStyle;

public class LeetCodeOffer46 {
    public static void main(String[] args) {
        System.out.println(translateNum(506));
    }
    /**
     * 给定数字num，将其翻译为字符串
     * 翻译规则如下：
     * 0-a, 1-b, 2-c,..., 11-l,..., 25-z
     * n >= 0
     * @param num
     * @return
     */
    public static int translateNum(int num) {
        if (num < 10) {
            return 1;
        }
        List<Integer> record = new ArrayList<>();
        while (num != 0) {
            record.add(num % 10);
            num = num / 10;
        }
        int len = record.size();
        int[] array = new int[len + 1];
        array[0] = 0;
        for (int i = 1; i <= len; i++) {
            array[i] = record.get(len - i);
        }
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            int sum = array[i-1] * 10 + array[i];
            if (array[i - 1] != 0 && sum < 26) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }
}

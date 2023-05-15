import java.util.Arrays;

class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }
        memo = new int[amount];

        return findWay(coins,amount);
    }
    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins,int amount){
        if(amount < 0){
            return -1;
        }
        if(amount == 0){
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        if(memo[amount-1] != 0){
            return memo[amount-1];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i < coins.length;i++){
            int res = findWay(coins,amount-coins[i]);
            if(res >= 0 && res < min){
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount-1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount-1];
    }
}

// class Solution {
//     public int[] coins;
//     public int res = Integer.MAX_VALUE;
//     public int[] memo;
//     public int amount;
//     public int coinChange(int[] coins, int amount) {
//         this.coins = coins;
//         this.amount = amount;
//         memo = new int[amount + 1];
//         memo[0] = 0;
//         Arrays.fill(memo, amount + 1);
//         res = dfs(amount);
//         if (res == Integer.MAX_VALUE) {
//             return -1;
//         }
//         return res;
//     }

//     public int dfs(int n) {
//         if (n < 0) {
//             return -1;
//         }
//         if (n == 0) {
//             return 0;
//         }
//         if (memo[n] != amount + 1) {
//             return memo[n];
//         }
//         int min = Integer.MAX_VALUE;
//         for (int coin : coins) {
//             int tmp = dfs(n - coin);
//             if (tmp >= 0 && tmp < min) {
//                 min = tmp + 1;
//             }
//             // if (tmp == -1) {
//             //     continue;
//             // }
//             // min = Math.min(min, 1 + tmp);
//         }
//         if (min == Integer.MAX_VALUE) {
//             return -1;
//         }
//         memo[n] = min;
//         return min;
//     }
// }

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = {186,419,83,408};
        System.out.println(s.coinChange(coins, 6249));
    }
}
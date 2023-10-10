package ByteDance;

public class MaxBitwiseORFromThreeStacks {
    public static int maxBitwiseOR(int[] stack1, int[] stack2, int[] stack3, int k) {
        int[] maxOR = new int[1];
        maxOR[0] = Integer.MIN_VALUE; // 初始化maxOR为最小值

        // 调用递归函数
        findMaxBitwiseOR(stack1, stack2, stack3, 0, 0, 0, 0, k, maxOR);

        return maxOR[0];
    }

    private static void findMaxBitwiseOR(int[] stack1, int[] stack2, int[] stack3,
            int i, int j, int l, int currentOR, int k, int[] maxOR) {
        if (i >= stack1.length || j >= stack2.length || l >= stack3.length || k == 0) {
            // 到达数组末尾或已经取得k个数，更新maxOR
            maxOR[0] = Math.max(maxOR[0], currentOR);
            return;
        }

        // 从三个栈中依次取出数
        int num1 = stack1[i];
        int num2 = stack2[j];
        int num3 = stack3[l];

        // 选择一个栈中的数，更新currentOR并递归
        findMaxBitwiseOR(stack1, stack2, stack3, i + 1, j, l, currentOR | num1, k - 1, maxOR);
        findMaxBitwiseOR(stack1, stack2, stack3, i, j + 1, l, currentOR | num2, k - 1, maxOR);
        findMaxBitwiseOR(stack1, stack2, stack3, i, j, l + 1, currentOR | num3, k - 1, maxOR);
    }

    public static void main(String[] args) {
        int[] stack1 = { 1, 2, 3, 4 };
        int[] stack2 = { 2, 2, 3, 4 };
        int[] stack3 = { 4, 2, 3, 4 };
        int k = 2;

        int result = maxBitwiseOR(stack1, stack2, stack3, k);
        System.out.println("按位或最大值是：" + result); // 输出：按位或最大值是：7
    }
}
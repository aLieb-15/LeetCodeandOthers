import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class sortAlgos {
    public static void main(String[] args) {
        int[] check = changeInteger(generateIArr(50));
        // int[] check = {5, 4, 3, 2, 1};
        printArray(check);
        // testQuickSort(check);
        // testBubbleSort(check);
        // testInsertSort(check);
        // testSelectSort(check);
        // testShellSort(check);
        // testMergeSort(check);
        // testHeapSort(check);
        testQuickProSort(check);
    }

    /**
     * 将Integer数组转换为int数组
     * @param arr
     * @return
     */
    public static int[] changeInteger(Integer[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i].intValue();
        }
        return ans;
    }

    /**
     * 将int数组转换为Integer数组
     * @param arr
     * @return
     */
    public static Integer[] changeInt(int[] arr) {
        Integer[] ans = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = Integer.valueOf(arr[i]);
        }
        return ans;
    }

    /**
     * 将int数组arr进行逆序排序
     * @param arr
     */
    public static void arrayReverseSort(int[] arr) {
        Arrays.sort(changeInt(arr), (o1, o2) -> o1 < o2 ? -1 : 1);
    }

    /**
     * 将Integer数组arr进行逆序排序
     * @param arr
     */
    public static void arrayReverseSort(Integer[] arr) {
        Arrays.sort(arr, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
    }

    /**
     * 使用随机数生成一个int数组
     * @param len
     * @return
     */
    public static int[] generateArr(int len) {
        int[] arr = new int[len];
        Random r = new Random();
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int tmp = r.nextInt(len + 1);
            while (tempSet.contains(tmp)) {
                tmp = r.nextInt(len + 1);
            }
            tempSet.add(tmp);
            arr[i] = tmp;
        }
        return arr;
    } 

    /**
     * 使用随机数生成一个Integer数组
     * @param len
     * @return
     */
    public static Integer[] generateIArr(int len) {
        Integer[] arr = new Integer[len];
        Random r = new Random();
        Set<Integer> tempSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int tmp = r.nextInt(len + 1);
            while (tempSet.contains(tmp)) {
                tmp = r.nextInt(len + 1);
            }
            tempSet.add(tmp);
            arr[i] = tmp;
        }
        return arr;
    }

    /**
     * 打印nums数组
     * @param nums
     */
    public static void printArray(int[] nums) {
        System.out.print("Array:");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("Array length:" + nums.length);
    }

    /**
     * 打印nums数组中的[l, r]位
     * @param nums
     * @param l
     * @param r
     */
    public static void printArray(int[] nums, int l, int r) {
        System.out.print("Array:");
        for (int i = l; i <= r; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        System.out.println("Array printed length:" + (r - l + 1));
    }

    /**
     * 交换数组中下标为i和j的元素，带越界检查
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int len = nums.length;
        if (i >= len || j >= len) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 测试快速排序，输出使用时间
     * @param nums
     */
    public static void testQuickSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        quickSort(nums, 0, nums.length - 1);
        long eTime = System.currentTimeMillis();
        System.out.println("Quick sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 对数组nums进行快速排序（升序）
     * @param nums
     * @param l
     * @param r 数组下标右边界，这个值应该是可以取到的，调用的时候应该为数组长度-1
     */
    public static void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pivot =partitionRandom(nums, l, r);
            // int pivot =partition(nums, l, r);
            quickSort(nums, l, pivot - 1);
            quickSort(nums, pivot + 1, r);
        }
    }

    /**
     * 快速排序用到的划分函数
     * @param nums
     * @param p
     * @param r
     * @return
     */
    public static int partition(int[] nums, int p, int r) {
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (nums[j] <= nums[r]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 快速排序用到的随机划分函数
     * 每次划分之前都随机在范围内找一个主元
     * 避免遇到基本有序序列还是使用最后一个元素做主元的情况
     * 对于长度为
     * @param nums
     * @param p
     * @param r
     * @return
     */
    public static int partitionRandom(int[] nums, int p, int r) {
        int i = p - 1;
        Random random = new Random();
        int randomIndex = random.nextInt(r - p + 1) + p;
        swap(nums, r, randomIndex);
        for (int j = p; j < r; j++) {
            if (nums[j] <= nums[r]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, r);
        return i + 1;
    }

    /**
     * 交换法实现的快速排序测试方法
     * @param nums
     */
    public static void testQuickProSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        quickSortPro(nums, 0, nums.length - 1);
        long eTime = System.currentTimeMillis();
        System.out.println("Quick sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 使用交换法实现的快速排序
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSortPro(int[] nums, int l, int r) {
        if(l >= r) {
            return;
        }
        int i = l;
        int j = r;
        int pivot = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, l);
        quickSortPro(nums, l, i-1);
        quickSortPro(nums, j + 1, r);
    }

    public static void testBubbleSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        bubbleSort(nums);
        long eTime = System.currentTimeMillis();
        System.out.println("Bubble sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 对数组nums进行冒泡排序（升序）
     * 对数组中的相邻元素进行两两比较，将大的放到后面去
     * @param nums
     */
    public static void bubbleSort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
        }
    }

    public static void testInsertSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        insertSort(nums);
        long eTime = System.currentTimeMillis();
        System.out.println("Insert sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 对数组nums进行插入排序（升序）
     * @param nums
     */
    public static void insertSort(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            // 这里一定要使用tmp记录nums[i]，并在之后的步骤中使用
            // 因为下边的j+1可能会覆盖nums[i]，造成排序错误
            int tmp = nums[i];
            int j = i - 1;
            // 由于数组的性质，要从后往前遍历，顺便把要放置元素的位置腾出来
            for (; j >= 0; j--) {
                if (nums[j] > tmp) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = tmp;
        }
    }

    public static void testShellSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        shellSort(nums);
        long eTime = System.currentTimeMillis();
        System.out.println("Shell sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 希尔排序，改进版的插入排序，把整个数组按照gap分成了几组
     * @param nums
     */
    public static void shellSort(int[] nums) {
        int[] drr = new int[]{5, 2, 1};
        for (int i = 0; i < drr.length; i++) {
            shell(nums, drr[i]);
        }
    }

    public static void shell(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int j = i - gap;
            // 和插入排序同理，必须使用tmp记录这最后一位
            int tmp = nums[i];
            for (; j >=0; j -= gap) {
                if (nums[j] > tmp) {
                    nums[j + gap] = nums[j];
                } else {
                    break;
                }
            } 
            nums[j + gap] = tmp;
        }
    }

    public static void testSelectSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        selectSort(nums);
        long eTime = System.currentTimeMillis();
        System.out.println("Select sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 选择排序，每趟从无序子串中选一个最小的放在前面，直到整个数组有序
     * @param nums
     */
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        } 
    }

    public static void testMergeSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        mergeSort(nums, 0, nums.length - 1);
        long eTime = System.currentTimeMillis();
        System.out.println("Merge sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 归并排序
     * 前两个递归的mergeSort是拆分过程
     * 最后的merge是合并过程
     * @param nums
     * @param l
     * @param r
     */
    public static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r, mid);
        printArray(nums, l, r);
    }

    /**
     * 将两个数组合并
     * 左数组范围为[l, mid]
     * 右数组范围为[mid + 1, r]
     * @param nums
     * @param l
     * @param r
     * @param mid
     */
    public static void merge(int[] nums, int l, int r, int mid) {
        // 问题等价于把两个数组合并到一个数组中
        int[] temp = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                temp[k] = nums[i];
                k++;
                i++;
            } else {
                temp[k] = nums[j];
                k++;
                j++;
            }
        }
        while (i <= mid) {
            temp[k] = nums[i];
            k++;
            i++;
        }
        while (j <= r) {
            temp[k] = nums[j];
            k++;
            j++;
        }
        for (int x = 0; x < temp.length; x++) {
            nums[x + l] = temp[x];
        }
    }

    public static void testHeapSort(int[] nums) {
        long sTime = System.currentTimeMillis();
        heapSort(nums);
        long eTime = System.currentTimeMillis();
        System.out.println("Heap sort end, time used:" + (eTime - sTime));
        System.out.println("Sorted array:");
        printArray(nums);
    }

    /**
     * 堆排序
     * 利用大根堆，将数组视作一个完全二叉树
     * 每次从小根堆顶取走元素，并重新构建小根堆
     * 直到所有元素被取完为止
     * @param nums
     */
    public static void heapSort(int[] nums) {
        // int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            heapAdjust(nums, i + 1);
            swap(nums, 0, i);
            printArray(nums);
        }
    }

    /**
     * 调整数组nums
     * 使其成为一个大根堆
     * @param nums
     */
    public static void heapAdjust(int[] nums, int len) {
        if (len == 1) {
            return;
        }
        int last = len / 2 - 1;
        int left = 0, right = 0;
        // 判断最后一个非叶子节点是否有右子
        // 把判断逻辑挪到for外面来，因为只有这一个节点要判断是不是有右子
        // 这个节点是必定有左子的，否则就是叶子节点了
        boolean hasRight = false;
        if (last * 2 + 2 < len) {
            hasRight = true;
        }
        if (hasRight) {
            left = nums[last * 2 + 1];
            right = nums[last * 2 + 2];
            int max = Math.max(left, right);
            // 这下边可千万别用left和right赋值
            if (max > nums[last]) {
                int tmp = nums[last];
                nums[last] = max;
                if (left > right) {
                    nums[last * 2 + 1] = tmp;
                } else {
                    nums[last * 2 + 2] = tmp;
                }
            }
        } else {
            // 别忘了last有左子，且左子大于他的情况（
            if (nums[last * 2 + 1] > nums[last]) {
                swap(nums, last, last * 2 + 1);
            }
        }

        for (int i = last - 1; i >= 0; i--) {
            left = nums[2 * i + 1];
            right = nums[2 * i + 2];
            int max = Math.max(left, right);
            if (max > nums[i]) {
                int tmp = nums[i];
                nums[i] = max;
                if (left > right) {
                    nums[2 * i + 1] = tmp;
                } else {
                    nums[2 * i + 2] = tmp;
                }
            }
        }
        System.out.print("Heap Adjusted:");
        printArray(nums);
    }
}

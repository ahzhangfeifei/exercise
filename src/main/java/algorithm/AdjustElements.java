package algorithm;

/**
 * @desc 调整数组顺序使奇数位于偶数的前面
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/12.
 */
public class AdjustElements {
    public static void order(int[] array) {
        if (array == null || array.length == 0)
            return;
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isEven(array[start]))
                start++;
            while (start < end && isEven(array[end]))
                end--;
            if (start < end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
    }

    private static boolean isEven(int num) {
        return (num & 1) == 0;
    }

    private static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5};
        order(arr);
        for(int i : arr) {
            System.out.print(" " + i);
        } System.out.println();
    }
}

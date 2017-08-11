package com.algorithm;

/**
 * @desc 旋转数组中的最小数字
 * @company tuniu.com
 * Created by zhangfeifei2 on 2017/7/11.
 */
public class ReverseList {

    public static int minInReverseList(int[] arr) {
        if (arr == null) {
            return -1;
        }
        int leftIndex = 0;
        int rightIndex = arr.length - 1;
        int midIndex = leftIndex;
        while (arr[leftIndex] >= arr[rightIndex]) {
            if (rightIndex - leftIndex <= 1) {
                midIndex = rightIndex;
                break;
            }
            midIndex = (leftIndex + rightIndex) / 2;
            if (arr[leftIndex] == arr[rightIndex] && arr[leftIndex] ==
                    arr[rightIndex]) {
                return minInOrder(arr, leftIndex, rightIndex);
            }
            if (arr[midIndex] >= arr[leftIndex]) {
                leftIndex = midIndex;
            } else if (arr[midIndex] < arr[rightIndex]) {
                rightIndex = midIndex;
            }
        }
        return arr[midIndex];
    }

    public static int minInOrder(int[] arr, int leftIndex, int rightIndex) {
        int min = arr[leftIndex];
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}

package com.vincent;

/**
 * @author vincent
 * @date 2021/8/26 14:56
 */
public class SelectionSort {


    public static void main(String[] args) {
        int i = 10;
        int b = ((i << 1) | 1);
        System.out.println(b);
    }

    /**
     * 随机数组
     *
     * @param maxSize
     * @param maxValue
     * @return
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        // Math.random()  [0,1)
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());

        }
        return arr;
    }

    /**
     * 判断两个数组是否相等
     *
     * @param arr1 数组1
     * @param arr2 数组2
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

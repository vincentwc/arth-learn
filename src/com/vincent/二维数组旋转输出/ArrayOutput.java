package com.vincent.二维数组旋转输出;

import java.util.ArrayList;

public class ArrayOutput {

    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5},
                {16, 17, 18, 19, 6},
                {15, 24, 25, 20, 7},
                {14, 23, 22, 21, 8},
                {13, 12, 11, 10, 9}
        };
        int[] ints = outPutArray(arr, 5, 5);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static int min(int a, int b) {
        return Math.min(a, b);
    }


    public static int[] outPutArray(int[][] array, int M, int N) {
        int[] result = new int[M * N];
        int count = 1;  //圈数
        int k = 0; //result[] 下标
        while (count <= (min(M, N) + 1) / 2) {
            //从左到右横向打印
            for (int i = count - 1; i < N - count; i++) {
                result[k] = array[count - 1][i];
                k++;
            }
            //从上到下纵向打印
            for (int i = count - 1; i < M - count; i++) {
                result[k] = array[i][N - count];
                k++;
            }
            //从右到左横向打印
            for (int i = N - count; i > count - 1; i--) {
                result[k] = array[M - count][i];
                k++;
            }
            //从下到上纵向打印
            for (int i = M - count; i > count - 1; i--) {
                result[k] = array[i][count - 1];
                k++;
            }
            count++;
        }
        /* 当最后一圈只有一个元素[如3*3数组]时，上述循环不会执行，
         * 需将最后一个元素插入到数组result中
         */
        if (k < M * N) {
            result[k] = array[count - 2][count - 2];
        }
        return result;
    }
}
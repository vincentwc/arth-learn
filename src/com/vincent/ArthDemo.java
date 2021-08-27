package com.vincent;

import com.vincent.单向链表.Node;
import org.junit.Test;

/**
 * @author vincent
 * @date 2021/8/26 16:26
 */
public class ArthDemo {

    /**
     * 两个int数字交换[中途不申请额外变量]
     */
    @Test
    public void test1() {
        int a = 10;
        int b = 20;
        // a = 10^20,b=20
        a = a ^ b;
        // a = 10^20,b=10^20^20 = 10   分析：20^20 = 0 ，任意数^0=任意数
        b = a ^ b;
        // a = 10^20^10 = 20, b = 10;
        a = a ^ b;
        System.out.println(a);
        System.out.println(b);

    }

    /**
     * 一个数组中只有一个数字出现奇数次，其他数都出现偶数次，怎么找到并打印这种数
     * 思路：集合一定是奇数个，直接排序然后取中间的值
     * 高级思路：直接eor变量去异或运算数组里面的每个数字，最后的值就是需要的值
     */
    @Test
    public void test2() {
        int eor = 0;
        int[] arr = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        System.out.println(eor);
    }

    /**
     * 怎么把一个整形数，提取出最右侧的1来  N&(^N + 1)
     * int N
     * N = 0 0 0 0 1 1 1 0 1 0 0 取反
     * 1 1 1 1 0 0 0 1 0 1 1 +1
     * 1 1 1 1 0 0 0 1 1 0 0 & N
     * 0 0 0 0 1 1 1 0 1 0 0
     * N = 0 0 0 0 0 0 0 0 1 0 0
     */
    @Test
    public void test3() {
//        1 1 1 0
        int n = 7;
//        ~n            0 0 0 1
//        ~n +1         0 0 1 1
//        n&(~n + 1)
        /**
         * 1 1 1 0
         * 0 0 1 1
         *
         * 0 0 1 0
         */
        int i = n & (~n + 1);
    }

    /**
     * 一个数组中，有两个数出现奇数次，其他数都出现偶数次，打印出两个基数信息
     * 假设这两个奇数是a和b 把所有的数组异或运算获取最后的值，其实最终就是a和b的异或运算
     */
    @Test
    public void test4() {
        int eor = 0;
        int[] arr = {1, 2, 3, 4, 5, 6, 4, 3, 2, 1};
        for (int i = 0; i < arr.length; i++) {
            eor = eor ^ arr[i];
        }
        // 此处获取到的是a和b的异或运算结果
        // 找出eor中最右侧的1
        int rightOne = eor & (~eor + 1);
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            if ((arr[i] & rightOne) != 0) {
                // 这一步就可以把两个奇数分开 --> rightOne位置为1的进行异或运算
                onlyOne ^= arr[i];
            }
        }
        // 此时  eor = 5^6
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    /**
     * 获取一个数中1的个数二进制
     * <p>
     * 011011010000
     * 000000010000
     * <p>
     * 011011000000
     */
    @Test
    public void test5() {
        int count = 0;
        int n = 10;
        while (n != 0) {
            // 获取最右边的1
            int rightOne = n & (~n + 1);
            // 把最右边的1去掉[异或运算]
            n ^= rightOne;
            count++;
        }
        System.out.println(count);
    }


    /**
     * 单链表反转
     * 双链表反转
     */
    @Test
    public void test06() {
        Node pre = null;
        Node next = null;
        Node head = new Node(1);
        Node head2 = new Node(2);
        Node head3 = new Node(3);
        head.setNext(head2);
        head2.setNext(head3);
        System.out.println(head);
        while (head != null) {
            // head的next赋值
            next = head.next;
            // next指针指向之前
            head.next = pre;
            // 移动pre的指针
            pre = head;
            // head往下跳
            head = next;
        }
        System.out.println(pre);
    }
}

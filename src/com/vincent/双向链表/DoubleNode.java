package com.vincent.双向链表;

/**
 * @author vincent
 * @date 2021/8/26 17:59
 */
public class DoubleNode<T> {

    public T value;
    public DoubleNode last;
    public DoubleNode next;

    public DoubleNode(T value) {
        this.value = value;
    }
}

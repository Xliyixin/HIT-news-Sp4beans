package com.Sp4beans.spider;

import java.util.LinkedList;

/**
 * ����
 *
 */
public class Queue {
	private LinkedList<String> queue = new LinkedList<String>();

	// ���
	public void enQueue(String t) {
		queue.addLast(t);
	}

	// ����
	public String deQueue() {
		return queue.removeFirst();
	}

	// �ж϶����Ƿ�Ϊ��
	public boolean isQueueEmpty() {
		return queue.isEmpty();
	}

	// �������Ƿ����t
	public boolean contains(Object t) {
		return queue.contains(t);
	}
}

package com._wzzit_01;

import java.util.LinkedList;
import java.util.Queue;

public class Lianxi02 {

	class TNode {
		String value;

		TNode left, right;
	}

	//递归	
	public static void TransLevel(TNode tree, int level) {
		if (tree == null)
			return;
		else {
			if (level == 1)
				System.out.println(tree.value);
			else {
				TransLevel(tree.left, level - 1);
				TransLevel(tree.right, level - 1);
			}
		}
	}

	//非递归
	public static void treeLevel(TNode tree, int level) {
		//如果根节点为空则直接返回
		if (tree == null)
			return;
		Queue<TNode> ll = new LinkedList<>();
		//将根节点加入队列
		ll.add(tree);
		int countlevel = 1; //当前层的节点数
		int countnode, levelnode;
		TNode q;
		while (!ll.isEmpty()) {
			if (countlevel == level)
				break;
			countnode = 0;
			levelnode = ll.size();
			while (countnode < levelnode) {
				q = ll.poll();
				if (q.left != null)
					ll.add(q.left);
				if (q.right != null)
					ll.add(q.right);
				countnode++;
			}
			countlevel++;
		}
		for (TNode tNode : ll) {
			System.out.println(tNode.value);
		}
	}
}

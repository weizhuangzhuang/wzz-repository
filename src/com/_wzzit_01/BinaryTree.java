package com._wzzit_01;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com._wzzit_01.Lianxi02.TNode;

/**
 * 
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>succez</p>
 * @author wzz
 * @createdate 2018年9月13日
 */
public class BinaryTree {

	private String[] array = { "A", "B", "C", "D", "E", "F", "G" };

	private static List<TNode> nodeList = null;

/**
 * 
 * <p>Copyright: Copyright (c) 2018</p>
 * <p>succez</p>
 * @author wzz
 * @createdate 2018年9月13日
 * 内部类
 */
	private static class TNode {
		TNode left;

		TNode right;

		String value;

		TNode(String newvalue) {
			left = null;
			right = null;
			value = newvalue;
		}
	}

	public void createBinTree() {
		nodeList = new LinkedList<TNode>();
		// 将一个数组的值依次转换为TNode节点  
		for (int TNodeIndex = 0; TNodeIndex < array.length; TNodeIndex++) {
			nodeList.add(new TNode(array[TNodeIndex]));
		}
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
		for (int parentIndex = 0; parentIndex < array.length / 2 - 1; parentIndex++) {
			// 左孩子  
			nodeList.get(parentIndex).left = nodeList.get(parentIndex * 2 + 1);
			// 右孩子  
			nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
		}
		// 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理  
		int lastParentIndex = array.length / 2 - 1;
		// 左孩子  
		nodeList.get(lastParentIndex).left = nodeList.get(lastParentIndex * 2 + 1);
		// 右孩子,如果数组的长度为奇数才建立右孩子  
		if (array.length % 2 == 1) {
			nodeList.get(lastParentIndex).right = nodeList.get(lastParentIndex * 2 + 2);
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
	//递归
	public static void TransLevel(TNode root,int level)
	{
	    if(root == null)
	        return ;
	    else
	    {
	        if(level == 1)
	          System.out.println(root.value);
	        else
	        {
	            TransLevel(root.left,level-1);
	            TransLevel(root.right,level-1);
	        }
	    }
	}
	public static void main(String[] args) {
		BinaryTree binTree = new BinaryTree();
		binTree.createBinTree();
		// nodeList中第0个索引处的值即为根节点  
		TNode root = nodeList.get(0);
		treeLevel(root, 3);
		System.out.println("==========");
		TransLevel(root, 3);
	}
}

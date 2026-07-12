package templates;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : Flowers6
 * @version : v1.0
 * @description :
 * @date : 2026/7/12
 * @time : 14:30
 */
public class BinarySearchTree {

    // 二叉树的遍历框架
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        traverse(root.left);
        // 中序位置
        traverse(root.right);
        // 后序位置
    }

    void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            // 访问 cur 节点
            System.out.println(cur.val);

            // 把 cur 的左右子节点加入队列
            if (cur.left != null) {
                q.offer(cur.left);
            }
            if (cur.right != null) {
                q.offer(cur.right);
            }
        }
    }

}

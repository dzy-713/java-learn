package com.dzy.leet;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中的中序遍历
 * 给定一个二叉树，返回它的中序 遍历。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,null,2,3]
 * 1
 * \
 * 2
 * /
 * 3
 * <p>
 * 输出: [1,3,2]
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author douzy
 * @date 2020-01-13.
 */
public class Question0094 {


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        midOrderTraversal(root,result);
        return result;
    }

    public void midOrderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if(root.left != null) {
            midOrderTraversal(root.left, result);
        }
        result.add(root.val);
        if(root.right != null) {
            midOrderTraversal(root.right, result);
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        List<Integer> result = new Question0094().inorderTraversal(treeNode);
        System.out.println(result);
    }
}

@Setter
@Getter
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
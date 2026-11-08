import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class LTC94 {

    // TODO: Study Morris Traversal

    // Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        // Inorder: Left - Root - Right (Preorder: Root - Left - Right, Postorder: Left - Right - Root)

        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            result.add(current.val);

            current = current.right;
        }

        return result;
    }

//    // Recursive
//    public List<Integer> inorderTraversal(TreeNode root) {
//        // Inorder: Left - Root - Right (Preorder: Root - Left - Right, Postorder: Left - Right - Root)
//
//        List<Integer> result = new ArrayList<>();
//
//        traverseTree(root, result);
//
//        return result;
//    }
//
//    private void traverseTree(TreeNode node, List<Integer> result) {
//        if (node == null) {
//            return;
//        }
//
//        traverseTree(node.left, result); // Left Child (Subtree)
//        result.add(node.val); // Root (Current Node)
//        traverseTree(node.right, result); // Right Child (Subtree)
//    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}

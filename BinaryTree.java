import java.util.*;
import java.util.LinkedList;
// import java.custom.util.Pair;

public class BinaryTree {
    private static void printLists(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static void preOrder(Node root, List<Integer> ans) {
        if (root == null)
            return;
        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }

    private static void inOrder(Node root, List<Integer> ans) {
        if (root == null)
            return;
        inOrder(root.left, ans);
        ans.add(root.val);
        inOrder(root.right, ans);
    }

    private static void postOrder(Node root, List<Integer> ans) {
        if (root == null)
            return;
        postOrder(root.left, ans);
        postOrder(root.right, ans);
        ans.add(root.val);
    }

    private static List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        if (root == null)
            return levelOrder;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                subList.add(queue.peek().val);
                if (queue.peek().left != null)
                    queue.add(queue.peek().left);
                if (queue.peek().right != null)
                    queue.add(queue.peek().right);
                queue.remove();
            }
            levelOrder.add(subList);
        }
        return levelOrder;
    }

    private static List<Integer> iterativePreOrder(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        if (root == null)
            return preOrder;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.peek();
            st.pop();
            preOrder.add(root.val);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preOrder;
    }

    private static List<Integer> iterativeInOrder(Node root) {
        List<Integer> inOrder = new ArrayList<>();
        if (root == null)
            return inOrder;
        Stack<Node> st = new Stack<>();
        while (true) {
            if (root != null) {
                st.push(root);
                root = root.left;
            } else {
                if (st.empty())
                    break;
                root = st.peek();
                st.pop();
                inOrder.add(root.val);
                root = root.right;
            }
        }
        return inOrder;
        //
    }

    private static List<Integer> iterativePostOrderWithTwoStack(Node root) {
        List<Integer> postOrder = new LinkedList<>();
        if (root == null)
            return postOrder;
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.isEmpty()) {
            root = st1.peek();
            st1.pop();
            st2.add(root);
            if (root.left != null)
                st1.push(root.left);
            if (root.right != null)
                st1.push(root.right);
        }
        while (!st2.isEmpty()) {
            postOrder.add(st2.peek().val);
            st2.pop();
        }
        return postOrder;
        // Tc -> O(2n);
        // sc -> O(2n);
    }

    private static List<Integer> iterativePostOrderWithOneStack(Node cur) {
        List<Integer> postOrder = new LinkedList<>();
        if (cur == null)
            return postOrder;
        Stack<Node> st = new Stack<>();
        while (cur != null || !st.isEmpty()) {
            if (cur != null) {
                st.add(cur);
                cur = cur.left;
            } else {
                Node temp = st.peek().right;
                if (temp == null) {
                    temp = st.peek();
                    st.pop();
                    postOrder.add(temp.val);
                    while (!st.isEmpty() && temp == st.peek().right) {
                        temp = st.peek();
                        st.pop();
                        postOrder.add(temp.val);
                    }
                } else
                    cur = temp;
            }
        }
        return postOrder;
        // tc -> O(2n);
    }

    private static List<List<Integer>> AllBFSTraversal(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();

        Stack<Pair<Node, Integer>> st = new Stack<>();
        st.push(new Pair<>(root, 1));
        while (!st.isEmpty()) {
            var it = st.peek();
            st.pop();
            if (it.getValue() == 1) {
                preOrder.add(it.getKey().val);
                it.setValue(2);
                st.push(it);
                if (it.getKey().left != null) {
                    st.push(new Pair<>(it.getKey().left, 1));
                }
            } else if (it.getValue() == 2) {
                inOrder.add(it.getKey().val);
                it.setValue(3);
                st.push(it);
                if (it.getKey().right != null) {
                    st.push(new Pair<>(it.getKey().right, 1));
                }
            } else {
                postOrder.add(it.getKey().val);
            }
        }
        res.add(preOrder);
        res.add(inOrder);
        res.add(postOrder);
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        // preOrder(root, pre);
        // System.out.println(pre);
        // System.out.println(iterativePreOrder(root));
        // inOrder(root, in);
        // System.out.println(in);
        // System.out.println(iterativeInOrder(root));
        // postOrder(root, post);
        // System.out.println(post);
        // System.out.println(iterativePostOrderWithTwoStack(root));
        // System.out.println(iterativePostOrderWithOneStack(root));
        // printLists(levelOrder(root));
        printLists(AllBFSTraversal(root));

    }
}

class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    };

};

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}

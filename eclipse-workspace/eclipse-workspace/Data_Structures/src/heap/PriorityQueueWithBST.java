package heap;

import java.util.Comparator;

class Node<E> {
    E data;
    int priority;
    Node<E> left, right;

    public Node(E data, int priority) {
        this.data = data;
        this.priority = priority;
        this.left = this.right = null;
    }
}

public class PriorityQueueWithBST<E> {
    private Node<E> root;
    private Comparator<E> comparator;

    public PriorityQueueWithBST(Comparator<E> comparator) {
        this.root = null;
        this.comparator = comparator;
    }

    public void insert(E data, int priority) {
        root = insertRec(root, data, priority);
    }

    private Node<E> insertRec(Node<E> root, E data, int priority) {
        if (root == null) {
            return new Node<>(data, priority);
        }

        if (priority < root.priority || (priority == root.priority && comparator.compare(data, root.data) < 0)) {
            root.left = insertRec(root.left, data, priority);
        } else {
            root.right = insertRec(root.right, data, priority);
        }

        return root;
    }

    public E extract() {
        if (root == null) {
            return null;
        }

        Node<E> minNode = findMin(root);
        root = deleteMin(root);

        return minNode.data;
    }

    private Node<E> findMin(Node<E> root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private Node<E> deleteMin(Node<E> root) {
        if (root.left == null) {
            return root.right;
        }
        root.left = deleteMin(root.left);
        return root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        PriorityQueueWithBST<String> pq = new PriorityQueueWithBST<>(String::compareTo);

        pq.insert("apple", 3);
        pq.insert("banana", 2);
        pq.insert("orange", 1);

        while (!pq.isEmpty()) {
            System.out.println(pq.extract());
        }
    }
}

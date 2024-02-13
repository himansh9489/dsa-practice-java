class Node {
    int data;
    Node next;
    Node prev;

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    Node(int data1) {
        data = data1;
        next = null;
        prev = null;
    }
};

public class DoublyLinkedList {
    private static Node arrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    private static int lengthOfLL(Node head) {
        Node current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    private static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return head;
        Node prev = head;
        head = head.next;
        prev.next = null;
        head.prev = null;
        return head;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        Node newTail = tail.prev;
        newTail.next = null;
        tail.prev = null;
        return head;
    }

    private static Node deleteKthElement(Node head, int k) {
        if (head == null)
            return null;
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k)
                break;
            temp = temp.next;
        }
        Node next = temp.next;
        Node prev = temp.prev;
        if (prev == null && next == null) {
            return null;
        } else if (prev == null) {
            return deleteHead(head);
        } else if (next == null) {
            return deleteTail(head);
        }
        next.prev = prev;
        prev.next = next;

        temp.next = null;
        temp.prev = null;
        return head;
    }

    private static void deleteNode(Node temp) {
        Node next = temp.next;
        Node prev = temp.prev;
        if (next == null) {
            prev.next = null;
            temp.prev = null;
            return;
        }
        prev.next = next;
        next.prev = prev;
        temp.next = temp.prev = null;
    }

    private static Node insertBeforeHead(Node head, int val) {
        Node newHead = new Node(val, head, null);
        head.prev = newHead;
        return newHead;
    }

    private static Node insertBeforeTail(Node head, int val) {
        if (head.next == null)
            return insertBeforeHead(head, val);
        Node tail = head;
        while (tail.next != null)
            tail = tail.next;
        Node prev = tail.prev;
        Node temp = new Node(val, tail, prev);
        prev.next = temp;
        tail.prev = temp;
        return head;
    }

    private static Node insertBeforeKthElement(Node head, int val, int k) {
        if (k == 1)
            return insertBeforeHead(head, val);
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k)
                break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node newNode = new Node(val, temp, prev);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    private static void insertBeforeNode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 4, 7, 8 };
        Node head = arrayToLinkedList(arr);
        display(head);
        // System.out.println(lengthOfLL(head));
        // display(deleteHead(head));
        // display(deleteTail(head));
        // display(deleteKthElement(head, 5));
        // deleteNode(head.next.next.next);
        // display(head);
        head = insertBeforeHead(head, 6);
        display(head);
        head = insertBeforeTail(head, 15);
        display(head);
        head = insertBeforeKthElement(head, 100, 2);
        display(head);
        insertBeforeNode(head.next.next, 34);
        display(head);
    }
}

class Node {
    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    };

    Node(int data) {
        this.data = data;
        this.next = null;
    };

}

public class LinkedList {
    private static Node arrayToLinkedList(int[] arr) {
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            current.next = temp;
            current = temp;
        }
        return head;
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

    private static boolean checkIfPresent(Node head, int k) {
        Node current = head;
        while (current != null) {
            if (current.data == k)
                return true;
            current = current.next;
        }
        return false;
    }

    private static Node deleteHead(Node head) {
        Node current = head;
        current = current.next;
        return current;
    }

    private static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;
        Node current = head;
        while (current.next.next != null)
            current = current.next;
        current.next = null;
        return head;
    }

    private static Node deleteKthElement(Node head, int k) {
        if (head == null)
            return head;
        if (k == 1) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == k) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
        return head;
    }

    private static Node deleteElement(Node head, int el) {
        if (head == null)
            return head;
        if (head.data == el) {
            head = head.next;
            return head;
        }
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            if (temp.data == el) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
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

    private static Node insertHead(Node head, int val) {
        Node temp = new Node(val, head);
        return temp;
    }

    private static Node insertTail(Node head, int val) {
        if (head == null)
            return new Node(val);
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        return head;
    }

    private static Node insertPosition(Node head, int k, int el) {
        if (head == null) {
            if (k == 1)
                return new Node(el);
            else
                return head;
        }
        if (k == 1) {
            return new Node(el, head);
        }
        Node temp = head;
        int cnt = 0;
        while (temp != null) {
            cnt++;
            if (cnt == (k - 1)) {
                Node newNode = new Node(el, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    private static Node insertBeforeValue(Node head, int val, int el) {
        if (head == null)
            return null;
        if (head.data == val) {
            return new Node(el, head);
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == val) {
                Node newNode = new Node(el, temp.next);
                temp.next = newNode;
                break;
            }
            temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int arr[] = { 12, 4, 7, 8 };
        Node head = arrayToLinkedList(arr);
        display(head);
        System.out.println(lengthOfLL(head));
        System.out.println(checkIfPresent(head, 2));
        // display(deleteHead(head));
        // display(deleteTail(head));
        // display(deleteKthElement(head, 1));
        // display(deleteElement(head, 9));
        head = insertPosition(head, 1, 6);
        display(head);
        head = insertPosition(head, 6, 100);
        display(head);
        head = insertBeforeValue(head, 12, 23);
        display(head);
        head = insertBeforeValue(head, 7, 78);
        display(head);
    }
}

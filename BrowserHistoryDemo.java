class Node {
    String data;
    Node prev;
    Node next;

    Node(String data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    Node(String data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

class BrowserHistory {
    Node head;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
    }

    public void visit(String url) {
        Node newNode = new Node(url, head, null);
        head.next = newNode;
        head = newNode;
    }

    public String back(int steps) {
        while (head.prev != null && steps > 0) {
            steps--;
            head = head.prev;
        }
        return head.data;
    }

    public String forward(int steps) {
        while (head.next != null && steps > 0) {
            steps--;
            head = head.next;
        }
        return head.data;
    }
}

public class BrowserHistoryDemo {

    private static void display(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        // [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        // Output:
        // [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

        BrowserHistory obj = new BrowserHistory("leetcode.com");
        System.out.println(obj.head.data);
        obj.visit("google.com");
        System.out.println(obj.head.data);
        obj.visit("facebook.com");
        System.out.println(obj.head.data);
        obj.visit("youtube.com");
        System.out.println(obj.head.data);
        // display(obj.head);
        String param_2 = obj.back(1);
        String param_3 = obj.back(1);
        String param_4 = obj.forward(1);
        System.out.println(param_2 + " " + param_3 + " " + param_4);
        obj.visit("linkedin.com");
        System.out.println(obj.head.data);
        display(obj.head);
        String param_5 = obj.forward(2);
        String param_6 = obj.back(2);
        String param_7 = obj.back(7);
        System.out.println(param_5 + " " + param_6 + " " + param_7);

    }
}
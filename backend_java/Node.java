package backend_java;

public class Node {
    public Ticket ticket;
    public Node next;

    public Node(Ticket ticket) {
        this.ticket = ticket;
        this.next = null;
    }
}
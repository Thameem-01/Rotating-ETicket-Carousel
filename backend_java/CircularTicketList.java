package backend_java;

public class CircularTicketList {
    private Node head = null;

    public void insertTicket(Ticket ticket) {
        Node newNode = new Node(ticket);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public void removeTicket(String ticketId) {
        if (head == null) return;

        Node curr = head;
        Node prev = null;

        do {
            if (curr.ticket.getTicketId().equals(ticketId)) {
                if (prev != null) {
                    prev.next = curr.next;
                    if (curr == head) head = curr.next;
                } else {
                    // removing head
                    Node tail = head;
                    while (tail.next != head) tail = tail.next;
                    if (tail == head) {
                        head = null; // only one node
                    } else {
                        head = head.next;
                        tail.next = head;
                    }
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets available.");
            return;
        }
        Node temp = head;
        do {
            System.out.println(temp.ticket);
            temp = temp.next;
        } while (temp != head);
    }

    public Ticket nextTicket(Ticket current) {
        Node temp = head;
        if (temp == null) return null;

        do {
            if (temp.ticket.equals(current)) {
                return temp.next.ticket;
            }
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    public Ticket prevTicket(Ticket current) {
        Node temp = head;
        Node prev = null;
        if (temp == null) return null;

        do {
            if (temp.ticket.equals(current)) {
                return prev != null ? prev.ticket : getLastNode().ticket;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        return null;
    }

    private Node getLastNode() {
        Node temp = head;
        while (temp.next != head) temp = temp.next;
        return temp;
    }
}
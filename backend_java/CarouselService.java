package backend_java;

import java.time.LocalDateTime;

public class CarouselService {
    public static void main(String[] args) {
        CircularTicketList carousel = new CircularTicketList();

        // Insert tickets
        carousel.insertTicket(new Ticket("T1", LocalDateTime.now().plusHours(1), "Alice"));
        carousel.insertTicket(new Ticket("T2", LocalDateTime.now().plusHours(2), "Bob"));
        carousel.insertTicket(new Ticket("T3", LocalDateTime.now().plusHours(3), "Charlie"));

        System.out.println("All tickets:");
        carousel.displayTickets();

        // Remove a ticket
        carousel.removeTicket("T2");
        System.out.println("\nAfter removing T2:");
        carousel.displayTickets();

        // Navigate next and previous
        Ticket first = new Ticket("T1", LocalDateTime.now().plusHours(1), "Alice");
        Ticket next = carousel.nextTicket(first);
        System.out.println("\nNext ticket after T1: " + next);

        Ticket prev = carousel.prevTicket(next);
        System.out.println("Previous ticket before " + next.getTicketId() + ": " + prev);
    }
}
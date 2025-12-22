package backend_java;

import java.time.LocalDateTime;

public class Ticket {
    private String ticketId;
    private LocalDateTime expiryTime;
    private String owner;

    public Ticket(String ticketId, LocalDateTime expiryTime, String owner) {
        this.ticketId = ticketId;
        this.expiryTime = expiryTime;
        this.owner = owner;
    }

    public String getTicketId() {
        return ticketId;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public String getOwner() {
        return owner;
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiryTime);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", expiryTime=" + expiryTime +
                ", owner='" + owner + '\'' +
                '}';
    }
}
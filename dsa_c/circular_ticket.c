#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Ticket {
    char id[50];
    long expiry;
    struct Ticket *next;
    struct Ticket *prev;
} Ticket;

Ticket *head = NULL;
void insertTicket(char *id, long expiry) {
    Ticket *node = malloc(sizeof(Ticket));
    strcpy(node->id, id);
    node->expiry = expiry;

    if (head == NULL) {
        node->next = node;
        node->prev = node;
        head = node;
        return;
    }

    Ticket *tail = head->prev;

    tail->next = node;
    node->prev = tail;

    node->next = head;
    head->prev = node;
}
#include <time.h>

void removeTicket() {
    if (head == NULL)
        return;

    Ticket *current = head;
    time_t now = time(NULL);

    do {
        Ticket *nextNode = current->next;

        if (current->expiry < now) {

            if (current->next == current) {
                head = NULL;
                free(current);
                return;
            }

            current->prev->next = current->next;
            current->next->prev = current->prev;

            if (current == head)
                head = nextNode;

            free(current);
        }

        current = nextNode;

    } while (current != head);
}
void displayTickets() {
    if (head == NULL) {
        printf("No active tickets\n");
        return;
    }

    Ticket *temp = head;

    printf("\nActive Tickets List:\n");

    do {
        printf("Ticket ID: %s | Expiry: %ld\n", temp->id, temp->expiry);
        temp = temp->next;
    } while (temp != head);

    printf("\n");
}
void nextTicket() {
    if (head != NULL)
        head = head->next;
}
void prevTicket() {
    if (head != NULL)
        head = head->prev;
}
int main() {
    insertTicket("A1", time(NULL) + 5);
    insertTicket("B1", time(NULL) + 10);
    insertTicket("C1", time(NULL) + 20);

    displayTickets();

    nextTicket();
    printf("After next:\n");
    displayTickets();

    return 0;
}

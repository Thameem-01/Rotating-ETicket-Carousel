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

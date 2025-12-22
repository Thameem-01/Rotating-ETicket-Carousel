const tickets = [
  "Metro Pass",
  "Bus Pass",
  "Concert Ticket",
  "Movie Ticket"
];

let index = 0;

function showTicket() {
  document.getElementById("ticket").innerText = tickets[index];
}

function nextTicket() {
  index = (index + 1) % tickets.length;
  showTicket();
}

function prevTicket() {
  index = (index - 1 + tickets.length) % tickets.length;
  showTicket();
}

showTicket();

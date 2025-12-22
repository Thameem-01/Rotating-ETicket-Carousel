let tickets = [];
let index = 0;

function render() {
  const card = document.getElementById("ticketCard");
  const counter = document.getElementById("counter");

  if (tickets.length === 0) {
    card.innerHTML = `<p style="color:#94a3b8">No tickets yet</p>`;
    counter.textContent = "0 / 0";
    return;
  }

  const t = tickets[index];

  card.innerHTML = `
    <h3>${t.venue}</h3>
    <div class="row"><span>Seat</span><span>${t.seat}</span></div>
    <div class="row"><span>Date</span><span>${t.date}</span></div>
    <div class="row"><span>Time</span><span>${t.time}</span></div>
    <div class="price">₹ ${t.price}</div>
  `;

  counter.textContent = `${index + 1} / ${tickets.length}`;
}

function nextTicket() {
  if (!tickets.length) return;
  index = (index + 1) % tickets.length;
  render();
}

function prevTicket() {
  if (!tickets.length) return;
  index = (index - 1 + tickets.length) % tickets.length;
  render();
}

/* Modal */
function openModal() {
  document.getElementById("modal").style.display = "flex";
}

function closeModal() {
  document.getElementById("modal").style.display = "none";
}

/* Add Ticket */
function addTicket() {
  const venue = venueInput();
  const seat = seatInput();
  const date = dateInput();
  const time = timeInput();
  const price = priceInput();

  if (!venue || !seat || !date || !time || !price) {
    alert("Please fill all fields");
    return;
  }

  tickets.push({ venue, seat, date, time, price });
  index = tickets.length - 1;
  closeModal();
  render();
}

/* Helpers */
const venueInput = () => document.getElementById("venue").value;
const seatInput = () => document.getElementById("seat").value;
const dateInput = () => document.getElementById("date").value;
const timeInput = () => document.getElementById("time").value;
const priceInput = () => document.getElementById("price").value;

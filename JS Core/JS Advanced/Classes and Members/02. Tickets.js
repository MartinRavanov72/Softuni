function tickets(tickets, sortingCriteria) {
  class Ticket {
    constructor(destination, price, status) {
      this.destination = destination;
      this.price = price;
      this.status = status;
    }
  }
  function sort(a, b) {
    switch (sortingCriteria) {
      case 'price': {
        return a.price - b.price;
      }
      case 'destination': {
        return a.destination.localeCompare(b.destination);
      }
      case 'status': {
        return a.status.localeCompare(b.status);
      }
    }
  }
  let ticketsArr = [];

  for (let ticket of tickets) {
    let [destination, price, status] = ticket.split('|');
    ticketsArr.push(new Ticket(destination, +price, status));
  }
  ticketsArr.sort(sort);
  return ticketsArr;
}
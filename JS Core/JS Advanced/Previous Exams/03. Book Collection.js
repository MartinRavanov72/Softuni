class BookCollection {
  constructor(shelfGenre, room, shelfCapacity) {
    let rooms = ["livingRoom", "bedRoom", "closet"];

    if (!rooms.includes(room)) {
      throw new Error(`Cannot have book shelf in ${room}`);
    }

    this.shelfGenre = shelfGenre;
    this.room = room;
    this.shelfCapacity = +shelfCapacity;
    this.shelf = [];
  }

  addBook(bookName, bookAuthor, genre = "") {
    if (this.shelf.length === this.shelfCapacity) {
      this.shelf.shift();
    }

    this.shelf.push({ bookName, bookAuthor, genre });

    this.shelf = this.shelf.sort((a, b) => a.bookAuthor.localeCompare(b.bookAuthor));
    return this;
  }

  throwAwayBook(bookName) {
    this.shelf = this.shelf.filter(x => x.bookName !== bookName);
  }

  showBooks(genre) {
    let books = [];

    for (let book of this.shelf) {
      if (book.genre === genre) {
        books.push(`\uD83D\uDCD6 ${book.bookAuthor} - "${book.bookName}"`);
      }
    }

    return `Results for search "${genre}":\n` +
      books.join("\n");
  }

  get shelfCondition() {
    return this.shelfCapacity - this.shelf.length;
  }

  toString() {
    if (this.shelf.length === 0) {
      return "It's an empty shelf";
    }
    else {
      let books = [];

      for (let book of this.shelf) {
        books.push(`\uD83D\uDCD6 "${book.bookName}" - ${book.bookAuthor}`);
      }

      return `"${this.shelfGenre}" shelf in ${this.room} contains:\n`
        + books.join("\n");
    }
  }
}

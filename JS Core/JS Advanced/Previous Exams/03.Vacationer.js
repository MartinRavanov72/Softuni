class Vacationer {
  constructor(fullName, creditCard) {
    this.fullName = fullName;
    this.creditCard = {
      cardNumber: 1111,
      expirationDate: "",
      securityNumber: 111
    };
    if (creditCard !== undefined) {
      this.addCreditCardInfo(creditCard);
    }
    this.generateIDNumber();
    this.wishList = [];
  }

  get fullName() {
    return this._fullName;
  }

  set fullName(input) {
    if (input.length !== 3) {
      throw new Error(
        "Name must include first name, middle name and last name"
      );
    }

    let pattern = /^[A-Z]{1}[a-z]+$/gm;

    input.forEach(element => {
      if (!element.match(pattern)) {
        throw new Error("Invalid full name");
      }
    });

    this._fullName = {
      firstName: input[0],
      middleName: input[1],
      lastName: input[2]
    };
  }

  generateIDNumber() {
    this.idNumber =
      231 * +this.fullName.firstName.charCodeAt(0) +
      139 * this.fullName.middleName.length;
    let midNameChars = this.fullName.middleName.split("");
    let lastChar = midNameChars[midNameChars.length - 1];
    if (
      lastChar == "a" ||
      lastChar == "o" ||
      lastChar == "u" ||
      lastChar == "e" ||
      lastChar == "i"
    ) {
      this.idNumber += "8";
    } else {
      this.idNumber += "7";
    }
  }

  addCreditCardInfo(input) {
    if (input.length !== 3) {
      throw new Error("Missing credit card information");
    }
    if (typeof input[0] !== "number" || typeof input[2] !== "number") {
      throw new Error("Invalid credit card details");
    }
    this.creditCard.cardNumber = input[0];
    this.creditCard.expirationDate = input[1];
    this.creditCard.securityNumber = input[2];
  }

  addDestinationToWishList(destination) {
    if (this.wishList.includes(destination)) {
      throw new Error("Destination already exists in wishlist");
    }
    this.wishList.push(destination);
    this.wishList.sort(function(a, b) {
      return a.length - b.length;
    });
  }
  getVacationerInfo() {
    return (
      "Name: " +
      this.fullName.firstName +
      " " +
      this.fullName.middleName +
      " " +
      this.fullName.lastName +
      "\n" +
      "ID Number: " +
      this.idNumber +
      "\n" +
      "Wishlist:\n" +
      (this.wishList.length === 0 ? "empty" : this.wishList.join(", ")) +
      "\n" +
      "Credit Card:\n" +
      "Card Number: " +
      this.creditCard.cardNumber +
      "\n" +
      "Expiration Date: " +
      this.creditCard.expirationDate +
      "\n" +
      "Security Number: " +
      this.creditCard.securityNumber
    );
  }
}
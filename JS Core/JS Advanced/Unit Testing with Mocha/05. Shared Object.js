describe("sharedObject", function () {
  describe("initially name and income should be null", function () {
    it("should return null for initial state of name", function () {
      assert.equal(sharedObject.name, null);
    });
    it("should return null for initial state of income", function () {
      assert.equal(sharedObject.income, null);
    });
  });

  describe("change name function", function () {
    it("should return number for number parameter", function () {
      sharedObject.changeName(3);
      assert.equal(sharedObject.name, 3);
      assert.equal($('#name').val(), "3");
    });
    it("should return previous name for empty string parameter", function () {
      sharedObject.changeName("Azis");
      sharedObject.changeName("");
      assert.equal(sharedObject.name, "Azis");
      assert.equal($('#name').val(), "Azis");
    });
    it("should return new name after calling the function more than one time", function () {
      sharedObject.changeName("Nqkoi");
      sharedObject.changeName("Azis");
      assert.equal(sharedObject.name, "Azis");
      assert.equal($('#name').val(), "Azis");
    });
  });

  describe("changeIncome function", function () {
    it("should return previous value after calling with 0 parameter", function () {
      sharedObject.changeIncome(1);
      sharedObject.changeIncome(0);
      assert.equal(sharedObject.income, 1);
      assert.equal($('#income').val(), "1");
    });
    it("should return correct result after calling with integer", function () {
      sharedObject.changeIncome(12);
      assert.equal(sharedObject.income, 12);
      assert.equal($('#income').val(), "12");
    });
    it("should return previous value after calling with negative parameter", function () {
      sharedObject.changeIncome(123);
      sharedObject.changeIncome(-102);
      assert.equal(sharedObject.income, 123);
      assert.equal($('#income').val(), "123");
    });
  });

  describe("updateName function", function () {
    it("should successfully change name with non empty string", function () {
      sharedObject.changeName("Nqkoi");
      $("#name").val("Azis");
      sharedObject.updateName();
      assert.equal(sharedObject.name, "Azis");
      assert.equal($("#name").val(), "Azis");
    });
    it("should not change name with empty string", function () {
      sharedObject.changeName("Azis");
      $("#name").val("");
      sharedObject.updateName();
      assert.equal(sharedObject.name, "Azis");
      assert.equal($("#name").val(), "");
    });
  });

  describe("updateIncome function", function () {
    it("should return previous value if value is NaN", function () {
      sharedObject.changeIncome(1);
      $("#income").val("Azis");
      sharedObject.updateIncome();
      assert.equal(sharedObject.income, 1);
      assert.equal($("#income").val(), "Azis");
    });
    it("should return previous value if value is floating point number", function () {
      sharedObject.changeIncome(1);
      $("#income").val("3.123");
      sharedObject.updateIncome();
      assert.equal(sharedObject.income, 1);
      assert.equal($("#income").val(), "3.123");
    });
    it("should return previous value if value is negative number", function () {
      sharedObject.changeIncome(1);
      $("#income").val("-123");
      sharedObject.updateIncome();
      assert.equal(sharedObject.income, 1);
      assert.equal($("#income").val(), "-123");
    });
    it("should return previous value if value is 0", function () {
      sharedObject.changeIncome(1);
      $("#income").val("0");
      sharedObject.updateIncome();
      assert.equal(sharedObject.income, 1);
      assert.equal($("#income").val(), "0");
    });
    it("should return correct value id value is positive integer", function () {
      sharedObject.changeIncome(1);
      $("#income").val("123");
      sharedObject.updateIncome();
      assert.equal(sharedObject.income, 123);
      assert.equal($("#income").val(), "123");
    })
  });
});
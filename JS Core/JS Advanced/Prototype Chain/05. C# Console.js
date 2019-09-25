describe("class Console static writeLine", function() {
  it("should return the same string for single string argument", function() {
    let string = "Azis";
    assert.equal(Console.writeLine(string), string);
  });
  it("should return JSON string for single object argument", function() {
    let object = { name: "Azis", age: 43 };
    assert.equal(Console.writeLine(object), JSON.stringify(object));
  });
  it("should throw error if no arguments were given", function() {
    assert.throws(() => Console.writeLine(), TypeError);
  });
  it("should throw error if first argument is not string", function() {
    assert.throws(() => Console.writeLine(5, 1, 2), TypeError);
  });
  it("should throw error if placeholders are less than arguments", function() {
    let string = "Replace {0} {1}.";
    assert.throws(
      () => Console.writeLine(string, "this", "three", "times"),
      RangeError
    );
  });
  it("should throw error if place of placeholders is changed", function() {
    let string = "Replace {0} {0} replaced.";
    assert.throws(() => Console.writeLine(string, "this", "be"), RangeError);
  });
  it("should successfully replace placeholders with valid arguments", function() {
    let string = "Replace {0} {1} please.";
    assert.equal(
      Console.writeLine(string, "this", "thing"),
      "Replace this thing please."
    );
  });
  it("should throw error if invalid placeholder is given", function() {
    let string = "Replace {0} aaaaaaaa {1} this. This one aaaaaaaaaa {2} not.";
    assert.throws(() => Console.writeLine(string, "one", "be"), RangeError);
  });
  it("should recognize the placeholder numbers well", function() {
    let string = "This does not {10} work.";
    assert.throws(() => Console.writeLine(string, "azis"), RangeError);
  });
});

describe("Calculator", () => {
  let calc = new Calculator();
  beforeEach(() => {
    calc = new Calculator();
  });

  it("works fine", () => {
    calc.add(10);
    calc.add(5);
    assert.equal(calc.divideNums(), 2);
  });

  it("works fine", () => {
    calc.add(undefined);
    expect(() => calc.divideNums()).to.throw();
  });

  it("works fine", () => {
    assert.equal(calc.expenses.length, 0);
  });

  it("works fine", () => {
    calc.add(34);
    assert.equal(calc.expenses.length, 1);
  });

  it("works fine", () => {
    calc.add(4);
    assert.equal(calc.expenses[0], 4);
  });

  it("works fine", () => {
    calc.add(10);
    calc.add("5");
    assert.equal(calc.divideNums(), 10);
  });

  it("works fine", () => {
    calc.add(10);
    calc.add(0);
    assert.equal(calc.divideNums(), "Cannot divide by zero");
  });

  it("works fine", () => {
    calc.add(10);
    assert.equal(calc.divideNums(), 10);
  });

  it("works fine", () => {
    calc.add(0);
    calc.add(5);
    assert.equal(calc.divideNums(), 0);
  });

  it("works fine", () => {
    calc.add("123");
    calc.add("123");
    expect(() => calc.divideNums()).to.throw();
  });

  it("works fine", () => {
    expect(() => calc.divideNums()).to.throw();
  });

  it("works fine", () => {
    calc.add("123");
    calc.add("33");
    calc.add(true);
    calc.add(12);
    assert.equal(calc.toString(), "123 -> 33 -> true -> 12");
  });

  it("works fine", () => {
    assert.equal(calc.toString(), "empty array");
  });

  it("works fine", () => {
    calc.add("123");
    calc.add("a");
    calc.add(4);
    calc.orderBy();
    assert.equal(calc.orderBy(), "123, 4, a");
  });

  it("works fine", () => {
    calc.add(123);
    calc.add(33);
    calc.add(4);
    assert.equal(calc.orderBy(), "4, 33, 123");
  });

  it("works fine", () => {
    assert.equal(calc.orderBy(), "empty");
  });

  it("works fine", () => {
    calc.add(10);
    calc.add(5);
    calc.divideNums();
    calc.add(2);
    calc.divideNums();
    calc.add(2);

    assert.equal(calc.orderBy(), "1, 2");
  });

  it("works fine", () => {
    calc.add(10);
    calc.add(5);
    calc.divideNums();
    calc.add(-2);
    calc.divideNums();
    calc.add(2);
    calc.orderBy();
    assert.equal(calc.toString(), "-1 -> 2");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(-2.5);
    assert.closeTo(calc.divideNums(), -2, 0.01);
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(2.5);
    assert.closeTo(calc.divideNums(), 2, 0.01);
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(-2.5);
    assert.equal(calc.orderBy(), "-2.5, 5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(2.5);
    assert.equal(calc.orderBy(), "2.5, 5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(2.5);
    assert.equal(calc.toString(), "5 -> 2.5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(-2.5);
    assert.equal(calc.toString(), "5 -> -2.5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(2.5);
    assert.equal(calc.orderBy(), "2.5, 5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(-2.5);
    assert.equal(calc.orderBy(), "-2.5, 5");
  });

  it("works fine", () => {
    calc.add(5);
    calc.add(-2.5);
    calc.add("azis");
    assert.equal(calc.orderBy(), "-2.5, 5, azis");
  });
});

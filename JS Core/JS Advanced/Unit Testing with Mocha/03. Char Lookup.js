describe("lookupChar", function () {
  it('with a non-string first parameter should return undefined', function () {
    assert.equal(lookupChar(7, 2), undefined);
  });
  it('with a non-string second parameter should return undefined', function () {
    assert.equal(lookupChar("azis", "slavi"), undefined);
  });
  it('with a floating point number second parameter should return undefined', function () {
    assert.equal(lookupChar("azis", 3.12), undefined);
  });
  it('with an incorrect index value should return incorrect index', function () {
    assert.equal(lookupChar("azis", 13), "Incorrect index");
  });
  it('with a negative index value should return incorrect index', function () {
    assert.equal(lookupChar("azis", -1), "Incorrect index");
  });
  it('with an index value equal to string length, should return incorrect index', function () {
    assert.equal(lookupChar("azis", 4), "Incorrect index");
  });
  it('with correct parameters, should return correct value', function () {
    assert.equal(lookupChar("azis", 0), "a");
  });
  it('with correct parameters should return correct value', function () {
    assert.equal(lookupChar("azis", 3), "s");
  });
});
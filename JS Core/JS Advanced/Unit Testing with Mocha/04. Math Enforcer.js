describe("mathEnforcer", function () {
  describe('addFive', function () {
    it("should return undefined for non-number parameter", function () {
      assert.equal(mathEnforcer.addFive("2"), undefined);
    });
    it("should return correct result for positive integer parameter", function () {
      assert.equal(mathEnforcer.addFive(8), 13);
    });
    it("should return correct result for negative integer parameter", function () {
      assert.equal(mathEnforcer.addFive(-2), 3);
    });
    it("should return correct result for floating point parameter", function () {
      assert.closeTo(mathEnforcer.addFive(3.14), 8.14, 0.01);
    });
  });

  describe('subtractTen', function () {
    it("should return undefined for non-number parameter", function () {
      assert.equal(mathEnforcer.subtractTen("2"), undefined);
    });
    it("should return correct result for positive integer parameter", function () {
      assert.equal(mathEnforcer.subtractTen(8), -2);
    });
    it("should return correct result for negative integer parameter", function () {
      assert.equal(mathEnforcer.subtractTen(-2), -12);
    });
    it("should return correct result for floating point parameter", function () {
      assert.closeTo(mathEnforcer.subtractTen(3.14), -6.86, 0.01);
    });
  });

  describe('sum', function () {
    it("should return undefined for non-number first parameter", function () {
      assert.equal(mathEnforcer.sum("2", 4), undefined);
    });
    it("should return undefined for non-number second parameter", function () {
      assert.equal(mathEnforcer.sum(4, "34"), undefined);
    });
    it("should return correct result for integer parameters", function () {
      assert.equal(mathEnforcer.sum(123, 123), 246);
    });
    it("should return correct result for floating point parameters", function () {
      assert.closeTo(mathEnforcer.sum(1.8, 3.1), 4.9, 0.01);
    })
  })
});
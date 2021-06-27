package org.23702
package task2

class KontoBankowe(initialBalance: BigDecimal) {
  private var _balance: BigDecimal = initialBalance

  def stanKonta: BigDecimal = _balance

  def this() {
    this(0)
  }

  def wplata(value: BigDecimal): Unit = {
    if (value < 0) {
      throw new Exception("Deposit cannot be lower than 0");
    } else {
      _balance = _balance + value
    }
  }

  def wyplata(value: BigDecimal): Unit = {
    if (value < 0) {
      throw new Exception("withdrawal cannot be negative");
    } else if (stanKonta < value) {
      throw new Exception("not enough funds");
    } else {
      _balance = _balance - value
    }
  }
}

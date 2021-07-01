package Demo

class KontoBankowe(poczatkowyStan: Double) {
  private var _stanKonta: Double = poczatkowyStan

  def stanKonta: Double = _stanKonta

  def this() {
    this(0)
  }

  def wplata(kwota: Double): Double = {
    _stanKonta = _stanKonta + kwota
    _stanKonta
  }

  def wyplata(kwota: Double): Double = {
    if (_stanKonta - kwota < 0) return _stanKonta

    _stanKonta = _stanKonta - kwota
    _stanKonta
  }
}

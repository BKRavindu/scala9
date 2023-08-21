class Rational1(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  
  private val gcdValue = gcd(n.abs, d.abs)
  val number: Int = n / gcdValue
  val denom: Int = d / gcdValue
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  
  def neg: Rational1 = new Rational1(-number, denom)
  
  def sub(other: Rational1): Rational1 = new Rational1(
    number * other.denom - other.number * denom,
    denom * other.denom
  )
  
  override def toString: String = s"$number/$denom"
}

object Main extends App {
  val x = new Rational1(3, 4)
  val y = new Rational1(5, 8)
  val z = new Rational1(2, 7)
  
  val result = x.sub(y).neg.sub(z)
  println(result)  
}

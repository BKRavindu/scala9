class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")
  
  private val gcdValue = gcd(n.abs, d.abs)
  val number: Int = n / gcdValue
  val denom: Int = d / gcdValue
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  
  def neg: Rational = new Rational(-number, denom)
  
  override def toString: String = s"$number/$denom"
}

object Main extends App {
  val x = new Rational(6, 8)
  println(x)    
  println(x.neg) 
}

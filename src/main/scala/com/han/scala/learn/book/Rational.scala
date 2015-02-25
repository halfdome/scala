package com.han.scala.learn.book

/**
 * Created by yhan on 2/9/15.
 *
 * Chapter 6
 */
class Rational(n:Int, d:Int) {
  require(d != 0)

  private val g = gcd(n.abs, d.abs)
  private val s = if (n*d < 0) -1 else 1
  val numerator = s * n.abs / g
  val denominator = d.abs /g

  override def toString = {
    if (numerator == 0) "0" else {
      if (denominator == 1) s"$numerator"
      else s"$numerator/$denominator"
    }
  }

  def this(n:Int) = this(n, 1)

  def +(r2: Rational):Rational = new Rational(n * r2.denominator + d * r2.numerator, d * r2.denominator)
  def *(r2: Rational):Rational = new Rational(n * r2.numerator, d * r2.denominator)
  def *(i: Int):Rational = new Rational(n * i, d)
  def -(r2: Rational):Rational = new Rational(n * r2.denominator - d * r2.numerator, d * r2.denominator)
  def /(r2: Rational):Rational = new Rational(n * r2.denominator, d * r2.numerator)

  private def gcd(a:Int, b:Int):Int = {
    if (b == 0) a else gcd(b, a % b)
  }
}

object RationalImplicits {
  implicit def int2Rational(i:Int) = new Rational(i)
}

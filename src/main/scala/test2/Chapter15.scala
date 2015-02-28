package test2

/**
 * Created by yhan on 2/23/15.
 */
object Chapter15 extends App{

  val op1 = BinOp("+", BinOp("*", UnOp("-", UnOp("-", Number(5))), Number(1)), Var("x"))
  println(op1.toString)
  println(simplifyAll(op1).toString)

  def simplifyAll(expr: Expr): Expr = expr match {
    case UnOp("-", UnOp("-", e)) => simplifyAll(e)
    case UnOp("abs", e @ UnOp("abs", _)) => simplifyAll(e)
    case UnOp("abs", Number(e)) if e >= 0 => Number(e)
    case UnOp("abs", Number(e)) if e < 0 => Number(-e)
    case UnOp(op, e) => UnOp(op, simplifyAll(e))
    case BinOp("^", e, Number(1)) => simplifyAll(e)
    case BinOp("+", e, Number(0)) => simplifyAll(e)
    case BinOp("*", e, Number(1)) => simplifyAll(e)
    case BinOp("+", x, y) if x == y => simplifyAll(BinOp("*", x, Number(2)))
    case BinOp(op, l, r) => BinOp(op, simplifyAll(l), simplifyAll(r))
    case _ => expr
  }

  def simplifyTop(expr: Expr): Expr = (expr: @unchecked) match {
    case UnOp("-", UnOp("-", e)) => e
    case UnOp("abs", e @ UnOp("abs", _)) => e
    case UnOp("abs", Number(e)) if e >= 0 => Number(e)
    case UnOp("abs", Number(e)) if e < 0 => Number(-e)
    case BinOp("^", e, Number(1)) => e
    case BinOp("+", e, Number(0)) => e
    case BinOp("*", e, Number(1)) => e
    case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
    case _ => expr
  }

  def generalSize(obj: Any): Int = obj match {
    case s: String => s.length
    case i: Int => 1
    case m: Map[_, _] => m.size
    case t: List[_] => t.size
    case _ => -1
  }

  println(generalSize(List(4,3,5)))

  val capitals = Map("France" -> "Paris", "China" -> "Beijing")
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
  println(show(capitals.get("China")))
  println(show(capitals.get("India")))

  var pSecond: PartialFunction[List[Int], Int] = {
    case x::y::_ => y
  }
  println(pSecond.isDefinedAt(List(2)))
}

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr



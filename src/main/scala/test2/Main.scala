/**
 * Created by yhan on 2/8/15.
 */
import scala.collection.parallel.immutable
import scala.io.Source
import scala.App

object Main extends App {
  println(
    """
      |Welcome to the scala playground!
      |This is follow the <Programming
      |in Scala: A Comprehensive Step-by-Step
      |Guide> and the examples in the book.
    """.stripMargin)

    sample2()

  def sample2(){
    val hanoi = new Hanoi()
    hanoi.compute(3)
    println(checkSumAccumulator.calculate("This is a test!!!"))
  }

  val abc = List("A", "B", "C")

  def add(res: String, x: String) = {
    println(s"op: $res + $x = ${res + x}")
    res + x
  }

  def add1(res: Int, x: Int): Int = res + x

  def sample1(){
    val list = List(1, 3, 5):::Nil
    val list1 = list.:::(List(-3, -1))
    val total = list1.reduce(add1)
    val list2 = list.map(b => b+5)
    println("total:"+total)
    val bigInt = new java.math.BigInteger("393286483764329643264923")
    list1.foreach(println)
    println("list2")
    list2.foreach(println)
    val stringArray = new Array[String](3)
    stringArray(0) = "line1"
    stringArray(1) = "line2"
    stringArray(2) = "line3"
    val stringArray1 = Array("line4", "line5", "line6")
    for (i <- 0 to 2)
      print(stringArray1(i)+"#")
    println(stringArray.mkString("@@"))

    val tuple1 = ("Obama", "Politics", 0.98)
    println(tuple1._2)

    val set1 = Set("alpha", "beta")
    assert(set1.contains("alpha"))

    val map1 = Map[String, Int]("Obama" -> 5, "Xi" -> 100)
    println (map1.toString())

    val file = Source.fromFile("/Users/yhan/workspace/scala/test1/src/main.scala").getLines().toList
    val width = file.foldLeft(0)((r,b:String) => if (r > b.length.toString.length) r else b.length.toString.length)
    for (line <- file) {
      println (" " * (width - line.length.toString.length)+line.length.toString+"| "+line)
    }
  }
}

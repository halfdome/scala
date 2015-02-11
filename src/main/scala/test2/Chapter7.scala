package test2

/**
 * Created by yhan on 2/9/15.
 */
class Chapter7{


}

object Chapter7 extends App{
val list = for {
    i <- 1 to 5
    if (i != 3)
    a = println("*"*i)
    j <- 1 to 5
    if (j != i)
    b = println("#"*j)
  } yield i*j
  try {
    list.foreach(println)
    throw new IllegalAccessException("Sample Exception")
  }catch {
    case ex:IllegalAccessException => println("No problem, caught.")
  }finally {
    println("Well, never forget this.")
  }

  3 match {
    case 3 => println(3)
    case 5 => println("no")
  }

  def makeRowSeq(row: Int, col: Int):List[String] = {
    if (col == 0) List()
    else {
      val prod = (row * col).toString
      val padding = " " * (4 - prod.length)
      (padding + prod)::makeRowSeq (row, col-1)
    }
  }

  def makeRow(row:Int) = makeRowSeq(row, 10).reverse.mkString

  def multiTable() = {
    val tableSeq =
      for (row <- 1 to 10)
        yield makeRow(row)
    tableSeq.mkString("\n")
  }

  print(multiTable())

}

import scala.collection.mutable

/**
 * Created by yhan on 2/9/15.
 */
class Hanoi {
  private val towers = List("A", "B", "C")
  def compute (count: Int) = {

    //recurse(count, towers)
    recurse1(count, towers).reverse.toList.foreach(println)
  }

  /*
  second version, functional
 */
  private def recurse1 (count: Int, stack: List[String]): List[String] = {
    if (count == 0) Nil
    else {
      var ret = recurse1(count - 1, List(stack(0), stack(2), stack(1)))
      ret = s"Move ${stack(0)} to ${stack(2)}"::ret
      recurse1(count - 1, List(stack(1), stack(0), stack(2))):::ret
    }
  }

  /*
    first version, imperative
   */
  private def recurse (count: Int, stack: List[String]) {
    if (count == 0)
      return
    else {
      recurse(count - 1, List(stack(0), stack(2), stack(1)))
      println ("Move "+stack(0)+" to "+stack(2))
      recurse(count - 1, List(stack(1), stack(0), stack(2)))
    }
  }

}

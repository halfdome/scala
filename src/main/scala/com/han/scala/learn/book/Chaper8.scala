package com.han.scala.learn.book

/**
 * Created by yhan on 2/11/15.
 */
object Chapter8 extends App{

  //function literal
  val increase = (x:Int) => x+1

  //underscore placeholder
  List(1,3,2).filter(_ > 1).foreach(println)

  //partial applied function
  val sum = (a:Int, b:Int, c:Int) => a + b + c
  val none = sum _
  val missing = sum(1, _:Int, 5)
  println(missing(6))
  println(none)

  //closure
  var more = 1
  val add = (_:Int) + more
  println(add(5))
  more = 5
  println(add(5))

  //function instantiate into multiple closures
  def bound(prior:Int) = prior + (_:Int)
  val bound1=bound(5)
  val bound2=bound(10)
  println(bound1(5))
  println(bound2(5))

  //repeated parameters
  def echo(args:String *) = for (arg <- args) print(arg)
  echo("*","*","*","*","*","*")
  val array=Array("a","b","c")
  echo(array: _*)

  //named arguments
  def minus(a:Int, b:Int) = a-b
  println(minus(b=100, a=50))


  //default value
  def multiple(a:Int = 10, b:Int) = a * b
  println(multiple(b=20))

  //tail recursion
  def boom(x:Int):Int =
    if (x == 0) throw new IllegalStateException
    else boom(x-1)
  boom(5)
  def boom1(x:Int):Int =
    if (x == 0) throw new IllegalStateException
    else boom1(x-1)+1
  boom(5)


}

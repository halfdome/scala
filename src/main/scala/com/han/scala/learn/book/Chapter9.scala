package com.han.scala.learn.book

import java.io.File
import scala.io.Source

/**
 * Created by yhan on 2/12/15.
 */
object Chapter9 extends App{
  private val file = Source.fromFile("/Users/yhan/workspace/scala/com.han.scala.learn.book/src/main/scala/com.han.scala.learn.book/Main.scala").getLines().toList

  def apply(query:String, matcher:(String, String)=>Boolean) =
    for (line <- file; if matcher(line, query)) yield line

  def ending(query:String) = apply(query, _.endsWith(_))
  def contains(query:String) = apply(query, _.contains(_))

  def apply(matcher:(String)=>Boolean) =
    for (line <- file; if matcher(line)) yield line

  def ending1(query:String) = apply(_.endsWith(query))
  def contains1(query:String) = apply(_.contains(query))

  contains1("string").foreach(println)

  def plus(x:Int)(y:Int) = x + y
  val fivePlus = plus(6)_
  println(fivePlus(6))
}

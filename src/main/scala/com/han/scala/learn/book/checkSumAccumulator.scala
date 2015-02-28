/**
 * Created by yhan on 2/9/15.
 *
 * Chapter 5
 */
package com.han.scala.learn.book

import scala.collection.mutable.Map

object checkSumAccumulator {
  private val cache = Map[String, Int]()

  def calculate (s: String): Int = {
    if (!cache.contains(s)) {
      val acc = new checkSumAccumulator
      s.foreach(c => acc.add(c.toByte))
      cache += (s -> acc.checkSum())
    }
    cache(s)
  }
}


class checkSumAccumulator {
  private var sum = 0
  def add (b: Byte) { sum += b }
  def checkSum(): Int = ~(sum & 0xFF) + 1
}

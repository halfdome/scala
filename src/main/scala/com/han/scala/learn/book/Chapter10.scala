package com.han.scala.learn.book

/**
 * Created by yhan on 2/17/15.
 */
import Element.elem

object Chapter10 extends App {
   val ele2 = Element.elem('*', 6, 3)
   val ele1 = Element.elem("Chapter 10")
   val ele3 = Element.elem('@', 4, 5)
   println(ele3.beside(ele1).above(ele2).toString)
}

abstract class Element {
  def contents: Array[String]
  def height = contents.length
  def width = if (height == 0) 0 else contents(0).length

  def above(that: Element) = elem((this widen that.width).contents ++ (that widen this.width).contents)

  def beside(that: Element) =
    elem(
      for (
        (line1, line2) <- (this heighten that.height).contents zip (that heighten this.height).contents
      ) yield line1 + line2
    )


  def widen(w: Int):Element = if (w <= width) this else this beside elem(' ', w - width, height)

  def heighten(h: Int):Element = if (h <= height) this else elem(' ', width, h - height) above this

  override def toString = contents mkString "\n"
}

object Element {
  def elem(contents:Array[String]):Element = new ArrayElements(contents)
  def elem(chr: Char, width: Int, height: Int):Element = new UniformElements(chr, width, height)
  def elem(line:String):Element = new LineElement(line)

  private class UniformElements(val chr: Char, override val width: Int, override val height: Int) extends Element {
    val contents = (
      for (i <- 0 until height) yield chr.toString * width
      ).toArray
  }

  private class ArrayElements(val contents: Array[String]) extends Element {}

  private class LineElement(s: String) extends ArrayElements(Array(s)) {
    override def height = 1
  }
}


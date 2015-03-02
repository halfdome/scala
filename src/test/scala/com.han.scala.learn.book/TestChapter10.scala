package test2

import org.scalatest.junit.JUnit3Suite
import org.junit.Test
import org.scalatest.{ShouldMatchers, FlatSpec}

/**
 * Created by yhan on 2/22/15.
 */
class TestChapter10a extends FlatSpec with ShouldMatchers {
  val ele1 = Element.elem('@', 4, 5)
  val ele2 = Element.elem('#', 6, 3)

  "Height after Above" should "be sum of both heights" in {
    ele1.above(ele2).height should be (8)
  }
}

class TestChapter10 extends JUnit3Suite{
  val ele1 = Element.elem('@', 4, 5)
  val ele2 = Element.elem('#', 6, 3)

@Test
  def testHeightOfAbove() {
    assertResult(8)(
      ele1.above(ele2).height
    )
  }

@Test
  def testWidthOfBeside() {
    assertResult(10)(
      ele1.beside(ele2).width
    )
  }
}

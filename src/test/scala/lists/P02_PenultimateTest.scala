package lists

import lists.P02_Penultimate.penultimate
import org.scalatest.WordSpec

class P02_PenultimateTest extends WordSpec {

  "The function penultimate" when {

    "provided with non-empty list" should {
      "return the last but one element of the list" in {
        val list = List(1, 1, 2, 3, 5, 8)
        assert(penultimate(list) == 5)
      }
    }

    "provided with single-element list" should {
      "throw NoSuchElementException exception" in {
        val singleElemList = List(13)
        assertThrows[NoSuchElementException] {
          penultimate(singleElemList)
        }
      }
    }

    "provided with an empty list" should {
      "throw NoSuchElementException exception" in {
        val emptyList = List.empty[Int]
        assertThrows[NoSuchElementException] {
          penultimate(emptyList)
        }
      }
    }
  }
}

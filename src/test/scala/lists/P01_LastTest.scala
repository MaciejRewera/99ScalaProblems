package lists

import lists.P01_Last.last
import org.scalatest.WordSpec

class P01_LastTest extends WordSpec {

  "The function last" when {

    "provided with non-empty list" should {
      "return last element of the list" in {
        val list = List(1, 1, 2, 3, 5, 8)
        assert(last(list) == list.last)
      }
    }

    "provided with single-element list" should {
      "return the only element" in {
        val singleElemList = List(13)
        assert(last(singleElemList) == 13)
      }
    }

    "provided with an empty list" should {
      "throw NoSuchElementException exception" in {
        val emptyList = List.empty[Int]
        assertThrows[NoSuchElementException] {
          last(emptyList)
        }
      }
    }
  }

}

package lists

import lists.P03_Nth.nth
import org.scalatest.WordSpec

class P03_NthTest extends WordSpec {

  "The function nth" when {

    "provided with empty list" should {
      "throw IndexOutOfBounds exception" in {
        val emptyList = List.empty[Int]
        val n = 1
        assertThrows[IndexOutOfBoundsException] {
          nth(n, emptyList)
        }
      }
    }

    "provided with empty list and n == 0" should {
      "throw IndexOutOfBounds exception" in {
        val emptyList = List.empty[Int]
        val n = 0
        assertThrows[IndexOutOfBoundsException] {
          nth(n, emptyList)
        }
      }
    }

    "provided with non-empty list and n > list.size" should {
      "throw IndexOutOfBounds exception" in {
        val list = List(1, 2, 3)
        val n = list.size + 1
        assertThrows[IndexOutOfBoundsException] {
          nth(n, list)
        }
      }
    }

    "provided with non-empty list and n == list.size" should {
      "throw IndexOutOfBounds exception" in {
        val list = List(1, 2, 3)
        val n = list.size
        assertThrows[IndexOutOfBoundsException] {
          nth(n, list)
        }
      }
    }

    "provided with non-empty list and negative n" should {
      "throw IndexOutOfBounds exception" in {
        val list = List(1, 2, 3)
        val n = -1
        assertThrows[IndexOutOfBoundsException] {
          nth(n, list)
        }
      }
    }

    "provided with non-empty list" should {
      "return n-th element of the list" in {
        val list = List(1, 2, 3, 4, 5)
        val n = 3
        assert(nth(n, list) == 4)
      }
    }
  }

}

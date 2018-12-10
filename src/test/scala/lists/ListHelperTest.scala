package lists

import lists.ListHelper._
import org.scalatest._

class ListHelperTest extends WordSpec {

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

  "The function length" when {
    "provided with empty list" should {
      "return zero" in {
        val emptyList = List.empty[Int]
        assert(length(emptyList) == 0)
      }
    }

    "provided with non-empty list" should {
      "return list size" in {
        val list = List(1, 2, 2, 5, 13)
        assert(length(list) == 5)
      }
    }
  }

  "The function reverse" when {
    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[Int]
        val expectedResult = Nil

        assert(reverse(list) == expectedResult)
      }
    }

    "provided with single-element list" should {
      "return the same single-element list" in {
        val list = List(13)
        val expectedResult = list

        assert(reverse(list) == expectedResult)
      }
    }

    "provided with multi-element list with the same values" should {
      "return the same single-element list" in {
        val list = List(1, 1)
        val expectedResult = list

        assert(reverse(list) == expectedResult)
      }
    }

    "provided with multi-element list" should {
      "return list with elements reversed" in {
        val list = List(1, 1, 2, 3, 5, 8)
        val expectedResult = List(8, 5, 3, 2, 1, 1)

        assert(reverse(list) == expectedResult)
      }
    }
  }

  "The function isPalindrome" should {
    "return false" when {
      "provided with non-palindrome list" in {
        val list = List(1, 2, 3)
        assert(!isPalindrome(list))
      }
    }

    "return true" when {
      "provided with empty list" in {
        val list = List.empty[Int]
        assert(isPalindrome(list))
      }

      "provided with single-element list" in {
        val list = List(13)
        assert(isPalindrome(list))
      }

      "provided with even-length palindrome list" in {
        val list = List(1, 2, 3, 3, 2, 1)
        assert(isPalindrome(list))
      }

      "provided with odd-length palindrome list" in {
        val list = List(1, 2, 3, 2, 1)
        assert(isPalindrome(list))
      }
    }
  }

}

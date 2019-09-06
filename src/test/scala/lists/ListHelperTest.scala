package lists

import lists.ListHelper._
import org.scalatest._

//noinspection ComparingUnrelatedTypes
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

  "The function flatten" when {
    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[String]
        assert(flatten(list) == List.empty[String])
      }
    }

    "provided with single-element list" should {
      "return the same single-element list" in {
        val list = List(13)
        assert(flatten(list) == list)
      }
    }

    "provided with already a list already flattened" should {
      "return the same list without order changes" in {
        val list = List(1, 1, 2, 3, 5, 8, 13)
        assert(flatten(list) == list)
      }
    }

    "provided with a list with nested list" should {
      "return list with elements from inner list without order changes" in {
        val list = List(1, 1, 2, 3, 5, 8, 13)
        val nestedList = List(list)
        assert(flatten(nestedList) == list)
      }
    }

    "provided with multi-level nested list" should {
      "return list without nesting" in {
        val list = List(List(1, 1), 2, List(3, List(5, 8)))
        assert(flatten(list) == List(1, 1, 2, 3, 5, 8))
      }
    }
  }

  "The function compress" when {

    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[Symbol]
        assert(compress(list) == List.empty[Symbol])
      }
    }

    "provided with single-element list" should {
      "return list with the same element" in {
        val list = List('a)
        assert(compress(list) == List('a))
      }
    }

    "provided with list containing 3 different elements" should {
      "return list with the same elements in the same order" in {
        val list = List('a, 'b, 'c)
        assert(compress(list) == List('a, 'b, 'c))
      }
    }

    "provided with list containing same elements but not next to each other" should {
      "return list with the same elements in the same order" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(compress(list) == List('a, 'b, 'c, 'a, 'b))
      }
    }

    "provided with list containing the same 3 elements" should {
      "return list with single occurrence of the element" in {
        val list = List('a, 'a, 'a)
        assert(compress(list) == List('a))
      }
    }

    "provided with list containing different elements but appearing in groups" should {
      "return compressed version of the list" in {
        val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
        assert(compress(list) == List('a, 'b, 'c, 'a, 'd, 'e))
      }
    }
  }

  "The function pack" when {

    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[Symbol]
        assert(pack(list) == List.empty)
      }
    }

    "provided with single-element list" should {
      "return list with the same element" in {
        val list = List('a)
        assert(pack(list) == List(List('a)))
      }
    }

    "provided with list containing 3 different elements" should {
      "return list with the same elements in the same order" in {
        val list = List('a, 'b, 'c)
        assert(pack(list) == List(List('a), List('b), List('c)))
      }
    }

    "provided with list containing same elements but not next to each other" should {
      "return list with the same elements in the same order" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(pack(list) == List(List('a), List('b), List('c), List('a), List('b)))
      }
    }

    "provided with list containing the same 3 elements" should {
      "return list with single occurrence of the element" in {
        val list = List('a, 'a, 'a)
        assert(pack(list) == List(List('a, 'a, 'a)))
      }
    }

    "provided with list containing different elements but appearing in groups" should {
      "return compressed version of the list" in {
        val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
        assert(pack(list) == List(
          List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)
        ))
      }
    }
  }

  "The function encode" should {
    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[Symbol]
        assert(encode(list) == List.empty)
      }

      "provided with single-element list" in {
        val list = List('a)
        assert(encode(list) == List((1, 'a)))
      }

      "provided with list containing 3 different elements" in {
        val list = List('a, 'b, 'c)
        assert(encode(list) == List((1, 'a), (1, 'b), (1, 'c)))
      }

      "provided with list containing same elements but not next to each other" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(encode(list) == List((1, 'a), (1, 'b), (1, 'c), (1, 'a), (1, 'b)))
      }

      "provided with list containing the same 3 elements" in {
        val list = List('a, 'a, 'a)
        assert(encode(list) == List((3, 'a)))
      }

      "provided with list containing different elements but appearing in groups" in {
        val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
        assert(encode(list) == List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      }
    }
  }

  "The function encodeModified" should {
    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[Symbol]
        assert(encodeModified(list) == List.empty)
      }

      "provided with single-element list" in {
        val list = List('a)
        assert(encodeModified(list) == List('a))
      }

      "provided with list containing 3 different elements" in {
        val list = List('a, 'b, 'c)
        assert(encodeModified(list) == List('a, 'b, 'c))
      }

      "provided with list containing same elements but not next to each other" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(encodeModified(list) == List('a, 'b, 'c, 'a, 'b))
      }

      "provided with list containing the same 3 elements" in {
        val list = List('a, 'a, 'a)
        assert(encodeModified(list) == List((3, 'a)))
      }

      "provided with list containing different elements but appearing in groups" in {
        val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
        assert(encodeModified(list) == List((4, 'a), 'b, (2, 'c), (2, 'a), 'd, (4, 'e)))
      }
    }
  }

  "The function decode" should {
    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[(Int, Symbol)]
        assert(decode(list) == List.empty)
      }

      "provided with single-element list" in {
        val list = List((1, 'a))
        assert(decode(list) == List('a))
      }

      "provided with list containing 3 different elements" in {
        val list = List((1, 'a), (1, 'b), (1, 'c))
        assert(decode(list) == List('a, 'b, 'c))
      }

      "provided with list containing same elements but not next to each other" in {
        val list = List((1, 'a), (1, 'b), (1, 'c), (1, 'a), (1, 'b))
        assert(decode(list) == List('a, 'b, 'c, 'a, 'b))
      }

      "provided with list containing the same 3 elements" in {
        val list = List((3, 'a))
        assert(decode(list) == List('a, 'a, 'a))
      }

      "provided with list containing different elements but appearing in groups" in {
        val list = List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
        assert(decode(list) == List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
      }
    }
  }

  "The function encodeDirect" should {
    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[Symbol]
        assert(encode(list) == List.empty)
      }

      "provided with single-element list" in {
        val list = List('a)
        assert(encodeDirect(list) == List((1, 'a)))
      }

      "provided with list containing 3 different elements" in {
        val list = List('a, 'b, 'c)
        assert(encodeDirect(list) == List((1, 'a), (1, 'b), (1, 'c)))
      }

      "provided with list containing same elements but not next to each other" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(encodeDirect(list) == List((1, 'a), (1, 'b), (1, 'c), (1, 'a), (1, 'b)))
      }

      "provided with list containing the same 3 elements" in {
        val list = List('a, 'a, 'a)
        assert(encodeDirect(list) == List((3, 'a)))
      }

      "provided with list containing different elements but appearing in groups" in {
        val list = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
        assert(encodeDirect(list) == List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
      }
    }
  }

}

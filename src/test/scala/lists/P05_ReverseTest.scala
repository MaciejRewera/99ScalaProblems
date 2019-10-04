package lists

import lists.P05_Reverse._
import org.scalatest.WordSpec

class P05_ReverseTest extends WordSpec {

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

  "The function reverseWithFold" when {

    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[Int]
        val expectedResult = Nil

        assert(reverseWithFold(list) == expectedResult)
      }
    }

    "provided with single-element list" should {
      "return the same single-element list" in {
        val list = List(13)
        val expectedResult = list

        assert(reverseWithFold(list) == expectedResult)
      }
    }

    "provided with multi-element list with the same values" should {
      "return the same single-element list" in {
        val list = List(1, 1)
        val expectedResult = list

        assert(reverseWithFold(list) == expectedResult)
      }
    }

    "provided with multi-element list" should {
      "return list with elements reversed" in {
        val list = List(1, 1, 2, 3, 5, 8)
        val expectedResult = List(8, 5, 3, 2, 1, 1)

        assert(reverseWithFold(list) == expectedResult)
      }
    }
  }

}

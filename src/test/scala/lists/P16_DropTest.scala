package lists

import lists.P16_Drop._
import org.scalatest.WordSpec

class P16_DropTest extends WordSpec {

  "THe function dropTailRec" should {

    "throw IllegalArgumentException" when {

      "provided with negative n" in {
        val n = -1
        val list = List('a, 'b, 'c)

        assertThrows[IllegalArgumentException](dropTailRec(n, list))
      }
    }

    "return correct list" when {

      "provided with empty list" in {
        val n = 3
        val list = List.empty[Symbol]
        assert(dropTailRec(n, list) == List.empty)
      }

      "provided with single-element list and n = 1" in {
        val n = 1
        val list = List('a)
        assert(dropTailRec(n, list) == List.empty)
      }

      "provided with n = 0" in {
        val n = 0
        val list = List('a, 'b, 'c)
        assert(dropTailRec(n, list) == list)
      }

      "provided with list shorter than n" in {
        val n = 4
        val list = List('a, 'b, 'c)
        assert(dropTailRec(n, list) == list)
      }

      "provided with n being multiplication of the list length" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
        assert(dropTailRec(n, list) == List('a, 'b, 'd, 'e, 'g, 'h))
      }

      "provided with any n" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
        assert(dropTailRec(n, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
      }
    }
  }

  "THe function dropSimpleRec" should {

    "throw IllegalArgumentException" when {

      "provided with negative n" in {
        val n = -1
        val list = List('a, 'b, 'c)

        assertThrows[IllegalArgumentException](dropSimpleRec(n, list))
      }
    }

    "return correct list" when {

      "provided with empty list" in {
        val n = 3
        val list = List.empty[Symbol]
        assert(dropSimpleRec(n, list) == List.empty)
      }

      "provided with single-element list and n = 1" in {
        val n = 1
        val list = List('a)
        assert(dropSimpleRec(n, list) == List.empty)
      }

      "provided with n = 0" in {
        val n = 0
        val list = List('a, 'b, 'c)
        assert(dropSimpleRec(n, list) == list)
      }

      "provided with list shorter than n" in {
        val n = 4
        val list = List('a, 'b, 'c)
        assert(dropSimpleRec(n, list) == list)
      }

      "provided with n being multiplication of the list length" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
        assert(dropSimpleRec(n, list) == List('a, 'b, 'd, 'e, 'g, 'h))
      }

      "provided with any n" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
        assert(dropSimpleRec(n, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
      }
    }
  }

}

package lists

import lists.P16_Drop.drop
import org.scalatest.WordSpec

class P16_DropSpec extends WordSpec {

  "THe function drop" should {

    "throw IllegalArgumentException" when {

      "provided with negative n" in {
        val n = -1
        val list = List('a, 'b, 'c)

        assertThrows[IllegalArgumentException](drop(n, list))
      }
    }

    "return correct list" when {

      "provided with empty list" in {
        val n = 3
        val list = List.empty[Symbol]
        assert(drop(n, list) == List.empty)
      }

      "provided with single-element list and n = 1" in {
        val n = 1
        val list = List('a)
        assert(drop(n, list) == List.empty)
      }

      "provided with n = 0" in {
        val n = 0
        val list = List('a, 'b, 'c)
        assert(drop(n, list) == list)
      }

      "provided with list shorter than n" in {
        val n = 4
        val list = List('a, 'b, 'c)
        assert(drop(n, list) == list)
      }

      "provided with n being multiplication of the list length" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
        assert(drop(n, list) == List('a, 'b, 'd, 'e, 'g, 'h))
      }

      "provided with any n" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
        assert(drop(n, list) == List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k))
      }
    }
  }

}

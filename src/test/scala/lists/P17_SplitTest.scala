package lists

import lists.P17_Split.split
import org.scalatest.WordSpec

class P17_SplitTest extends WordSpec {

  "The function split" should {

    "throw an IllegalArgumentException" when {
      "provided with negative n" in {
        val n = -1
        val list = List('a, 'b, 'c)

        assertThrows[IllegalArgumentException](split(n, list))}
    }

    "return correct list" when {

      "provided with empty list" in {
        val n = 2
        val list = List.empty

        assert(split(n, list) == (List.empty, List.empty))
      }

      "provided with n = 0" in {
        val n = 0
        val list = List('a, 'b, 'c)

        assert(split(n, list) == (List.empty, list))
      }

      "provided with n = 1" in {
        val n = 1
        val list = List('a, 'b, 'c)

        assert(split(n, list) == (List('a), List('b, 'c)))
      }

      "provided with n equal to lists length" in {
        val list = List('a, 'b, 'c)
        val n = list.length

        assert(split(n, list) == (list, List.empty))
      }

      "provided with n equal to lists length minus 1" in {
        val list = List('a, 'b, 'c)
        val n = list.length - 1

        assert(split(n, list) == (List('a, 'b), List('c)))
      }

      "provided with n bigger than lists length" in {
        val list = List('a, 'b, 'c)
        val n = list.length + 1

        assert(split(n, list) == (list, List.empty))
      }

      "provided with n close to half of the lists length" in {
        val n = 3
        val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)

        assert(split(n, list) == (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
      }
    }
  }
  
}

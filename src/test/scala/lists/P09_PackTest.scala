package lists

import lists.P09_Pack.pack
import org.scalatest.WordSpec

class P09_PackTest extends WordSpec {

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

}

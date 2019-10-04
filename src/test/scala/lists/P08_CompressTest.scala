package lists

import lists.P08_Compress.compress
import org.scalatest.WordSpec

class P08_CompressTest extends WordSpec {

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

}

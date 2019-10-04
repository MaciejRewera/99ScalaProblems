package lists

import lists.P13_EncodeDirect.encodeDirect
import org.scalatest.WordSpec

class P13_EncodeDirectTest extends WordSpec {

  "The function encodeDirect" should {

    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[Symbol]
        assert(encodeDirect(list) == List.empty)
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

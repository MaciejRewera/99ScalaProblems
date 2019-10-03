package lists

import lists.P12_Decode.decode
import org.scalatest.WordSpec

class P12_DecodeTest extends WordSpec {

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

}

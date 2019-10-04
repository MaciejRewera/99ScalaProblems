package lists

import lists.P10_Encode.encode
import org.scalatest.WordSpec

class P10_EncodeTest extends WordSpec {

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

}

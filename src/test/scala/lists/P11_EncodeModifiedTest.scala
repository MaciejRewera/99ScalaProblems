package lists

import lists.P11_EncodeModified.encodeModified
import org.scalatest.WordSpec

class P11_EncodeModifiedTest extends WordSpec {

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

}

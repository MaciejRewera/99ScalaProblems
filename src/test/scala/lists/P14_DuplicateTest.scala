package lists

import lists.P14_Duplicate.duplicate
import org.scalatest.WordSpec

class P14_DuplicateTest extends WordSpec {

  "The function duplicate" should {

    "return correct list" when {

      "provided with empty list" in {
        val list = List.empty[Symbol]
        assert(duplicate(list) == List.empty)
      }

      "provided with single-element list" in {
        val list = List('a)
        assert(duplicate(list) == List('a, 'a))
      }

      "provided with list containing 3 different elements" in {
        val list = List('a, 'b, 'c)
        assert(duplicate(list) == List('a, 'a, 'b, 'b, 'c, 'c))
      }

      "provided with list containing same elements but not next to each other" in {
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(duplicate(list) == List('a, 'a, 'b, 'b, 'c, 'c, 'a, 'a, 'b, 'b))
      }

      "provided with list containing the same 3 elements" in {
        val list = List('a, 'a, 'a)
        assert(duplicate(list) == List('a, 'a, 'a, 'a, 'a, 'a))
      }

      "provided with list containing different elements but appearing in groups" in {
        val list = List(
          'a, 'a,
          'b,
          'c, 'c,
          'a, 'a,
          'd,
          'e, 'e, 'e)
        assert(duplicate(list) == List(
          'a, 'a, 'a, 'a,
          'b, 'b,
          'c, 'c, 'c, 'c,
          'a, 'a, 'a, 'a,
          'd, 'd,
          'e, 'e, 'e, 'e, 'e, 'e)
        )
      }
    }
  }

}

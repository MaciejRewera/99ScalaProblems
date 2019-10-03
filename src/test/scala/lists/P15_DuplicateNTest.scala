package lists

import lists.P15_DuplicateN.duplicateN
import org.scalatest.WordSpec

class P15_DuplicateNTest extends WordSpec {

  "The function duplicateN" should {

    "return correct list" when {

      "provided with empty list" in {
        val amount = 3
        val list = List.empty[Symbol]
        assert(duplicateN(amount, list) == List.empty)
      }

      "provided with single-element list" in {
        val amount = 3
        val list = List('a)
        assert(duplicateN(amount, list) == List('a, 'a, 'a))
      }

      "provided with list containing 3 different elements" in {
        val amount = 3
        val list = List('a, 'b, 'c)
        assert(duplicateN(amount, list) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c))
      }

      "provided with list containing same elements but not next to each other" in {
        val amount = 3
        val list = List('a, 'b, 'c, 'a, 'b)
        assert(duplicateN(amount, list) == List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'a, 'a, 'a, 'b, 'b, 'b))
      }

      "provided with list containing the same 3 elements" in {
        val amount = 3
        val list = List('a, 'a, 'a)
        assert(duplicateN(amount, list) == List('a, 'a, 'a, 'a, 'a, 'a, 'a, 'a, 'a))
      }

      "provided with list containing different elements but appearing in groups" in {
        val amount = 3
        val list = List(
          'a, 'a,
          'b,
          'c, 'c,
          'a, 'a,
          'd,
          'e, 'e, 'e)
        assert(duplicateN(amount, list) == List(
          'a, 'a, 'a, 'a, 'a, 'a,
          'b, 'b, 'b,
          'c, 'c, 'c, 'c, 'c, 'c,
          'a, 'a, 'a, 'a, 'a, 'a,
          'd, 'd, 'd,
          'e, 'e, 'e, 'e, 'e, 'e, 'e, 'e, 'e)
        )
      }

      "provided with list containing 3 different elements and an amount" which {

        "equals 1" in {
          val amount = 1
          val list = List('a, 'b, 'c)
          assert(duplicateN(amount, list) == List('a, 'b, 'c))
        }

        "equals 4" in {
          val amount = 4
          val list = List('a, 'b, 'c)
          assert(duplicateN(amount, list) == List('a, 'a, 'a, 'a, 'b, 'b, 'b, 'b, 'c, 'c, 'c, 'c))
        }
      }
    }
  }

}

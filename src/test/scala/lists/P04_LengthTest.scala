package lists

import lists.P04_Length.length
import org.scalatest.WordSpec

class P04_LengthTest extends WordSpec {

  "The function length" when {

    "provided with empty list" should {
      "return zero" in {
        val emptyList = List.empty[Int]
        assert(length(emptyList) == 0)
      }
    }

    "provided with non-empty list" should {
      "return list size" in {
        val list = List(1, 2, 2, 5, 13)
        assert(length(list) == 5)
      }
    }
  }

}

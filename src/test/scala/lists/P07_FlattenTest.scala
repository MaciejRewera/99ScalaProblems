package lists

import lists.P07_Flatten.flatten
import org.scalatest.WordSpec

class P07_FlattenTest extends WordSpec {

  "The function flatten" when {

    "provided with empty list" should {
      "return empty list" in {
        val list = List.empty[String]
        assert(flatten(list) == List.empty[String])
      }
    }

    "provided with single-element list" should {
      "return the same single-element list" in {
        val list = List(13)
        assert(flatten(list) == list)
      }
    }

    "provided with already a list already flattened" should {
      "return the same list without order changes" in {
        val list = List(1, 1, 2, 3, 5, 8, 13)
        assert(flatten(list) == list)
      }
    }

    "provided with a list with nested list" should {
      "return list with elements from inner list without order changes" in {
        val list = List(1, 1, 2, 3, 5, 8, 13)
        val nestedList = List(list)
        assert(flatten(nestedList) == list)
      }
    }

    "provided with multi-level nested list" should {
      "return list without nesting" in {
        val list = List(List(1, 1), 2, List(3, List(5, 8)))
        assert(flatten(list) == List(1, 1, 2, 3, 5, 8))
      }
    }
  }

}

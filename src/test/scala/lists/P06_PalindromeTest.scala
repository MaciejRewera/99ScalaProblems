package lists

import lists.P06_Palindrome.isPalindrome
import org.scalatest.WordSpec

class P06_PalindromeTest extends WordSpec {

  "The function isPalindrome" should {

    "return false" when {
      "provided with non-palindrome list" in {
        val list = List(1, 2, 3)
        assert(!isPalindrome(list))
      }
    }

    "return true" when {
      "provided with empty list" in {
        val list = List.empty[Int]
        assert(isPalindrome(list))
      }

      "provided with single-element list" in {
        val list = List(13)
        assert(isPalindrome(list))
      }

      "provided with even-length palindrome list" in {
        val list = List(1, 2, 3, 3, 2, 1)
        assert(isPalindrome(list))
      }

      "provided with odd-length palindrome list" in {
        val list = List(1, 2, 3, 2, 1)
        assert(isPalindrome(list))
      }
    }
  }

}

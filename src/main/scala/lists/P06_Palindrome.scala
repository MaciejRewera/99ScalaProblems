package lists

object P06_Palindrome {

  def isPalindrome[A](input: List[A]): Boolean = input match {
    case Nil => true
    case _ +: Nil => true
    case head +: middle :+ last if head == last => isPalindrome(middle)
    case _ => false
  }

}

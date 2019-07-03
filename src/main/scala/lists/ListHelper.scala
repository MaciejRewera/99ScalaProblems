package lists

object ListHelper {

  def last[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case _ :+ e => e
  }

  def penultimate[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException
    case _ +: Nil => throw new NoSuchElementException
    case _ :+ e :+ _ => e
  }

  def nth[A](n: Int, list: List[A]): A = {
    if ((n >= list.size) || (n < 0)) throw new IndexOutOfBoundsException
    else iterate[A](n, list)
  }

  private def iterate[A](n: Int, list: List[A]): A = n match {
    case 0 => list head
    case _ => iterate[A](n - 1, list.tail)
  }

  def length[A](list: List[A]): Int = {
    lengthCounter[A](0, list)
  }

  private def lengthCounter[A](counter: Int, list: List[A]): Int = list match {
    case Nil => counter
    case _ => lengthCounter[A](counter + 1, list.tail)
  }

  def reverse[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case lastElement +: Nil => List(lastElement)
    case head +: tail => reverse(tail) :+ head
  }

  def isPalindrome[A](list: List[A]): Boolean = list match {
    case Nil => true
    case _ +: Nil => true
    case head +: middle :+ last if head == last => isPalindrome(middle)
    case _ => false
  }

  def flatten(input: List[_]): List[_] = input match {
    case Nil => Nil
    case (list: List[_]) :: tail => flatten(list) ::: flatten(tail)
    case elem +: tail => elem +: flatten(tail)
  }

  def compress[A](input: List[A]): List[A] =
    input.foldLeft(List.empty[A]) { (list, elem) =>
      list match {
        case Nil => list :+ elem
        case _ :+ last if last != elem => list :+ elem
        case _ => list
      }
    }

  def pack[A](input: List[A]): List[List[A]] =
    input.foldLeft(List.empty[(A, Int)]) { (list, elem) =>
      list match {
        case Nil => List((elem, 1))
        case initialTuples :+ lastTuple if lastTuple._1 == elem => initialTuples :+ (elem, lastTuple._2 + 1)
        case _ => list :+ (elem, 1)
      }
    }.map(t => List.fill(t._2)(t._1))

}

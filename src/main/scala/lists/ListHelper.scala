package lists

import scala.annotation.tailrec

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

  def compress[A](input: List[A]): List[A] = {

    @tailrec
    def comp(revAcc: List[A], rest: List[A]): List[A] = rest match {
      case Nil => revAcc
      case hd :: tl if hd != revAcc.head => comp(hd +: revAcc, tl)
      case _ => comp(revAcc, rest.tail)
    }

    if (input.nonEmpty) comp(List(input.head), input.tail).reverse else Nil
  }

  def pack[A](input: List[A]): List[List[A]] = encodeDirect(input).map(t => List.fill(t._1)(t._2))

  def encode[A](input: List[A]): List[(Int, A)] = pack(input).map(list => (list.length, list.head))

  def encodeModified[A](input: List[A]): List[Any] = encode(input).map {
    case (1, value) => value
    case t => t
  }

  def decode[A](input: List[(Int, A)]): List[A] = input.flatMap(elem => List.fill(elem._1)(elem._2))

  def encodeDirect[A](input: List[A]): List[(Int, A)] =
    input.foldLeft(List.empty[(Int, A)]) { (list, elem) =>
      list match {
        case Nil => List((1, elem))
        case initialTuples :+ lastTuple if lastTuple._2 == elem => initialTuples :+ (lastTuple._1 + 1, elem)
        case _ => list :+ (1, elem)
      }
    }

  def duplicate[A](input: List[A]): List[A] = input.flatMap(elem => List(elem, elem))

}

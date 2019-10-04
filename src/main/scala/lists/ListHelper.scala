package lists

object ListHelper {

  def last[A](input: List[A]): A = P01_Last.last(input)

  def penultimate[A](input: List[A]): A = P02_Penultimate.penultimate(input)

  def nth[A](n: Int, input: List[A]): A = P03_Nth.nth(n, input)

  def length[A](input: List[A]): Int = P04_Length.length(input)

  def reverse[A](input: List[A]): List[A] = P05_Reverse.reverse(input)

  def isPalindrome[A](input: List[A]): Boolean = P06_Palindrome.isPalindrome(input)

  def flatten(input: List[_]): List[_] = P07_Flatten.flatten(input)

  def compress[A](input: List[A]): List[A] = P08_Compress.compress(input)

  def pack[A](input: List[A]): List[List[A]] = P09_Pack.pack(input)

  def encode[A](input: List[A]): List[(Int, A)] = P10_Encode.encode(input)

  def encodeModified[A](input: List[A]): List[Any] = P11_EncodeModified.encodeModified(input)

  def decode[A](input: List[(Int, A)]): List[A] = P12_Decode.decode(input)

  def encodeDirect[A](input: List[A]): List[(Int, A)] = P13_EncodeDirect.encodeDirect(input)

  def duplicate[A](input: List[A]): List[A] = P14_Duplicate.duplicate(input)

  def duplicateN[A](amount: Int, input: List[A]): List[A] = P15_DuplicateN.duplicateN(amount, input)

}

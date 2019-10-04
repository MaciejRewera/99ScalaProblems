package lists

import lists.P10_Encode.encode

object P11_EncodeModified {

  def encodeModified[A](input: List[A]): List[Any] = encode(input).map {
    case (1, value) => value
    case t => t
  }

}

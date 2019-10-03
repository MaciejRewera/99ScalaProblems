package lists

import lists.P09_Pack.pack

object P10_Encode {

  def encode[A](input: List[A]): List[(Int, A)] = pack(input).map(list => (list.length, list.head))

}

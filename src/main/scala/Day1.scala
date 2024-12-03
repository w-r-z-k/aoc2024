object Day1 extends App {

  import scala.io.Source

  val fn= "/Users/user/Development/aoc2024/data/Day1.txt"

  val (a, b) = Source.fromFile(fn)
                     .getLines()
                     .toList.map(s => {val x = s.split("   "); (x.head.toInt, x.last.toInt)})
                     .unzip

  val r = a.sorted.zip(b.sorted).map(x => if (x._1 < x._2) x._2 - x._1 else x._1 - x._2).sum

  println(r)

  val r2 = a.map(x => (x, b.count(_ == x))).map(x => x._1 * x._2).sum

  println(r2)
}

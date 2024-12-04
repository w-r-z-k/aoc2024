object Day2 extends App {

  import scala.io.Source

  val fn= "/Users/user/Development/aoc2024/data/Day2.txt"

  val reports = Source.fromFile(fn)
                      .getLines()
                      .toList.map(s => {val x = s.split(" "); x.toList.map(_.toInt)})

  def isSafe(report : List[Int]): Boolean = {
     val e = report.zip(report.tail).map(x => x._1 - x._2)
     (e.count(x => x < 0 && x >= -3) == e.length) ||
     (e.count(x => x > 0 && x <=  3) == e.length)
  }

  println(reports.map(r => isSafe(r)).count(x => x))

  println(reports.map{r => (for(i <- 0 until r.length) yield r.patch(i, Nil, 1))
                          .map(rrr => isSafe(rrr)).contains(true)
                     }.count(x => x))
}

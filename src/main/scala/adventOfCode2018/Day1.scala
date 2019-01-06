package adventOfCode2018

import scala.io.Source

object Day1 extends App {
  val filename = "D:\\Workspace\\ScalaScraps\\Inputs\\Day_1.in"

  def part_one(inputFilePath: String): Unit = {
    val ans = Source.fromFile(inputFilePath).getLines.map(_.toInt).sum
    println(ans)
  }

  def part_two(inputFilePath: String): Unit = {
    var seenFreq = Set.empty[Int]
    var currentFreq = 0
    var index =0
    val lines:List[Int] = Source.fromFile(filename).getLines.map(_.toInt).toList

    while(!seenFreq.contains(currentFreq)){
      seenFreq+=currentFreq
      currentFreq = currentFreq + lines(index % lines.size)
      index+=1
    }
    println(s"First one we found and refound:\t$currentFreq" )
  }

  part_two(filename)
}
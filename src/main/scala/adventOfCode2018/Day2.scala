package adventOfCode2018

import scala.io.Source

object Day2 extends App {
  val filename1 = "D:\\Workspace\\ScalaScraps\\Inputs\\Day_2.in"
  val filename2 = "D:\\Workspace\\ScalaScraps\\Inputs\\Day_2_2.in"

  part_two(filename2)

  def part_one(inputFilePath: String): Unit = {
    val linesIter = Source.fromFile(inputFilePath).getLines()
    var id3letters = 0
    var id2letters = 0

    linesIter.foreach { line =>
      val lineMap = line.foldLeft(Map.empty[Char, Int]) {
        case (currentMap, oneChar) =>
          currentMap + (oneChar -> (currentMap.getOrElse(oneChar, 0) + 1))
      }

      if (lineMap.exists { case (_, occurances) => occurances == 2 }) {
        id2letters += 1
      }

      if (lineMap.exists { case (_, occurances) => occurances == 3 }) {
        id3letters += 1
      }
    }
    println(s"Checksum is $id2letters * $id3letters = ${id2letters * id3letters}")
  }

  def part_two(inputFilePath: String):Unit ={
    val linesIter = Source.fromFile(inputFilePath).getLines().toList
    println(s"Lines ${linesIter.length}")
    linesIter.foreach{
      line =>
        linesIter.foreach{ otherLine =>
        var difference=0
        for(i<-0 until line.length){
          if(line(i) != otherLine(i)){
            difference+=1
          }
        }
        if(difference==1){
          println(s"For\t$line\nand\t$otherLine")
          print("Got strings of 2 different letters, common letters\nare\t")
          for(i<-0 until line.length){
            if(line(i) == otherLine(i)){
              print(line(i))
            }
            else print("-")
          }
          println()
          println("========================================")
        }
      }
    }
  }
}

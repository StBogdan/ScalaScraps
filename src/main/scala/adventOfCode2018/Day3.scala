package adventOfCode2018
import util.control.Breaks._
import scala.io.Source

object Day3 extends App{
  val filename = "D:\\Workspace\\ScalaScraps\\Inputs\\Day_3.in"


  def part_one(inputFilePath: String): Unit = {
    val rawReqList = Source.fromFile(inputFilePath).getLines
    var useMap = Array.ofDim[Int](1000,1000)
    useMap =useMap.map(_.map(_ => 0))

    // Example
    // #1302 @ 912,468: 16x22
    rawReqList.foreach{
      canvasSpec =>
        val specElem = canvasSpec.split("@|:|,|x").map(_.trim)
        val xStart = specElem(1).toInt
        val yStart = specElem(2).toInt
        val xSize = specElem(3).toInt
        val ySize = specElem(4).toInt

        for(i <- xStart until (xStart+xSize)){
          for(j<- yStart until (yStart + ySize)){
            useMap(i)(j) +=1
          }
        }
    }

    printMatrix(useMap)
    println(s"Squares used at least twice count:\t ${useMap.flatMap{
      row => row.filter( _ > 1)
    }.length}")
  }

  def part_two(inputFilePath: String): Unit = {
    val rawReqList = Source.fromFile(inputFilePath).getLines.toList
    var useMap = Array.ofDim[Int](1000,1000).map(_.map(_ => 0))

    rawReqList.foreach{
      canvasSpec =>
        val specElem = canvasSpec.split("@|:|,|x").map(_.trim)
        val xStart = specElem(1).toInt
        val yStart = specElem(2).toInt
        val xSize = specElem(3).toInt
        val ySize = specElem(4).toInt

        for(i <- xStart until (xStart+xSize)){
          for(j<- yStart until (yStart + ySize)){
            useMap(i)(j) +=1
          }
        }
    }

    rawReqList.foreach{
      canvasSpec =>
        var isAlone = true
        val specElem = canvasSpec.split("@|:|,|x").map(_.trim)
        val orderId= specElem(0)
        val xStart = specElem(1).toInt
        val yStart = specElem(2).toInt
        val xSize = specElem(3).toInt
        val ySize = specElem(4).toInt

        breakable {
          for (i <- xStart until (xStart + xSize)) {
            for (j <- yStart until (yStart + ySize)) {
              if (useMap(i)(j) > 1){
                isAlone = false
                break
              }
            }
          }
        }

        if(isAlone)
          println(s"Order ID $orderId is untouched")
    }
  }


  def printMatrix(matrix: Array[Array[Int]]): Unit ={
     matrix.foreach{
      line =>
        line.foreach{ lineElem =>
          print(lineElem)
        }
        println()
    }
  }

  part_two(filename)
}

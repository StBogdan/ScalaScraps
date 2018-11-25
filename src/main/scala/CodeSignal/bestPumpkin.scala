package CodeSignal

object bestPumpkin extends App {

  case class RectDesign(hei:Int,wid: Int)

  def determineDesignDimensions(design: Array[String]):RectDesign = {
    var top = -1
    var bot = -1

    var left = -1
    var right= -1

    //Top
    var i =0
    var foundMark = false
    var emptyDesign = false

    while(!foundMark && i<design.length){
      if(design(i).contains('#')){
        top= i
        foundMark=true
      }
      i+=1
    }
    if(i== design.length) {
      emptyDesign=true
    }

    //Bot
    i =design.length-1
    foundMark = false
    while(!foundMark && i>=0){
      if(design(i).contains('#')){
        bot= i
        foundMark=true
      }
      i-=1
    }

    //Left
    var j=0
    foundMark = false
    while(!foundMark && j<design(0).length){
      if( design.map( x => x(j)).contains('#')){
        left= j
        foundMark=true
      }
      j+=1
    }

    //Right
    j=design(0).length-1
    foundMark = false
    while(!foundMark && j>=0){
      if( design.map( x => x(j)).contains('#')){
        right= j
        foundMark=true
      }
      j-=1
    }

    //Calculate size of design and return
    RectDesign(bot-top+1,right-left+1)
  }

  def getMatchDesignIndex(foundDesign: RectDesign, pumpkinDimensions: Array[Array[Int]]): Int ={

    var bestFitIndex = 0
    var bestFitSize = pumpkinDimensions(0)
    for (i <- 1 until pumpkinDimensions.length) {
      val a = pumpkinDimensions(i)

      val delta_a =  designDiff(a,foundDesign)
      val delta_best = designDiff(bestFitSize,foundDesign)

      if(delta_a == delta_best){
        val size_a = a(0)*a(1)
        val size_best = bestFitSize(0)*bestFitSize(1)

        if(size_a>size_best){
          bestFitIndex=i
          bestFitSize=a
        } // End same size cae
      }
      else{
        if(delta_a < delta_best){ //We want smallest distance
          bestFitIndex=i
          bestFitSize=a
        }
      } //End Same delta case

    } //Comparator
    bestFitIndex
  }

  def designDiff(design: Array[Int],refDesign: RectDesign): Double ={
    val refDesignRatio = refDesign.hei.toFloat/refDesign.wid.toFloat
    Math.min(Math.abs(design(1).toFloat/design(0).toFloat - refDesignRatio),
          Math.abs(design(0).toFloat/design(1).toFloat - refDesignRatio))
  }

  def bestPumpkin(design: Array[String], pumpkinDimensions: Array[Array[Int]]): Int = {
      val foundDesign = determineDesignDimensions(design)
      getMatchDesignIndex(foundDesign,pumpkinDimensions)
  }


  val test1Input_design= Array("..............................",
          "..............................",
          ".........#....................",
          "........##............#.......",
          ".......###...........###......",
          ".......###..........####......",
          "......###...........###.......",
          ".....######........######.....",
          ".....#######.......#######....",
          "..............................",
          "...............#..............",
          "..............###.............",
          ".....#.......#####............",
          ".....#....................#...",
          ".....##.#................##...",
          "......####............#..#....",
          "......####..##..###..#####....",
          "........#################.....",
          ".........###############......",
          "...........#..##...##.........",
          "..............................")
  val test1Input_sizes= Array[Array[Int]](
      Array(14,22),
      Array (9,16),
      Array(11,7),
      Array(33,23),
      Array(42,25))

  val test6Input_design= Array(
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    ".......#..............#.......",
    "......#.#............#.#......",
    ".......#..............#.......",
    "..............................",
    ".....######################...",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    "..............................",
    ".............................."
  )
    val test6Input_sizes= Array(Array(983,857),
      Array(33,741),
      Array(680,591),
    Array(471,412),
    Array(635,447),
    Array(260,128),
    Array(141,595),
    Array(792,883),
    Array(125,63),
    Array(506,438),
    Array(258,159),
    Array(351,331),
    Array(71,888),
    Array(68,384),
    Array(829,594),
    Array(533,602),
    Array(612,579),
    Array(404,744),
    Array(157,384),
      Array(842,303))




  try {
    assert(bestPumpkin(test1Input_design,test1Input_sizes) == 3)
    assert(bestPumpkin(test6Input_design,test6Input_sizes) == 6)
    //    assert(digitRootSort(Array(100, 22, 4, 11, 31, 103)) == Array(100, 11, 4, 22, 31, 103))
    //    println("Provided test cases succeed")
  }
  catch {
    case e:AssertionError => e.printStackTrace()
  }
}

package HackerRank.Algorithms

import java.io.PrintWriter

object GradingStudents {

  /*
   * Complete the gradingStudents function below.
   */
  def gradingStudents(grades: Array[Int]): Array[Int] = {
    /*
     * Write your code here.
     */
    grades.map { grade =>
      if (grade > 37) {
        val diff: Int = grade % 5
        if (diff > 2)
          grade + (5 - diff) //Round up
        else
          grade
      }
      else
        grade
    }
  }

  def main(args: Array[String]) {
    val scan = scala.io.StdIn
    val fw = new PrintWriter(sys.env("OUTPUT_PATH"))
    val n = scan.readLine.trim.toInt

    val grades = Array.ofDim[Int](n)

    for (gradesItr <- 0 until n) {
      val gradesItem = scan.readLine.trim.toInt
      grades(gradesItr) = gradesItem}

    val result = gradingStudents(grades)

    fw.println(result.mkString("\n"))
    fw.close()
  }
}

import scala.annotation.tailrec

object Recursion {
  def main(args: Array[String]): Unit = {
    val listMax = scala.math.pow(2, 24).toInt
    val list = List.range(0, listMax)

    println("Number of list elements: " + list.size)

    println("calling sum")
    printExecutionTime(sum(list))
    printExecutionTime(sum(list))
    printExecutionTime(sum(list))

    println("calling sumRecursionTailRecursive")
    printExecutionTime(sumRecursionTailRecursive(list))
    printExecutionTime(sumRecursionTailRecursive(list))
    printExecutionTime(sumRecursionTailRecursive(list))

    println("calling sumRecursionTailRecursivePro")
    printExecutionTime(sumRecursionTailRecursivePro(list))
    printExecutionTime(sumRecursionTailRecursivePro(list))
    printExecutionTime(sumRecursionTailRecursivePro(list))

//    println("calling sumRecursion")
//    printExecutionTime(sumRecursion(list))
//    printExecutionTime(sumRecursion(list))
//    printExecutionTime(sumRecursion(list))
  }

  // Uses private helper function
  def sumRecursionTailRecursive(list: List[Int]): Int = {
    sumRecursionTailRecursiveAccumulator(list, 0)
  }

  @tailrec
  private def sumRecursionTailRecursiveAccumulator(list: List[Int], accumulator: Int): Int = {
    list match {
      case Nil => accumulator
      case x :: xs => sumRecursionTailRecursiveAccumulator(xs, accumulator + x)
    }
  }

  // With nested function
  def sumRecursionTailRecursivePro(list: List[Int]): Int = {
    @tailrec
    def sumRecursionTailRecursiveAccumulatorPro(list: List[Int], currentSum: Int): Int = {
      list match {
        case Nil => currentSum
        case x :: xs => sumRecursionTailRecursiveAccumulatorPro(xs, currentSum + x)
      }
    }

    sumRecursionTailRecursiveAccumulatorPro(list, 0)
  }

  // Uses var
  private def sum(list: List[Int]): Int = {
    var s = 0
    for (x <- list) {
      s += x
    }
    s
  }

  // Causes a StackOverflowError for large lists (stack frame size)
  def sumRecursion(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case x :: xs => x + sumRecursion(xs)
    }
  }

  def printExecutionTime(codeBlock: => Int): Unit = {
    val timeBeforeCall = System.currentTimeMillis

    val result = codeBlock
    val timeDiff = System.currentTimeMillis - timeBeforeCall

    println(">>> " + result)
    println("total time consumed: " + timeDiff + "ms")
  }
}
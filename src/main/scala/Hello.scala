object Hello {
  def main(args: Array[String]): Unit = {
    println("Hello, world!")

    val intList = List(1, 2, 3, 4, 5)
    val intMapResult = myMap(mulInt, intList)
    println(">> " + intMapResult)
    val intFilterResult = myFilter(evenInt, intList)
    println(">> " + intFilterResult)

    val doubleList = List(1.0, 2.0, 3.0, 4.0, 5.0)
    val doubleResult = myMap(mulDouble, doubleList)
    println(">> " + doubleResult)
    val doubleFilterResult = myFilter(evenDouble, doubleList)
    println(">> " + doubleFilterResult)
  }

  // FIXME: how to do this generic? I want only one function!
  def mulInt(value: Int): Int = value * value
  def mulDouble(value: Double): Double = value * value
  def evenInt(value: Int): Boolean = value % 2 == 0
  def evenDouble(value: Double): Boolean = value % 2 == 0
  
  def myFilter[A](f: A => Boolean, list: Seq[A]): Seq[A] = {
    for (x <- list if f(x)) yield x
  }

  def myMap[A, B](f: A => B, list: Seq[A]): Seq[B] = {
    for {
      x <- list
    } yield f(x) // <-- apply 'f' to each element 'x'
  }
}
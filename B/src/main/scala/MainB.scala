import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object MainB extends App{
  val f  = Future {}
  // Scala 2.12 specific code
  f.transform(res => res)
  println("I am B")
  Common.common()
}
